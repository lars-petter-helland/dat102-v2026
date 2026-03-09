package no.hvl.dat102.sortert_liste;

/**
 * A class that implements the ADT sorted list by using a chain of linked nodes.
 * Duplicate entries are allowed. Recursive version.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 *          Fikset litt av Lars-Petter mars 2024
 */
public class LenketSortertListe<T extends Comparable<? super T>> implements SortertListeADT<T> {

	private Node firstNode;
	private int numberOfEntries;

	public LenketSortertListe() {
		firstNode = null;
		numberOfEntries = 0;
	}

	/* ------------------------------------------------------------------------ */
	
	@Override
	public void add(T newEntry) {
		firstNode = lenkeEtterInnsetting(newEntry, firstNode);
		numberOfEntries++;
	}

	/**
	 * Rekursiv "hjelpe"-metode for å sette inn et nytt element i listen
	 */
	private Node lenkeEtterInnsetting(T newEntry, Node p) {

		// TODO Gjøre denne sammen! Rekursiv metode for å oppdatere og returnere
		//      lenken med innsatt newEntry.

		return null;
	}

	/* ------------------------------------------------------------------------ */

	@Override
	public boolean remove(T anEntry) {
		boolean found = false;

		if (numberOfEntries > 0) {
			Node nodeToRemove;
			Node nodeBefore = getNodeBefore(anEntry);

			if (nodeBefore == null)
				nodeToRemove = firstNode;
			else
				nodeToRemove = nodeBefore.next;

			if ((nodeToRemove != null) && anEntry.equals(nodeToRemove.data)) {
				found = true;

				if (nodeBefore == null)
					firstNode = nodeToRemove.next;
				else {
					Node nodeAfter = nodeToRemove.next;
					nodeBefore.next = nodeAfter;
				} // end if

				numberOfEntries--;
			}
		}

		return found;
	}

	@Override
	public int getPosition(T anEntry) {
		int position = 1;
		Node currentNode = firstNode;

		while ((currentNode != null) && (anEntry.compareTo(currentNode.data) > 0)) {
			currentNode = currentNode.next;
			position++;
		}

		if ((currentNode == null) || anEntry.compareTo(currentNode.data) != 0)
			position = -position;

		return position;
	}

	@Override
	public T getEntry(int givenPosition) {
		T result = null;

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			result = getNodeAt(givenPosition).data;
		}
		return result;
	}

	@Override
	public T remove(int givenPosition) {
		T result = null;

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			if (givenPosition == 1) {
				result = firstNode.data;
				firstNode = firstNode.next;
			} else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.next;
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.next = nodeAfter;
				result = nodeToRemove.data;
			}
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public boolean contains(T anEntry) {
		return getPosition(anEntry) > 0;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			currentNode = currentNode.next;
			index++;
		}

		return result;
	}

	/* ------------------------------------------------------------------------ */

	/*
	 * Finds the node that is before the node that should or does contain a given
	 * entry. Returns either a reference to the node that is before the node that
	 * contains--or should contain--anEntry, or null if no prior node exists (that
	 * is, if anEntry is or belongs at the beginning of the list).
	 */
	private Node getNodeBefore(T anEntry) {
		Node currentNode = firstNode;
		Node nodeBefore = null;

		while ((currentNode != null) && (anEntry.compareTo(currentNode.data) > 0)) {
			nodeBefore = currentNode;
			currentNode = currentNode.next;
		}

		return nodeBefore;
	}

	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.next;
		return currentNode;
	}

	private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

	}
}
