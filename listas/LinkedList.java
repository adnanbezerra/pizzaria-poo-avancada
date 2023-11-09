package listas;

import objetos.Pedido;

public class LinkedList<Ingrediente> {
    private Node<Ingrediente> cabeca;
    private Node<Ingrediente> cauda;
    private int quantidade = 0;

    public void addFirst(Ingrediente valor) {
        Node<Ingrediente> novoNode = new Node<Ingrediente>(valor);
        novoNode.proximo = cabeca;
        cabeca = novoNode;

        if (size() == 0) {
            cauda = novoNode;
        }

        quantidade++;
    }

    public void addLast(Ingrediente valor) {
        Node<Ingrediente> novoNode = new Node<Ingrediente>(valor);
        if (isEmpty()) {
            addFirst(valor);
            return;
        }

        cauda.proximo = novoNode;
        quantidade++;
        cauda = novoNode;
    }

    public Ingrediente removeFirst() {
        Node<Ingrediente> temp = cabeca;
        cabeca = temp.proximo;
        quantidade--;

        return temp.valor;
    }

    public Ingrediente removeLast() {
        if (cabeca == null) {
            return null;
        }

        if (cabeca.proximo == null) {
            return null;
        }

        Node<Ingrediente> second_last = cabeca;
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

    public Ingrediente first() {
        return cabeca.valor;
    }

    public Ingrediente getLast() {
        return cauda.valor;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (cabeca == null) {
            return "Sem ingredientes";
        }

        if (cabeca.proximo == null) {
            builder.append(cabeca.valor);
        }

        Node<Ingrediente> temp = cabeca;
        while (temp.proximo != null) {
            if (temp.proximo == null) {
                builder.append(((objetos.Ingrediente) temp.valor).getNome());
            } else {
                builder.append(", " + ((objetos.Ingrediente) temp.valor).getNome());
            }
        }

        return builder.toString();
    }
    public Node<Ingrediente> getCabeca() {
        return cabeca;
    }

		public Ingrediente get(int index) {
        if (index < 0 || index >= size()) {
            return null; 
        }

        Node<Ingrediente> currentNode = cabeca;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.proximo;
        }

        return currentNode.valor;
    }

}

class Node<Ingrediente> {
    public Ingrediente valor;
    public Node<Ingrediente> proximo = null;

    public Node(Ingrediente valor) {
        this.valor = valor;
    }

    public Node<Ingrediente> getProximo() {
        return proximo;
    }

    public void setProximo(Node<Ingrediente> proximo) {
        this.proximo = proximo;
    }

    public Ingrediente getValor() {
        return valor;
    }
}