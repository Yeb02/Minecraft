import sys
import matplotlib.pyplot as plt
import cv2
import numpy as np
import time
import requests
import threading
sys.path.append(r'C:\Users\alpha\AppData\Roaming\.minecraft\mcpipy')
from mine import *


url = 'http://192.168.43.1:8080/shot.jpg'


u = [[35, k] for k in range(15)]
v = [[171, k] for k in range(15)]
indices = u + v

col = []
for elt in indices:
    col.append(block.Block(elt).getRGBA())


mc = Minecraft()            #pas dans la boucle , question de visibilité in game
playerPos = mc.player.getPos()


def draw_live(im, playerPos, col):

    x1 = playerPos.x
    z1 = playerPos.z
    y1 = playerPos.y

    for a in range(im.shape[0]):
        for b in range(im.shape[1]):
            co = im[a][b]
            min = 1000000000
            comin = 0
            for i, elt in enumerate(col):
                dist = ((co[0] - elt[2])**2 + (co[1] - elt[1])**2 + (co[2] - elt[0])**2)
                if min > dist:
                    min = dist
                    comin = i
            mc.setBlock(x1 + a, y1 -1, z1 + b, block.Block(indices[comin]))

while True:
    img_resp = requests.get(url)
    img_arr = np.array(bytearray(img_resp.content), np.uint8)
    im = cv2.imdecode(img_arr, -1)

    shape = im.shape
    im = cv2.resize(im, (int(shape[1]/10), int(shape[0]/10)))

    draw_live(im, playerPos, col)
    # while True:
    #     if cv2.waitKey(1) == 32:  #espace
    #         break

    # time.sleep(.5)


    # cv2.imshow("Live",  img)
    # if cv2.waitKey(1) == 27:
    #     break