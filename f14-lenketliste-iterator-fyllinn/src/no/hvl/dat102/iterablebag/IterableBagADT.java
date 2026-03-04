package no.hvl.dat102.iterablebag;

import java.util.Iterator;

/**
 * An interface that describes the operations of a bag of objects.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * Endret litt av Lars-Petter Helland februar 2024.
 */
public interface IterableBagADT<T> {
	
	/**
	 * Henter en iterator for bagen.
	 */
	Iterator<T> getIterator();
	
	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return The integer number of entries currently in the bag.
	 */
	int getCurrentSize();

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if the bag is empty, or false if not.
	 */
	boolean isEmpty();

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	boolean add(T newEntry);

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	T remove();

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	boolean remove(T anEntry);

	/** Removes all entries from this bag. */
	void clear();

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	int getFrequencyOf(T anEntry);

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry The entry to find.
	 * @return True if the bag contains anEntry, or false if not.
	 */
	boolean contains(T anEntry);

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in the bag. Note: If the
	 *         bag is empty, the returned array is empty.
	 */
	T[] toArray();
}
