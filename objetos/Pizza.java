package objetos;

import listas.LinkedList;

public class Pizza {
	private LinkedList<Ingrediente> ingredientes;
	private String descricao;
	private int codigo;

	public Pizza(String descricao, int codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
		this.ingredientes = new LinkedList<Ingrediente>();
	}

	public void adicionarIngrediente(Ingrediente ingrediente) {
		ingrediente.usarIngrediente();
		this.ingredientes.addLast(ingrediente);
	}

	public Ingrediente removerÚltimoIngrediente() {
		Ingrediente ingredienteRemovendo = this.ingredientes.removeLast();

		return ingredienteRemovendo;
	}

	@Override
	public String toString() {
		String saida = "Pizza com os " + ingredientes.toString();

		return saida;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}
}