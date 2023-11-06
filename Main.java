import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
    PriorityQueue<Pedido> pedidos = new PriorityQueue<Pedido>();
    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
    ingredientes.add(new Ingrediente("Pepperoni"));
    ingredientes.add(new Ingrediente("Frango com catupiry"));
    ingredientes.add(new Ingrediente("Abacaxi"));
	  String comando;
    Stack<Ingrediente> pizzas = new Stack<>();
    ArrayList<Pedido> pedidosServidos = new ArrayList<>();

    System.out.println("Bem-vindo à Pizzaria!");
    while(true) {
      listarComandos();
      comando = sc.nextLine();

      if (comando.equals("1")) {
        // TODO - Criar uma pizza
        // FALTA implementar a nossa Fila personalizada

        System.out.println("Os ingredientes disponíveis:");
        for (Ingrediente pizzaIngredientes : ingredientes) {
            System.out.println(pizzaIngredientes);
        }

        String novaPizza = ""; // Crie uma string para representar a nova pizza.

        int contador = 0;
        boolean adicionarMaisIngredientes = true;

        while (contador < 4 && adicionarMaisIngredientes) {
            System.out.println("Digite um ingrediente, dentre os disponíveis: ");
            String entradaDoUsuario = sc.nextLine();

            Ingrediente ingrediente = new Ingrediente(entradaDoUsuario);

            if (ingredientes.contains(ingrediente)) {
                novaPizza += ingrediente; // Adicione o ingrediente à string da pizza.
                contador++;

                System.out.println("Deseja adicionar mais algum ingrediente? Digite 'sim' ou 'nao':");
                String confirmacao = sc.nextLine();

                if (confirmacao.equals("nao")) {
                    adicionarMaisIngredientes = false;
                }
            } else {
                System.out.println("Ingrediente inválido. Tente novamente.");
            }
        }

        System.out.println("Pizza criada!");
        
        if (!pizzas.isEmpty()) {
            System.out.println("Deseja remover o último ingrediente da pilha? Digite 'sim' ou 'nao':");
            String removerConfirmacao = sc.nextLine();

            if (removerConfirmacao.equals("sim")) {
                Ingrediente ultimoIngredienteRemovido = pizzas.pop();
                System.out.println("O último ingrediente removido foi: " + ultimoIngredienteRemovido.getNome());
            }
        }
      } else if (comando.equals("2")) {
        // TODO - Criar um novo pedido

      } else if (comando.equals("3")) {
        // Servir um pedido
        System.out.println("Pedidos feitos:" );
        for (Pedido pizza : pedidos) {
            System.out.println(pizza);
        }

        System.out.println("Digite o numero da mesa do seu pedido:");
        int pedido = sc.nextInt(); 
        
        Pedido pedidoVez = pedidos.peek();

        if (pedidoVez.getNumeroDaMesa() == pedido){
            Pedido pedidoServido = pedidos.poll();
            System.out.println("Pedido entregue: " + pedidoServido);
            pedidosServidos.add(pedidoServido);
            
        } else {
            System.out.println("Não é a vez de retirar seu pedido.As pizzas sao entregues por ordem de pedido.Aguarde!");
        }
    
      } else if (comando.equals("4")) {
        // Adicionar ingredientes 
        System.out.println("Qual ingrediente você deseja adicionar?");
        String nome = sc.nextLine();

        if (ingredientes.contains(new Ingrediente(nome))) {
        System.out.println("Esse ingrediente já existe");
        } else {
          ingredientes.add(new Ingrediente(nome));
          System.out.println("Ingrediente adicionado!");
        }

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