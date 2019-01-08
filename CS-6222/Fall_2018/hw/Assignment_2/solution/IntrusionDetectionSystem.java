import java.io.IOException;

public class IntrusionDetectionSystem {
	public static void main(String[] args) throws IOException{
		ARPSpoofingDetection ARPSD = new ARPSpoofingDetection();
		PortScanDetection PSD = new PortScanDetection();
		// Input the .pcap file for ARP Spoofing Detection
		String FileAddress1 = "C:\\Users\\51248\\Desktop\\final\\arpspoofing.pcap";
		// Input the .pcap file for Port Scan Detection
		String FileAddress2 = "C:\\Users\\51248\\Desktop\\final\\portscan.pcap";
		ARPSD.ARPspoofing(FileAddress1);
		PSD.PortScandetection(FileAddress2);
	}
}
