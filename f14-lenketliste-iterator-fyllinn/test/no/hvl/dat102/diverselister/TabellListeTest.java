package no.hvl.dat102.diverselister;

public class TabellListeTest extends AbstraktListeTest {

    @Override
    ListeADT<String> opprettNyListe() {
        return new TabellListe<String>();
    }
}
