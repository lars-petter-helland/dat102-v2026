package no.hvl.dat102.tabellstabel;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in an array.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.1
 * 
 *          Fikset litt på av Lars-Petter Helland, januar 2024
 */
public final class TabellStabel<T> implements StabelADT<T> {

	private T[] stack;
	private int topIndex;

	private static final int DEFAULT_CAPACITY = 10;

	public TabellStabel() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public TabellStabel(int initialCapacity) {
		stack = (T[]) new Object[initialCapacity];
		topIndex = -1;
	}

	@Override
	public void push(T newEntry) {
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack[topIndex];
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T top = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		return top;
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void clear() {
		// Remove references to the objects in the stack,
		// but do not deallocate the array
		while (topIndex > -1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

	// Doubles the size of the array stack if it is full
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		if (topIndex >= stack.length - 1) { // If array is full, double its size
			stack = Arrays.copyOf(stack, 2 * stack.length);
		}
	}
}
