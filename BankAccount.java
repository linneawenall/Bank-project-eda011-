
public class BankAccount {
	private Customer accountHolder;
	private int accountNumber;
	private double amount;
	private static int counter = 1000;

	public BankAccount(String holderName, long holderId) {
		accountHolder = new Customer(holderName, holderId);
		amount = 0;
		counter++;
		this.accountNumber = counter;
	}

	public BankAccount(Customer holder) {
		accountHolder = holder;
		amount = 0;
		counter++;
		this.accountNumber = counter;
	}

	public Customer getHolder() {
		return accountHolder;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void deposit(double amount) {
		this.amount += amount;
	}

	public void withdraw(double amount) {
		this.amount -= amount;
	}

	public String toString() {
		return ("konto " + accountNumber + "(" + accountHolder.toString() + "): " + amount);
	}
}
