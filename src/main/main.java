package main;



import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		try {
			int packetLength = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tama�o del datagrama"));
			int mtu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tama�o del MTU"));
			Datagram datagram = new Datagram(packetLength, mtu);
			datagram.print();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, debe ingresar solo n�meros",null,0);
		}
	}
}