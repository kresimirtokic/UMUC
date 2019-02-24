
/*
 * Kresimir Tokic
 * CMIS242 Project 3
 * Project3.java
 * 2/24/19
 * This program demonstrates recursive methods
 * by creating a GUI that accepts a value then
 * does math to it both iteratively and recursively
 * it outputs the results and efficiency of each
 * method to the screen. Finally, writes data to file.
 * 
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Project3 {

	private JFrame frmProject;
	private JTextField inputField;
	private JTextField efficiencyField;
	private JTextField resultField;
	private final ButtonGroup radioButtonGroup = new ButtonGroup();

	private static int nValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project3 window = new Project3();
					window.frmProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProject = new JFrame();
		frmProject.setTitle("Project 3");
		frmProject.setBounds(100, 100, 230, 242);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				AppExitFileWriter writeOnClose = new AppExitFileWriter();
				try {
					writeOnClose.writeFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		frmProject.getContentPane().setLayout(null);

		JRadioButton iterativeRadioButton = new JRadioButton("Iterative");
		radioButtonGroup.add(iterativeRadioButton);
		iterativeRadioButton.setSelected(true);
		iterativeRadioButton.setBounds(90, 7, 98, 23);
		frmProject.getContentPane().add(iterativeRadioButton);

		JRadioButton recursiveRadioButton = new JRadioButton("Recursive");
		radioButtonGroup.add(recursiveRadioButton);
		recursiveRadioButton.setBounds(90, 33, 98, 23);
		frmProject.getContentPane().add(recursiveRadioButton);

		inputField = new JTextField();
		inputField.setBounds(90, 73, 98, 20);
		frmProject.getContentPane().add(inputField);
		inputField.setColumns(10);

		JLabel enterLabel = new JLabel("Enter n:");
		enterLabel.setBounds(10, 73, 70, 14);
		frmProject.getContentPane().add(enterLabel);

		/* 
		 * compute button action checks radio button selection
		 * triggers input validation then triggers sequence
		 * functions and shows results
		*/
		JButton computeButton = new JButton("Compute");
		computeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (iterativeRadioButton.isSelected()) {
					if (validateText() >= 0) {
						Sequence.computeIterative(nValue);
						showResult();
					} else {
						clearScreen();
					}
				} else if (recursiveRadioButton.isSelected()) {
					if (validateText() >= 0) {
						Sequence.computeRecursive(nValue);
						showResult();
					} else {
						clearScreen();
					}
				}
			}

		});
		computeButton.setBounds(90, 104, 98, 23);
		frmProject.getContentPane().add(computeButton);

		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setBounds(90, 138, 98, 20);
		frmProject.getContentPane().add(resultField);
		resultField.setColumns(10);

		efficiencyField = new JTextField();
		efficiencyField.setEditable(false);
		efficiencyField.setBounds(90, 169, 98, 20);
		frmProject.getContentPane().add(efficiencyField);
		efficiencyField.setColumns(10);

		JLabel resultLabel = new JLabel("Result:");
		resultLabel.setBounds(10, 138, 70, 14);
		frmProject.getContentPane().add(resultLabel);

		JLabel efficiencyLabel = new JLabel("Efficiency:");
		efficiencyLabel.setBounds(10, 169, 70, 14);
		frmProject.getContentPane().add(efficiencyLabel);
	}

	// validates user input
	private int validateText() {
		try {
			nValue = Integer.parseInt(inputField.getText());
			if (nValue >= 0) {
				return nValue;
			} else {
				JOptionPane.showMessageDialog(frmProject, "Please Enter Non-Negative Integers");
				return nValue = -1;
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(frmProject, "Please Enter Non-Negative Integers");
			clearScreen();
			return nValue = -1;
		}
	}

	// prints results to screen
	private void showResult() {
		if (nValue >= 0) {
			resultField.setText(Integer.toString(Sequence.getResult()));
			efficiencyField.setText(Integer.toString(Sequence.getEfficiency()));
		}
	}

	// clears all the text fields
	private void clearScreen() {
		inputField.setText(null);
		resultField.setText(null);
		efficiencyField.setText(null);
	}

	// writes data to file on exit
	class AppExitFileWriter extends WindowAdapter {
		private void writeFile() throws IOException { 
			FileWriter fwData = new FileWriter("outputData.csv");
			for (int i = 0; i <= 10; i++) {
				Sequence.computeIterative(i);
				fwData.write(Integer.toString(i) + "," + Integer.toString(Sequence.getEfficiency()));
				Sequence.computeRecursive(i);
				fwData.append("," + Integer.toString(Sequence.getEfficiency()) + System.getProperty("line.separator"));
			}
			fwData.close();
		}
	}
}
