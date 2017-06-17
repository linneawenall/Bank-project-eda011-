import java.util.ArrayList;

import java.util.Scanner;

public class BankApplication { 
	Bank bank = new Bank();

	public static void main(String[] args) {
		BankApplication newBank = new BankApplication();
		newBank.RunApplication();

	}

	public void RunApplication() {
		Menu();
		while (menuOptions() == true) {
			menuOptions();
		}
	}

	public boolean menuOptions() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int choice = scan.nextInt();
			while (choice >9  || choice <1) {
				System.out.println("Välj ett kommando 1-9");
				choice = scan.nextInt();
			}
			System.out.println("Val:" + choice);

			if (choice == 1) {
				System.out.println("id:");
				scan.nextLine();
				long idNr = scan.nextLong();
				ArrayList<BankAccount> allAccountsforHolder = bank.findAccountsForHolder(idNr);
				if (allAccountsforHolder.isEmpty()) {
					System.out.println("Inga konton hittades");
				} else {
					for (int i = 0; i < allAccountsforHolder.size(); i++) {
						System.out.println(allAccountsforHolder.get(i).toString());
					}
				}
				Menu();
				return true;
			}
			if (choice == 2) {
				System.out.println("namn:");
				scan.nextLine();
				String namePart = scan.nextLine();
				ArrayList<Customer> matchingNames = bank.findByPartOfName(namePart);
				if (matchingNames.isEmpty()) {
					System.out.println("Inga konton hittades");
				} else {
					for (int i = 0; i < matchingNames.size(); i++) {
						System.out.println(matchingNames.get(i).toString());
					}
				}
				Menu();
				return true;

			}
			if (choice == 3) {
				System.out.println("Konto:");
				int accountNumber = scan.nextInt();
				while (bank.findByNumber(accountNumber) == null) {
					System.out.println("felaktigt kontonr!");
					System.out.println("Konto:");
					accountNumber = scan.nextInt();
				}
				System.out.println("belopp:");
				double amount = scan.nextDouble();
				while (amount < 0) {
					System.out.println("beloppet får inte vara negativt");
					System.out.println("belopp:");
					amount = scan.nextDouble();

				}
				bank.findByNumber(accountNumber).deposit(amount);
				System.out.println(bank.findByNumber(accountNumber).toString()); 
				Menu();
				return true;
			}
			if (choice == 4) {
				System.out.println("Från konto:");
				int accountNumber = scan.nextInt();
				while (bank.findByNumber(accountNumber) == null) {
					System.out.println("felaktigt kontonr");
					System.out.println("Konto:");
					accountNumber = scan.nextInt();
				}

				System.out.println("belopp:");
				double amount = scan.nextDouble();
				System.out.println("Konto:");

				while(amount <= 0) {
					System.out.println("beloppet måste vara större än noll");
					System.out.println("belopp:");
					amount = scan.nextDouble();

				}

				if (amount > bank.findByNumber(accountNumber).getAmount()) {
					System.out.println("uttaget misslyckades, endast " + bank.findByNumber(accountNumber).getAmount()
							+ " på kontot!");
				} else {
					bank.findByNumber(accountNumber).withdraw(amount);
					System.out.println(bank.findByNumber(accountNumber).toString());
				}
				Menu();
				return true;
			}

			if (choice == 5) {
				System.out.println("Från konto:");
				int accountNumber1 = scan.nextInt();
				while (bank.findByNumber(accountNumber1) == null) {
					System.out.println("felaktigt kontonr");
					System.out.println("Konto:");
					accountNumber1 = scan.nextInt();
				}
				System.out.println("Till konto:");
				int accountNumber2 = scan.nextInt();
				while (bank.findByNumber(accountNumber2) == null) {
					System.out.println("felaktigt kontonr");
					System.out.println("Konto:");
					accountNumber2 = scan.nextInt();
				}

				System.out.println("belopp:");
				double amount = scan.nextDouble();

				while (amount < 0) {
					System.out.println("beloppet får inte vara negativt");
					System.out.println("belopp:");
					amount = scan.nextDouble();

				}

				if (amount > bank.findByNumber(accountNumber1).getAmount()) {
					System.out.println("uttaget misslyckades, endast " + bank.findByNumber(accountNumber1).getAmount()
							+ "på kontot");
				} else {
					bank.findByNumber(accountNumber1).withdraw(amount);
					bank.findByNumber(accountNumber2).deposit(amount);
					System.out.println(bank.findByNumber(accountNumber1).toString());
					System.out.println(bank.findByNumber(accountNumber2).toString());
				}
				Menu();
				return true;
			}
			if (choice == 6) {
				System.out.println("namn:");
				scan.nextLine();
				String holderName = scan.nextLine();
				System.out.println("id:");
				long idNr = scan.nextLong();
				while (idNr <0){
					System.out.println("Felaktigt id-nummer!");
					idNr = scan.nextLong();
				}
				System.out.println("Konto skapat:" + bank.addAccount(holderName, idNr));
				Menu();
				return true;

			}
			if (choice == 7) {
				System.out.println("Konto:");
				int accountNumber = scan.nextInt();
				if (bank.findByNumber(accountNumber) == null) {
					System.out.println("felaktigt kontonr");
				}
				bank.removeAccount(accountNumber);
				Menu();
				return true;
			}
			if (choice == 8) {
				ArrayList<BankAccount> sortedAccounts = bank.getAllAccounts();
				if (sortedAccounts.isEmpty()) {
					System.out.println("Det finns inga konton");
				}
				for (int i = 0; i < sortedAccounts.size(); i++) {
					System.out.println(sortedAccounts.get(i).toString());

				}
				Menu();
				return true; 
			}
			if (choice == 9) {
				System.out.println("Programmet avslutas");
				return false;

			}
		}
	}

	private static void Menu() {
		System.out.println(" Vad är ditt ärende? Välj en siffra i menyn");
		System.out.println("1. Hitta konto utifrån innehavare ");
		System.out.println("2. Sök kontoninnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");

	}

}