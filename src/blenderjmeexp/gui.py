__version__ = '$Revision$'
__date__ = '$Date$'
__author__ = 'Blaine Simpson, blaine (dot) simpson (at) admc (dot) com'
__url__ = 'http://www.jmonkeyengine.com'

# Copyright (c) 2009, Blaine Simpson and the jMonkeyEngine team
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#     * Redistributions of source code must retain the above copyright
#       notice, this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above copyright
#       notice, this list of conditions and the following disclaimer in the
#       documentation and/or other materials provided with the distribution.
#     * Neither the name of the <organization> nor the
#       names of its contributors may be used to endorse or promote products
#       derived from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY Blaine Simpson and the jMonkeyEngine team
# ''AS IS'' AND ANY
# EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
# WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
# DISCLAIMED. IN NO EVENT SHALL Blaine Simpson or the jMonkeyEngine team
# BE LIABLE FOR ANY
# DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
# ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

import Blender
from Blender import Draw
from Blender import BGL
from bpy import data
import exporter
from os import path
from blenderjmeexp import resFileAbsPath
from blenderjmeexp.wrapperclasses import *
from traceback import tb_lineno
from sys import exc_info
from os.path import isfile

defaultFilePath = path.abspath("default-jme.xml")
saveAll = False
xmlFile = None
BTNID_SAVEALL = 1
BTNID_SAVE = 2
BTNID_CANCEL = 3
BTNID_OVERWRITE = 4
selCount = None
allCount = None
fileOverwrite = False

def exitModule():
    global guiBox, selCount, allCount
    guiBox.free()
    selCount = None
    allCount = None
    Draw.Exit()
    print "Exiting exporter"

def updateExportableCounts():
    """Returns counts of all exportable objects, and all selected exportable
    objects"""

    global selCount, allCount
    selCount = 0
    allCount = 0
    for o in data.objects:
        if JmeNode.supported(o): allCount = allCount + 1
    for o in data.scenes.active.objects.selected:
        if JmeNode.supported(o): selCount = selCount + 1

def btnHandler(btnId):
    global saveAll, xmlFile, defaultFilePath, fileOverwrite
    if btnId == BTNID_SAVEALL:
        saveAll = not saveAll
        return
    if btnId == BTNID_OVERWRITE:
        fileOverwrite = not fileOverwrite
        return
    if btnId == BTNID_SAVE:
        try:
            xmlFile = exporter.gen(saveAll, True)
        except Exception, e:
            # Python 2.5 does not support "except X as y:" syntax
            ei = exc_info()[2]
            while ei:
                print ("  " + ei.tb_frame.f_code.co_filename + ':'
                    + str(tb_lineno(ei)))
                ei = ei.tb_next
            print e
            if 1 == Draw.PupMenu(str(e) + "%t|Abort|Try other settings"):
                exitModule()
            return
        Blender.Window.FileSelector(saveFile, "Write XML file", defaultFilePath)
        # TODO:  Upon successful save, store file path to Blender registry
        # so that we can use it as default the next time.
        return
    if btnId == BTNID_CANCEL:
        exitModule()
        return

def inputHandler(eventNum, press): # press is set for mouse movements. ?
    if not press: return
    if eventNum == Draw.ESCKEY:
        print "Got ESC"
        exitModule()

class GuiBox(object):
    __slots__ = ['x', 'y', 'w', 'h', '__imgs', '__imgpaths']

    def __init__(self, w, h, imgpaths):
        object.__init__(self)
        self.w = w
        self.h = h
        availableW, availableH = Blender.Window.GetAreaSize()
        if w > availableW or h > availableH:
            raise Exception("Current Window not large enough for our Gui")
        self.x = (availableW - self.w) / 2
        self.y = (availableH - self.h) / 2
        self.__imgpaths = imgpaths
        self.__loadImages()

    def __loadImages(self):
        self.__imgs = []
        for path in self.__imgpaths:
            self.__imgs.append(Blender.Image.Load(resFileAbsPath(path)))
        for img in self.__imgs: img.glLoad()

    def free(self):
        for img in self.__imgs: img.glFree()
        self.__imgs = None

    def drawBg(self):
        if self.__imgs == None: self.__loadImages()
        BGL.glColor3f(.95,.54,.24)
        BGL.glRectf(self.x, self.y, self.x + self.w, self.y + self.h)
        BGL.glColor3f(1, 1, 1)
        BGL.glRectf(self.x + 5, self.y + 5,
                self.x + self.w - 5, self.y + self.h - 5)

        imgDim = self.__imgs[0].getSize()[0]; # Unfortunately [0] == [1]
        imgY = self.y + self.h - imgDim   # Img starts at top of gui box
        imgX = self.x + (self.w - len(self.__imgs) * imgDim) / 2
          # Centered horizontally in gui box
        for img in self.__imgs:
            BGL.glEnable(BGL.GL_TEXTURE_2D)
            BGL.glBindTexture(BGL.GL_TEXTURE_2D, img.getBindCode())
            BGL.glBegin(BGL.GL_POLYGON)
            BGL.glTexCoord2f(0.0,0.0) 
            BGL.glColor3f(1.0,1.0,1.0)
            BGL.glVertex3f(float(imgX),float(imgY),0.0)
            BGL.glTexCoord2f(1.0,0.0)
            BGL.glColor3f(1.0,1.0,1.0)
            BGL.glVertex3f(float(imgX + imgDim),float(imgY),0.0)
            BGL.glTexCoord2f(1.0,1.0)
            BGL.glColor3f(1.0,1.0,1.0)
            BGL.glVertex3f(float(imgX+imgDim),float(imgY+imgDim),0.0)
            BGL.glTexCoord2f(0.0,1.0)	
            BGL.glColor3f(1.0,1.0,1.0)
            BGL.glVertex3f(float(imgX),float(imgY+imgDim),0.0 )
            imgX += imgDim
            BGL.glEnd() 
            BGL.glDisable(BGL.GL_TEXTURE_2D)

        # Anything done after the image writing writes with BLACK
        #BGL.glColor3f(1., 0., 0.)
        #BGL.glRectf(self.x, y, self.x + self.w, self.y + self.h -  self.imgH)


guiBox = GuiBox(330, 300,
        ['bje1.png', 'bje2.png', 'bje3.png', 'bje4.png', 'bje5.png'])

def redrawDummy(x, y): Draw.Redraw()

def saveFile(filepath):
    # Can only get here when our Gui is present, but completely overwritten
    # by the FileSelector window.
    global defaultFilePath, fileOverwrite

    try:
        if filepath.endswith(".blend"):
            raise Exception(
            "You should only save Blender native files with extension '.blend'")
        if isfile(filepath) and (not fileOverwrite) and (1 != Draw.PupMenu(
                "Overwrite '" + filepath + "'?%t|Yes|No")): return
        print "Attempting to save file '" + filepath + "'"
        xmlFile.writeFile(filepath)
        print "Saved file '" + filepath + "'"
        defaultFilePath = filepath
        exitModule()
    except Exception, e:
        # Python 2.5 does not support "except X as y:" syntax
        ei = exc_info()[2]
        while ei:
            print ("  " + ei.tb_frame.f_code.co_filename + ':'
                + str(tb_lineno(ei)))
            ei = ei.tb_next
        print e
        if 1 == Draw.PupMenu(str(e) + "%t|Abort|Try other settings"):
            exitModule()
            return
        print "Will retry"

def drawer():
    global saveAll, guiBox, selCount, allCount, fileOverwrite

    BGL.glClear(BGL.GL_COLOR_BUFFER_BIT)
    guiBox.drawBg()
    Draw.PushButton("Cancel", BTNID_CANCEL,
            guiBox.x + 10, guiBox.y + 10, 50, 20, "Abort export")
    Draw.Label(" (c) 2009 Blaine Simpson"
            guiBox.x + 170, guiBox.y + 23,145,10)
    Draw.Label("+ the jMonkeyEngine team",
            guiBox.x + 160, guiBox.y + 9,157,10)
    if not allCount: updateExportableCounts()
    if allCount < 1:
        Draw.Label("Your scenes contain no",
                guiBox.x + 10, guiBox.y + 200,200,20)
        Draw.Label("export-supported objects",
                guiBox.x + 10, guiBox.y + 170,200,20)
        return
    if saveAll:
        toggleText = str(allCount) + " Scene Object(s)"
    else:
        toggleText = str(selCount) + " Selected Object(s)"
    Draw.Toggle(toggleText,
            BTNID_SAVEALL, guiBox.x + 10, guiBox.y + 200, 130, 20, saveAll,
            "Choose to export supported SELECTED objects or ALL objects",
            redrawDummy)
            # Would prefer to make a 2-line button, but Draw does not
            # support that... or basically anything other than vanilla.
    Draw.Toggle("Overwrite", BTNID_OVERWRITE,
            guiBox.x + 10, guiBox.y + 155, 60, 20, fileOverwrite,
            "Silently overwrite export file if it exists beforehand")
    Draw.PushButton("Export", BTNID_SAVE,
            guiBox.x + 10, guiBox.y + 50, 50, 20, "Select file to save to")
    Draw.Label("Reserved space", guiBox.x + 180, guiBox.y + 150,200,20)
    Draw.Label("More space", guiBox.x + 180, guiBox.y + 100,200,20)
