package no.hvl.dat102.waitline;

public class Customer {
	
	private int arrivalTime;
	private int transactionTime;
	private int customerNumber;
	
	public Customer(int arrivalTime, int transactionTime, int customerNumber) {
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.customerNumber = customerNumber;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getTransactionTime() {
		return transactionTime;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}
	
	

}
