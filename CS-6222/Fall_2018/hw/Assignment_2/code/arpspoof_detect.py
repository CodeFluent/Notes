"""

arpspoof_detect.py

A program to take a pcap file and use the scapy library to detect an ARP spoof attack.
Also outputs a file of all attacks by the advesary.

Made by Wasfi Momen.

"""

"""
REQUIREMENTS:
    - ~~Input and process a Pcap file~~
    - ~~Detect an ARP spoofing attack~~
    - ~~Output a warning including the offending MAC address and packet number of the malicious packet~~
    ALL COMPLETE

ISSUES:
    - Only considers ARP spoofing as in the provided pcap, does not account for other strategies.
        - For example, if record_client registers an attacker with the same MAC address as the target, 
        then the detection will fail and warning will not be issued.
    - File I/O might need sudo privileges.
    - Broadcast address packets (ff:ff:ff:ff:ff:ff) are considered legit, so hopefully there's a 
    firewall somewhere there.
"""

from scapy.utils import rdpcap
from scapy.layers.all import *

clients = {}
f = open("attacker.txt", "w")


def get_key(value):
    """
    Returns the first key given the value. Cuz dictionaries aren't "intended" to do that. 
    Used to return the ip from a given mac address registered in the clients dictionary. 
    """
    for ip, mac in clients.items():
        if (mac == value):
            return ip


def record_client(packet):
    """Records all clients in the pcap file into the clients dictionary."""
    if ((packet.psrc and packet.hwsrc) not in clients):
        clients[packet.psrc] = packet.hwsrc


def identify_attacker(p):
    """Returns the source mac address of the attacker. Will return None if packet is legit"""
    # exclude the  standard way for ethernet packets to broadcast to all clients
    if p.dst != 'ff:ff:ff:ff:ff:ff':
        # if the ip and mac of the packet is not the same as the the registered ones
        # then we return the packet's mac address. This mac address is our advesary.
        if not((get_key(p.pdst) == p.pdst and clients.get(p.dst) == p.dst)):
            return p.src


def output_warning(packet, packet_number):
    """
    Outputs a warning for the attacker's packets.
    Also writes these warnings to a file.
    """
    if (packet != None):
        str = "Offending MAC address: %s" % packet + \
            " , " + "Packet number: %s" % packet_number + "\n"
        print(str)
        f.write(str)


# def experiments():
#     """Not used in the program. Only used to experiment with the scapy library."""

#     # EXPERIMENTS with scapy...

#     """
#     What follows are the scapy packet attributes (by layer) and their Wireshark equivalents in parentheses.
#         - p.src (Eth) is also p.psrc, p.hwsrc (ARP) as SourceMACField, SourceIPField, or ARPSourceMacField, respectively. (SenderIPAddress)
#         - p.dst (Eth) is also p.pdst, p.hwdst (ARP) as DestMacField, IPField, or MACField, respectively. (TargetMACAddress)
#         - p.pdst is just an IPField, normally the destination (TargetIPAddress)
#     """

#     # # for more info on packets
#     # for idx, p in enumerate(a):
#     #     p.show()

#     # # for more info on fields
#     # for idx, p in enumerate(a):
#     #     ls(p)

#     # # for more info on ARP layer packets
#     # for idx, p in enumerate(a):
#     #     if (p.haslayer(ARP)):
#     #         if (idx == 9):
#     #             p.show()


def main():
    # load file from same directory
    a = rdpcap('arpspoofing.pcap')

    # a.show()  # to show all packets using nsummary format

    # experiments()  # for experimental/learning purposes

    for idx, p in enumerate(a):
        if (p.haslayer(ARP)):
            # get a list of clients and their MAC addresses
            record_client(p)
            # get the source mac address of the attacker
            attacker = identify_attacker(p)
            # Output a warning with the attacker's MAC address and the offending packet number
            output_warning(attacker, idx+1)

    # print(clients)  # print out the list of clients
    f.close()  # close the open file after all functions are complete


if __name__ == '__main__':
    main()
