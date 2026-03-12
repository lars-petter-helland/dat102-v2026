package no.hvl.dat102;

import static no.hvl.dat102.Soking.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SokingTest1 {
	
	static Integer[] tomTabell = {};
	static Integer[] usortertTabell = new Integer[] { 1, 8, 0, 5, 7 };
	static Integer[] sortertTabell = new Integer[] { 1, 5, 7, 8, 9 };
	
	static Node<Integer> tomLenke = null;
	static Node<Integer> usortertLenke = null;
	static Node<Integer> sortertLenke = null;

	@BeforeAll
	static void settOppLenkene() throws Exception {

		//  lagLenke() er en hjelpemetode for å lage en lenke (se nederst) 
		usortertLenke = lagLenke(usortertTabell); // Vi kan bruke tabell som input,
		sortertLenke  = lagLenke(1, 5, 7, 8, 9);  // eller enkeltverdier ...
	}

	@Test
	void testUsortertTabell() {
		assertTrue(sokUsortertTabell(usortertTabell, 1));
		assertTrue(sokUsortertTabell(usortertTabell, 0));
		assertTrue(sokUsortertTabell(usortertTabell, 7));
		
		assertFalse(sokUsortertTabell(usortertTabell, 3));
		
		assertFalse(sokUsortertTabell(tomTabell, 3));
	}

	@Test
	void testSortertTabell() {
		assertTrue(sekvensieltSokSortertTabell(sortertTabell, 1));
		assertTrue(sekvensieltSokSortertTabell(sortertTabell, 7));
		assertTrue(sekvensieltSokSortertTabell(sortertTabell, 9));
		
		assertFalse(sekvensieltSokSortertTabell(sortertTabell, 0));
		assertFalse(sekvensieltSokSortertTabell(sortertTabell, 6));
		assertFalse(sekvensieltSokSortertTabell(sortertTabell, 11));
		
		assertFalse(sekvensieltSokSortertTabell(tomTabell, 3));
	}

	@Test
	void testUsortertLenke() {
		assertTrue(sokUsortertLenke(usortertLenke, 1));
		assertTrue(sokUsortertLenke(usortertLenke, 0));
		assertTrue(sokUsortertLenke(usortertLenke, 7));
		
		assertFalse(sokUsortertLenke(usortertLenke, 3));
		
		assertFalse(sokUsortertLenke(tomLenke, 3));
	}

	@Test
	void testSortertLenke() {
		assertTrue(sekvensieltSokSortertLenke(sortertLenke, 1));
		assertTrue(sekvensieltSokSortertLenke(sortertLenke, 7));
		assertTrue(sekvensieltSokSortertLenke(sortertLenke, 9));
		
		assertFalse(sekvensieltSokSortertLenke(sortertLenke, 0));
		assertFalse(sekvensieltSokSortertLenke(sortertLenke, 6));
		assertFalse(sekvensieltSokSortertLenke(sortertLenke, 11));
		assertFalse(sekvensieltSokSortertLenke(sortertLenke, 3));
		
		assertFalse(sekvensieltSokSortertLenke(tomLenke, 3));
	}
	
	/* ---------------------------------------------------------------- */
	
	/* Hjelpemetode for å lage lenke med verdier.
	 * 
	 * Setter inn først i lenken, og må da gå gjennom input baklengs.
	 * Kunne sikkert satt inn bakerst i stedet for enklere løkke.
	 *  
	 * Laget av Lars-Petter 4. mars 2025.
	 */
	static <T> Node<T> lagLenke(
			@SuppressWarnings("unchecked") T ... verdier) {
		
		Node<T> forste = null;
		
		for (int i=verdier.length-1; i>=0; i--) { // Baklengs n-1 .. 0
			
			Node<T> temp = new Node<>(verdier[i]);
			temp.neste = forste;
			forste = temp;
		}
		return forste;
	}
}
