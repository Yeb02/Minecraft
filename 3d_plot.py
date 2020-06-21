import sys
import matplotlib.pyplot as plt
import cv2
import numpy as np
import time
import requests
import threading
sys.path.append(r'C:\Users\alpha\AppData\Roaming\.minecraft\mcpipy')
from mine import *
from mpl_toolkits.mplot3d import Axes3D

mc = Minecraft()   #co : le mod place mal: en 0 0 0 , 371, -4, 201


# file_data_path= r"C:\Users\alpha\Downloads\sample.xyz"
# point_cloud= np.loadtxt(file_data_path, skiprows=1, max_rows=1000000)

def draw_3D(cloud):
    u = [[35, k] for k in range(15)]
    v = [[171, k] for k in range(15)]
    indices = u + v
    playerPos = mc.player.getPos()
    x1 = playerPos.x
    z1 = playerPos.z
    M = np.amin(point_cloud[:,2:3])
    m = 246 / (np.amax(point_cloud[:,2:3]) - M)
    for k in range(len(cloud)):
        # co = cloud[k][3:]
        # min = 195076    #1000000000 ? 3 * 255 ** 2  +1
        # comin = 0
        # for elt in indices:
        #     col = block.Block(elt).getRGBA()
        #     dist = ((co[0] - col[2])**2 + (co[1] - col[1])**2 + (co[2] - col[0])**2)
        #     if min > dist:
        #         min = dist
        #         comin = elt
        # mc.setBlock(x1 + m * (cloud[k][0] - M), m * (cloud[k][2] - M) + 4, z1 + m * (cloud[k][1] - M), block.Block(comin))

        mc.setBlock(x1 + m * (cloud[k][0] - M), m * (cloud[k][2] - M) + 4, z1 + m * (cloud[k][1] - M), block.Block([35, 1]))

draw_3D(point_cloud)


# mean_Z=np.mean(point_cloud,axis=0)[2]
# spatial_query=point_cloud[abs( point_cloud[:,2]-mean_Z)<1]
# xyz=spatial_query[:,:3]
# rgb=spatial_query[:,3:]
# ax = plt.axes(projection='3d')
# ax.scatter(xyz[:,0], xyz[:,1], xyz[:,2], c = rgb/255, s=0.01)
# plt.show()