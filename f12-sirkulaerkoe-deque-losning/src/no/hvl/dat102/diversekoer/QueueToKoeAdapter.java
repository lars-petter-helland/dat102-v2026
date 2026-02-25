package no.hvl.dat102.diversekoer;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import no.hvl.dat102.adter.EmptyQueueException;
import no.hvl.dat102.adter.KoeADT;

public class QueueToKoeAdapter<T> implements KoeADT<T> {

	private Queue<T> q = new LinkedList<>();

	@Override
	public void enqueue(T newEntry) {
		q.add(newEntry);
	}

	@Override
	public T dequeue() {
		try {
			return q.remove();
		} catch (NoSuchElementException e) {
			throw new EmptyQueueException();
		}
	}

	@Override
	public T getFront() {
		try {
			return q.element();
		} catch (NoSuchElementException e) {
			throw new EmptyQueueException();
		}
	}

	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public void clear() {
		q.clear();
	}

}
