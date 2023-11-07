import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import objetos.Ingrediente;
import objetos.Pedido;
import objetos.Pizza;

class Main {
	public static final String TRAVESSAO = "--------------------------";
	public static final String APERTE_ENTER = "Aperte Enter para continuar";
	public static final String DIGITE_CODIGO = "Digite o código do produto.";
	public static final String NAO_ENCONTRADO = "Produto não encontrado.";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Ingrediente> ingredientesDisponiveis = new ArrayList<>();
		ingredientesDisponiveis.add(new Ingrediente("Pepperoni"));
		ingredientesDisponiveis.add(new Ingrediente("Frango com catupiry"));
		ingredientesDisponiveis.add(new Ingrediente("Abacaxi"));
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		Queue<Pedido> pedidos = new PriorityQueue<>();
		String comando;

		System.out.println("Bem-vindo à Pizzaria!");
		while (true) {
			listarComandos();
			comando = sc.nextLine();

			if (comando.equals("1")) {
				// TODO - Falta implementar a nossa Fila personalizada

				System.out.println("Os ingredientes disponíveis:");
				for (Ingrediente pizzaIngredientes : ingredientesDisponiveis) {
					System.out.println(pizzaIngredientes.getNome());
				}

				Pizza novaPizza = new Pizza(comando, 0);

				int contador = 0;
				boolean adicionarMaisIngredientes = true;

				while (contador < 4 && adicionarMaisIngredientes) {
					System.out.println("Digite um ingrediente, dentre os disponíveis: ");
					String entradaDoUsuario = sc.nextLine();

					Ingrediente ingrediente = new Ingrediente(entradaDoUsuario);

					if (ingredientesDisponiveis.contains(ingrediente)) {
						novaPizza.adicionarIngrediente(ingrediente);
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

				pizzas.add(novaPizza);
				System.out.println("Pizza criada!");

				if (!pizzas.isEmpty()) {
					System.out.println("Deseja remover o último ingrediente da pizza? Digite 'sim' ou 'nao':");
					String removerConfirmacao = sc.nextLine();

					if (removerConfirmacao.equals("sim")) {
						Ingrediente ultimoIngredienteRemovido = novaPizza.removerÚltimoIngrediente();
						System.out.println("O último ingrediente removido foi: " + ultimoIngredienteRemovido.getNome());
					}
				}

			} else if (comando.equals("2")) {
				// TODO - Falta criar nossa fila pedidos personalizada

				System.out.println("Qual pizza você deseja pedir? Digite o código da sua pizza com base nas pizzas abaixo:");

				for (int i = 0; i < pizzas.size(); i++) {
					Pizza pizza = pizzas.get(i);
					System.out.println("Pizza " + (i + 1) + ": " + pizza.toString());
				}

				int pedido = Integer.parseInt(sc.nextLine());

				if (pedido >= 1 && pedido <= pizzas.size()) {
					System.out.println("Qual é o número da mesa?");
					int numeroMesa = Integer.parseInt(sc.nextLine());

					if (numeroMesa >= 1) {
						Pizza pizzaEscolhida = pizzas.get(pedido - 1);
						Pedido novoPedido = new Pedido(pizzaEscolhida, numeroMesa);
						pedidos.add(novoPedido);

						System.out.println("Pedido adicionado.");
					} else {
						System.out.println("Número de mesa inválido.");
					}
				} else {
					System.out.println("Código de pizza inválido.");
				}

			} else if (comando.equals("3")) {
        // Servir pedido

				System.out.println("Pedidos feitos:");
				for (Pedido pizza : pedidos) {
					System.out.println(pizza.toString());
				}

				System.out.println("Digite o numero da mesa do seu pedido:");
				int pedido = Integer.parseInt(sc.nextLine());

				Pedido pedidoVez = pedidos.peek();

				if (pedidoVez.getNumeroDaMesa() == pedido) {
					Pedido pedidoServido = pedidos.poll();
					System.out.println("Pedido entregue: " + pedidoServido);

				} else {
					System.out.println(
							"Não é a vez de retirar seu pedido. As pizzas sao entregues por ordem de pedido.Aguarde!");
				}

			} else if (comando.equals("4")) {
        // Criar novo ingrediente

				System.out.println("Qual ingrediente você deseja adicionar?");
				String nome = sc.nextLine();

				if (ingredientesDisponiveis.contains(new Ingrediente(nome))) {
					System.out.println("Esse ingrediente já existe");
				} else {
					ingredientesDisponiveis.add(new Ingrediente(nome));
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

	public static int lerNumeroNaoNegativo(Scanner sc) {
		int numero;
		do {
			numero = Integer.parseInt(sc.nextLine());
			if (numero < 0) {
				System.out.println("O número não pode ser negativo. Digite novamente:");
			}
		} while (numero < 0);
		return numero;
	}
}