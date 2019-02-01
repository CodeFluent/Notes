"""

ids.py

A program to take a pcap file and use the scapy library to detect a TCP SYN port scan.
To run this program, you will need python 3.0+ and the scapy library installed.
You can install scapy with `pip install scapy`.

Made by Wasfi Momen.

"""

"""
REQUIREMENTS:
    - ~~Detect a port scan when an attacker sends more than 100 TCP SYN packets to a target system~~
    - ~~Detect a port scan when an attacker sends more than 100 UDP packets to a target system~~
    - ~~Output a warning including the offending source IP address, the victim destination IP address
    , and the offending packet numbers.~~
    ALL COMPLETE

ISSUES:
    - Should've probably asked, but the instructions said "TCP SYN or UDP" and I took that as 
    inclusive. So both TCP SYN and UDP packets will increment the ports_hit.
    - This program will fail to detect anything other than the clients listed in the clients
    dictionary.
    - Ports_hit will also increment on valid connections that exchange application data.

"""

from scapy.utils import rdpcap
from scapy.layers.all import *

# load file from same directory
a = rdpcap('portscan.pcap')

# dictionary of clients with their MAC addresses and number of ports hit
clients = {
    "192.168.0.100": ["7c:d1:c3:94:9e:b8", 0],
    # typo in assignment .103 should be .101 and MAC is 60:fe not d8:96
    "192.168.0.101": ["60:fe:c5:9e:63:3c", 0],
    "192.168.0.1": ["f8:1a:67:cd:57:6e", 0]
}

# list of ports
tracked_ports = []


def identify_attacker(packet, packet_number):
    for i in clients.keys():
        if (clients[i][1] >= 100):
            output_warning(packet['IP'].src, packet['IP'].dst, packet_number)


def increment_ports_hit(source_ip_address):
    # future feature: before incrementing, follow convo of packet to see if it is actually a legit connection. If legit, don't increment.
    for ip in clients.keys():
        if (ip == source_ip_address):
            # delete the ports_hit value and stores it in ports_hit
            ports_hit = clients[source_ip_address].pop(1)
            # append an incremented ports_hit value
            clients[source_ip_address].append(ports_hit + 1)


def unique_port(packet):
    """Returns a boolean to indicate if the port has been used before."""
    if (packet.dport not in tracked_ports):
        tracked_ports.append(packet.dport)
        return True
    else:
        return False


def output_warning(source_ip_address, destination_ip_address, packet_number):
    """
    Outputs a warning for the attacker's packets.
    Also writes these warnings to a file.
    """
    str = "Offending source IP address: %s" % source_ip_address + \
        " , " + " Victim destination IP address: %s" % destination_ip_address + \
        " , " + "Packet number: %s" % packet_number + "\n"
    print(str)


def main():

    # a.show()  # to show all packets using nsummary format

    for idx, p in enumerate(a):
        if ((p.haslayer(TCP) and p['TCP'].flags == 'S') or (p.haslayer(UDP))):
            # see if destination port is unique in the pcap
            if (unique_port(p)):
                # find the packet's source ip in the dictionary and increment the number of ports hit
                increment_ports_hit(p['IP'].src)
                identify_attacker(p, idx + 1)

    # print(clients)  # print out the list of clients


if __name__ == '__main__':
    main()
