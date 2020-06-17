import sys
sys.path.append(r'C:\Users\alpha\AppData\Roaming\.minecraft\mcpipy')

import matplotlib.pyplot as plt
import cv2
import numpy as np
import time
from mine import *


im = cv2.imread(r'C:\Users\alpha\Downloads\84730486_206146350535635_8164266718370201600_n.jpg')
shape = im.shape
im = cv2.resize(im, (int(shape[1]/6), int(shape[0]/6)))

mc = Minecraft()

playerPos = mc.player.getPos()
# x1 = playerPos.x + 346
# z1 = playerPos.z + 570
# y1 = playerPos.y + 4




###########


def draw1(im, playerPos):
    couleurs = []
    for a in range(251):
        couleurs.append(block.Block(a).getRGBA())

    x1 = playerPos.x
    z1 = playerPos.z
    y1 = playerPos.y
    for a in range(im.shape[0]):
        for b in range(im.shape[1]):
            co = im[a][b]
            min = 1000000
            comin = 0
            for i, elt in enumerate(couleurs):
                dist = ((co[0] - elt[2])**2 + (co[1] - elt[1])**2 + (co[2] - elt[0])**2)
                if min > dist:
                    min = dist
                    comin = i

            mc.setBlock(x1 + a, y1 -1, z1 + b, block.Block(comin))
            # mc.setBlock(x1 + a, y1 -2, z1 + b, block.Block(168))
        # mc.postToChat(a)
        # mc.postToChat(mcblock)
        # mc.postToChat(comin)

############



def draw2(im, playerPos):

    couleurs = [[[] for i in range(20)] for j in range(251)]
    tri = []
    indices = []
    for a in range(251):
        for b in range(20):
            c = block.Block(a, b).getRGBA()
            if not c in tri:
                tri.append(c)
                couleurs[a][b] = c
                indices.append([a, b])


    x1 = playerPos.x
    z1 = playerPos.z
    y1 = playerPos.y
    for a in range(im.shape[0]):
        for b in range(im.shape[1]):
            co = im[a][b]
            min = 1000000
            comin = 0
            for elt in indices:
                col = couleurs[elt[0]][elt[1]]
                dist = ((co[0] - col[2])**2 + (co[1] - col[1])**2 + (co[2] - col[0])**2)
                if min > dist:
                    min = dist
                    comin = elt
            mc.setBlock(x1 + a, y1 -1, z1 + b, block.Block(comin))

############




def draw3(im, playerPos):
    u = [[35, k] for k in range(15)]
    v = [[171, k] for k in range(15)]
    indices = u + v

    x1 = playerPos.x
    z1 = playerPos.z
    y1 = playerPos.y
    for a in range(im.shape[0]):
        for b in range(im.shape[1]):
            co = im[a][b]
            min = 1000000000
            comin = 0
            for elt in indices:
                col = block.Block(elt).getRGBA()
                dist = ((co[0] - col[2])**2 + (co[1] - col[1])**2 + (co[2] - col[0])**2)
                if min > dist:
                    min = dist
                    comin = elt
            mc.setBlock(x1 + a, y1 -1, z1 + b, block.Block(comin))



########
# mc.postToChat("x={0}, y={1}, z={2}".format(x1, y1, z1))
mc.postToChat("Running")
draw3(im, playerPos)
mc.postToChat("Done")
