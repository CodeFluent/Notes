from scapy.all import IP, TCP

a = IP(ttl=10)/TCP()
print(a.src, a.dst)
