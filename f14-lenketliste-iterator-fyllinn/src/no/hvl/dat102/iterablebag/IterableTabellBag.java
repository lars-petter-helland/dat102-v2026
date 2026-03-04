package no.hvl.dat102.iterablebag;

import java.util.Arrays;
import java.util.Iterator;

/**
 * En implementasjon av BagADT
 * 
 * @author Lars-Petter Helland
 */
public class IterableTabellBag<T> implements IterableBagADT<T> {
	
	/* ------------------------------------------------------------------- */

	//TODO ...
	
	/* ------------------------------------------------------------------- */
	
	@Override
	public Iterator<T> getIterator() {
		//TODO ...
		return null;
	}

	/* ------------------------------------------------------------------- */
	
	private static final int DEFAULT_KAPASITET = 10;

	private T[] tabell;
	private int antall;

	public IterableTabellBag() {
		this(DEFAULT_KAPASITET);
	}

	@SuppressWarnings("unchecked")
	public IterableTabellBag(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
		antall = 0;
	}

	/* ------------------------------------------------------------------- */

	@Override
	public int getCurrentSize() {
		return antall;
	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public boolean add(T newEntry) {
		if (antall == tabell.length) {
			// return false;
			// Alternativt, vi flytter elementene over i en større tabell
			// før innsetting hvis den gamle er full. 
			tabell = Arrays.copyOf(tabell, tabell.length * 2);
		}
		tabell[antall] = newEntry;
		antall++;
		return true;
	}

	@Override
	public T remove() {
		if (antall > 0) {
			//Gjør det enkelt. Fjerner siste. Slipper å tette hull.
			T element = tabell[antall - 1];
			antall--;
			return element;
		}
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// I denne metoden må vi først finne (indeksen til) den som skal slettes.
		// Kunne kanskje hatt søkingen som en private hjelpemetode.
		boolean funnet = false;
		int indeks = 0;
		while(indeks < antall && !funnet) {
			if (anEntry.equals(tabell[indeks])) {
				funnet = true; //på indeks
			} else {
				indeks++;
			}
		}
		if (!funnet) {
			return false;
		}
		
		// Sletter ved å sette siste element inn på plassen til den som
		// skal slettes, dvs. fyller hullet som oppstår.
		tabell[indeks] = tabell[antall-1];
		tabell[antall-1] = null;
		antall--;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		int length = tabell.length;
		tabell = (T[]) new Object[length];
		antall = 0;
	}
	
//  Alternativt, og kanskje bedre ...
//	@Override
//	public void clear() {
//		while (!isEmpty()) {
//			remove();
//		}
//		antall = 0;
//	}


	@Override
	public int getFrequencyOf(T anEntry) {
		int frekvens = 0;
		for (int i = 0; i < antall; i++) {
			if (anEntry.equals(tabell[i])) {
				frekvens++;
			}
		}
		return frekvens;
	}

	@Override
	public boolean contains(T anEntry) {
		// ... bag.contains("Per");
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (element.equals(anEntry)) {
				return true;
			}
		}
		return false;
	}
	
//  Alternativt, hvis getFrequencyOf allerede er laget ...
//	@Override
//	public boolean contains(T anEntry) {
//		return getFrequencyOf(anEntry) > 0;
//	}
	
	@Override
	public T[] toArray() {
		return Arrays.copyOf(tabell, antall);
	}


	/************************************************************/

}
