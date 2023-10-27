package JavaBankApplication;

// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************
import java.util.Scanner;
import java.util.ArrayList;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " +
				"3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	public static String formatBalance(double balance) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		DecimalFormat twoDecimals = new DecimalFormat("0.00",symbols);
		return twoDecimals.format(balance);
	}
	private static void listAccounts() {
		System.out.print("\n*** Account list ***\n");
		for (Account account : accountList) {
			System.out.println("Number: " + account.getAccountNumber() + " | Balance: " + formatBalance(account.getBalance()) + " euros");
		}
	}

	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter account number: ");
		String userInput = input.nextLine();
		boolean accountExists = false;
		for (Account account : accountList) {
			if (account.getAccountNumber().contains(userInput)) {
				accountExists = true;
				break;
			}
		}
		if (!accountExists) {
			Account newAccount = new Account(userInput);
			accountList.add(newAccount);
			System.out.println();
			System.out.println("Account created successfully!	");
		} else {
			System.out.println();
			System.out.println("Account not created. Account " + userInput + " exists already!");
		}
	}
	private static Account findAccount(String accountNumber) {
		Account myAccount = null;
		for (Account account : accountList) {
			if (account.getAccountNumber().equals(accountNumber)) {
				myAccount = account;
				break;
			}
		}
		return myAccount;
	}

	private static void depositMoney() {
		System.out.print("\n*** Deposit money to an account ***\n");
		System.out.print("Enter account number: ");
		String userInput = input.nextLine();
		Account myAccount = findAccount(userInput);
		if (myAccount != null) {
			System.out.print("Enter the amount to be deposited: ");
			double depositAmount = Double.parseDouble(input.nextLine());
			if (depositAmount > 0) {
				myAccount.deposit(depositAmount);
				System.out.println();
				System.out.println("Deposit completed successfully!");
			} else {
				System.out.println();
				System.out.println("Cannot deposit a negative amount!");
			}

		} else {
			System.out.println();
			System.out.println("Account " + userInput + " does not exist!");
		}

	}

	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");
		System.out.print("Enter account number: ");
		String userAccountnumber = input.nextLine();
		Account myAccount = findAccount(userAccountnumber);
		if (myAccount != null) {
			System.out.print("Enter the amount to be withdrawn: ");
			double userWithdraw = Double.parseDouble(input.nextLine());
			if (userWithdraw < 0) {
				System.out.println();
				System.out.println("Cannot withdraw a negative amount!");
				return;
			}
			if (myAccount.withdraw(userWithdraw)) {
				System.out.println();
				myAccount.setBalance(myAccount.getBalance() - userWithdraw);
				System.out.println("Withdrawal completed successfully!");
			} else {
				System.out.println();
				System.out.println("Withdrawal not completed. Available balance is too low.");
			}
		} else {
			System.out.println();
			System.out.println("Account " + userAccountnumber + " does not exist!");
		}
	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");
		System.out.print("Enter account number: ");
		String userInput = input.nextLine();
		Account myAccount = findAccount(userInput);
		if (myAccount != null) {
			accountList.remove(myAccount);
			System.out.println();
			System.out.println("Account deleted successfully!");
		} else {
			System.out.println();
			System.out.println("Nothing deleted. Account " + userInput + " does not exist!");
		}
	}
}
