package no.hvl.dat102.iteratorer;

import java.util.Iterator;
import java.util.Set;

public class IteratorerMain {
	
	public static void main(String[] args) {
		
		Set<String> spraakMengde = Set.of("Java", "C++", "C#", "JavaScript");

		Iterator<String> spraakIterator = spraakMengde.iterator();
		
		while (spraakIterator.hasNext()) {
			System.out.println(spraakIterator.next());
		}
	}

}
