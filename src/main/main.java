package main;



import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		try {
			int packetLength = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del datagrama"));
			int mtu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del MTU"));
			Datagram datagram = new Datagram(packetLength, mtu);
			datagram.print();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, debe ingresar solo números",null,0);
		}
	}
}