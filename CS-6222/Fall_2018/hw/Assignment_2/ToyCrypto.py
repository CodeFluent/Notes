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
import string


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
        self.n_bytes = self.utf8len(self.message)

        print("\nThe message is: ", self.message)
        print("The message length is: ", self.utf8len(self.message))
        return self.message

    def str_xor(self, s1, s2):
        done = "".join([chr(ord(c1) ^ ord(c2)) for (c1, c2) in zip(s1, s2)])
        print("Formatted: {:02x}".format(done))
        return done

    def encrypt(self, key, message):
        if (key != None and message != None):

            n_times = int(self.n_bytes/2)
            string_to_concat = ''.join(
                str(key) * n_times)  # K || K n/2 times

            # can uncomment to see the keys concatenated
            print("\nThe string of K keys: ",
                  string_to_concat + " (Repeated " + str(n_times) + " times)")

            # self.str_xor(str(key), message)
            # self.str_xor("100", "100")

            # self.encrypted_message = (
            #     int(message, 2) ^ int(string_to_concat, 2)) * 100
            print("\nThe encrypted message is: ", self.encrypted_message)

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
        #  decryption same as encryption
        return self.encrypt(key, message)

    def bruteForce(self):
        pass

    def utf8len(self, string):
        """Returns the actual length of a string in bytes."""
        return len(string.encode('utf-8'))


def main():
    toy = ToyCrypto()
    key = toy.generateKey()
    message = toy.generateMessage()
    encrypted = toy.encrypt(key, message)
    decrypted = toy.decrypt(key, encrypted)


if __name__ == '__main__':
    main()
