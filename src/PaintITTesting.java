import menu.component.Menupanel;

import javax.swing.*;
//import menu.component.*;

public class PaintITTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Paint IT");
		Menupanel menu = new Menupanel();
		frame.add(Menupanel.menu_pane);
		frame.setSize(810, 639); //set a frame's resolution
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
	}

}
