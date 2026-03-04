package no.hvl.dat102.diverselister;

import java.util.Arrays;

/**
 * A class that implements a list of objects by using an array. Entries in a
 * list have positions that begin with 1. Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 *          Fikset litt av Lars-Petter Helland februar 2024
 */
public class TabellListe<T> implements ListeADT<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private T[] tab; // NB! Indekser 1..n tilsvarer posisjon 1..n. list[0] er ubrukt!
	private int n;

	public TabellListe() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public TabellListe(int initialCapacity) {

        // Sikre at fornuftig verdi på initialCapacity.
        // Hvis ikke mellom 2 og 1000, så kaster vi et unntak.
        if (initialCapacity < 2 || initialCapacity > 1000) {
            throw new IllegalArgumentException(
                    "En ny TabellListe må ha en initiell kapasitet mellom 2 og 1000!");
        }

		tab = (T[]) new Object[initialCapacity + 1]; // NB! list[1]..list[n] !
		n = 0;
	}

	@Override
	public void add(T newEntry) {
		add(n + 1, newEntry);
	}

	@Override
	public void add(int givenPosition, T newEntry) {

		if ((givenPosition < 1) || (givenPosition > n + 1)) {
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
		}

		if (givenPosition <= n) {
			makeRoom(givenPosition);
		}
		tab[givenPosition] = newEntry;
		n++;

		ensureCapacity(); // Ensure enough room for next add
	}

	@Override
	public T remove(int givenPosition) {

		if ((givenPosition < 1) || (givenPosition > n)) {
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		}

		T result = tab[givenPosition];

		if (givenPosition < n) {
			removeGap(givenPosition);
		}

		tab[n] = null;
		n--;

		return result;
	}

	@Override
	public void clear() {
		for (int index = 1; index <= n; index++) {
			tab[index] = null;
		}
		n = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {

		if ((givenPosition < 1) || (givenPosition > n)) {
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
		}
		T originalEntry = tab[givenPosition];
		tab[givenPosition] = newEntry;

		return originalEntry;
	}

	@Override
	public T getEntry(int givenPosition) {

		if ((givenPosition < 1) || (givenPosition > n)) {
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		}
		return tab[givenPosition];
	}

	@Override
	public T[] toArray() {
		//Kan ikke bruke Arrays.copyOf(tab, n) siden elementene er på plass 1..n
		//i tab. Må i stedet bruke Arrays.copyOfRange(tab, 1, n+1).
		return Arrays.copyOfRange(tab, 1, n+1);
	}

	@Override
	public boolean contains(T anEntry) {
		
		for (int i=1; i<=n; i++) {
			if (anEntry.equals(tab[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getLength() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	// Doubles the capacity of the array list if it is full.
	private void ensureCapacity() {
		
		int capacity = tab.length - 1;
		if (n >= capacity) {
			int newCapacity = 2 * capacity;
			tab = Arrays.copyOf(tab, newCapacity + 1);
		}
	}

	// Makes room for a new entry at newPosition.
	private void makeRoom(int givenPosition) {
		
		int newIndex = givenPosition;
		int lastIndex = n;

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--) {
			tab[index + 1] = tab[index];
		}
	}

	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	private void removeGap(int givenPosition) {
		
		int removedIndex = givenPosition;
		for (int index = removedIndex; index < n; index++) {
			tab[index] = tab[index + 1];
		}
	}
}
