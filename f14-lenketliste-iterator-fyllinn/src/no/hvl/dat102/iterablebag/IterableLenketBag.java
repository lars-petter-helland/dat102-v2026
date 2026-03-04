package no.hvl.dat102.iterablebag;

import java.util.Iterator;

public class IterableLenketBag<T> implements IterableBagADT<T> {

	/* ------------------------------------------------------------------- */

	//TODO ...

	/* ------------------------------------------------------------------- */

	@Override
	public Iterator<T> getIterator() {
		//TODO ...
		return null;
	}

	/* ------------------------------------------------------------------- */

	private Node forste;
	private int antall;
	
	public IterableLenketBag() {
		forste = null;
		antall = 0;
	}
	
	/* ------------------------------------------------------------------- */
	
	@Override
	public int getCurrentSize() {
		return antall;
	}

	@Override
	public boolean isEmpty() {
		return forste == null; //eller antall == 0;
	}

	@Override
	public boolean add(T newEntry) {
		
		// Legger inn først i listen siden det er enklest
		Node ny = new Node(newEntry);
		ny.neste = forste;
		forste = ny;
		antall++;
		
		return true;
	}

	@Override
	public T remove() {
		
		if (isEmpty()) {
			return null;
		}
		// Fjerner den første siden det er enklest
		T elementSomFjernes = forste.data;
		forste = forste.neste;
		antall--;
		
		return elementSomFjernes;
	}

	@Override
	public boolean remove(T anEntry) {
		
		//1) Finn referanse til den som skal fjernes, null hvis ikke funnet.
		//   Nesten som da vi søkte etter "Anne". Kanskje vi burde laget en
		//   private hjelpemetode for denne?
		Node funnetNode = finnNode(anEntry);
		
		//2) Hvis ikke funnet, så return false.
		if (funnetNode == null) {
			return false;
		}
		
		//3) Fjerning kan gjøres ved å overskrive data med data fra første node, 
		//	 og deretter fjerne første node.
		funnetNode.data = forste.data;
		forste = forste.neste;
		return true;
	}
	
	/* Private hjelpemetode til bruk i f.eks. remove(T e);
	 * Returnerer referanse til node hvis funnet, ellers null.
	 */
	private Node finnNode(T entry) {
		boolean funnet = false;
		Node temp = forste;
		while (temp != null && !funnet) {
			if (temp.data.equals(entry)) {
				funnet = true;
			} else {
				temp = temp.neste;
			}
		}
		return temp;
	}

	@Override
	public void clear() {
		// Her kan vi bruke remove() som hjelpemetode og gå i en løkke.
		// Evt. bare nullstille medlemsvariabler.
		forste = null;
		antall = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		//Litt tilsvarende søkemetoden finnNode()
		int frekvens = 0;
		Node temp = forste;
		while (temp != null) {
			if (temp.data.equals(anEntry)) {
				frekvens++;
			}
			temp = temp.neste;
		}
		return frekvens;
	}

	@Override
	public boolean contains(T anEntry) {
		// Her kan vi bruke getFrequencyOf() som hjelpemetode?
		// Eller kanskje enda enklere, søkemetoden finnNode()
		return finnNode(anEntry) != null;
	}

	@Override
	public T[] toArray() {
		// Starter med å lage tabellen elementene skal settes inn i.
		// Hva hvis tom? Lage en tabell med plass til 0 elementer?
		@SuppressWarnings("unchecked")
		T[] resultat = (T[]) new Object[antall];

		//Deretter er det å kopiere over elementene.
		Node temp = forste;
		int indeks = 0;
		while (temp != null) { //Kunne også sjekket på indeks vs. antall
			resultat[indeks] = temp.data;
			temp = temp.neste;
			indeks++;
		}
		return resultat;
	}
	
	/*
	 * Tester ut traversering og utskrift
	 */
	public void skrivUt() {
		
		Node denne = forste;
		while(denne != null) {
			System.out.println(denne.data);
			denne = denne.neste;
		}
	}

	/* ------------------------------------------------------------------- */
	
	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	/* ------------------------------------------------------------------- */
	
}
