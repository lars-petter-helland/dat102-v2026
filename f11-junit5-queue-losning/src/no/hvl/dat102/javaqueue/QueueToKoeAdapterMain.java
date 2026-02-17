package no.hvl.dat102.javaqueue;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.koeadt.KoeADT;

public class QueueToKoeAdapterMain {
	
	@Test
	public void t() {
		assertEquals(1,2);
	}

	public static void main(String[] args) {
		
		Queue<String> koe1 = new ArrayDeque<>();	// Sirkulær_tabell-implementasjon
		Queue<String> koe2 = new LinkedList<>();	// Dobbeltlenket_liste-implementasjon
		Queue<String> koe3 = new PriorityQueue<>();	// Haug-implementasjon
		
		Queue<String> koe = koe2;

		koe.add("Per");		//Per stiller seg i køen
		koe.add("Pål");		//Pål stiller seg i køen
		koe.add("Espen");		//Espen stiller seg i køen
		
		System.out.println("Førstemann i køen er " + koe.element()); 
		
		System.out.println("Ekspederer " + koe.remove()); 
		System.out.println("Ekspederer " + koe.remove()); 
		System.out.println("Ekspederer " + koe.remove()); 
		
		System.out.println(koe.isEmpty() ? "Køen er tom" : "Det er fremdeles folk i køen");
		
		koe.clear(); //Tømmer køen om den ikke hadde vært tom allerede
		
		/*
		 * Siden Queue<E> er en utvidelse av Collection<E>, får vi med mange metoder
		 * som ikke natrulig tilhører en kø-ADT. Dette kalles interface-pollution. 
		 * De metodene man kanskje bør bruke er:
		 * - add(e) for å legge inn et element bakerst i køen = enqueue(e)
		 * - remove() for å fjerne et element fremst i køen = dequeue()
		 * - element() for å få en referanse til fremste element i køen = getFront()
		 * 
		 * I tillegg er jo disse greie:
		 * - isEmpty() sjekker om tom kø
		 * - clear() tømmer køen
		 * 
		 * For å unngå interface-pollution kan kanskje lage vår egen implementasjon
		 * der ArrayDeque, LinkedList eller PriorityQueue blir kjernen av løsningen.
		 */
		KoeADT<String> koe4 = new QueueToKoeAdapter<>();
	}

}
