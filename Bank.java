import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;

	public Bank() {
		this.bankAccounts = new ArrayList<BankAccount>();

	}

	public int addAccount(String holderName, long idNr) {
		if (findHolder(idNr) == null) {
			BankAccount account = new BankAccount(holderName, idNr);
			bankAccounts.add(account);
			return account.getAccountNumber();
		} else {
			BankAccount account = new BankAccount(findHolder(idNr));
			bankAccounts.add(account);
			return account.getAccountNumber();
		}

	}

	public Customer findHolder(long idNr) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getHolder().getIdNr() == idNr) {
				return bankAccounts.get(i).getHolder();

			}
		}

		return null;
	}

	public boolean removeAccount(int number) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getAccountNumber() == number) {
				bankAccounts.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<BankAccount> getAllAccounts() {
		for (int i = 0; i < bankAccounts.size(); i++) {
			for (int j = i + 1; j < bankAccounts.size(); j++) {
				String customer1 = bankAccounts.get(i).getHolder().getName();
				String customer2 = bankAccounts.get(j).getHolder().getName();
				int result = customer1.compareTo(customer2);
				if (result > 0) {
					BankAccount temp = bankAccounts.get(i);
					bankAccounts.set(i, bankAccounts.get(j));
					bankAccounts.set(j, temp);
				}

			}
		}
		return bankAccounts;
	}

	public BankAccount findByNumber(int accountNumber) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getAccountNumber() == accountNumber) {
				return bankAccounts.get(i);

			}
		}

		return null;
	}

	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> matchingAccounts = new ArrayList<BankAccount>();
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getHolder().getIdNr() == idNr) {
				matchingAccounts.add(bankAccounts.get(i));
			}
		}

		return matchingAccounts;
	}

	public ArrayList<Customer> findByPartOfName(String namePart) {
		ArrayList<Customer> matchingNames = new ArrayList<Customer>();
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				matchingNames.add(bankAccounts.get(i).getHolder());
			}
		}

		return matchingNames;
	}
}
