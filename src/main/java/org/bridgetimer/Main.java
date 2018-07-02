package org.bridgetimer;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setContentPane(new MainPanel());
		
		frame.pack();
	    frame.setVisible(true);
	}
}
