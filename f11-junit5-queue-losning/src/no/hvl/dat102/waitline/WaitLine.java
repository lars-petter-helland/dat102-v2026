package no.hvl.dat102.waitline;

import no.hvl.dat102.koeadt.KoeADT;
import no.hvl.dat102.lenketkoe.LenketKoe;

/**
 * Simulates a waiting line.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class WaitLine {

	private KoeADT<Customer> line;
	private int numberOfArrivals;
	private int numberServed;
	private int totalTimeWaited;

	public WaitLine() {
		line = new LenketKoe<>();
		reset();
	}

	/**
	 * Simulates a waiting line with one serving agent.
	 * 
	 * @param duration           The number of simulated minutes.
	 * @param arrivalProbability A real number between 0 and 1, and the probability
	 *                           that a customer arrives at a given time
	 * @param maxTransactionTime The longest transaction time for a customer
	 */
	public void simulate(int duration, double arrivalProbability, int maxTransactionTime) {

		int transactionTimeLeft = 0;

		for (int clock = 0; clock < duration; clock++) {
			if (Math.random() < arrivalProbability) {
				numberOfArrivals++;
				int transactionTime = (int) (Math.random() * maxTransactionTime + 1);
				Customer nextArrival = new Customer(clock, transactionTime, numberOfArrivals);
				line.enqueue(nextArrival);
				System.out.println("Customer " + numberOfArrivals + " enters line at time " + clock
						+ ". Transaction time is " + transactionTime);
			}

			if (transactionTimeLeft > 0)
				transactionTimeLeft--;
			else if (!line.isEmpty()) {
				Customer nextCustomer = line.dequeue();
				transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
				int timeWaited = clock - nextCustomer.getArrivalTime();
				totalTimeWaited = totalTimeWaited + timeWaited;
				numberServed++;
				System.out.println("Customer " + nextCustomer.getCustomerNumber() + " begins service at time " + clock
						+ ". Time waited is " + timeWaited);
			}
		}
	}

	/** Displays summary results of the simulation. */
	public void displayResults() {
		System.out.println();
		System.out.println("Number served = " + numberServed);
		System.out.println("Total time waited = " + totalTimeWaited);
		double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
		System.out.println("Average time waited = " + averageTimeWaited);
		int leftInLine = numberOfArrivals - numberServed;
		System.out.println("Number left in line = " + leftInLine);
	} 

	/** Initializes the simulation. */
	public final void reset() {
		line.clear();
		numberOfArrivals = 0;
		numberServed = 0;
		totalTimeWaited = 0;
	} 
} 
