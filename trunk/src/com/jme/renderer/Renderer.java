/*
 * Copyright (c) 2003-2004, jMonkeyEngine - Mojo Monkey Coding
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the Mojo Monkey Coding, jME, jMonkey Engine, nor the
 * names of its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.jme.renderer;

import com.jme.bounding.BoundingVolume;
import com.jme.curve.Curve;
import com.jme.effects.Tint;
import com.jme.scene.Clone;
import com.jme.scene.CloneNode;
import com.jme.scene.Geometry;
import com.jme.scene.Line;
import com.jme.scene.Point;
import com.jme.scene.Spatial;
import com.jme.scene.Text;
import com.jme.scene.TriMesh;
import com.jme.scene.state.AlphaState;
import com.jme.scene.state.AttributeState;
import com.jme.scene.state.CullState;
import com.jme.scene.state.DitherState;
import com.jme.scene.state.FogState;
import com.jme.scene.state.FragmentProgramState;
import com.jme.scene.state.LightState;
import com.jme.scene.state.MaterialState;
import com.jme.scene.state.ShadeState;
import com.jme.scene.state.StencilState;
import com.jme.scene.state.TextureState;
import com.jme.scene.state.VertexProgramState;
import com.jme.scene.state.WireframeState;
import com.jme.scene.state.ZBufferState;
import com.jme.widget.WidgetRenderer;

/**
 * <code>Renderer</code> defines an interface that handles displaying
 * of graphics data to the context. Creation of this object is typically
 * handled via a call to a <code>DisplaySystem</code> subclass.
 *
 * All rendering state and tasks can be handled through this interface.
 *
 * Example Usage:<br>
 * NOTE: This example uses the <code>DisplaySystem</code> class to obtain the
 * <code>Renderer</code>.
 *
 * <code>
 * DisplaySystem ds = new LWJGLDisplaySystem();<br>
 * ds.createWindow(640,480,16,60,false);<br>
 * Renderer r = ds.getRenderer();<br>
 * r.draw(point);<br>
 * </code>
 * @see com.jme.system.DisplaySystem
 * @author Mark Powell
 * @version $Id: Renderer.java,v 1.39 2004-08-20 23:21:21 ericthered Exp $
 */
public interface Renderer {

    // TODO: Javadoc these
    public final static int QUEUE_INHERIT      = 0;
    public final static int QUEUE_SKIP         = 1;
    public final static int QUEUE_OPAQUE       = 2;
    public final static int QUEUE_TRANSPARENT  = 3;
    public final static int QUEUE_ORTHO        = 4;

    /**
     * <code>setCamera</code> sets the reference to the applications camera
     * object.
     * @param camera the camera object to use with this <code>Renderer</code>.
     */
    public void setCamera(Camera camera);

    /**
     * <code>createCamera</code> retrieves the camera this renderer is using.
     * @return the camera this renderer is using.
     */
    public Camera getCamera();

    /**
     *
     * <code>createCamera</code> retrieves a default camera for this renderer.
     * @param width the width of the frame.
     * @param height the height of the frame.
     * @return a default camera for this renderer.
     */
    public Camera createCamera(int width, int height);

    /**
     * @deprecated Use createCamera.
     * @see #createCamera(int, int)
     */
    public Camera getCamera(int width, int height);

    /**
     *
     * <code>createAlphaState</code> retrieves the alpha state object for the
     * proper renderer.
     * @return the <code>AlphaState</code> object that can make use of the
     *      proper renderer.
     */
    public AlphaState createAlphaState();

    /**
     * @deprecated Use createAlphaState.
     * @see #createAlphaState()
     *
     */
    public AlphaState getAlphaState();

    /**
     *
     * <code>createAttributeState</code> retrieves the attribute saving state
     * object for the proper renderer.
     * @return the <code>AttributeState</code> object that can make use of
     * 		the proper renderer.
     */
    public AttributeState createAttributeState();

    /**
     * @deprecated Use createAttributeState.
     * @see #createAttributeState()
     */
    public AttributeState getAttributeState();

    /**
     *
     * <code>createCullState</code> retrieves the cull state object for the
     * proper renderer.
     * @return the <code>CullState</code> object that can make use of the
     *      proper renderer.
     */
    public CullState createCullState();

    /**
     * @deprecated Use createCullState.
     * @see #createCullState()
     */
    public CullState getCullState();
    /**
     *
     * <code>createDitherState</code> retrieves the dither state object for the
     * proper renderer.
     * @return the <code>DitherState</code> object that can make use of the
     *      proper renderer.
     */
    public DitherState createDitherState();

    /**
     * @deprecated Use createDitherState.
     * @see #createDitherState()
     */
    public DitherState getDitherState();

    /**
     *
     * <code>createFogState</code> retrieves the fog state object for the
     * proper renderer.
     * @return the <code>FogState</code> object that can make use of the
     *      proper renderer.
     */
    public FogState createFogState();

    /**
     * @deprecated Use createFogState.
     * @see #createFogState()
     */
    public FogState getFogState();

    /**
     *
     * <code>createLightState</code> retrieves the light state object for the
     * proper renderer.
     * @return the <code>LightState</code> object that can make use of the
     *      proper renderer.
     */
    public LightState createLightState();

    /**
     * @deprecated Use createLightState
     * @see #createLightState()
     */
    public LightState getLightState();

    /**
     *
     * <code>createMaterialState</code> retrieves the material state object for the
     * proper renderer.
     * @return the <code>MaterialState</code> object that can make use of the
     *      proper renderer.
     */
    public MaterialState createMaterialState();


    /**
     * @deprecated Use createMaterialState.
     * @see #createMaterialState()
     */
    public MaterialState getMaterialState();

    /**
     *
     * <code>createShadeState</code> retrieves the shade state object for the
     * proper renderer.
     * @return the <code>ShadeState</code> object that can make use of the
     *      proper renderer.
     */
    public ShadeState createShadeState();

    /**
     * @deprecated Use createShadeState.
     * @see #createShadeState()
     */
    public ShadeState getShadeState();

    /**
     *
     * <code>createTextureState</code> retrieves the texture state object for the
     * proper renderer.
     * @return the <code>TextureState</code> object that can make use of the
     *      proper renderer.
     */
    public TextureState createTextureState();

    /**
     * @deprecated Use createTextureState.
     * @see #createTextureState()
     */
    public TextureState getTextureState();

    /**
     *
     * <code>createWireframeState</code> retrieves the wireframe state object for the
     * proper renderer.
     * @return the <code>WireframeState</code> object that can make use of the
     *      proper renderer.
     */
    public WireframeState createWireframeState();

    /**
     * @deprecated Use createWireframeState.
     * @see #createWireframeState()
     */
    public WireframeState getWireframeState();

    /**
     * Retrieves the Z buffer state object for the proper renderer.
     * @return The <code>ZBufferState</code> object that can make use of the
     *      proper renderer.
     */
    public ZBufferState createZBufferState();

    /**
     * @deprecated Use createZBufferState.
     * @see #createZBufferState()
     */
    public ZBufferState getZBufferState();

    /**
     * Retrieves the vertex program state object for the proper renderer.
     * @return The <code>VertexProgramState</code> object that can make use of the
     *      proper renderer.
     */
    public VertexProgramState createVertexProgramState();

    /**
     * @deprecated Use createVertexProgramState.
     * @see #createVertexProgramState()
     */
    public VertexProgramState getVertexProgramState();    
    
    /**
     * @deprecated Use createFragmentProgramState.
     * @see #createFragmentProgramState()
     */
    public FragmentProgramState getFragmentProgramState();
    
    /**
     * Retrieves the fragment program state object for the proper renderer.
     * @return The <code>VertexProgramState</code> object that can make use of the
     *      proper renderer.
     */
    public FragmentProgramState createFragmentProgramState();

    /**
     * Retrieves the stencil state object for the proper renderer.
     * @return The <code>StencilState</code> object that can make use of the
     *      proper renderer.
     */
    public StencilState createStencilState();

    /**
     * @deprecated Use createStencilState
     * @see #createStencilState()
     */
    public StencilState getStencilState();

    /**
     * If true, statistical upkeep of information is done during rendering.
     * @param value Should the renderer keep track of statistical information?
     */
    public void enableStatistics(boolean value);

    /** Reset rendering tracking statistical information. */
    public void clearStatistics();
    /**
     * Returns statistical data as a String.  The data is renderer specific but usually contains
     * triangle and vertex counts at a minimum.
     * @return Statistical data for the renderer.
     */
    public String getStatistics();

    /**
     * <code>setBackgroundColor</code> sets the color of window. This color
     * will be shown for any pixel that is not set via typical rendering
     * operations.
     * @param c the color to set the background to.
     */
    public void setBackgroundColor(ColorRGBA c);

    /**
     * <code>getBackgroundColor</code> retrieves the color used for the
     * window background.
     * @return the background color that is currently set to the background.
     */
    public ColorRGBA getBackgroundColor();

    /**
     * <code>clearZBuffer</code> clears the depth buffer of the renderer.
     * The Z buffer allows sorting of pixels by depth or distance from the
     * view port. Clearing this buffer prepares it for the next frame.
     *
     */
    public void clearZBuffer();

    /**
     * <code>clearBackBuffer</code> clears the back buffer of the renderer.
     * The backbuffer is the buffer being rendered to before it is displayed
     * to the screen. Clearing this buffer frees it for rendering the next
     * frame.
     *
     */
    public void clearBackBuffer();

    /**
     * <code>clearBuffers</code> clears both the depth buffer and the
     * back buffer.
     *
     */
    public void clearBuffers();

    /**
     * <code>displayBackBuffer</code> swaps the back buffer with the currently
     * displayed buffer. Swapping (page flipping) allows the renderer to display
     * a prerenderer display without any flickering.
     *
     */
    public void displayBackBuffer();

    /**
     *
     * <code>setOrtho</code> sets the display system to be in orthographic mode.
     * If the system has already been set to orthographic mode a
     * <code>JmeException</code> is thrown. The origin (0,0) is the bottom left
     * of the screen.
     *
     */
    public void setOrtho();

    /**
     *
     * <code>setOrthoCenter</code> sets the display system to be in orthographic mode.
     * If the system has already been set to orthographic mode a
     * <code>JmeException</code> is thrown. The origin (0,0) is the center
     * of the screen.
     *
     *
     */
    public void setOrthoCenter();

    /**
     *
     * <code>unsetOrhto</code> unsets the display system from orthographic mode
     * back into regular projection mode. If the system is not in orthographic
     * mode a <code>JmeException</code> is thrown.
     *
     *
     */
    public void unsetOrtho();

    /**
     *
     * <code>takeScreenShot</code> saves the current buffer to a png file.
     * The filename is provided, .png will be appended to the end of the
     * name.
     * @param filename the name of the screenshot file.
     * @return true if the screen capture was successful, false otherwise.
     */
    public boolean takeScreenShot(String filename);

    /**
     * <code>draw</code> renders a scene. As it recieves a base class of
     * <code>Spatial</code> the renderer hands off management of the
     * scene to spatial for it to determine when a <code>Geometry</code>
     * leaf is reached.
     * @param s the scene to render.
     */
    public void draw(Spatial s);

    /**
     * <code>drawBounds</code> renders the bounds of a Clone.
     * @param c the clone whose bounds you want to render.
     */
    public void drawBounds(Clone c);

    /**
     * <code>drawBounds</code> renders the bounds of a Geometry. As it recieves a base class of
     * <code>Geometry</code> the renderer hands off management of the
     * scene to spatial for it to determine when a <code>Geometry</code>
     * leaf is reached.
     * @param s the Spatial to render bounds for.
     */
    public void drawBounds(Spatial s);

    /**
     * <code>drawBounds</code> renders the bounds of a Geometry. As it recieves a base class of
     * <code>BoundingVolume</code> the renderer hands off management of the
     * scene to spatial for it to determine when a <code>Geometry</code>
     * leaf is reached.
     * @param bv the BoundingVolume to render.
     */
    public void drawBounds(BoundingVolume bv);

    /**
     * <code>drawBounds</code> renders the bounds of a Geometry. As it recieves a base class of
     * <code>Geometry</code> the renderer hands off management of the
     * scene to spatial for it to determine when a <code>Geometry</code>
     * leaf is reached.
     * @param g the Geometry to render.
     */
    public void drawBounds(Geometry g);


    /**
     * <code>draw</code> renders a tint to the back buffer
     * @param t is the tint to render.
     */
    public void draw(Tint t);

    /**
     * <code>draw</code> renders a single point to the back buffer.
     * @param p the point to be rendered.
     */
    public void draw(Point p);

    /**
     * <code>draw</code> renders a line to the back buffer.
     * @param l the line to be rendered.
     */
    public void draw(Line l);

    /**
     *
     * <code>draw</code> renders a curve to the back buffer.
     * @param c the curve to be rendered.
     */
    public void draw(Curve c);

    /**
     *
     * <code>draw</code> renders text to the back buffer.
     * @param t the text object to be rendered.
     */
    public void draw(Text t);

    /**
     * <code>draw</code> renders a triangle mesh to the back buffer.
     * @param t the mesh to be rendered.
     */
    public void draw(TriMesh t);

    /**
     * Draws a cloned node to the back buffer
     * @param cn The node to be rendered.
     */
    public void draw(CloneNode cn);

    /**
     * Draws a cloned object to the back buffer.
     * @param c The clone to draw.
     */
    public void draw(Clone c);

    /**
     * <code>draw</code> renders a Widget that is associated
     * with the WidgetRenderer object to the back buffer.
     * @param wr the WidgetPanel to be rendered.
     */
    public void draw(WidgetRenderer wr);


    /**
     * Get the render queue associated with this Renderer.
     * @return RenderQueue
     */
    public RenderQueue getQueue();

    /**
     * Return true if this renderer is in the middle of processing
     * its RenderQueue.
     * @return boolean
     */
    public boolean isProcessingQueue();

    /**
     * Check a given Spatial to see if it should be queued.  return true if it was queued
     * @param s Spatial to check
     * @return true if it was queued.
     */
    public boolean checkAndAdd(Spatial s);

    /**
     * Return true if the system running this supports VBO
     * @return boolean
     */
    public boolean supportsVBO();
}
