package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SokingTest2 {
	
	static Integer[] tomTabell = {};
	static Integer[] sortertTabell = new Integer[] { 1, 5, 7, 8, 9 };
	
	/*
	 * Merknad fra Lars-Petter 12. mars 2026:
	 * 
	 * Det var mye "nesten-duplikatkode" i SokingTest1.
	 * 
	 * Er det mulig å gjenbruke testene for å teste ulike søkemetoder?
	 *  
	 * I denne testklassen SokingTest2 prøver jeg å få til dette.
	 * Merknad: Utenfor DAT102-pensum. For de spesielt interesserte.
	 */
	
	/* 
	 * En liste av metoder som kan utføre søk i sortert tabell.
	 * Denne listen brukes som input til den parametriserte testen
	 * testeSokemetoderTabell().
	 */
	@FunctionalInterface
	interface Sokemetode {
		boolean sok(Integer[] tabell, Integer sokeverdi);
	}
	static Stream<Arguments> sokemetoderTabell() {
		return Stream.of(
				Arguments.of((Sokemetode) Soking::sekvensieltSokSortertTabell, "sekvensieltSokSortertTabell()"),
				Arguments.of((Sokemetode) Soking::binaertSokRekursiv, "binaertSokRekursiv()"),
				Arguments.of((Sokemetode) Soking::binaertSokIterativ, "binaertSokIterativ()"),
				Arguments.of((Sokemetode) (tab, e) -> Arrays.binarySearch(tab, e) >= 0, "Arrays.binarySearch()"));
	}

	@ParameterizedTest(name = "Test av søkemetode {1}") //Setter navnet som vises ved kjøring likt parameteren metodenavn
	@MethodSource("sokemetoderTabell")
	void testeSokemetoderTabell(Sokemetode sokemetode, String metodenavn) {

        // sortertTabell = [1, 5, 7, 8, 9]
		assertTrue(sokemetode.sok(sortertTabell, 1));
		assertTrue(sokemetode.sok(sortertTabell, 7));
		assertTrue(sokemetode.sok(sortertTabell, 9));
		
		assertFalse(sokemetode.sok(sortertTabell, 0));
		assertFalse(sokemetode.sok(sortertTabell, 6));
		assertFalse(sokemetode.sok(sortertTabell, 10));
		
		assertFalse(sokemetode.sok(tomTabell, 3));
	}
}
