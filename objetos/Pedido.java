package objetos;

public class Pedido implements Comparable<Pedido> {
    private Pizza pizza;
    private int numeroDaMesa;
    private static int contadorPedidos = 0;

    public Pedido(Pizza pizza, int numeroDaMesa) {
        this.pizza = pizza;
        this.numeroDaMesa = numeroDaMesa;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getNumeroDaMesa() {
        return numeroDaMesa;
    }

    public void setNumeroDaMesa(int numeroDaMesa) {
        this.numeroDaMesa = numeroDaMesa;
    }

    @Override
    public String toString() {
        return "Número da mesa: " + this.numeroDaMesa + ", Pizza: " + this.pizza.toString();
    }

    @Override
    public int compareTo(Pedido outroPedido) {
    	return this.contadorPedidos - outroPedido.contadorPedidos;
    }
}