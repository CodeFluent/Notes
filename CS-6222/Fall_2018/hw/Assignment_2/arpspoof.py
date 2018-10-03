from scapy.all import *

a = rdpcap('arpspoofing.pcap')

# a.show() # to show all packets nsummary

for p in a:
    if (p.haslayer(ARP)):
        p.show()
