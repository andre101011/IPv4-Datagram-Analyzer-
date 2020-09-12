package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
		int packetLength = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del datagrama"));
		int mtu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del MTU"));
		Datagram datagram = new Datagram(packetLength, mtu);
		
		ArrayList<String> fragments=datagram.getFragments();
		String table="N° | Total Lenthg | flags | offset (BIN) | offset (DEC) | HEXA ";
		
	    String tableRow="%d  |%s           |%s   |%s           |%s     |%s";	
	    
		for (int i = 0; i < fragments.size(); i++) {
			String fragmentData[]=fragments.get(i).split("/");
			
			table+="\n" +String.format(tableRow, i,fragmentData[0],fragmentData[1],fragmentData[2],fragmentData[3],fragmentData[4])+ "\n";
			
		}
		System.out.println(table);
		
		
	}
	


}
