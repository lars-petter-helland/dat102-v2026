package no.hvl.dat102.diverselister;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstraktListeTest {
	
	ListeADT<String> tomListe;
	ListeADT<String> listeMedPerOgPaal;

	/*
		Denne metoden for å opprette en ny liste er abstrakt / uspesifisert
		i denne superklassen. For å teste en implementasjon av ListeADT-en
		lages en subklasse som oppretter i liste av gitt implementasjon.
		Slik kan vi teste mange ulike implementasjoner på samme tid :)
	 */
	abstract ListeADT<String> opprettNyListe();

	// ------------------------------------------------------------------------

	@BeforeEach
	void oppsett() {
		tomListe = opprettNyListe();
		listeMedPerOgPaal = opprettNyListe();
		listeMedPerOgPaal.add("Per");
		listeMedPerOgPaal.add("Pål");
	}

	// ------------------------------------------------------------------------

	@Test
	void egenskaperTomListe() {
		assertTrue(tomListe.isEmpty());
		assertEquals(0, tomListe.getLength());
		assertFalse(tomListe.contains("Per"));
	}

	@Test
	void egenskaperIkkeTomListe() {
		assertFalse(listeMedPerOgPaal.isEmpty());
		assertEquals(2, listeMedPerOgPaal.getLength());
		assertTrue(listeMedPerOgPaal.contains("Per"));
	}
	
	@Test
	void indeksgrenserTomListe() {
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.getEntry(0));
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.getEntry(1));
	}

	@Test
	void indeksgrenserIkkeTomListe() {
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.getEntry(0));
		assertEquals("Per", listeMedPerOgPaal.getEntry(1));
		assertEquals("Pål", listeMedPerOgPaal.getEntry(2));
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.getEntry(3));
	}
	
	@Test
	void leggeInnPaaPosisjon0() {
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.add(0, "A"));
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.add(0, "A"));
	}
	
	@Test
	void leggeInnPaaPosisjonNpluss2() {
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.add(2, "A"));
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.add(4, "A"));
	}
	
	@Test
	void leggeInnPaaLovligPosisjon() {
		
		tomListe.add(1, "A"); // n=0. Eneste lovlige posisjon er 1
		tomListe.add(2, "B"); // n=1. Lovlige posisjoner er 1 og 2
		assertEquals("A", tomListe.getEntry(1));
		assertEquals("B", tomListe.getEntry(2));
		
		listeMedPerOgPaal.add(1, "C"); // n=2. Lovlige posisjoner er 1, 2 og 3
		listeMedPerOgPaal.add(2, "D"); // n=3. Lovlige posisjoner er 1, 2, 3 og 4
		listeMedPerOgPaal.add(5, "E"); // n=4. Lovlige posisjoner er 1, 2, 3, 4 og 5
		assertEquals("C", listeMedPerOgPaal.getEntry(1));
		assertEquals("D", listeMedPerOgPaal.getEntry(2));
		assertEquals("Per", listeMedPerOgPaal.getEntry(3));
		assertEquals("Pål", listeMedPerOgPaal.getEntry(4));
		assertEquals("E", listeMedPerOgPaal.getEntry(5));
	}

	@Test
	void fjerneFraTomListe() {
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.remove(1));
	}

	@Test
	void fjerneFraUgyldigPosisjon() {
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.remove(3));
	}

	@Test
	void fjerneFraPerOgPaalListe() {
		String per = listeMedPerOgPaal.remove(1); //Fjerner og returnerer Per
		assertEquals("Per", per);
		assertEquals(1, listeMedPerOgPaal.getLength());
		String paal = listeMedPerOgPaal.remove(1); //Fjerner og returnerer Pål
		assertEquals("Pål", paal);
		assertEquals(0, listeMedPerOgPaal.getLength());
		assertTrue(listeMedPerOgPaal.isEmpty());
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.remove(1));
	}
	
	@Test
	void erstattITomListe() {
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.replace(0, "NY"));
		assertThrows(IndexOutOfBoundsException.class, () -> tomListe.replace(1, "NY"));
	}

	@Test
	void erstattIUgyldigPosisjon() {
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.replace(0, "Espen"));
		assertThrows(IndexOutOfBoundsException.class, () -> listeMedPerOgPaal.replace(3, "Espen"));
	}

	@Test
	void erstattIPerOgPaalListe() {
		String per = listeMedPerOgPaal.replace(1, "Espen"); //Erstatter Per med Espen og returnerer Per
		assertEquals("Per", per);
		assertEquals("Espen", listeMedPerOgPaal.getEntry(1));
		assertEquals(2, listeMedPerOgPaal.getLength());

		String paal = listeMedPerOgPaal.replace(2, "Espen"); //Erstatter Pål med Espen og returnerer Pål
		assertEquals("Pål", paal);
		assertEquals("Espen", listeMedPerOgPaal.getEntry(2));
		assertEquals(2, listeMedPerOgPaal.getLength());
	}

	@Test
	void testeClear() {
		listeMedPerOgPaal.clear();

		assertTrue(listeMedPerOgPaal.isEmpty()); //Denne feilet for List2ListeAdapter1
		assertEquals(0, listeMedPerOgPaal.getLength());
		assertFalse(listeMedPerOgPaal.contains("Per"));
	}

	@Test
	void testeToArray() {
		Object[] tabell = listeMedPerOgPaal.toArray(); //Denne feilet for List2ListeAdapter1
		assertEquals(2, tabell.length);
		assertEquals("Per", tabell[0]);
		assertEquals("Pål", tabell[1]);
	}
}
