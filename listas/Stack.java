package listas;

public class Stack<E> extends LinkedList<E>{

	private Stack<E> lista = new Stack<>();
	
	
	public void push(E elemento) {
		lista.addFirst(elemento);
	}
	
	public E pop() {
		return lista.removeFirst();
	}
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	public int size() {
		return lista.size();
	}
	
	public E top() {
	return lista.first();	
	}
	
}
