package listas;

public class LinkedList<E> {
		
	private Node<E> cabeca;
	private Node<E> cauda;
	private int quantidade = 0;
		
	public void addFirst(E valor) {
		Node<E> novoNode = new Node<E>(valor);
		novoNode.proximo = cabeca;
		cabeca = novoNode;

		if (size() == 0) {
			cauda = novoNode;
		}

		quantidade++;
	}
		
	public void addLast(E valor) {
		Node<E> novoNode = new Node<E>(valor);
		if (isEmpty()) {
			addFirst(valor);
			return;
		}

		cauda.proximo = novoNode;
		quantidade++;
		cauda = novoNode;
	}
		
	public E removeFirst() {
		Node<E> temp = cabeca;
		cabeca = temp.proximo;
		quantidade--;

		return temp.valor;
	}

	public E removeLast() {
    if (cabeca == null) {
      return null; 
		}
  
    if (cabeca.proximo == null) { 
      return null; 
    } 
  
    Node<E> second_last = cabeca; 
    while (second_last.proximo.proximo != null) {
      second_last = second_last.proximo; 
		}
  
    second_last.proximo = null; 
  
    return cabeca.valor;
	}
		
	public int size() {
		return quantidade;
	}
		
	public boolean isEmpty() {
		return quantidade == 0;
	}
		
	public E first() {
		return cabeca.valor;
	}

	public E getLast() {
		return cauda.valor;
	}
		
}

class Node<E> {
	public E valor;
	public Node<E> proximo = null;
		
	public Node(E valor) {
		this.valor = valor;
	}
}
