package no.hvl.dat102.immutable_person;

/*
 * Demonstrerer ikke-mutérbarhet (en. immutability) ...
 * 
 * Creating an Immutable Class in Java:
 * 	1 - Make all of the fields private so that direct access is not allowed.
 * 	2 - Don't provide setter methods for variables.
 * 	3 - Make all mutable fields final so that a field's value can be assigned only once.
 * 	4 - Declare the class as final so it can't be extended.
 * 
 * Både boken og artikler på nettet sier dette, men selv med private final Navn navn
 * kan man gjøre navn.setEtternavn("...");
 * 
 * En annen artikkel sier i tillegg:
 *  5 - Deep Copy of objects should be performed in the getter methods to return a 
 *    copy rather than returning the actual object reference.
 *  6 - A parameterized constructor should initialize all the fields performing a 
 *    deep copy so that data members can’t be modified with an object reference.
 *    
 * Vi har altså 6 ting som må gjøres for å gjøre et objekt immutable.
 */
public class Main {
	
	public static void main(String[] args) {
		
		NavnMuterbar atlePatle = new NavnMuterbar("Atle", "Patle");
		NavnMuterbar perViskeler = new NavnMuterbar("Per", "Viskeler");
		NavnMuterbar madamFelle = new NavnMuterbar("Madam", "Felle");
		
		System.out.println("\nBegynner med muterbar Person Atle Patle, født år 2000:");
		PersonMuterbar p1 = new PersonMuterbar(atlePatle, 2000);
		System.out.println(p1);
		System.out.println("Muterer ved å endre navn og fødselsår via settere:");
		p1.setNavn(perViskeler);
		p1.setFodselsaar(1980);
		System.out.println(p1);
		
		// Problem: Enkelt å mutere p1 siden vi har public objektvariabler og/eller set-metoder
		// 		Fiks1+2: Gjøre objektvariabler private og fjerne set-metoder
		// 		Fiks3+4: Merker også objektvariabler og klassen med final for å hindre
		// 			utilsiktet mutering internt i koden.

		System.out.println("\nPrøver nå etter tiltak 1..4 med Atle Patle, født år 2000:");
		PersonTiltak1234 p2 = new PersonTiltak1234(atlePatle, 2000);
		System.out.println(p2);
		System.out.println("Muterer ved å endre etternavnet i navnet vi får fra getNavn():");
		p2.getNavn().setEtternavn("Nytt etternavn");
		System.out.println(p2);
		System.out.println("Muterer ved å endre fornavnet vi brukte i konstrukøren:");
		atlePatle.setFornavn("Nytt fornavn");
		System.out.println(p2);

		// Problem: Navn er muterbart, så p2.getNavn() gir mulighet til å endre innhold i navn.
		// 			Tilsvarende problem hvis vi endrer navneobjektet vi brukte i konstruktøren.
		// 		Fiks5: Returnere en kopi/klone av navnet fra getNavn().
		// 		Fiks6: Konstruere med en kopi/klone.

		System.out.println("\nPrøver nå etter tiltak 1..6 med Per Viskeler, født år 2000:");
		PersonTiltak123456 p3 = new PersonTiltak123456(perViskeler, 2000);
		p3.getNavn().setEtternavn("Nytt etternavn");
		perViskeler.setFornavn("Nytt fornavn");
		System.out.println(p3);
		
		System.out.println("\nVi har nå gjort Person ikke-muterbar! :)");
	}

}
