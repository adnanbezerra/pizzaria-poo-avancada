package pizzaria;

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

  @Override
  public String toString() {
    StringBuilder saida = new StringBuilder();

    for (int i = 0; i < ingredientes.size(); i++) {
      if (i == 0) {
        saida.append("Pizza de " + ingredientes.get(i));
      } else {
        saida.append(", " + ingredientes.get(i));
      }
    }

    return saida.toString();
  }
}
