import java.util.ArrayList;
import java.util.Scanner;

import listas.Fila;
import objetos.Ingrediente;
import objetos.Pedido;

class Main {
  public static final String TRAVESSAO = "--------------------------";
	public static final String APERTE_ENTER = "Aperte Enter para continuar";
	public static final String DIGITE_CODIGO = "Digite o código do produto.";
	public static final String NAO_ENCONTRADO = "Produto não encontrado.";

  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
    Fila<Pedido> pedidos = new Fila<Pedido>();
    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
    ingredientes.add(new Ingrediente("Pepperoni"));
    ingredientes.add(new Ingrediente("Frango com catupiry"));
    ingredientes.add(new Ingrediente("Abacaxi"));
	  String comando;

    System.out.println("Bem-vindo ao Comério!");
    while(true) {
      listarComandos();
      comando = sc.nextLine();

      if (comando.equals("1")) {
        // TODO - Criar uma pizza
      } else if (comando.equals("2")) {
        // TODO - Criar um novo pedido
      } else if (comando.equals("3")) {
        // TODO - Servir um pedido
      } else if (comando.equals("4")) {
        // TODO - Adicionar ingredientes
      } else if (comando.equals("5")) {
        // TODO - Estatísticas dos pedidos
      } else if (comando.equals("6")) { 
        System.out.println("Até mais ver!");
	      break;
      } else {
        System.out.println("Insira um comando válido!");
      }
    }

    sc.close();
  }

  public static void listarComandos() {
		System.out.println(TRAVESSAO);
	  System.out.println("Lista dos comandos: ");
	  System.out.println("1. Criar nova pizza;");
	  System.out.println("2. Criar novo pedido;");
	  System.out.println("3. Servir um pedido;");
	  System.out.println("4. Adicionar ingredientes;");
	  System.out.println("5. Estatística dos pedidos;");
	  System.out.println("6. Sair.");
		System.out.println(TRAVESSAO);
		System.out.println("Digite o código do comando: ");        
	}

  public static void imprimeEntreTravessao(String imprimir) {
	  System.out.println(TRAVESSAO);
	  System.out.println(imprimir);
		System.out.println(TRAVESSAO);
	}
}