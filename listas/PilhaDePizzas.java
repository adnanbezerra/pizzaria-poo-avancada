package listas;
import listas.LinkedList;

import objetos.Pizza;


public class PilhaDePizzas {
    private listas.LinkedList<Pizza> pizzas;

    public PilhaDePizzas() {
        pizzas = new LinkedList<>();
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.addFirst(pizza);
    }

    public Pizza removerPizza() {
        if (!pizzas.isEmpty()) {
            return pizzas.removeFirst();
        } else {
            return null;
        }
    }

 

	public void add(Pizza novaPizza) {
		pizzas.addLast(novaPizza);
		
	}

	public boolean isEmpty() {
		return pizzas.isEmpty();
	}

	public int size() {
		return pizzas.size();
	}

	public Pizza get(int index) {
        if (index < 0 || index >= pizzas.size()) {
            return null; 
        }

        Node<Pizza> currentNode = pizzas.getCabeca();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getProximo();
        }

        return currentNode.getValor();
    }
}