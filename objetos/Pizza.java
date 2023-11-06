package objetos;

import java.util.ArrayList;

public class Pizza {
  private ArrayList<Ingrediente> ingredientes;

  public Pizza() {
    this.ingredientes = new ArrayList<>();
  }

  public void adicionarIngrediente(Ingrediente ingrediente) {
    ingrediente.usarIngrediente();
    this.ingredientes.add(ingrediente);
  }

  public Ingrediente removerÚltimoIngrediente() {
    Ingrediente ingredienteRemovendo = ingredientes.get(ingredientes.size() - 1);
    ingredientes.get(ingredientes.size() - 1).cancelarUsoDoIngrediente();
    this.ingredientes.remove(ingredientes.size() - 1);

    return ingredienteRemovendo;
  }
}
