package no.hvl.dat102.sortert_liste;

/**
 * A driver that demonstrates the class LinkedSortedList.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Driver {

	public static void main(String[] args) {

		// Create a list
		System.out.println("Create a new sorted list that is empty:");
		
//		SortertListeADT<String> myList = new LenketSortertListe<>();
		SortertListeADT<String> myList = new LListeSortertListe<>();

		// Test isEmpty with an empty list
		System.out.println("Test isEmpty with an empty list:");
		if (myList.isEmpty())
			System.out.println("isEmpty finds the list empty - OK");
		else
			System.out.println("isEmpty does not return true - ERROR");

		// Test add, getLength, and getEntry
		System.out.println("\nTest add, getLength, and getEntry ");
		myList.add("45");
		myList.add("15");
		myList.add("25");
		myList.add("35");
		myList.add("55");
		myList.add("95");
		myList.add("85");
		myList.add("65");
		myList.add("75");

		// Display the list (Tests getLength and getEntry)
		System.out.println("The sorted list should contain 9 entries, as follows: 15 25 35 45 55 65 75 85 95\n");
		displayList(myList);

		// Test getPosition
		System.out.println("\nTest getPosition:\n");
		System.out.println("15 is at position " + myList.getPosition("15") + " (should be 1)");
		System.out.println("55 is at position " + myList.getPosition("55") + " (should be 5)");
		System.out.println("95 is at position " + myList.getPosition("95") + " (should be 9)");
		System.out.println("0 s/b at position " + myList.getPosition("0") + " (should be -1)");
		System.out.println("50 s/b at position " + myList.getPosition("50") + " (should be -5)");
		System.out.println("90 s/b at position " + myList.getPosition("90") + " (should be -9)");
		System.out.println("99 s/b at position " + myList.getPosition("996") + " (should be -10)");

		// Test contains
		System.out.println("\nTest contains:\n");

		// The following entries are in the list
		if (myList.contains("15"))
			System.out.println("\n15 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 15");

		if (myList.contains("25"))
			System.out.println("\n25 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 25");

		if (myList.contains("35"))
			System.out.println("\n35 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 35");

		if (myList.contains("45"))
			System.out.println("\n45 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 45");

		if (myList.contains("55"))
			System.out.println("\n55 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 55");

		if (myList.contains("65"))
			System.out.println("\n65 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 65");

		if (myList.contains("75"))
			System.out.println("\n75 is in the list - OK");
		else
			System.out.println("contains() error: Cannot locate 75");
		// The following entries are not in the list
		if (myList.contains("9"))
			System.out.println("contains() error: Finds 9 in the list");
		else
			System.out.println("\n9 is not in the list - OK");

		if (myList.contains("59"))
			System.out.println("contains() error: Finds 59 in the list");
		else
			System.out.println("\n59 is not in the list - OK");

		if (myList.contains("99"))
			System.out.println("contains() error: Finds 99 in the list");
		else
			System.out.println("\n99 is not in the list - OK");

		// Test remove
		System.out.println("\nTest remove:");

		// Remove first entry
		System.out.println("\nRemoving first item (15): " + myList.remove("15"));
		System.out.println("\nAfter removing 15:");
		displayList(myList);

		// Remove interior
		System.out.println("\nRemoving interior item (55): " + myList.remove("55"));
		System.out.println("\nAfter removing 5:");
		displayList(myList);

		// Remove last
		System.out.println("\nRemoving last item (95): " + myList.remove("95"));
		System.out.println("\nAfter removing 95:");
		displayList(myList);

		// Remove non-existant entries
		System.out.println("\nTrying to remove an entry (15) that does not exist: " + myList.remove("15"));
		System.out.println("\nTrying to removeg an entry (55) that does not exist: " + myList.remove("55"));
		System.out.println("\nTrying to remove an entry (95) that does not exist: " + myList.remove("95"));

		System.out.println("\nThe sorted list should contain 6 entries, as follows: 25 35 45 65 75 85\n");
		displayList(myList);
		// Test clear
		System.out.println("\nTest clear():\n");
		myList.clear();
		if (myList.isEmpty())
			System.out.println("\nThe list is empty after invoking clear().");
		else
			System.out.println("\nclear() error");

		// Test contains with an empty list
		System.out.println("\nTest contains with an empty list:");

		if (myList.contains("15"))
			System.out.println("contains() error: Finds 15 in the empty list");
		else
			System.out.println("15 is not in an empty list - OK");

		System.out.println("\n\nDone.");
	} // end main

	public static void displayList(SortertListeADT<String> aList) {
		int numberOfEntries = aList.getLength();
		System.out.print("The sorted list contains " + numberOfEntries + " entries, as follows: ");
		for (int position = 1; position <= numberOfEntries; position++)
			System.out.print(aList.getEntry(position) + " ");
		System.out.println();
		System.out.println();
	} // end displayList
} // end Driver

/*
 * Create a new sorted list that is empty: Test isEmpty with an empty list:
 * isEmpty finds the list empty - OK
 * 
 * Test add, getLength, and getEntry The sorted list should contain 9 entries,
 * as follows: 15 25 35 45 55 65 75 85 95
 * 
 * The sorted list contains 9 entries, as follows: 15 25 35 45 55 65 75 85 95
 * 
 * 
 * Test getPosition:
 * 
 * 15 is at position 1 (should be 1) 55 is at position 5 (should be 5) 95 is at
 * position 9 (should be 9) 0 s/b at position -1 (should be -1) 50 s/b at
 * position -5 (should be -5) 90 s/b at position -9 (should be -9) 99 s/b at
 * position -10 (should be -10)
 * 
 * Test contains:
 * 
 * 
 * 15 is in the list - OK
 * 
 * 25 is in the list - OK
 * 
 * 35 is in the list - OK
 * 
 * 45 is in the list - OK
 * 
 * 55 is in the list - OK
 * 
 * 65 is in the list - OK
 * 
 * 75 is in the list - OK
 * 
 * 9 is not in the list - OK
 * 
 * 59 is not in the list - OK
 * 
 * 99 is not in the list - OK
 * 
 * Test remove:
 * 
 * Removing first item (15): true
 * 
 * After removing 15: The sorted list contains 8 entries, as follows: 25 35 45
 * 55 65 75 85 95
 * 
 * 
 * Removing interior item (55): true
 * 
 * After removing 5: The sorted list contains 7 entries, as follows: 25 35 45 65
 * 75 85 95
 * 
 * 
 * Removing last item (95): true
 * 
 * After removing 95: The sorted list contains 6 entries, as follows: 25 35 45
 * 65 75 85
 * 
 * 
 * Trying to remove an entry (15) that does not exist: false
 * 
 * Trying to removeg an entry (55) that does not exist: false
 * 
 * Trying to remove an entry (95) that does not exist: false
 * 
 * The sorted list should contain 6 entries, as follows: 25 35 45 65 75 85
 * 
 * The sorted list contains 6 entries, as follows: 25 35 45 65 75 85
 * 
 * 
 * Test clear():
 * 
 * 
 * The list is empty after invoking clear().
 * 
 * Test contains with an empty list: 15 is not in an empty list - OK
 * 
 * 
 * Done.
 */
