package no.hvl.dat102.diversekoer;

import java.util.Arrays;

import no.hvl.dat102.adter.EmptyQueueException;
import no.hvl.dat102.adter.KoeADT;

/**
 * A class that implements the ADT queue by using an expandable circular array
 * with one unused location after the back of the queue.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.1
 * 
 * Fikset littegrann av Lars-Petter Helland, februar 2024
 * 
 */
public class SirkulaerKoe<E> implements KoeADT<E> {

	private static final int DEFAULT_CAPACITY = 3; // Small capacity for testing

	private E[] tabell; // Circular array of queue entries and one unused location
	private int frontIndex; // Index of front entry
	private int backIndex; // Index of back entry

	public SirkulaerKoe() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public SirkulaerKoe(int initialCapacity) {
		tabell = (E[]) new Object[initialCapacity + 1];
		frontIndex = 0;
		backIndex = initialCapacity;
	}

	@Override
	public void enqueue(E newEntry) {
		ensureCapacity();
		backIndex = (backIndex + 1) % tabell.length;
		tabell[backIndex] = newEntry;
	}

	@Override
	public String toString() {
		return "SirkulaerKoe [queue=" + Arrays.toString(tabell) 
				+ ", frontIndex=" + frontIndex 
				+ ", backIndex=" + backIndex + "]";
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return tabell[frontIndex];
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		E front = tabell[frontIndex];
		tabell[frontIndex] = null;
		frontIndex = (frontIndex + 1) % tabell.length;
		return front;
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == (backIndex + 1) % tabell.length;
	}

	@Override
	public void clear() {
		if (!isEmpty()) { // Deallocates only the used portion
			for (int index = frontIndex; index != backIndex; index = (index + 1) % tabell.length) {
				tabell[index] = null;
			}
			tabell[backIndex] = null;
		}
		frontIndex = 0;
		backIndex = tabell.length - 1;
	}

	// Doubles the size of the array queue if it is full.
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {

		if (isArrayFull()) {
			E[] oldQueue = tabell;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			
//			System.out.println("Kapasitet utvides til " + newSize);
			tabell = (E[]) new Object[newSize];
			for (int index = 0; index < oldSize - 1; index++) {
				tabell[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}

	private boolean isArrayFull() {
		return frontIndex == ((backIndex + 2) % tabell.length);
	}
}
