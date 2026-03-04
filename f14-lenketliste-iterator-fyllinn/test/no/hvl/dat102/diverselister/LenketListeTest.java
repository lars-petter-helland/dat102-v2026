package no.hvl.dat102.diverselister;

public class LenketListeTest extends AbstraktListeTest {

    @Override
    ListeADT<String> opprettNyListe() {
        return new LenketListe<String>();
    }
}
