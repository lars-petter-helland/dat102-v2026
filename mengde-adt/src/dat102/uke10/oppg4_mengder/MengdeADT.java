package dat102.uke10.oppg4_mengder;

public interface MengdeADT<T> {
	
	/**
	 * @return Om mengden er tom
	 */
	boolean erTom();
	
	/**
	 * @param element
	 * @return Om mengden inneholder element
	 */
	boolean inneholder(T element);
	
	/**
	 * @param annenMengde
	 * @return Om mengden er en delmengde av en annenMengde
	 */
	boolean erDelmengdeAv(MengdeADT<T> annenMengde);
	
	/**
	 * @param annenMengde
	 * @return Om mengden er lik en annenMengde
	 */
	boolean erLik(MengdeADT<T> annenMengde);
	
	/**
	 * @param annenMengde
	 * @return Om mengden og en annenMengde er disjunkte
	 */
	boolean erDisjunkt(MengdeADT<T> annenMengde);
	
	/**
	 * @param annenMengde
	 * @return Snittet av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	MengdeADT<T> snitt(MengdeADT<T> annenMengde);
	
	/**
	 * @param annenMengde
	 * @return Unionen av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	MengdeADT<T> union(MengdeADT<T> annenMengde);
	
	/**
	 * @param annenMengde
	 * @return Mengden minus annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	MengdeADT<T> minus(MengdeADT<T> annenMengde);
	
	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis
	 * det ikke finnes i mengden fra før.
	 * 
	 * @param element
	 */
	void leggTil(T element);
	
	/**
	 * Legger alle elementer fra en annenMengde til i mengden. Kun elementer
	 * som ikke finnes i mengden fra før, skal legges til.
	 * 
	 * @param annenMengde
	 */
	void leggTilAlleFra(MengdeADT<T> annenMengde);
	
	/**
	 * Fjerner og returnerer et element fra mengden. Hvis elementet ikke finnes 
	 * i mengden, skal metoden returnere null.
	 * 
	 * @param element Et element som er lik det elementet som skal fjernes 
	 * @return Elementet som ble fjernet fra mengden, null hvis det ikke fantes.
	 */
	T fjern(T element);
	
	/**
	 * @return En tabell av elementene i mengden. Tabellen har størrelse lik
	 *         antall elementer i mengden.
	 */
	T[] tilTabell();
	
	/**
	 * @return Antall elementer i mengden.
	 */
	int antallElementer();
	
}
