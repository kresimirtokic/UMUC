/*
 * Kresimir Tokic
 * 6/15/20
 * GUIParser.java
 * This file parses the input file and outputs the GUI
 */

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GUIParser {

	// class variables
	static JFrame frame;
	static String title;
	static String layout;
	static JPanel panel;
	static JButton button;
	static JLabel label;
	static JTextField textField;
	static ButtonGroup buttonGroup;
	static JRadioButton radioButton;
	static FlowLayout flow;
	static GridLayout grid;
	static int row;
	static int column;
	String input = "";
	static boolean noError = true;
	static boolean framePanel = false;
	static int panelCount = 0;
	static int endCount = 0;

	// constructor
	public GUIParser(String fileName) throws FileNotFoundException {
		FileReader fr = new FileReader(fileName);
		Scanner scan = new Scanner(fr);
		mainParser(input, scan);
	}

	// recursive method loops through the file
	private static boolean mainParser(String input, Scanner scan) {
		if (noError == true) {
			try {
				input = scan.next();
				if (input.equalsIgnoreCase("end.")) {
					showGUI();
					return noError = true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("No Such Element. Error.");
				return noError = false;
			}
			parseStatement(input, scan, framePanel);
			mainParser(input, scan);
			return noError = true;
		} else {
			System.out.println("Error. Unable to parse file. Check syntax.");
		}
		return noError = false;
	}

	// parses the current statement
	private static boolean parseStatement(String input, Scanner scan, boolean framePanel) {
		if (input.equalsIgnoreCase("window")) {
			return windowParser(input, scan);
		} else if (input.equalsIgnoreCase("textfield")) {
			return textFieldParser(input, scan, framePanel);
		} else if (input.equalsIgnoreCase("Panel")) {
			return panelParser(input, scan, framePanel);
		} else if (input.equalsIgnoreCase("button")) {
			return buttonParser(input, scan, framePanel);
		} else if (input.equalsIgnoreCase("label")) {
			return labelParser(input, scan, framePanel);
		} else if (input.equalsIgnoreCase("group")) {
			return groupParser(input, scan, framePanel);
		} else {
			return false;
		}
	}

	// figures out the frame, title, call frameSize and layoutParser
	private static boolean windowParser(String input, Scanner scan) {
		String token = scan.next();
		char first = token.charAt(0);
		char last = token.charAt(token.length() - 1);
		if (first == '"' && last == '"') {
			title = token.replaceAll("\"", "");
			frame = new JFrame(title);
			input = scan.next();
			frameSize(input, scan);
			input = scan.next();
			framePanel = true;
			layoutParser(input, scan, true);
			return noError = true;
		}
		return noError = false;
	}

	// figures out frame size
	private static boolean frameSize(String input, Scanner scan) {
		char first = input.charAt(0);
		char last = input.charAt(input.length() - 1);
		if (first == '(' && last == ',') {
			String temp = input.replaceAll("[(,]", "");
			int width = Integer.parseInt(temp); // catch NumberFormatException
			input = scan.next();
			last = input.charAt(input.length() - 1);
			if (last == ')') {
				temp = input.replaceAll("[)]", "");
				int height = Integer.parseInt(temp); // catch NumberFormatException
				frame.setSize(width, height);
				return noError = true;
			}
		}
		return noError = false;
	}

	// figures out the layout
	private static boolean layoutParser(String input, Scanner scan, boolean framePanel) {
		if (input.equalsIgnoreCase("layout")) {
			input = scan.next();
			// System.out.print(input);
			if (input.toLowerCase().contains("flow")) {
				FlowLayout flow = new FlowLayout();
				if (framePanel) {
					frame.setLayout(flow);
					// System.out.println("frameLayout-"+frame.getLayout());
				} else {
					panel.setLayout(flow);
					// System.out.println(panel.getLayout());
				}
				return noError = true;
			} else if (input.toLowerCase().contains("grid")) {
				input = scan.next();
				// System.out.print(input);// HERES MY FIRST JOINT row
				char first = input.charAt(0);
				char last = input.charAt(input.length() - 1);
				if (first == '(' && last == ',') {
					String temp = input.replaceAll("[(,]", "");
					row = Integer.parseInt(temp); // catch NumberFormatException
					input = scan.next();
					// System.out.print(input);// HERES MY SECOND JOINT col
					last = input.charAt(input.length() - 1);
					if (last == ')') {
						temp = input.replaceAll("[)]", "");
						column = Integer.parseInt(temp); // catch NumberFormatException
						grid = new GridLayout(row, column);
						if (framePanel) {
							frame.setLayout(grid);
							// System.out.println("g x,x"+frame.getLayout());
						} else {
							panel.setLayout(grid);
							// System.out.println("g x,x"+panel.getLayout());
						}
						return noError = true;
					} else if (last == ',') {
						temp = input.replaceAll("[,]", "");
						column = Integer.parseInt(temp);
						grid = new GridLayout(row, column);
						input = scan.next();
						// System.out.print(input);// HERES MY THIRD JOINT hGap
						temp = input.replaceAll("[,]", "");
						int hGap = Integer.parseInt(temp); // catch NumberFormatException
						grid.setHgap(hGap);
						input = scan.next();
						// System.out.print(input); // HERES MY FOURHT JOINT vGap
						temp = input.replaceAll("[):]", "");
						int vGap = Integer.parseInt(temp); // catch NumberFormatException
						grid.setVgap(vGap);
						if (framePanel) {
							// System.out.println("frame.setLayout(grid)");
							frame.setLayout(grid);
						} else {
							// System.out.println("panel.setlayout(grid)");
							panel.setLayout(grid);
						}
						return noError = true;
					}
				}
			}
		}
		return noError = false;
	}

	// creates JPanel with respective layout
	private static boolean panelParser(String input, Scanner scan, boolean framePanel) {
		// System.out.println(input);
		panelCount++;
		//System.out.println("panelCount " + panelCount);
		while (panelCount > endCount) {
			// System.out.println(input);
			if (input.equalsIgnoreCase("panel")) {
				if (framePanel) {
					panel = new JPanel();
					input = scan.next();
					framePanel = false;
					layoutParser(input, scan, framePanel);
					frame.add(panel);

				} else {
					framePanel = false;
					panel.add(panel = new JPanel(layoutParser(scan.next(), scan, framePanel)));
				}
			}
			framePanel = false;
			input = scan.next();
			//System.out.println(input);
			if (input.equalsIgnoreCase("end;")) {
				endCount++;
				//System.out.println("endCount: " + endCount);
				noError = true;
				//break;
			} else if (panelCount > endCount){
				parseStatement(input, scan, false);
			}
			if (noError == false) {
				return noError = false;
			}
			// panelParser(input, scan, framePanel);
			// System.out.println(panel.getLayout());
		}
		// endCount++;
	
			return noError = true;
		// return noError = true;
	}

	// figure out the button group call method to figure out radio buttons
	private static boolean groupParser(String input, Scanner scan, boolean framePanel) {
		// endCount++;
		buttonGroup = new ButtonGroup();
		while (!input.equalsIgnoreCase("end;")) {
			input = scan.next();
			radioParser(input, scan, framePanel);
		}
		if (input.equalsIgnoreCase("end;")) {
			// endCount = 0;
			return noError = true;
		} else {
			return noError = false;
		}
	}

	// figure out radio buttons and add to group and panel
	private static boolean radioParser(String input, Scanner scan, boolean framePanel) {
		if (input.equalsIgnoreCase("radio")) {
			input = scan.next();
			char first = input.charAt(0);
			char secondToLast = input.charAt(input.length() - 2);
			char last = input.charAt(input.length() - 1);
			if (first == '"' && secondToLast == '"' && last == ';') {
				String temp = input.replaceAll("[;\"]", "");
				radioButton = new JRadioButton(temp);
				buttonGroup.add(radioButton);
				if (framePanel) {
					frame.add(radioButton);
				} else {
					panel.add(radioButton);
				}
				return noError = true;
			}
		}
		return noError = false;
	}

	// figures out the JLabel and adds to panel
	private static boolean labelParser(String input, Scanner scan, boolean framePanel) {
		if (input.equalsIgnoreCase("label")) {
			input = scan.next();
			char first = input.charAt(0);
			char secondToLast = input.charAt(input.length() - 2);
			char last = input.charAt(input.length() - 1);
			if (first == '"' && secondToLast == '"' && last == ';') {
				String temp = input.replaceAll("[;\"]", "");
				label = new JLabel(temp);
				if (framePanel) {
					frame.add(label);
					// System.out.println("frame label");
				} else {
					panel.add(label);
					// System.out.println("panel label");
				}
				return noError = true;
			}
		}
		return noError = false;
	}

	// figures out the JButton and its text and adds to panel
	private static boolean buttonParser(String input, Scanner scan, boolean framePanel) {
		if (input.equalsIgnoreCase("button")) {
			input = scan.next();
			char first = input.charAt(0);
			char secondToLast = input.charAt(input.length() - 2);
			char last = input.charAt(input.length() - 1);
			if (first == '"' && secondToLast == '"' && last == ';') {
				String temp = input.replaceAll("[;\"]", "");
				button = new JButton(temp);
				if (framePanel) {
					// System.out.println("frame button");
					frame.add(button);
				} else {
					// System.out.println("panel button");
					panel.add(button);
				}
				return noError = true;
			}
		}
		return noError = false;
	}

	// gets the text field and row
	private static boolean textFieldParser(String input, Scanner scan, boolean framePanel) {
		if (input.equalsIgnoreCase("textfield")) {
			input = scan.next();
			char last = input.charAt(input.length() - 1);
			if (last == ';') {
				String temp = input.replaceAll("[;]", "");
				row = Integer.parseInt(temp); // catch NumberFormatException
				textField = new JTextField(row);
				if (framePanel) {
					// System.out.println("frame textfield");
					frame.add(textField);
				} else {
					panel.add(textField);
				}
				return noError = true;
			}
		}
		return noError = false;
	}

	// finally shows the gui
	private static void showGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}// end class
