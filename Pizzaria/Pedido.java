package Pizzaria;

import java.util.List;

public class Pedido {
    private int mesa;
    private String pizza;

    public Pedido(int mesa, String pizza2) {
        this.mesa = mesa;
        this.pizza = pizza2;
    }

    public int getNumeroMesa() {
        return mesa;
    }

    public String getIngredientesPizza() {
        return pizza;
    }
    @Override
    public String toString() {
        return "Mesa " + mesa + ": " + pizza.toString();
    }
}