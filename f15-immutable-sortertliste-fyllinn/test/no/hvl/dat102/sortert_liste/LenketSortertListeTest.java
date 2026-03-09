package no.hvl.dat102.sortert_liste;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LenketSortertListeTest {
	
	@Test
	void testeLittegrann() {
		
		SortertListeADT<Integer> liste = new LenketSortertListe<>();
		
		liste.add(5); // Sette inn i tom liste   -> [*5]
		liste.add(3); // Sette inn først         -> [*3, 5]
		liste.add(6); // Sette inn sist          -> [3, 5, *6]
		liste.add(4); // Sette inn midt i        -> [3, *4, 5, 6]
		liste.add(3); // Sette inn lik første    -> [*3, 3, 4, 5, 6]
		liste.add(4); // Sette inn lik en midt i -> [3, 3, *4, 4, 5, 6]
		liste.add(6); // Sette inn lik siste     -> [3, 3, 4, 4, 5, *6, 6]

		assertEquals(7, liste.getLength());
		assertArrayEquals(new Integer[]{3, 3, 4, 4, 5, 6, 6}, liste.toArray());

		System.out.println(Arrays.toString(liste.toArray()));
	}

}
