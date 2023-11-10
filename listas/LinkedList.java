package listas;

import java.util.ArrayList;

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

    public ArrayList<E> getValues() {
        ArrayList<E> values = new ArrayList<>();

        Node<E> temp = cabeca;
        while (temp != null) {
            values.add(temp.valor);
        
            temp = temp.proximo;
        }

        return values;
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

        return cauda.valor;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (cabeca == null) {
            return "Sem ingredientes";
        }

        Node<E> temp = cabeca;
        while (temp != null) {
            if (temp.proximo == null) {
                builder.append(((String) temp.valor + " "));
            } else {
                builder.append(((String) temp.valor + ", "));
            }

            temp = temp.proximo;
        }

        return builder.toString();

    }

    public Node<E> getCabeca() {
        return cabeca;
    }

	public E get(int index) {
        if (index < 0 || index >= size()) {
            return null; 
        }

        Node<E> currentNode = cabeca;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.proximo;
        }

        return currentNode.valor;
    }

}

class Node<E> {
    public E valor;
    public Node<E> proximo = null;

    public Node(E valor) {
        this.valor = valor;
    }

    public Node<E> getProximo() {
        return proximo;
    }

    public void setProximo(Node<E> proximo) {
        this.proximo = proximo;
    }

    public E getValor() {
        return valor;
    }
}