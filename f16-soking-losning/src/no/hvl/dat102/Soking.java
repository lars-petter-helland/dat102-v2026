package no.hvl.dat102;

/*
 * En samling av ulike søkemetoder for søk i tabell og nodelenke
 */
public class Soking<T> {

	/*
	 * Søk i usortert tabell - Sekvensielt søk
	 */
//	public static <T> boolean sokUsortertTabell(T[] tabell, T element) {
//		boolean funnet = false;
//		int i = 0;
//		while (!funnet && i < tabell.length) {
//			if (element.equals(tabell[i])) {
//				funnet = true;
//			}
//			i++;
//		}
//		return funnet;
//	}
	public static <T> boolean sokUsortertTabell(T[] tabell, T element) {
		for (T e : tabell) {
			if (element.equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	/* 
	 * Søk i usortert lenke/kjede - Sekvensielt søk
	 */
//	public static <T> boolean sokUsortertLenke(Node<T> start, T element) {
//		Node<T> p = start;
//		while (p != null) {
//			if (element.equals(p.data)) {
//				return true;
//			}
//			p = p.neste;
//		}
//		return false;
//	}
	public static <T> boolean sokUsortertLenke(Node<T> start, T element) {
		for (Node<T> p = start; p != null; p = p.neste) {
			if (element.equals(p.data)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Søk i sortert tabell - Sekvensielt søk
	 */
//	public static <T extends Comparable<T>> boolean sekvensieltSokSortertTabell(
//			T[] tabell, T element) {
//
//		int i = 0;
//		while (i < tabell.length && element.compareTo(tabell[i]) > 0) {
//			i++;
//		}
//
//		if (i == tabell.length) {
//			return false;
//		} else {
//			return element.equals(tabell[i]);
//		}
//	}
    public static <T extends Comparable<T>> boolean sekvensieltSokSortertTabell(
            T[] tabell, T element) {

        for (T e : tabell) {
            if (element.compareTo(e) <= 0) {
                return element.equals(e);
            }
        }
        return false;
    }

	/*
	 * Søk i sortert lenke/kjede - Sekvensielt søk
	 */
	public static <T extends Comparable<T>> boolean sekvensieltSokSortertLenke(
			Node<T> start, T element) {
		
		Node<T> p = start;
		while (p != null && element.compareTo(p.data) > 0) {
			p = p.neste;
		}

		if (p == null) {
			return false;
		} else {
			return element.equals(p.data);
		}
	}

	/* ---------------------------------------------------------------- */
	
	/* 
	 * Binært søk i sortert tabell - Rekursiv
	 * Vist i boken.
	 */
	public static <T extends Comparable<T>> boolean binaertSokRekursiv(
			T[] tabell, T element) {
		return binaertSokRekursiv(tabell, element, 0, tabell.length - 1);
	}

//	private static <T extends Comparable<T>> boolean binaertSokRekursiv(
//			T[] tabell, T element, int venstre, int hoyre) {
//
//		if (venstre > hoyre) { // basistilfelle, tom tabelldel
//			return false;
//		}
//
//		int midtpunkt = (venstre + hoyre) / 2;
//		int resultat = element.compareTo(tabell[midtpunkt]);
//
//		if (resultat == 0) { // basistilfelle, funne elementet
//			return true;
//
//		} else if (resultat < 0) {  // søker i venstre del
//			return binaertSokRekursiv(tabell, element, venstre, midtpunkt - 1);
//
//		} else { // søker i høgre del
//			return binaertSokRekursiv(tabell, element, midtpunkt + 1, hoyre);
//		}
//	}
	private static <T extends Comparable<T>> boolean binaertSokRekursiv(
			T[] tabell, T element, int venstre, int hoyre) {

		if (venstre > hoyre) { // basistilfelle, tom tabelldel
			return false;
		}

		int midten = (venstre + hoyre) / 2;
		int sammenligning = element.compareTo(tabell[midten]);

		if (sammenligning == 0) { // basistilfelle, funnet elementet
			return true;
		}

        // Skrevet om den siste delen slik at det kun blir ett rekursivt kall
        // helt sist, såkalt halerekursjon (tail recursion).
        if (sammenligning < 0) { // søke i venstre del
            hoyre = midten - 1;
		} else { // søke i høyre del
            venstre = midten + 1;
		}
        return binaertSokRekursiv(tabell, element, venstre, hoyre);
	}

	/* ---------------------------------------------------------------- */
	
	/* 
	 * Binært søk i sortert tabell - Iterativ
	 * Ikke vist i boken, men gitt som Exercise 6.
	 */
	public static <T extends Comparable<T>> boolean binaertSokIterativ(
			T[] tabell, T element) {
		return binaertSokIterativ(tabell, element, 0, tabell.length - 1);
	}
	
	private static <T extends Comparable<T>> boolean binaertSokIterativ(
			T[] tabell, T element, int venstre, int hoyre) {
		
		while (venstre <= hoyre) {
			
			int midten = (venstre + hoyre)/2;
			int sammenligning = element.compareTo(tabell[midten]);
			
			if (sammenligning == 0) {
                return true;
            }

			if (sammenligning < 0) {
				hoyre = midten - 1;
			} else {
				venstre = midten + 1;
			}
		}
		return false;
	}
	
	/* ---------------------------------------------------------------- */
	
}
