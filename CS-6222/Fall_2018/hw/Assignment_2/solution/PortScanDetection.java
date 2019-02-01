
import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.*;
import io.pkts.protocol.Protocol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PortScanDetection  {
    static int count = 0;
    File file = new File("PortScanDetectionResult.txt");
	BufferedWriter output =  null;
    public void PortScandetection(String FileAddress) throws IOException {
    	ArrayList<String> SourceIP = new ArrayList<String>();
        ArrayList<String> DestinationIP = new ArrayList<String>();
        output = new BufferedWriter(new FileWriter(file));
        Pcap pcap = Pcap.openStream(FileAddress);
        pcap.loop(new PacketHandler() {
            @Override
            public boolean nextPacket(Packet packet) throws IOException {
                if (packet.hasProtocol(Protocol.TCP)) {
                    TCPPacket tcppacket = (TCPPacket) packet.getPacket(Protocol.TCP);
                    String scrIP = tcppacket.getSourceIP();
                    if(!SourceIP.contains(tcppacket.getSourceIP())){
                    	SourceIP.add(tcppacket.getSourceIP());}
                    if(!DestinationIP.contains(tcppacket.getDestinationIP())){
                    	DestinationIP.add(tcppacket.getDestinationIP());}
                    }
                else if(packet.hasProtocol(Protocol.UDP)){
                	UDPPacket udppacket = (UDPPacket) packet.getPacket(Protocol.UDP);
                	if(DestinationIP.contains(udppacket.getDestinationIP())){
                        DestinationIP.add(udppacket.getDestinationIP());}
                	if(!SourceIP.contains(udppacket.getSourceIP())){
                    	SourceIP.add(udppacket.getSourceIP());}
                }
                return true;
            }
        });
        	for(String scrip:SourceIP){
        		for(String desip:DestinationIP){
        			if(!scrip.matches(desip) && !scrip.matches("192.168.0.1")){
        			count = 0;
        			ArrayList<Integer> Port = new ArrayList<Integer>(); 
        			ArrayList<Integer> PacketNum = new ArrayList<Integer>();
        			Pcap pcap1 = Pcap.openStream(FileAddress);
        			pcap1.loop(new PacketHandler() {
        				 @Override
        				 public boolean nextPacket(Packet packet) throws IOException {
        					 count++;
        					 if(packet.hasProtocol(Protocol.TCP)){
        						 TCPPacket tcppacket = (TCPPacket) packet.getPacket(Protocol.TCP);
        						 String tcpsrc = tcppacket.getSourceIP();
        						 String tcpdest = tcppacket.getDestinationIP();
        						 
        						 if(tcpsrc.matches(scrip)&&tcpdest.equals(desip)){
        							if(!Port.contains(tcppacket.getDestinationPort())){
        								Port.add(tcppacket.getDestinationPort());
        								PacketNum.add(count);
        							}
        						 }
        					 }
        					 else if(packet.hasProtocol(Protocol.UDP)){
        						 UDPPacket udppacket = (UDPPacket) packet.getPacket(Protocol.UDP);
        						 String udpsrc = udppacket.getSourceIP();
        						 String udpdest = udppacket.getDestinationIP();
        						 if(udpsrc.matches(scrip)&&udpdest.matches(desip)){
         							if(!Port.contains(udppacket.getDestinationPort())){
         								Port.add(udppacket.getDestinationPort());
         								PacketNum.add(count);
         							}
         						 }
        					 }
        					 return true;
        				 }
        			 });
        			if(Port.size()>100){
        				output.write("The Offencing Source IP is: " + scrip +" The Victim IP is: " + desip +" The offencing Packets are: \n");
        				for(int x:PacketNum){
        					output.write(x + "\n");
        				}
        				
        			}
        		}
        	}
        }
        output.close();
    }
}
