package no.hvl.dat102.javadeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class JavaDequeMain {
	
	public static void main(String[] args) {
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.addFirst("Per");	// [Per]
		deque.addFirst("Pål");	// [Pål, Per]
		deque.addLast("Espen");	// [Pål, Per, Espen]
		System.out.println(deque);
		
		System.out.println(deque.getFirst());	// Pål
		System.out.println(deque.getLast()); 	// Espen
		
		deque.removeLast(); // Espen
		deque.removeLast(); // Per
		System.out.println(deque.getLast()); 	// Pål
		
		System.out.println(deque.isEmpty());	// false
		
		deque.clear();
		System.out.println(deque.isEmpty());	// true
		
	}

}
