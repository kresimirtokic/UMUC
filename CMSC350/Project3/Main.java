
/*
 * Author: Kresimir Tokic
 * Date: 4/18/19
 * Filename: Main.java
 * About: UMUC CMSC350 Project 3
 * Creates GUI, tokenizes userInput
 */

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;
//import javax.swing.border.*;

public class Main {

	private String[] tokens;
	private JFrame mainWindow;
	private JTextField userInput;
	private JTextField sortedList;
	private final ButtonGroup sortOrderButtonGroup = new ButtonGroup();
	private final ButtonGroup numericTypeButtonGroup = new ButtonGroup();
	//private TitledBorder radioButtonBorders;
	//private Border blackline = BorderFactory.createLineBorder(Color.black);
	//private Border jComp4;

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
		mainWindow.setTitle("Binary Search Tree Sort");
		mainWindow.setBounds(100, 100, 435, 275);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);

		userInput = new JTextField();
		userInput.setBounds(195, 11, 212, 20);
		mainWindow.getContentPane().add(userInput);

		JLabel userInputLabel = new JLabel("Oringal List");
		userInputLabel.setBounds(10, 14, 150, 14);
		mainWindow.getContentPane().add(userInputLabel);

		JLabel sortedListLabel = new JLabel("Sorted List");
		sortedListLabel.setBounds(10, 50, 150, 14);
		mainWindow.getContentPane().add(sortedListLabel);

		/*
		//radioButtonBorders = BorderFactory.createTitledBorder(blackline, "test");
		//radioButtonBorders.setTitleJustification(TitledBorder.CENTER);
		//((JComponent) jComp4).setBorder(radioButtonBorders);
		Border paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);
		JPanel titledBorders = new JPanel();
		titledBorders.setBorder(paneEdge);
		titledBorders.setLayout(new BoxLayout(titledBorders, BoxLayout.Y_AXIS));
		TitledBorder titled;
		titled = BorderFactory.createTitledBorder("title");
		addCompForBorder(titled, "default titled border" + " (default just., default pos.)",titledBorders);
		*/
		
		JLabel sortOrderLabel = new JLabel("Sort Order");
		sortOrderLabel.setBounds(10, 145, 150, 14);
		mainWindow.getContentPane().add(sortOrderLabel);

		JRadioButton ascendingButton = new JRadioButton("Ascending");
		sortOrderButtonGroup.add(ascendingButton);
		ascendingButton.setSelected(true);
		ascendingButton.setBounds(10, 165, 98, 23);
		mainWindow.getContentPane().add(ascendingButton);

		JRadioButton descendingButton = new JRadioButton("Descending");
		sortOrderButtonGroup.add(descendingButton);
		descendingButton.setSelected(false);
		descendingButton.setBounds(10, 195, 98, 23);
		mainWindow.getContentPane().add(descendingButton);

		JLabel numericTypeLabel = new JLabel("Numeric Type");
		numericTypeLabel.setBounds(250, 145, 150, 14);
		mainWindow.getContentPane().add(numericTypeLabel);

		JRadioButton integerButton = new JRadioButton("Integer");
		numericTypeButtonGroup.add(integerButton);
		integerButton.setSelected(true);
		integerButton.setBounds(250, 165, 98, 23);
		mainWindow.getContentPane().add(integerButton);

		JRadioButton fractionButton = new JRadioButton("Fraction");
		numericTypeButtonGroup.add(fractionButton);
		fractionButton.setSelected(false);
		fractionButton.setBounds(250, 195, 98, 23);
		mainWindow.getContentPane().add(fractionButton);

		sortedList = new JTextField();
		sortedList.setBounds(195, 50, 212, 20);
		sortedList.setEditable(false);
		mainWindow.getContentPane().add(sortedList);

		JButton performSortButton = new JButton("Perform Sort");
		performSortButton.setBounds(130, 100, 138, 23);
		mainWindow.getContentPane().add(performSortButton);
		performSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sortedList.setText(null);
					if (ascendingButton.isSelected() && integerButton.isSelected()) {
						tokenizeUserInputIntegers(userInput.getText());
						BinarySearchTree sortIntegers = new BinarySearchTree(tokens);
						sortedList.setText(sortIntegers.sortAscending());
					} else if (ascendingButton.isSelected() && fractionButton.isSelected()) {
						tokenizeUserInputFractions(userInput.getText());
						BinarySearchTree sortFractions = new BinarySearchTree(tokens);
						sortedList.setText(sortFractions.sortAscending());
					} else if (descendingButton.isSelected() && integerButton.isSelected()) {
						tokenizeUserInputIntegers(userInput.getText());
						BinarySearchTree sortIntegers = new BinarySearchTree(tokens);
						sortedList.setText(sortIntegers.sortDescending());
					} else if (descendingButton.isSelected() && fractionButton.isSelected()) {
						tokenizeUserInputFractions(userInput.getText());
						BinarySearchTree sortFractions = new BinarySearchTree(tokens);
						sortedList.setText(sortFractions.sortDescending());
					}

				} catch (FormatException fe) {
					// window called by tokenizer methods
				}
			}
		});

	}

	// method tokenizes user input fractions and checks for bad input
	public String[] tokenizeUserInputFractions(String userInput) throws FormatException {
		Pattern fractionPattern = Pattern.compile("\\d+/\\d+");
		Matcher fractionMatcher;
		tokens = userInput.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			fractionMatcher = fractionPattern.matcher(tokens[i]);
			if (!tokens[i].matches("\\d+/\\d+")) {
				throw new FormatException(tokens[i]);
			} else if (tokens[i].contains("/0")) {
				throw new FormatException(tokens[i]);
			}
		}
		return tokens;
	}

	// method tokenizes user input for integers and checks for bad input
	public String[] tokenizeUserInputIntegers(String userInput) throws FormatException {
		tokens = userInput.split(" ");
		for (String elementsOf : tokens) {
			if (!elementsOf.matches("^[0-9]+$")) {
				throw new FormatException(elementsOf);
			}
		}
		return tokens;
	}

}// end public class Main
