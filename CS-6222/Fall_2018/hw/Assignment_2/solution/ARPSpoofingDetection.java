
import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.*;
import io.pkts.protocol.Protocol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ARPSpoofingDetection {
    static int count = 0;
    File file = new File("ARPSpoofingResult.txt");
	BufferedWriter output =  null;
	
    public void ARPspoofing(String FileAddress) throws IOException {
    	output = new BufferedWriter(new FileWriter(file));
        final Pcap pcap = Pcap.openStream(FileAddress);

        pcap.loop(new PacketHandler() {
            @Override

            public boolean nextPacket(Packet packet) throws IOException {
                if (packet.hasProtocol(Protocol.IPv4)) {
                    MACPacket mac = (MACPacket) packet.getPacket(Protocol.ETHERNET_II);
                    String srcmac = mac.getSourceMacAddress();
                    IPPacket ipa = (IPPacket) packet.getPacket(Protocol.IPv4);
                    String ipd = ipa.getSourceIP();
                    //System.out.println("IP:"+ipd + "  Mac:" + srcmac);
                    if(!ipd.matches("192.168.0.100") && srcmac.matches("7C:D1:C3:94:9E:B8")){
                    	output.write("Packet # " + count + " has made a spoofing IP as: " + ipd + ", while the mac is: " + srcmac + "\n");
                    }
                    count++;
                }
                return true;
            }
        });
        output.close();
    }
}
