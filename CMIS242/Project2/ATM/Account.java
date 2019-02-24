/*
 * Account.java
 * Kresimir Tokic
 * January 31 1019
 * Account class for mock ATM GUI for
 * for CMIS 242 Project 2 Assignment
 * 
 */

public class Account {

	// declare variables
	private double accountBalance;
	private static int transactionTracker;

	// constructor
	public Account(double balance) {
		this.accountBalance = balance;

	}

	// get accountBalance method
	public double getBalance() {
		return this.accountBalance;
	}

	// deposit method
	public void deposit(double dollarAmount) {
		this.accountBalance = this.accountBalance + dollarAmount;
	}

	// checks for insufficient funds adds service fee after 4 withdraws
	public void withdraw(double dollarAmount) throws InsufficientFundsException {
		if (this.accountBalance - dollarAmount < 0 || this.accountBalance - dollarAmount - 1.50 < 0) {
			throw new InsufficientFundsException();
		} else {
			transactionTracker++;
			System.out.println(transactionTracker);
			if (transactionTracker > 4) {
				this.accountBalance = this.accountBalance - dollarAmount - 1.50;
			} else {
				this.accountBalance = this.accountBalance - dollarAmount;
			}
		}
	}

	// transferFrom method checks insufficient funds and reduces balance
	public void transferFrom(double dollarAmount) throws InsufficientFundsException {
		if (this.accountBalance - dollarAmount < 0) {
			throw new InsufficientFundsException();
		} else {
			this.accountBalance = this.accountBalance - dollarAmount;
		}
	}

	// transferTo method increases balance
	public void transferTo(double dollarAmount) {
		this.accountBalance = this.accountBalance + dollarAmount;
	}

}
