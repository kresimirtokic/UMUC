
/*
 * Author: Kresimir Tokic
 * Date: 3/31/19
 * Filename: Main.java
 * About: UMUC CMSC350 Project 1
 * Creates GUI and uses InfixCalc class
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

	private JFrame mainWindow;
	private JTextField userInput;
	private JTextField result;
	// private String userEquation;
	// private String solution;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	// build the gui
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setTitle("Infix Expression Evaluator");
		mainWindow.setBounds(100, 100, 435, 170);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);

		userInput = new JTextField();
		userInput.setBounds(195, 11, 212, 20);
		mainWindow.getContentPane().add(userInput);

		JLabel userInputLabel = new JLabel("Enter Infix Expression");
		userInputLabel.setBounds(10, 14, 150, 14);
		mainWindow.getContentPane().add(userInputLabel);

		JButton evaluateButton = new JButton("Evaluate");
		evaluateButton.setBounds(127, 50, 138, 23);
		mainWindow.getContentPane().add(evaluateButton);
		evaluateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfixCalc calculon = new InfixCalc();
				calculon.tokenizeUserInput(userInput.getText());
				result.setText(String.valueOf(calculon.solution));
			}

		});

		result = new JTextField();
		result.setBounds(195, 90, 212, 20);
		result.setEditable(false);
		mainWindow.getContentPane().add(result);

		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 90, 150, 14);
		mainWindow.getContentPane().add(resultLabel);
	}
}// end public class Main
