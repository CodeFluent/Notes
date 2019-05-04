from PIL import Image
import imagehash
import os
import time


folder_path = "../images/"


def computeHashesForImages():

    for root, dirs, files in os.walk("./images/misc"):
        for filename in files:
            print(filename)

            start = time.time()
            value =
            hash = imagehash.dhash_vertical(
                Image.open("./images/misc/" + filename))
            print("\t%s" % hash)


computeHashesForImages()
