from scapy.utils import rdpcap
from scapy.layers.all import *

clients = {}


def record_client(packet):
    if ((packet.psrc and packet.hwsrc) not in clients):
        clients[packet.psrc] = packet.hwsrc


def main():
    # load file from same directory
    a = rdpcap('arpspoofing.pcap')

    # a.show()  # to show all packets using nsummary

    """
    What follows are the scapy packet attributes and their Wireshark equivalents in parentheses.
        - p.src is also p.hwsrc as SourceIPField or ARPSourceMacField, respectively. (SenderIPAddress)
        - p.dst is also p.hwdst as DestMacField or MACField, respectively. (TargetMACAddress)
        - p.pdst is just an IPField, normally the destination (TargetIPAddress)
    """

    # for more info on packets
    # for idx, p in enumerate(a):
    #     p.show()

    # for more info on fields
    # for idx, p in enumerate(a):
    #     ls(p)

    for idx, p in enumerate(a):
        if (p.haslayer(ARP)):
            # get a list of clients and their MAC addresses
            record_client(p)
            # ARP attacker will be telling every other client that they are a certain IP address to spoof
            # Output a warning with the attacker's MAC address and the offending packet number
            p.getlayer(ARP).show()
            # print(idx + 1)  # packet number

    print(clients)


if __name__ == '__main__':
    main()
