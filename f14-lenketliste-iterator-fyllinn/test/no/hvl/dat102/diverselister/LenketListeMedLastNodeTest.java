package no.hvl.dat102.diverselister;

public class LenketListeMedLastNodeTest extends AbstraktListeTest {

    @Override
    ListeADT<String> opprettNyListe() {
        return new LenketListeMedLastNode<>();
    }
}
