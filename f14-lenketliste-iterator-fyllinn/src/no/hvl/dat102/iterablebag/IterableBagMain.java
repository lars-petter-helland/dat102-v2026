package no.hvl.dat102.iterablebag;

import java.util.Iterator;

public class IterableBagMain {
	
	public static void main(String[] args) {
		
//		IterableBagADT<String> bag = new IterableTabellBag<>();
		IterableBagADT<String> bag = new IterableLenketBag<>();
		
//		Iterator<String> iterator = bag.getIterator();
//		System.out.println(iterator.next()); //Kaster NoSuchElementException
		
		bag.add("Per");
		bag.add("Pål");
		bag.add("Espen");
		
		Iterator<String> iterator = bag.getIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
//		System.out.println(iterator.next()); //Kaster NoSuchElementException
	}

}
