package no.hvl.dat102.diverselister;

public class ListToListeAdapter1Test extends AbstraktListeTest {

    @Override
    ListeADT<String> opprettNyListe() {
        return new ListToListeAdapter1<>();
    }
}
