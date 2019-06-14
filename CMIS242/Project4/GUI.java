
/*
 * Author: Kresimir Tokic
 * CMIS242 Project 4
 * Date: 3/4/19
 * Filename: GUI.java
 * About: Creates the GUI and runs the program. 
 * Contains all the GUI actions and methods.
 * 
 *  
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
//import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class GUI {

	// declare variables
	private JFrame mainWindow;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField majorTextField;
	HashMap<String, Student> studentDB = new HashMap();
	private static String studentID;
	private static String studentName;
	private static String studentMajor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setTitle("Project 4");
		mainWindow.setBounds(100, 100, 435, 243);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);

		idTextField = new JTextField();
		idTextField.setToolTipText("Input Student's ID");
		idTextField.setBounds(195, 11, 212, 20);
		mainWindow.getContentPane().add(idTextField);
		idTextField.setColumns(10);

		nameTextField = new JTextField();
		nameTextField.setToolTipText("Input Student's Name");
		nameTextField.setColumns(10);
		nameTextField.setBounds(195, 42, 212, 20);
		mainWindow.getContentPane().add(nameTextField);

		majorTextField = new JTextField();
		majorTextField.setToolTipText("Input Student's Major");
		majorTextField.setColumns(10);
		majorTextField.setBounds(195, 73, 212, 20);
		mainWindow.getContentPane().add(majorTextField);

		JLabel idLabel = new JLabel("Id:");
		idLabel.setBounds(10, 14, 46, 14);
		mainWindow.getContentPane().add(idLabel);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 45, 46, 14);
		mainWindow.getContentPane().add(nameLabel);

		JLabel majorLabel = new JLabel("Major:");
		majorLabel.setBounds(10, 76, 46, 14);
		mainWindow.getContentPane().add(majorLabel);

		JLabel selectionLabel = new JLabel("Choose Selection:");
		selectionLabel.setBounds(10, 107, 114, 14);
		mainWindow.getContentPane().add(selectionLabel);

		JComboBox dropCombo = new JComboBox();
		dropCombo.setToolTipText("Select Action");
		dropCombo.setModel(new DefaultComboBoxModel(new String[] { "Insert", "Delete", "Find", "Update" }));
		dropCombo.setMaximumRowCount(4);
		dropCombo.setBounds(195, 104, 212, 20);
		mainWindow.getContentPane().add(dropCombo);

		JButton processButton = new JButton("Process Request");
		processButton.setToolTipText("Click to Begin");
		processButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dropCombo.getSelectedItem().equals("Insert")) {
					checkInputs();
					clearText();
				} else if (dropCombo.getSelectedItem().equals("Delete")) {
					deleteStudent();
					clearText();
				} else if (dropCombo.getSelectedItem().equals("Find")) {
					findStudent();
					clearText();
				} else if (dropCombo.getSelectedItem().equals("Update")) {
					updateStudent();
					clearText();
				}

			}
		});
		processButton.setBounds(127, 149, 138, 23);
		mainWindow.getContentPane().add(processButton);
	}

	// success window
	private void confirmationWindow() {
		JOptionPane.showMessageDialog(mainWindow, "Operation Successful");
	}

	// fail window
	private void failureWindow(String failMessage) {
		JOptionPane.showMessageDialog(mainWindow, failMessage);
	}

	// grade selector pop up
	private String chooseGradeWindow() {
		JPanel gradePanel = new JPanel();
		JComboBox gradeCombo = new JComboBox();
		gradeCombo.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "F" }));
		JLabel gradeLabel = new JLabel("Select Grade:");
		gradePanel.add(gradeLabel);
		gradePanel.add(gradeCombo);
		JOptionPane.showMessageDialog(mainWindow, gradePanel, "Grade Selector", 3); // 3 sets "?" icon
		return (String) gradeCombo.getSelectedItem();
	}

	// course credit selector pop up
	private int creditSelectorWindow() {
		JPanel creditPanel = new JPanel();
		JComboBox creditCombo = new JComboBox();
		creditCombo.setModel(new DefaultComboBoxModel(new Integer[] { 3, 4 }));
		JLabel creditLabel = new JLabel("Select Credit:");
		creditPanel.add(creditLabel);
		creditPanel.add(creditCombo);
		JOptionPane.showMessageDialog(mainWindow, creditPanel, "Credit Selector", 3);
		return (Integer) creditCombo.getSelectedItem();
	}

	// find student pop up
	private void findStudent() {
		studentID = idTextField.getText();
		if (studentDB.containsKey(studentID)) {
			JOptionPane.showMessageDialog(mainWindow, studentDB.get(studentID).toString());
		} else {
			failureWindow("Student ID: " + studentID + " Not Found");
		}

	}

	// validate studentID
	private boolean validateID(String studentID) {
		if (studentDB.containsKey(studentID)) {
			failureWindow("ID: " + studentID + " Already Exists");
			return false;
		} else {
			return true;
		}
	}

	// calls validateID before creating a new database/object entry
	private void insertStudent() {
		if (validateID(studentID)) {
			Student newStudent = new Student(studentName, studentMajor);
			studentDB.put(studentID, newStudent);
			confirmationWindow();
		}
	}

	// makes sure each field is NOT empty then calls insertStudent
	private void checkInputs() {
		studentID = idTextField.getText();
		studentName = nameTextField.getText();
		studentMajor = majorTextField.getText();
		if (studentID.isEmpty()) {
			failureWindow("Do not leave ID empty");
			// return;
		} else if (studentName.isEmpty()) {
			failureWindow("Do not leave name empty");
			// return;
		} else if (studentMajor.isEmpty()) {
			failureWindow("Do not leave major empty");
			// return;
		} else {
			insertStudent();
		}
	}

	// checks for valid student ID then deletes student record
	private void deleteStudent() {
		studentID = idTextField.getText();
		if (studentDB.containsKey(studentID)) {
			studentDB.remove(studentID);
			confirmationWindow();
		} else {
			failureWindow("Student ID: " + studentID + " Not Found");
		}
	}

	// checks for valid student ID then updates student record
	private void updateStudent() {
		studentID = idTextField.getText();
		if (!studentDB.containsKey(studentID)) {
			failureWindow("Student ID: " + studentID + " Not Found");
		} else {
			int numericalGrade = convertLetterGrade(chooseGradeWindow());
			int credits = creditSelectorWindow();
			studentDB.get(studentID).courseCompleted(credits, numericalGrade);
			confirmationWindow();
		}
	}

	// converts letter grade to numeric value
	private int convertLetterGrade(String letterGrade) {
		if (letterGrade == "A") {
			return 4;
		} else if (letterGrade == "B") {
			return 3;
		} else if (letterGrade == "C") {
			return 2;
		} else if (letterGrade == "D") {
			return 1;
		} else {
			return 0;
		}
	}

	// clear text fields
	private void clearText() {
		idTextField.setText(null);
		nameTextField.setText(null);
		majorTextField.setText(null);
	}
}
