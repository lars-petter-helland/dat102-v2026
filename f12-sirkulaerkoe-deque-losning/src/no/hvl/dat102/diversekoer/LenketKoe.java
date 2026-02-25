package no.hvl.dat102.diversekoer;

import no.hvl.dat102.adter.EmptyQueueException;
import no.hvl.dat102.adter.KoeADT;

/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * Fikset littegrann av Lars-Petter Helland, februar 2024
 */

public final class LenketKoe<T> implements KoeADT<T> {

	/* -------------------------------------------------------------- */

	private class Node {
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	/* -------------------------------------------------------------- */

	private Node foran; // References node at front of queue
	private Node bak; // References node at back of queue

	public LenketKoe() {
		foran = null;
		bak = null;
	}

	@Override
	public void enqueue(T newEntry) {

		Node nyNode = new Node(newEntry);

		if (isEmpty()) {
			foran = nyNode;
		} else {
			bak.neste = nyNode;
		}
		bak = nyNode;
	}

	@Override
	public T getFront() {

		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return foran.data;
	}

	@Override
	public T dequeue() {
		T front = getFront(); // Might throw EmptyQueueException
							  // Assertion: firstNode != null
		foran.data = null;
		foran = foran.neste;

		if (foran == null) {
			bak = null;
		}
		return front;
	}

	@Override
	public boolean isEmpty() {
		return (foran == null) && (bak == null);
	}

	@Override
	public void clear() {
		foran = null;
		bak = null;
	}
}
