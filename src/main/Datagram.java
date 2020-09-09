package main;

public class Datagram {

	private int mtu;
	private int numberOfFragments;
	private String headerLength;
	private String typeOfService;
	private int packetLength; /**/
	private String flags; /**/
	private String fragmentOffset; /**/

	public Datagram(int packetLength, int mtu) {
		this.packetLength = packetLength;
		this.mtu = mtu; 
		findNumberOfFragments();
	}

	public void findNumberOfFragments() {
		numberOfFragments = (int) Math.ceil(((double)(packetLength - 20)) / mtu);
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

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getFragmentOffset() {
		return fragmentOffset;
	}

	public void setFragmentOffset(String fragmentOffset) {
		this.fragmentOffset = fragmentOffset;
	}

}
