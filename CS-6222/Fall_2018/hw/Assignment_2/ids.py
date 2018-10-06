"""

ids.py

A program to take a pcap file and use the scapy library to detect a TCP SYN port scan.

Made by Wasfi Momen.

"""

from scapy.utils import rdpcap
from scapy.layers.all import *

# load file from same directory
a = rdpcap('portscan.pcap')

clients = {
    "192.168.0.100": ["7c:d1:c3:94:9e:b8", 0],
    # typo in assignment .103 should be .101 and MAC is 60:fe not d8:96
    "192.168.0.101": ["60:fe:c5:9e:63:3c", 0],
    "192.168.0.1": ["f8:1a:67:cd:57:6e", 0]
}


def identify_attacker():
    for i in clients.keys():
        if (clients[i][1] >= 100):
            print("FUCK", clients[i])


def increment_ports_hit(source_ip_address):
    # future feature: before incrementing, follow convo of packet to see if it is actually a legit connection. If legit, don't increment.
    for ip in clients.keys():
        if (ip == source_ip_address):
            # delete the ports_hit value and stores it in ports_hit
            ports_hit = clients[source_ip_address].pop(1)
            # append an incremented ports_hit value
            clients[source_ip_address].append(ports_hit + 1)


def unique_port(port_num, packet_number):
    """Returns a boolean to indicate if the port has been used before."""
    # checks all past packets to see if port_num was previously used. Return false if already used.
    # could cut down range by just getting the first TCP SYN packet and all subsequent ones.
    for packet in range(0, packet_number):
        if ((packet.haslayer(TCP) and packet['TCP'].flags == 'S') and (packet.dport == port_num)):
            return False
    return True


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
        if (p.haslayer(TCP) and p['TCP'].flags == 'S'):
            # see if destination port is unique in the pcap
            if (unique_port(p, idx + 1)):
                # find the packet's source ip in the dictionary and increment the number of ports hit
                increment_ports_hit(p.src)

            # Output a warning
            # output_warning(src_ip, dest_ip, idx+1)
        elif (p.haslayer(UDP)):
            pass

    identify_attacker()
    # print(clients)  # print out the list of clients


if __name__ == '__main__':
    main()
