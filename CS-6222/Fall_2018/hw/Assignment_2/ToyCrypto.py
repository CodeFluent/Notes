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
        if (key != None and message != None):

            # calculate how many times we need to concat the key (message length in bytes / 2)
            n_times = int(self.n_bytes/2)

            # concat the key by n_times
            string_to_concat = ''.join(
                str(key) * n_times)

            # print the resulting concatenation
            print("\nThe string of K keys: ",
                  string_to_concat + " (Repeated " + str(n_times) + " times)")

            # use str_xor to do the actual encryption process
            self.encrypted_message = self.str_xor(str(key), message)

            # print the encrypted message
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
        print("\n" + "-"*10 + "DECRYPTION" + "-"*10)
        return self.encrypt(key, message)

    def bruteForce(self):
        pass


def main():
    toy = ToyCrypto()
    key = toy.generateKey()
    message = toy.generateMessage()
    encrypted = toy.encrypt(key, message)
    # decrypted = toy.decrypt(key, encrypted)


if __name__ == '__main__':
    main()
