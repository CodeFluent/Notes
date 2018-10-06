"""
ToyCrypto is a toy cryptosystem made in python.
Made by Wasfi Momen.

"""

"""
REQUIRMENTS
    - ~~Keys are randomly generated 16 bit values~~
    - ~~Messages are randomly generated strings with
    an even number of characters~~
    - ~~Valid characters are upper case and lower case
    characters~~
    - ~~Encryption is n bytes with K being n/2 times
     (E(M) = M XOR K || K || K) with || as string concat~~
    - ~~Decryption is the same as encryption
     (D(C) = C XOR K || K || K)~~
     - Bruteforce attack

ISSUES
    - Bruteforce not completed
"""


import random
import string
import re


class ToyCrypto:

    """
    ToyCrypto class is responsible for all the functions required to
    encrypt a message, generate a key, and decrypt a message. It also
    contains a brute force algorithm to try and decrypt the message.
    """

    def __init__(self):
        self.message = self.decrypted_message = self.encrypted_message = None
        self.key = None
        self.n_bytes = 0

    def generateKey(self):
        self.key = random.getrandbits(16)
        print("\nThe key is: ", self.key)
        return self.key

    def generateMessage(self):

        # generates a string using upper and lower cases of even character lengths
        #  from 2 to up to 100 total characters.
        self.message = ''.join(random.choices(
            string.ascii_letters, k=random.randrange(2, 100, 2)))

        # save the message length (in bytes)
        self.n_bytes = len(self.message)

        print("\nThe message is: ", self.message)
        print("The message length is: ", len(self.message))
        return self.message

    def str_xor(self, s1, s2):
        """Returns the complete encrypted string."""
        # convert each character to unicode, XOR them, then use chr to convert the character
        #  back to ascii. Do this for all characters in string s1 and s2.
        done = ''.join(chr(ord(a) ^ ord(b)) for a, b in zip(s1, s2))
        return done

    def encrypt(self, key, message):
        """Returns an encrypted message string and prints status messages."""
        if (key != None and message != None):

            # calculate how many times we need to concat the key (message length in bytes / 2)
            n_times = int(self.n_bytes/2)

            # concat the key by n_times
            string_to_concat = ''.join(
                str(key) * n_times)

            # print the resulting concatenation
            print("\nThe string of K keys: ",
                  string_to_concat + " (Repeated " + str(n_times) + " times)")

            # use str_xor to concat the message and the key concatenation
            self.encrypted_message = self.str_xor(string_to_concat, message)

            # print the encrypted message
            print("\nThe encrypted message is: ", self.encrypted_message)
            print("The encrypted message length is: ",
                  len(self.encrypted_message))

            return self.encrypted_message

        elif (key is None):
            print("Key is empty, please run generateKey() first.")
            return
        elif (message is None):
            print("Message is empty, please run generateMessage() first.")
            return
        else:
            print("Unknown error.")
            return

    def decrypt(self, key, message):
        """Decryption same as encryption. Copy/pasted for convienence, but messages
        should be in other functions instead."""

        # calculate how many times we need to concat the key (message length in bytes / 2)
        n_times = int(self.n_bytes/2)

        # concat the key by n_times
        string_to_concat = ''.join(
            str(key) * n_times)

        # use str_xor to concat the message and the key concatenation
        self.decrypted_message = self.str_xor(string_to_concat, message)

        return self.decrypted_message

    def bruteForce(self, encrypted_message):
        """
        Attempts to brute force the key given an encrypted string.
        Iterates over all possible key values since the attacker knows
        the key length.
        """
        for i in range(2**16):  # 2^16 possible key values
            key_string = ""
            length_of_key = len(key_string)
            for j in range(16-length_of_key):
                key_string = "0" + key_string
            decrypted_message = self.decrypt(key_string, encrypted_message)
            if (re.match("[a-zA-Z ]+", decrypted_message)):
                print("decrypted message: ", decrypted_message)
                print("key is: ", key_string)


def main():
    toy = ToyCrypto()
    key = toy.generateKey()
    message = toy.generateMessage()
    encrypted = toy.encrypt(key, message)

    # uncomment to see decryption work
    # decrypted = toy.decrypt(key, encrypted)
    # print("\nThe decrypted message is: " + decrypted)

    # does not work
    # toy.bruteForce(encrypted)


if __name__ == '__main__':
    main()
