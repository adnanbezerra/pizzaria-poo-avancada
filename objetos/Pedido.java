package objetos;

public class Pedido {
	  private Pizza pizza;
	  private int numeroDaMesa;

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
	}
