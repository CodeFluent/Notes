from PIL import Image
import imagehash
import os


folder_path = "../images/"


def computeHashesForImages():

    for root, dirs, files in os.walk("./images/misc"):
        for filename in files:
            print(filename)
            hash = imagehash.dhash_vertical(
                Image.open("./images/misc/" + filename))
            print("\t%s" % hash)


computeHashesForImages()
