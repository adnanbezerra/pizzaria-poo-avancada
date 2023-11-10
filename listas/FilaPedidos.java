package listas;

import objetos.Pedido;
import objetos.Pizza;

public class FilaPedidos {
    private listas.LinkedList<Pedido> pedidos;

    public FilaPedidos() {
        pedidos = new LinkedList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.addLast(pedido);
    }

    public Pedido removerPedido() {
        if (!pedidos.isEmpty()) {
            return pedidos.removeFirst();
        } else {
            return null;
        }
    }

    public boolean estaVazia() {
        return pedidos.isEmpty();
    }

    public Pedido primeiro() {
        return pedidos.first();
    }
    public listas.LinkedList<Pedido> getPedidos() {
        return pedidos;
    }
}
