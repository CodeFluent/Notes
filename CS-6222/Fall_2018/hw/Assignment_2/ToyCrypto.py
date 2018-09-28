"""
ToyCrypto is a toy cryptosystem made in python.
Made by Wasfi Momen.

"""

"""
REQUIRMENTS
    - Keys are randomly generated 16 bit values
    - Messages are randomly generated strings with 
    an even number of characters
    - Valid characters are upper case and lower case
    characters
    - Encryption is n bytes with K being n/2 times
     (E(M) = M XOR K || K || K) with || as string concat
    - Decryption is the same as encryption
     (D(C) = C XOR K || K || K)
     - Bruteforce attack

"""


import random


class ToyCrypto:

    """
    ToyCrypto class is responsible for all the functions required to 
    encrypt a message, generate a key, and decrypt a message. It also
    contains a brute force algorithm to try and decrypt the message.
    """

    def __init__(self, message, encrypted_message, decrypted_message, key):
        self.message = message
        self.encrypted_message = encrypted_message
        self.decrypted_message = decrypted_message
        self.key = key

    def generateKey():
