package no.hvl.dat102.diverselister;

import java.util.ArrayList;
import java.util.List;

public class ListToListeAdapter2<T> implements ListeADT<T> {

	/*
	 * NB! Prøve en variant med justering av indekser i stedet for å
	 *     bruke en dummy-entry i pos 0.
	 *
	 *     Sjekke med enhetstesting at vi har gjort ting riktig!
	 */
	List<T> list;

	@SuppressWarnings("unchecked")
	public ListToListeAdapter2() {
		list = new ArrayList<>();
	}

	@Override
	public void add(T newEntry) {
		list.add(newEntry);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		list.add(newPosition-1, newEntry);
	}

	@Override
	public T remove(int givenPosition) {
		return list.remove(givenPosition-1);
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		return list.set(givenPosition-1, newEntry);
	}

	@Override
	public T getEntry(int givenPosition) {
		return list.get(givenPosition-1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[]) list.toArray();
	}

	@Override
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	@Override
	public int getLength() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void clear() {
		list.clear();
	}

}
