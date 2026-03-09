package no.hvl.dat102.sortert_liste;

/**
 * A linked implemention of the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 *          Fikset litt av Lars-Petter Helland, februar 2024
 * 
 *          Ting jeg ALLTID fikser i bokens eksempler: I Java skal
 *          startparentes{ stå på slutten av linje! Alle blokker bør ha
 *          klammeparenteser{}, også hvis kun én linje! Alle metoder definert i
 *          interface eller superklasse skal ha @Override! Bruk kun kommentarer
 *          for ting som IKKE kan uttrykkes i kode! Alle andre kommentarer er boss.
 * 
 *          Ellers fikser jeg litt på kodestil og forenkler der jeg kan. Jeg har
 *          også tatt et valg om "stil" for feilhåndtering, vet at feilsituasjoner
 *          ryddes av veien (return/throw) FØR man går videre.
 * 
 *          Jeg har også gjort et designvalg om å bruke Node sin data og next
 *          direkte med =, i stedet for å bruke getNext() og setNext().
 * 
 */
public class LenketListe<T> implements ListeADT<T> {

	/* ------------------------------------------------------------------- */

	private class Node {

		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	/* ------------------------------------------------------------------- */

	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LenketListe() {
		initializeDataFields();
	}

	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public void clear() {
		initializeDataFields();
	}

	@Override
	public void add(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			firstNode = newNode;
		} else {
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.next = newNode;
		}
		numberOfEntries++;
	}

	@Override
	public void add(int givenPosition, T newEntry) {

		if ((givenPosition < 1) || (givenPosition > numberOfEntries + 1)) {
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
		}

		Node newNode = new Node(newEntry);
		if (givenPosition == 1) {
			newNode.next = firstNode;
			firstNode = newNode;
		} else {
			Node nodeBefore = getNodeAt(givenPosition - 1);
			Node nodeAfter = nodeBefore.next;
			newNode.next = nodeAfter;
			nodeBefore.next = newNode;
		}
		numberOfEntries++;
	}

	@Override
	public T remove(int givenPosition) {

		if ((givenPosition < 1) || (givenPosition > numberOfEntries)) {
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		}

		T result = null;
		if (givenPosition == 1) {
			result = firstNode.data;
			firstNode = firstNode.next;
		} else {
			Node nodeBefore = getNodeAt(givenPosition - 1);
			Node nodeToRemove = nodeBefore.next;
			result = nodeToRemove.data;
			Node nodeAfter = nodeToRemove.next;
			nodeBefore.next = nodeAfter;
		}
		numberOfEntries--;
		return result;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {

		if ((givenPosition < 1) || (givenPosition > numberOfEntries)) {
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
		}

		Node desiredNode = getNodeAt(givenPosition);
		T originalEntry = desiredNode.data;
		desiredNode.data = newEntry;
		return originalEntry;
	}

	@Override
	public T getEntry(int givenPosition) {

		if ((givenPosition < 1) || (givenPosition > numberOfEntries)) {
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		}
		return getNodeAt(givenPosition).data;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			currentNode = currentNode.next;
			index++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		Node currentNode = firstNode;

		while (currentNode != null) {
			if (anEntry.equals(currentNode.data)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	/*
	 * Denne måtte jeg bare la stå siden den viser mange av tingene jeg fikser.
	 * Sammenlign gjerne med min forenklede/forbedrede versjon under. Ingen, verken
	 * studenter eller lærebokforfattere, bør skrive slik kode !!!
	 */
//	public boolean isEmpty() {
//		boolean result;
//
//		if (numberOfEntries == 0) // Or getLength() == 0
//		{
//			// Assertion: firstNode == null
//			result = true;
//		} else {
//			// Assertion: firstNode != null
//			result = false;
//		} // end if
//
//		return result;
//	} // end isEmpty

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/*
	 * Returns a reference to the node at a given position. Precondition: (The chain
	 * is not empty) and (1 <= givenPosition <= numberOfEntries).
	 */
	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		for (int counter = 1; counter < givenPosition; counter++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
}
