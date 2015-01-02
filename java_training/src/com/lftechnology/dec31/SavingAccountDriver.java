package com.lftechnology.dec31;

/**
 * Create class SavingsAccount. Use a static variable annualInterestRate to
 * store the annual interest rate for all account holders. Each object of the
 * class contains a private instance variable savingsBalance indicating the
 * amount the saver currently has on deposit. Provide method
 * calculateMonthlyInterest to calculate the monthly interest by multiplying the
 * savingsBalance by annualInterestRate divided by 12. This interest should be
 * added to savingsBalance. Provide a static method modifyInterestRate that sets
 * the annualInterestRate to a new value. Write a program to test class
 * SavingsAccount. Instantiate two savingsAccount objects, saver1 and saver2,
 * with balances of $2000.00 and $3000.00, respectively. Set annualInterestRate
 * to 4%, then calculate the monthly interest and print the new balances for
 * both savers. Then set the annualInterestRate to 5%, calculate the next
 * month's interest and print the new balances for both savers.
 * 
 * @author satish
 *
 */
public class SavingAccountDriver {

	public static void main(String[] args) {

		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate(4);
		System.out.println("Initial balance for saver1 : "
				+ saver1.getSavingsBalance());
		System.out.println("Initial balance for saver2 : "
				+ saver2.getSavingsBalance());

		// apply interest to saver1 balance for one month
		saver1.applyInterest(saver1.calculateMonthlyInterest(), 1);
		System.out.println("balance of saver 1 after 1st month : "
				+ saver1.getSavingsBalance());

		// apply interest to saver2 balance for one month
		saver2.applyInterest(saver1.calculateMonthlyInterest(), 1);
		System.out.println("balance of saver 2 after 1st month : "
				+ saver2.getSavingsBalance());

		SavingsAccount.modifyInterestRate(5);

		// apply new interest to saver1 balance for one month
		saver1.applyInterest(saver1.calculateMonthlyInterest(), 1);
		System.out.println("balance of saver1 after 2nd month : "
				+ saver1.getSavingsBalance());

		// apply new interest to saver2 balance for one month
		saver2.applyInterest(saver1.calculateMonthlyInterest(), 1);
		System.out.println("balance of saver2 after 2nd month : "
				+ saver2.getSavingsBalance());

	}

}

/**
 * This class represents a saving account for its instances holding the savings
 * Balance for it. Also it stores the interest rate common for all the saving
 * accounts and allows to update it. it provides methods for calculating new
 * balance and setting it after apllying the monthly interest rate.
 * 
 * @author satish
 *
 */
class SavingsAccount {
	public static double annualInterestRate = 0;
	private double savingsBalance = 0;

	SavingsAccount(double startingBalance) {
		savingsBalance = startingBalance;
	}

	/**
	 * @param newAnnualInterestRate
	 */
	public static void modifyInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}

	/**
	 * @return current saving Balance
	 */
	public double getSavingsBalance() {
		return savingsBalance;
	}

	/**
	 * calculate the montly interest from the annual interest
	 * 
	 * @return monthly interest
	 */
	public double calculateMonthlyInterest() {
		return annualInterestRate / 12;
	}

	/**
	 * adds the specified interest for a given time period (months)
	 * 
	 * @param monthlyInterest
	 *            to be applied to savings balance
	 * @param months
	 *            -time in months for which the interest need to be applied
	 */
	public void applyInterest(double monthlyInterest, int months) {
		savingsBalance *= 1 + (monthlyInterest * months) / 100;
	}

}
