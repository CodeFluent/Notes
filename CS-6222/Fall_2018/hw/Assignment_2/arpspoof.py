from scapy.utils import rdpcap
from scapy.layers.all import *

clients = {}


def record_client(packet):
    if ((packet.psrc and packet.hwsrc) not in clients):
        clients[packet.psrc] = packet.hwsrc


def identify_attacker(packet):
    # exclude the  standard way for ethernet packets to broadcast to all clients
    if packet.dst != 'ff:ff:ff:ff:ff:ff':
        # The attacker's Eth layer p.src will not match the ARP layer p.hwsrc
        if (packet.src != packet.hwsrc):
            return packet.src
    else:
        return None


def output_warning(packet, packet_number):
    if (packet != None):
        print("Offending MAC address: ", packet,
              "Packet number:", packet_number)


def main():
    # load file from same directory
    a = rdpcap('arpspoofing.pcap')

    # a.show()  # to show all packets using nsummary

    """
    What follows are the scapy packet attributes (by layer) and their Wireshark equivalents in parentheses.
        - p.src (Eth) is also p.psrc, p.hwsrc (ARP) as SourceMACField, SourceIPField, or ARPSourceMacField, respectively. (SenderIPAddress)
        - p.dst (Eth) is also p.pdst, p.hwdst (ARP) as DestMacField, IPField, or MACField, respectively. (TargetMACAddress)
        - p.pdst is just an IPField, normally the destination (TargetIPAddress)
    """

    # # for more info on packets
    # for idx, p in enumerate(a):
    #     p.show()

    # # for more info on fields
    # for idx, p in enumerate(a):
    #     ls(p)

    for idx, p in enumerate(a):
        if (p.haslayer(ARP)):
            # get a list of clients and their MAC addresses
            record_client(p)
            # ARP attacker will be telling every other client that they are a certain IP address to spoof
            attacker = identify_attacker(p)
            # Output a warning with the attacker's MAC address and the offending packet number
            output_warning(attacker, idx+1)
            # p.getlayer(ARP).show()
            # print(idx + 1)  # packet number

    print(clients)


if __name__ == '__main__':
    main()
