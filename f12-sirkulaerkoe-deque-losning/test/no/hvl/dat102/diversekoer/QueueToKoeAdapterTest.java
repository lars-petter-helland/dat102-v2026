package no.hvl.dat102.diversekoer;

import no.hvl.dat102.adter.KoeADT;

class QueueToKoeAdapterTest extends AbstractKoeADTTest {

	@Override
	protected <T> KoeADT<T> opprettNyKoe() {
		return new QueueToKoeAdapter<T>();
	}
}
