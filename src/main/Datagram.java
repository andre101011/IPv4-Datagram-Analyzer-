package main;

import java.awt.Frame;
import java.util.ArrayList;

public class Datagram {

	private int mtu;
	private int numberOfFragments;
	private String headerLength;
	private String typeOfService;
	private int packetLength; /**/

	public Datagram(int packetLength, int mtu) {
		this.packetLength = packetLength;
		this.mtu = mtu;
		findNumberOfFragments();
	}

	public void findNumberOfFragments() {
		numberOfFragments = (int) Math.ceil(((double) (packetLength - 20)) / mtu);
	}

	public ArrayList<String> getFragments() {
		
		ArrayList<String>fragments=new ArrayList<String>();
		
	
		if (this.numberOfFragments != 1) {
			int dataLength=packetLength-20;
			int offset=0;
			int fragmentLength = mtu;
			int fragmentLengthAcua=0;
			String flags="000";
			
		
			for (int i = 0; i < numberOfFragments; i++) {
				
				if((fragmentLengthAcua+(mtu-20))<dataLength) {
					
					fragmentLength=mtu-20;
					
				}else {
					fragmentLength=dataLength-fragmentLengthAcua;
				
				}
				
				fragmentLengthAcua+=mtu-20;
				
				offset=fragmentLengthAcua-(mtu-20);
			
				fragments.add((fragmentLength+20)+"/"+(offset/8));
			}

		}else {
			fragments.add( packetLength + "/000/00000000000000/0/0000");
		}
		return fragments;
		
	}

	public int getMtu() {
		return mtu;
	}

	public void setMtu(int mtu) {
		this.mtu = mtu;
	}

	public int getNumberOfFragments() {
		return numberOfFragments;
	}

	public void setNumberOfFragments(int numberOfFragments) {
		this.numberOfFragments = numberOfFragments;
	}

	public String getHeaderLength() {
		return headerLength;
	}

	public void setHeaderLength(String headerLength) {
		this.headerLength = headerLength;
	}

	public int getPacketLength() {
		return packetLength;
	}

	public void setPacketLength(int packetLength) {
		this.packetLength = packetLength;
	}

}
