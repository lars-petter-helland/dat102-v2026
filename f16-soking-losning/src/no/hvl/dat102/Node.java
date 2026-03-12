package no.hvl.dat102;

public class Node<T> {
	
	T data;
	Node<T> neste;

	Node(T data) {
		this.data = data;
	}
}
