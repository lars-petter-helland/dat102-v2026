package no.hvl.dat102.immutable_person_alt;

public class Main {
	
	public static void main(String[] args) {

		NavnIkkeMuterbar perViskeler = new NavnIkkeMuterbar("Per", "Viskeler");

		System.out.println("\nPerson Per Viskeler, født år 2000 etter tiltak 1..4 med ikke-muterbart navn:");
		PersonTiltak1234 p = new PersonTiltak1234(perViskeler, 2000);
		System.out.println(p);

		// Siden Navn nå er ikke-muterbart, kan ikke dette endres via set-metoder !
//		System.out.println("Muterer ved å endre etternavnet i navnet vi får fra getNavn():");
//		p.getNavn().setEtternavn("Nytt etternavn");
//		System.out.println("Muterer ved å endre fornavnet vi brukte i konstrukøren:");
//		perViskeler.setFornavn("Nytt fornavn");

		System.out.println("\nVPerson er ikke-muterbar! :)");
	}

}
