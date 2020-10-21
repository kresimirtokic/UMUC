
/*
 * Kresimir Tokic
 * 7/12/20
 * CMSC405 Comp Graphics 
 * Project 2
 * Main class launches Proj2
 */

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Proj2 | Translate:WASD | Zoom:+- | Rotate:arrows | Reset: R");
		Proj2 panel = new Proj2();
		window.setContentPane(panel);
		window.pack();
		window.setLocation(50, 50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		panel.requestFocusInWindow();

	}

}
