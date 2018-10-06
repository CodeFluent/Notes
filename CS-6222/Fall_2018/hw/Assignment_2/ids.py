"""

ids.py

A program to take a pcap file and use the scapy library to detect a TCP SYN port scan.

Made by Wasfi Momen.

"""

from scapy.utils import rdpcap
from scapy.layers.all import *

clients = {
    "192.168.0.100": "7c:d1:c3:94:9e:b8",
    # typo in assignment .103 should be .101 and MAC is 60:fe not d8:96
    "192.168.0.101": "60:fe:c5:9e:63:3c",
    "192.168.0.1": "f8:1a:67:cd:57:6e"
}


def get_key(value):
    """
    Returns the first key given the value. Cuz dictionaries aren't "intended" to do that. 
    Used to return the ip from a given mac address registered in the clients dictionary. 
    """
    for ip, mac in clients.items():
        if (mac == value):
            return ip


# def record_client(packet):
#     """Records all clients in the pcap file into the clients dictionary."""
#     if ((packet.psrc and packet.hwsrc) not in clients):
#         clients[packet.psrc] = packet.hwsrc


def identify_attacker(p):
    """Returns the source mac address of the attacker. Will return None if packet is legit"""
    # exclude the  standard way for ethernet packets to broadcast to all clients
    if p.dst != 'ff:ff:ff:ff:ff:ff':
        # if the ip and mac of the packet is not the same as the the registered ones
        # then we return the packet's mac address. This mac address is our advesary.
        if not((get_key(p.pdst) == p.pdst and clients.get(p.dst) == p.dst)):
            return p.src


def output_warning(source_ip_address, destination_ip_address, packet_number):
    """
    Outputs a warning for the attacker's packets.
    Also writes these warnings to a file.
    """
    str = "Offending source IP address: %s" % source_ip_address + \
        " , " + " Victim destination IP address: %s" % destination_ip_address + \
        " , " + "Packet number: %s" % packet_number + "\n"
    print(str)


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
    a = rdpcap('portscan.pcap')

    # a.show()  # to show all packets using nsummary format

    # experiments()  # for experimental/learning purposes

    for idx, p in enumerate(a):
        if (p.haslayer(ARP)):
            # get the source mac address of the attacker
            attacker = identify_attacker(p)
            # Output a warning
            output_warning(src_ip, dest_ip, idx+1)

    # print(clients)  # print out the list of clients


if __name__ == '__main__':
    main()
