package no.hvl.dat102.sortert_liste;

/**
 * A class that implements the ADT sorted list by using an instance of LList.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * Fikset litt av Lars-Petter mars 2024
 */
public class LListeSortertListe<T extends Comparable<? super T>> implements SortertListeADT<T> {

	private ListeADT<T> listen;

	public LListeSortertListe() {
		listen = new LenketListe<T>();
	}

	@Override
	public int getPosition(T anEntry) {

		int position = 1;
        while ((position <= listen.getLength()) && (anEntry.compareTo(listen.getEntry(position)) > 0)) {
			position++;
		}
		if ((position > listen.getLength()) || (anEntry.compareTo(listen.getEntry(position)) != 0)) {
			position = -position;
		}
		return position;
	}

	@Override
	public void add(T newEntry) {
		int newPosition = Math.abs(getPosition(newEntry));
		listen.add(newPosition, newEntry);
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getPosition(anEntry);

		if (position > 0) {
			listen.remove(position);
			result = true;
		}

		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		return getPosition(anEntry) > 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		return listen.getEntry(givenPosition);
	}

	@Override
	public T remove(int givenPosition) {
		return listen.remove(givenPosition);
	}

	@Override
	public void clear() {
		listen.clear();
	}

	@Override
	public int getLength() {
		return listen.getLength();
	}

	@Override
	public boolean isEmpty() {
		return listen.isEmpty();
	}

	@Override
	public T[] toArray() {
		int numberOfEntries = listen.getLength();

		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];

		for (int index = 0; index < numberOfEntries; index++)
			result[index] = listen.getEntry(index + 1);

		return result;
	}

}
