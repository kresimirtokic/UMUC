
/*
 * ATM.java
 * Kresimir Tokic
 * January 31 1019
 * Mock ATM GUI for CMIS242
 * Project 2 Assignment
 * 
 */

//import java.awt.BorderLayout;
import java.awt.EventQueue;
//import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ATM extends JFrame {

	// for the constructor
	private JPanel contentPane;
	private JTextField textField;
	private ButtonGroup radioButtons = new ButtonGroup();
	private JRadioButton rdbtnChecking = new JRadioButton("Checking");
	private JRadioButton rdbtnSavings = new JRadioButton("Savings");
	private static final int WIDTH = 339;
	private static final int HEIGHT = 269;
	private static final int HORIZ = 790;
	private static final int VERT = 434;

	// create accounts with balances
	private Account savingsAccount = new Account(100);
	private Account checkingAccount = new Account(100);

	// useful variables
	private double dollarAmount;

	// format doubles to dollars
	private static DecimalFormat dollarFormat = new DecimalFormat("$0.00");

	/**
	 * Launch the application. MAIN
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM frame = new ATM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ATM() {
		setTitle("ATM Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(HORIZ, VERT, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					validateTextEntry();
					if (isDivisibleBy20() != 0) {
						if (rdbtnChecking.isSelected()) {
							checkingAccount.withdraw(dollarAmount);
							confirmationPopUp();
						} else if (rdbtnSavings.isSelected()) {
							savingsAccount.withdraw(dollarAmount);
							confirmationPopUp();
						}
					}
				} catch (InsufficientFundsException e) {
					e.printStackTrace();
					textField.setText(null);
				}
			}
		});
		btnWithdraw.setBounds(39, 35, 109, 23);
		contentPane.add(btnWithdraw);

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateTextEntry();
				if (dollarAmount != 0) {
					if (rdbtnChecking.isSelected()) {
						checkingAccount.deposit(dollarAmount);
					} else if (rdbtnSavings.isSelected()) {
						savingsAccount.deposit(dollarAmount);
					}
					textField.setText(null);
					confirmationPopUp();
				}
			}
		});
		btnDeposit.setBounds(176, 35, 109, 23);
		contentPane.add(btnDeposit);

		JButton btnTransferTo = new JButton("Transfer to");
		btnTransferTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validateTextEntry();
					if (dollarAmount != 0) {
						if (rdbtnChecking.isSelected()) {
							savingsAccount.transferFrom(dollarAmount);
							checkingAccount.transferTo(dollarAmount);
						} else if (rdbtnSavings.isSelected()) {
							checkingAccount.transferFrom(dollarAmount);
							savingsAccount.transferTo(dollarAmount);
						}
						confirmationPopUp();
					}
				} catch (InsufficientFundsException e1) {
					e1.printStackTrace();
					textField.setText(null);
				}
			}
		});
		btnTransferTo.setBounds(39, 82, 109, 23);
		contentPane.add(btnTransferTo);

		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balanceInquiry();
			}

		});

		btnBalance.setBounds(176, 82, 109, 23);
		contentPane.add(btnBalance);
		rdbtnChecking.setSelected(true); // checking radio button selected at start
		rdbtnChecking.setBounds(39, 123, 109, 23);
		contentPane.add(rdbtnChecking);
		radioButtons.add(rdbtnChecking);
		rdbtnSavings.setBounds(176, 123, 109, 23);
		contentPane.add(rdbtnSavings);
		radioButtons.add(rdbtnSavings);
		textField = new JTextField();
		textField.setBounds(39, 173, 246, 20);
		contentPane.add(textField);
		textField.setColumns(10);

	}

	// validates and returns textField values as doubles
	public double validateTextEntry() {
		try {
			dollarAmount = Double.parseDouble(textField.getText());
			if (dollarAmount > 0) {
				return dollarAmount;
			} else {
				textField.setText(null);
				JOptionPane.showMessageDialog(contentPane, "Please Enter Positive Values");
				return dollarAmount = 0;
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(contentPane, "Please enter numbers");
			textField.setText(null);
			return dollarAmount = 0;
		}
	}// end validatTextEntry

	// validates dollarAmount is divisible by 20
	public double isDivisibleBy20() {
		dollarAmount = Double.parseDouble(textField.getText());
		if (dollarAmount % 20 == 0) {
			return dollarAmount;
		} else {
			JOptionPane.showMessageDialog(contentPane, "Please enter amounts in increments of 20");
			textField.setText(null);
			return 0;
		}
	}// end isDivbibleBy20

	// run balance inquiry by which account is selected
	public void balanceInquiry() {
		if (rdbtnChecking.isSelected()) {
			JOptionPane.showMessageDialog(contentPane,
					"Checking Balance: " + dollarFormat.format(checkingAccount.getBalance()));
		} else if (rdbtnSavings.isSelected()) {
			JOptionPane.showMessageDialog(contentPane,
					"Savings Balance: " + dollarFormat.format(savingsAccount.getBalance()));
		}
	}// end balanceInquiry

	// confirmation pop up clears text and gets balance
	public void confirmationPopUp() {
		textField.setText(null);
		JOptionPane.showMessageDialog(contentPane,
				"Transaction Successful" + "\nChecking Balance: " + dollarFormat.format(checkingAccount.getBalance())
						+ "\nSavings Balance: " + dollarFormat.format(savingsAccount.getBalance()));
	}// end confirmationPopUp

}
