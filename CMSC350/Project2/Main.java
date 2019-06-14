
/*
 * Author: Kresimir Tokic
 * Date: 4/3/19
 * Filename: Main.java
 * About: UMUC CMSC350 Project 2
 * Creates GUI and uses PostCalc class
 */

import java.awt.*;
import java.awt.event.*;
import java.util.EmptyStackException;
import javax.swing.*;

public class Main {

	private JFrame mainWindow;
	private JTextField userInput;
	private JTextField infixExpression;

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
		mainWindow.setTitle("Three Address Generator");
		mainWindow.setBounds(100, 100, 435, 170);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);

		userInput = new JTextField();
		userInput.setBounds(195, 11, 212, 20);
		mainWindow.getContentPane().add(userInput);

		JLabel userInputLabel = new JLabel("Enter Postfix Expression");
		userInputLabel.setBounds(10, 14, 150, 14);
		mainWindow.getContentPane().add(userInputLabel);

		JButton constructTreeButton = new JButton("Construct Tree");
		constructTreeButton.setBounds(127, 50, 138, 23);
		mainWindow.getContentPane().add(constructTreeButton);
		constructTreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostfixEvaluator calculon = new PostfixEvaluator();
				try {
					calculon.tokenizeUserInput(userInput.getText());
				} catch (InvalidCharacter | EmptyStackException ee) {

				}
				infixExpression.setText(String.valueOf(calculon.solution));
			}

		});

		infixExpression = new JTextField();
		infixExpression.setBounds(195, 90, 212, 20);
		infixExpression.setEditable(false);
		mainWindow.getContentPane().add(infixExpression);

		JLabel infixExpressionLabel = new JLabel("Infix Expression");
		infixExpressionLabel.setBounds(10, 90, 150, 14);
		mainWindow.getContentPane().add(infixExpressionLabel);
	}

}// end public class Main
