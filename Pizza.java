package objetos;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private ArrayList<Ingrediente> ingredientes;
	private String descricao;
	private int codigo;

	public Pizza(String descricao, int codigo, ArrayList<Ingrediente> ingredientes) {
		this.descricao = descricao;
		this.codigo = codigo;
		this.ingredientes = ingredientes;
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
				saida.append("Pizza de " + ingredientes.get(i).getNome());
			} else {
				saida.append(", " + ingredientes.get(i).getNome());
			}
		}

		return saida.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}
}
