package main;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		int packetLength = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del datagrama"));
		int mtu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del MTU"));
		Datagram datagram = new Datagram(packetLength, mtu);
		JOptionPane.showMessageDialog(null, datagram.getNumberOfFragments());
		System.out.println(datagram.getFragments());
	}

}
