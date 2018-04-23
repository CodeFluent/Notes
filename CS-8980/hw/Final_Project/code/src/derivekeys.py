import hmac
import hashlib
import sha
import binascii
from pbkdf2 import PBKDF2 # https://github.com/dlitz/python-pbkdf2/blob/master/pbkdf2.py

####    CONFIG VALUES   ####

# Change these to the network you are on.
SSID = "Circle of Hell"
password = "Inferno09"

# need nonces, you can grab them using wireshark and filtering by the EAPOL transport protocol
# calculated using any pseudorandomfunction with 256 bits, typically HMAC
ANonce = binascii.a2b_hex("0d27c9ec7ad78cc4c8ccba8239af3ffe681d8cb00138d5fc2fad8ff003878b5c") 
SNonce = binascii.a2b_hex("e9aeeff31097a2e98bb507e55d6e4870b007d7ea30a2f4e74198821aced42225") 

# get these from wireshark
Auth_MAC = binascii.a2b_hex("200cc8216e8a") # Mac address of authenticator (router)
Supplicant_MAC = binascii.a2b_hex("8086f2bd00f7") # Mac address of supplicant (client/victim)
Data = "dd14000fac048fa027f33ea89063500bebcfa4a42237" # data given from authentication to supplicant in step 1

####    STEP 1 OF HANDSHAKE    #### 
print("\n####\tStep 1 of Handshake\t####")

# derive the pairwise master key
print("\nCreating Pairwise Master Key...\n");
PMK = PBKDF2(password, SSID, 4096).read(32).encode("hex") # 32 bytes max for password
                                                          # HMAC-SHA1 is included in the PBKDF2 library, default PRF
print("Pairwise Master Key: \n" + PMK)


# derive the pairwise transient key

print("\nCreating Pairwise Transient Key...\n");

# PTK is typically 512 bits and a version of HMAC
# http://etutorials.org/Networking/802.11+security.+wi-fi+protected+access+and+802.11i/Part+II+The+Design+of+Wi-Fi+Security/Chapter+10.+WPA+and+RSN+Key+Hierarchy/Computing+the+Temporal+Keys/
# input parameters are:
    # the PMK
    # a string, normally "Pairwise Key Expansion"
    # concatenation of our nonces and mac addresses of the supplicant and authenticator
def PRF(pmk, str, concat):
    numBytes = 64 # max allowed in EAPOL
    i = 0 # intial count
    R = '' # register

    while (i <= (numBytes * 8 + 159) / 160):
        hmacsha1 = hmac.new(pmk, str+chr(0x00)+concat+chr(i), hashlib.sha1) # supplied parameters are pmk, the concat string with padding and sha-1 hash
        i+=1
        R = R + hmacsha1.digest()
    return R[0:numBytes] # return bit 0 till 64th bit

str_concat = min(Auth_MAC, Supplicant_MAC) + max(Auth_MAC, Supplicant_MAC) + min(ANonce, SNonce) + max(ANonce, SNonce) # from the standard
PTK = PRF(PMK, "Pairwise Key Expansion", str_concat).encode("hex")

print("Pairwise Transient Key: \n" + PTK)


# dervice the MIC (Message Integrity Code)

# mic1 = hmac.new(PTK[0:16], Data).hexdigest()

# print("\nMessage Integrity Code: \n" + mic1)


print("\n")



