package no.hvl.dat102.diversekoer;

import no.hvl.dat102.adter.KoeADT;

class SirkulaerKoeTest extends AbstractKoeADTTest {

	@Override
	protected <T> KoeADT<T> opprettNyKoe() {
		return new SirkulaerKoe<T>();
	}
}
