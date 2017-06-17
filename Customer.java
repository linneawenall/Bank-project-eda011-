
public class Customer {
	private static int counter = 100;
	private String name;
	private long idNr;
	private int customerNr = 1;

	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		counter++;
		this.customerNr = counter;

	}

	public String getName() {
		return name;
	}

	public long getIdNr() {
		return idNr;
	}

	public int getCustomerNr() {
		return customerNr;
	}

	public String toString() {
		return (name + ", id " + idNr + ", kundnr " + customerNr );
	}
}