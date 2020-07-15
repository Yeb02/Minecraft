Linking minecraft to python with the module from     https://www.instructables.com/id/Python-coding-for-Minecraft/, and using the MCP to get an editable copy of minecraft's source code. (java)

Useful for pathfinding, 3D ploting, SLAM illustration, building, or fun.

1- guigue will be a pathfinder implemented in the jars files of minecraft. It is far from done, as I haven't found all the functions I need in the game's source yet. I am as well looking for a way of making in run on the GPU. (using java's openGL from lwjgl)

2- capture.py uses the scanner_live src from the 'tools' repo to plot live in Minecraft a phone's camera video feed.

3- pycraft_001.py and 3d_plot.py are an ongoing attempt at 3D-plotting objects from the quixel-megascan library (unreal engine). Using the threading module to speed up the process. The more core the CPU has, the faster. But it doesn't change much, so Anaconda Accelerate may be a better solution.


3D display of point clouds, here using a model from https://drive.google.com/drive/folders/1Ih_Zz9a6UcbUlaA-puEB_is7DYvXrb4w. Colors can be made to correspond to the point cloud, but it takes longer to appear in game. 


![solarized palette](https://github.com/Yeb02/Minecraft/blob/master/images/1%206l80I_oAzD-9q4eZLNR51A.png)
![solarized palette](https://github.com/Yeb02/Minecraft/blob/master/images/2020-06-21_13.29.55.png)

Chose Zuckerberg because displaying pictures with the 16 colors of wools (without K-means, just least square means) gives bad results on an image with a large palette. Therefore faces yield good renders:

![solarized palette](https://github.com/Yeb02/Minecraft/blob/master/images/MarkZuckerberg.jpg)
![solarized palette](https://github.com/Yeb02/Minecraft/blob/master/images/zuckerbis.png)
