//package octat;

import java.util.Scanner;

// ATM class simulates the operations of an ATM machine
class ATM {
	
	double balance; // Stores the user's current balance
	int PIN = 1432; // Hardcoded PIN for security
	Scanner sc = new Scanner(System.in); // Scanner object for input from the user

	// Constructor to initialize the ATM
	ATM() {
		System.out.println("THE MACHINE IS STARTED!!");
	}

	// Method to check if the entered PIN is correct
	void checkPin(int pin) {
		if (pin == PIN)  // If PIN is correct, show the menu
			menu();
		else {
			System.out.println("The pin is incorrect.");  // Incorrect PIN message
			exit();  // Exit the application
		}
	}

	// Menu to display ATM options to the user
	void menu() {
		System.out.println("1. CHECK BALANCE");  // Option to check balance
		System.out.println("2. DEPOSIT MONEY");  // Option to deposit money
		System.out.println("3. WITHDRAW MONEY"); // Option to withdraw money
		System.out.println("4. EXIT");           // Option to exit the ATM
		System.out.print("Please enter the Operation Number: ");
		
		int choice = sc.nextInt();  // Get user input for menu option
		
		// Perform action based on user's choice
		switch (choice) {
			case 1:
				checkBalance();  // Check the current balance
				break;
			case 2:
				depositMoney();  // Deposit money into the account
				break;
			case 3:
				withdrawMoney(); // Withdraw money from the account
				break;
			case 4:
				exit();  // Exit the ATM application
				break;
			default:
				System.out.println("Please enter the correct option.");  // Invalid input handling
				menu();  // Recall the menu for invalid input
		}
	}

	// Method to display the current balance
	void checkBalance() {
		System.out.println("BALANCE: " + balance);  // Show current balance
		menu();  // Go back to the menu
	}

	// Method to deposit money into the account
	void depositMoney() {
		System.out.print("Enter the money to deposit: ");
		double money = sc.nextDouble();  // Take input for deposit amount
		balance += money;  // Add deposit amount to balance
		System.out.println("Deposited successfully!");
		menu();  // Go back to the menu
	}

	// Method to withdraw money from the account
	void withdrawMoney() {
		System.out.print("Enter the money to withdraw: ");
		double money = sc.nextDouble();  // Take input for withdrawal amount

		// Check if the withdrawal amount is greater than available balance
		if (money > balance) {
			System.out.println("Insufficient Balance.");  // Error message if balance is insufficient
		} else {
			balance -= money;  // Subtract the withdrawal amount from balance
			System.out.println("Withdrawal successful!");
		}
		menu();  // Go back to the menu
	}

	// Method to exit the ATM application
	void exit() {
		System.out.println("THANK YOU!!!");  // Exit message
	}
}

// Main class to run the ATM machine
public class ATMMachine {

	public static void main(String[] args) {
		ATM obj = new ATM();  // Create a new ATM object
		
		// Create a new Scanner object for PIN input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the PIN: ");
		int pin = sc.nextInt();  // Get the PIN input from user
		obj.checkPin(pin);  // Check if the PIN is correct
		sc.close();  // Close the scanner
	}
}
