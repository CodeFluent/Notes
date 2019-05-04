from PIL import Image
import imagehash

hash = imagehash.dhash_vertical(Image.open("kodim02.png"))
print(hash)
