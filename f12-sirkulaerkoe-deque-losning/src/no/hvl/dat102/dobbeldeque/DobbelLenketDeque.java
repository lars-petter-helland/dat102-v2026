package no.hvl.dat102.dobbeldeque;

import no.hvl.dat102.adter.DequeADT;
import no.hvl.dat102.adter.EmptyQueueException;

/**
 * A class that implements the ADT deque by using a doubly linked chain of
 * nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 *
 * Fikset littegrann av Lars-Petter Helland, februar 2024
 * 
 */
public class DobbelLenketDeque<T> implements DequeADT<T> {

	private DLNode firstNode; // References node at front of deque
	private DLNode lastNode; // References node at back of deque

	public DobbelLenketDeque() {
		firstNode = null;
		lastNode = null;
	}

	public void addToBack(T newEntry) {

		DLNode newNode = new DLNode(newEntry);
		newNode.prev = lastNode;

		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}

	public void addToFront(T newEntry) {

		DLNode newNode = new DLNode(newEntry);
		newNode.next = firstNode;

		if (isEmpty()) {
			lastNode = newNode;
		} else {
			firstNode.prev = newNode;
		}
		firstNode = newNode;
	}

	public T getBack() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return lastNode.data;
	}

	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return firstNode.data;
	}

	public T removeFront() {

		T front = getFront(); // Might throw EmptyQueueException

		firstNode = firstNode.next;

		if (firstNode == null) {
			lastNode = null;
		} else {
			firstNode.prev = null;
		}
		return front;
	}

	public T removeBack() {

		T back = getBack(); // Might throw EmptyQueueException

		lastNode = lastNode.prev;

		if (lastNode == null) {
			firstNode = null;
		} else {
			lastNode.next = null;
		}
		return back;
	}

	public void clear() {
		firstNode = null;
		lastNode = null;
	}

	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	/* ------------------------------------------------------------------------- */

	private class DLNode {

		private T data;
		private DLNode next;
		private DLNode prev;

		private DLNode(T dataPortion) {
			data = dataPortion;
			next = null;
			prev = null;
		}
	}

	/* ------------------------------------------------------------------------- */

}
