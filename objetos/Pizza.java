package objetos;

import listas.LinkedList;

public class Pizza {
  private LinkedList<Ingrediente> ingredientes;

  public Pizza() {
    this.ingredientes = new LinkedList<>();
  }
}
