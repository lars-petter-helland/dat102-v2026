package no.hvl.dat102.diverselister;

public class ListToListeAdapter2Test extends AbstraktListeTest {

    @Override
    ListeADT<String> opprettNyListe() {
        return new ListToListeAdapter2<>();
    }
}
