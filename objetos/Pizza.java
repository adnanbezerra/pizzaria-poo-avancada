package objetos;

import java.util.ArrayList;

import listas.LinkedList;
import listas.PilhaDePizzas;


public class Pizza {
    private LinkedList<String> ingredientes;
    private String descricao;
    private int codigo;

    public Pizza(String descricao, int codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.ingredientes = new LinkedList<String>();
    }

    public void adicionarIngrediente(String ingrediente) {
        this.ingredientes.addLast(ingrediente);
    }

    public String removerÚltimoIngrediente() {
        String ingredienteRemovendo = this.ingredientes.removeLast();
        return ingredienteRemovendo;
    }

    public ArrayList<String> getSabores() {
        return this.ingredientes.getValues();
    }
    
    @Override
    public String toString() {
        String saida = "Pizza de " + ingredientes.toString();
        return saida;
    }

      public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public LinkedList<String> getIngredientes() {
        return this.ingredientes;
    }

	}