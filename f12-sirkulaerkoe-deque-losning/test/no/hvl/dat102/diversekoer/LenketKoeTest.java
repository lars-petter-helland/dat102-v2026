package no.hvl.dat102.diversekoer;

import no.hvl.dat102.adter.KoeADT;

class LenketKoeTest extends AbstractKoeADTTest {

	@Override
	protected <T> KoeADT<T> opprettNyKoe() {
		return new LenketKoe<T>();
	}
}
