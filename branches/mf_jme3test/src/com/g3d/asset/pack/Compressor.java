package com.g3d.asset.pack;

import SevenZip.Compression.LZMA.Encoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;
import java.util.jar.JarInputStream;
import java.util.jar.Pack200;
import java.util.jar.Pack200.Packer;
import java.util.zip.Deflater;

public class Compressor {

    public static final int COMPRESS_BUF_SIZE = 4096;

    private final Deflater txtDef = new Deflater(Deflater.BEST_COMPRESSION, true);
    private final Deflater binDef = new Deflater(Deflater.BEST_COMPRESSION, true);
    private final Encoder jarLzma = new Encoder();
    private final Packer pack = Pack200.newPacker();
    
    public static final int COPY_BUF_SIZE = 1024 * 200; // 200 KB
    private final ByteBuffer byteBuf = ByteBuffer.allocate(COPY_BUF_SIZE);
    private final byte[] buffer = byteBuf.array();

    {
        byteBuf.order(ByteOrder.LITTLE_ENDIAN);
        
        Map<String, String> p = pack.properties();
        p.put(Packer.EFFORT, "9");
        p.put(Packer.KEEP_FILE_ORDER, Packer.FALSE);
        p.put(Packer.MODIFICATION_TIME, Packer.LATEST);
        p.put(Packer.DEFLATE_HINT, Packer.FALSE);
        p.put(Packer.CODE_ATTRIBUTE_PFX+"LineNumberTable", Packer.STRIP);
        p.put(Packer.UNKNOWN_ATTRIBUTE, Packer.ERROR);

        jarLzma.SetNumFastBytes(128);
        // Fast bytes, aka Word Size [5, 273], default: 128

        jarLzma.SetAlgorithm(1);
        // 1 = normal, 0 = fast

        jarLzma.SetEndMarkerMode(false);
        // Not needed if size is written at the beginning of the file (default)

        jarLzma.SetLcLpPb(3, 0, 2);
        // Literal context bits Lc [0, 8], default: 3 (4 may help for big files)
        // Literal position bits Lp [0, 4], default: 0
        // Position bits Pb [0, 4], default: 2

        jarLzma.SetMatchFinder(1);
        // bt2  -> 0
        // bt4  -> 1
        // bt4b -> 2

        jarLzma.SetDictionarySize(22); // aka 2^22 bytes = 4 MB
    }

    private int copy(InputStream in, OutputStream out) throws IOException{
        int copied = 0;
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
            copied += len;
        }
        return copied;
    }

    private int copy(ReadableByteChannel in, OutputStream out) throws IOException{
        byteBuf.rewind();
        byteBuf.limit(byteBuf.capacity());

        int copied = 0;
        int len;
        while ((len = in.read(byteBuf)) > 0) {
            byteBuf.flip();
            out.write(buffer, 0, len);
            copied += len;
        }
        return copied;
    }

    private int copy(InputStream in, WritableByteChannel out) throws IOException {
        int copied = 0;
        int len;

        while (true) {
            len = in.read(buffer);
            if (len <= 0)
                break;

            byteBuf.rewind();
            byteBuf.limit(len);
            out.write(byteBuf);

            copied += len;
        }
        return copied;
    }

    private int copy(InputStream in, MappedByteBuffer out) throws IOException{
        int copied = 0;
        int len;
        while ((len = in.read(buffer)) > 0) {
            byteBuf.rewind();
            byteBuf.limit(len);
            out.put(byteBuf);
            copied += len;
        }
        return copied;
    }

    public void deflate(InputStream src, WritableByteChannel chan, J3PEntry entry) throws IOException{
        binDef.reset();
        DeflaterWritableChannel defChan =
                new DeflaterWritableChannel(chan, binDef, COMPRESS_BUF_SIZE);
        copy(src, defChan);
        defChan.finish();
        entry.flags |= J3PEntry.DEFLATE_COMPRESSED;
    }

    public void deflateHigh(InputStream src, WritableByteChannel chan, J3PEntry entry) throws IOException{
        txtDef.reset();
        DeflaterWritableChannel defChan =
                new DeflaterWritableChannel(chan, txtDef, COMPRESS_BUF_SIZE);
        copy(src, defChan);
        defChan.finish();
        entry.flags |= J3PEntry.DEFLATE_COMPRESSED;
    }

    public void lzma(InputStream src, WritableByteChannel chan, J3PEntry entry, long length) throws IOException{
        OutputStream out = Channels.newOutputStream(chan);
        jarLzma.WriteCoderProperties(out);
        for (int i = 0; i < 8; i++)
                out.write((byte)(length >> (8 * i)));

        jarLzma.Code(src, out, -1, -1, null);
        entry.flags |= J3PEntry.LZMA_COMPRESSED;
    }

    public void packDeflate(InputStream src, WritableByteChannel chan, J3PEntry entry) throws IOException{
        JarInputStream jis = new JarInputStream(src);
        binDef.reset();
        DeflaterWritableChannel defChan =
                new DeflaterWritableChannel(chan, binDef, COMPRESS_BUF_SIZE);
        OutputStream out = Channels.newOutputStream(defChan);
        pack.pack(jis, out);
        defChan.finish();
        entry.flags |= J3PEntry.PACK200_DEFLATE_COMPRESSED;
    }

    public void packLzma(InputStream src, WritableByteChannel chan, J3PEntry entry, long length) throws IOException{
        JarInputStream jis = new JarInputStream(src);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        pack.pack(jis, baos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

        OutputStream out = Channels.newOutputStream(chan);
        jarLzma.WriteCoderProperties(out);
        for (int i = 0; i < 8; i++)
                out.write((byte)(length >> (8 * i)));

        jarLzma.Code(bais, out, -1, -1, null);

        entry.flags |= J3PEntry.PACK200_LZMA_COMPRESSED;
    }

    public void compress(InputStream src, WritableByteChannel chan, J3PEntry entry, long length) throws IOException{
        String name = entry.name;
        int idx = name.lastIndexOf(".");
        if (idx <= 0){
            copy(src, chan);
            return;
        }

        name = name.substring(idx+1);
        name = name.toLowerCase();

        // TEXT   => MAX COMPRESSION DEFLATE
        // JAR    => PACK200 + DEFAULT DEFLATE
        // BINARY => DEFAULT DEFLATE
        // IMAGE  => RAW
        if (length < 200){
            // don't bother compressing for files less than 200 bytes
            copy(src, chan);
            return;
        }

        if (name.equals("jpg") || name.equals("jpeg") || name.equals("png") || name.equals("avi")){
            copy(src, chan);
        } else if (name.equals("xml") || name.equals("txt") || name.equals("material")
         || name.equals("sh")){
            lzma(src, chan, entry, length);
        }else if (name.equals("jar")){
            packLzma(src, chan, entry, length);
        }else if (name.equals("tga") || name.equals("dds") || name.equals("exe")){
            lzma(src, chan, entry, length);
        }else{
            lzma(src, chan, entry, length);
        }
        //copy(src, chan);
    }

}
