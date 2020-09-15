package main;

import java.util.ArrayList;

public class Datagram {

	private int mtu;
	private int numberOfFragments;
	private String headerLength;
	private int packetLength;
	private ArrayList<String> fragments;;

	public Datagram(int packetLength, int mtu) {
		this.packetLength = packetLength;
		this.mtu = mtu;
		findNumberOfFragments();
		computeFragments();
	}

	public void findNumberOfFragments() {
		numberOfFragments = (int) Math.ceil(((double) (packetLength - 20)) / mtu);
	}

	public void computeFragments() {
		ArrayList<String> fragments = new ArrayList<String>();
		if (this.numberOfFragments != 1) { // si length > mtu
			int headerSize = 20;
			int mtuData = mtu - headerSize;
			int dataLength = packetLength - headerSize;
			int offset = 0;
			int fragmentLength = mtu;
			int acumulatedFragmentDataLength = 0;
			String flags = "001";

			for (int i = 0; i < numberOfFragments; i++) {
				if ((acumulatedFragmentDataLength + mtuData) < dataLength) { // si los datos acumulados son menores que
																				// los datos totales sin ecabezado
					fragmentLength = mtuData;
				} else { // si los datos aculumados al sumarle mtuData supera el numero de datos
							// totales(sin encabezado)

					fragmentLength = dataLength - acumulatedFragmentDataLength; // a la longitud de los datos se le
					flags = "000"; // resta los datos acumulados y nos da
									// la longitud del ultimo fragmento
				}

				acumulatedFragmentDataLength += mtuData; // acumula los datos que van "pasando" por el mtu

				offset = acumulatedFragmentDataLength - mtuData; // calcula el offset a apartir de los datos acumulados
				String binaryOffset = binaryOffset(offset);
				String hexa = convertToHexa(flags + binaryOffset);

				fragments.add((fragmentLength + headerSize) + "/" + flags + "/" + binaryOffset + "/" + (offset / 8)
						+ "/" + hexa);

			}
		} else {
			fragments.add(packetLength + "/000/00000000000000/0/0000");
		}
		this.fragments = fragments;
	}

	/**
	 * Metodo que convierte de binario a hexa de 4 digitos primero se pasa el
	 * binario a decimal y luego ese decimal se pasa a hexa todod con el fin de
	 * utilizar los metodos de java
	 * 
	 * @param binario
	 * @return
	 */

	private String convertToHexa(String binario) {

		int number = Integer.parseInt(binario, 2);
		String numberHexa = Integer.toHexString(number);

		int complete = 4 - numberHexa.length();

		for (int i = 0; i < complete; i++) {

			numberHexa = "0" + numberHexa;
		}

		return numberHexa;
	}

	/*
	 * Metodo que covierte el offset a binario y completa con ceros a la derecha
	 * hasta completar los 13 bits
	 */

	private String binaryOffset(int offset) {

		String binaryOffset = decimalToBinary(offset);

		int bitsToComplete = 13 - binaryOffset.length();
		for (int i = 0; i < bitsToComplete; i++) {
			binaryOffset = "0" + binaryOffset;
		}

		return binaryOffset;
	}

	public String decimalToBinary(int num) {

		if (num != 0) {
			int div = num / 2;
			String res = "" + (num % 2);
			return decimalToBinary(div) + res;

		} else {
			return "";
		}

	}

	public void print() {
		TableList tl = new TableList(6, "N°", "Total Length", "flags", "Offset (BIN)", "Offset (DEC)", "Offset (HEX)").sortBy(0);
		for (int i = 0; i < fragments.size(); i++) {
			String fragmentData[] = fragments.get(i).split("/");
			tl.addRow(i + "", fragmentData[0], fragmentData[1]+"aaaaaaaaaaaaa", fragmentData[2], fragmentData[3], fragmentData[4]);
		}
		tl.print();
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

	public ArrayList<String> getFragments() {
		return fragments;
	}

	public void setFragments(ArrayList<String> fragments) {
		this.fragments = fragments;
	}

}
