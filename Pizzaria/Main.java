package Pizzaria;

import java.util.ArrayList;

/* MEMBROS DO GRUPO:
- Adnan Medeiros Bezerra
- Natália Galdino Bronzeado
- Gizele Gabriele Vidal de Sousa
- Caio Henrique Ramos Medeiros
- Adeval Neto Cordeiro de Albuquerque
- Layla Kethlen Ramos Apolinario
- Lucas Emanuel Gomes da Silva
*/

import java.util.Scanner;
import java.util.Map.Entry;

import listas.FilaPedidos;
import listas.IngredientesHashMap;
import listas.PilhaDePizzas;
import objetos.Pedido;
import objetos.Pizza;

class Main {
	public static final String TRAVESSAO = "--------------------------";
	public static final String APERTE_ENTER = "Aperte Enter para continuar";
	public static final String DIGITE_CODIGO = "Digite o código do produto.";
	public static final String NAO_ENCONTRADO = "Produto não encontrado.";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IngredientesHashMap ingredientesDisponiveis = new IngredientesHashMap();
		ingredientesDisponiveis.criarIngrediente("Pepperoni");
		ingredientesDisponiveis.criarIngrediente("Frango com bacon");
		ingredientesDisponiveis.criarIngrediente("Abacaxi");
		PilhaDePizzas pizzas = new PilhaDePizzas();
		FilaPedidos pedidos = new FilaPedidos();
		ArrayList<Pedido> pedidosServidos = new ArrayList<>();
		String comando;

		imprimeEntreTravessao("Bem-vindo à pizzaria!");
		while (true) {
			listarComandos();
			comando = sc.nextLine();

			if (comando.equals("1")) {
				// Criar nova pizza

				System.out.println("Os ingredientes disponíveis:");
				for (String pizzaIngredientes : ingredientesDisponiveis.getKeys()) {
					String ingredientesMaiusculo = pizzaIngredientes.substring(0, 1).toUpperCase() + pizzaIngredientes.substring(1);
					System.out.println(ingredientesMaiusculo);
				}

				Pizza novaPizza = new Pizza(comando, 0);

				int contador = 0;
				boolean adicionarMaisIngredientes = true;

				while (contador < 4 && adicionarMaisIngredientes) {
					System.out.println("Digite um ingrediente, dentre os disponíveis: ");
					String entradaDoUsuario = sc.nextLine();

					if (ingredientesDisponiveis.contains(entradaDoUsuario)) {
						novaPizza.adicionarIngrediente(entradaDoUsuario);
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
				imprimeEntreTravessao("Pizza criada!");

				if (!pizzas.isEmpty()) {
					System.out.println("Deseja remover o último ingrediente da pizza? Digite 'sim' ou 'nao':");
					String removerConfirmacao = sc.nextLine();

					if (removerConfirmacao.equals("sim")) {
						String ultimoIngredienteRemovido = novaPizza.removerÚltimoIngrediente();
						imprimeEntreTravessao("O último ingrediente removido foi: " + ultimoIngredienteRemovido);
					}
				}

				System.out.println("Processo terminado.");
				System.out.println(APERTE_ENTER);
				sc.nextLine();

			} else if (comando.equals("2")) {
				// Criar novo pedido
				System.out.println("Qual pizza você deseja pedir? Digite o código da sua pizza com base nas pizzas abaixo:");

				for (int i = 0; i < pizzas.size(); i++) {
					Pizza pizza = pizzas.get(i);
					System.out.println("Código da pizza: " + (i + 1) + ". Sabores: " + pizza.toString());
				}

				int pedido = Integer.parseInt(sc.nextLine());

				if (pedido >= 1 && pedido <= pizzas.size()) {
					System.out.println("Qual é o número da mesa?");
					int numeroMesa = Integer.parseInt(sc.nextLine());

					if (numeroMesa >= 1) {
						Pizza pizzaEscolhida = pizzas.get(pedido - 1);
						ArrayList<String> sabores = pizzaEscolhida.getSabores();
						ingredientesDisponiveis.usarIngredientes(sabores);
						
						Pedido novoPedido = new Pedido(pizzaEscolhida, numeroMesa);
						pedidos.adicionarPedido(novoPedido);

						imprimeEntreTravessao("Pedido adicionado.");
					} else {
						System.out.println("Número de mesa inválido.");
					}
				} else {
					System.out.println("Código de pizza inválido.");
				}

				System.out.println(APERTE_ENTER);
				sc.nextLine();

			} else if (comando.equals("3")) {
        // Servir pedido

				System.out.println("Pedidos feitos:");
				for (int i = 0; i < pedidos.getPedidos().size(); i++) {
				    Pedido pedido = pedidos.getPedidos().get(i);
				    System.out.println(pedido.toString());
				}				

	      System.out.println("Digite o numero da mesa do seu pedido:");
				int pedido = Integer.parseInt(sc.nextLine());

				Pedido pedidoVez = pedidos.primeiro();

				if (pedidoVez.getNumeroDaMesa() == pedido) {
					Pedido pedidoServido = pedidos.removerPedido();
					imprimeEntreTravessao("Pedido entregue: " + pedidoServido);
					pedidosServidos.add(pedidoServido);
					System.out.println(APERTE_ENTER);
					sc.nextLine();

				} else {
					imprimeEntreTravessao("Não é a vez de retirar seu pedido. As pizzas sao entregues por ordem de pedido. Aguarde!");
					System.out.println(APERTE_ENTER);
					sc.nextLine();
				}

			} else if (comando.equals("4")) {
        // Criar novo ingrediente

				System.out.println("Qual ingrediente você deseja adicionar?");
				String nome = sc.nextLine();

				if (ingredientesDisponiveis.contains(nome)) {
					System.out.println("Esse ingrediente já existe");
					System.out.println(APERTE_ENTER);
					sc.nextLine();
				} else {
					ingredientesDisponiveis.criarIngrediente(nome);
					imprimeEntreTravessao("Ingrediente adicionado!");
					System.out.println(APERTE_ENTER);
					sc.nextLine();
				}

			} else if (comando.equals("5")) {
				// Estatísticas dos pedidos
				System.out.println(TRAVESSAO);

				System.out.println("Quantidade de pizzas servidas: ");
				int quantidadeDePedidos = pedidosServidos.size();
				if (quantidadeDePedidos == 0) {
					System.out.println("Nenhuma pizza pedida ainda");
				} else {
					if (quantidadeDePedidos == 1) {
						System.out.println(quantidadeDePedidos + " pizza foi servida.");
					} else {
						System.out.println(quantidadeDePedidos + " pizzas foram servidas.");
					}
					
				}

				System.out.println(TRAVESSAO);

				double mediaDeIngredientes = getMediaDeIngredientes(pedidosServidos, pedidos);
				System.out.println("Média de sabores de pizza: " + mediaDeIngredientes);

				Entry<String, Integer> saborMaisPedido = ingredientesDisponiveis.getMaisUsado();
				System.out.println("Sabor de pizza mais pedido: " + saborMaisPedido.getKey() + ". Quantidade de pedidos: " + saborMaisPedido.getValue());
				
				String saboresNaoPedidos = ingredientesDisponiveis.getNaoUsados();
				System.out.println("Sabores não pedidos: " + saboresNaoPedidos.toString());

				System.out.println(TRAVESSAO);

				System.out.println(APERTE_ENTER);
				sc.nextLine();

			} else if (comando.equals("6")) {
				System.out.println("Até mais ver!");
				break;
			} else {
				imprimeEntreTravessao("Insira um comando válido!");
			}

		}
		sc.close();

	}

	public static void listarComandos() {
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

	public static double getMediaDeIngredientes(ArrayList<Pedido> pedidos, FilaPedidos pedidosAtivos) {
		double media = 1;

		for (Pedido each : pedidos) {
				media = (each.getPizza().getSabores().size() + media) / 2;
		}

		for (int i = 0; i < pedidosAtivos.getPedidos().size(); i++) {
			Pedido pedido = pedidosAtivos.getPedidos().get(i);
			media = (media + pedido.getPizza().getSabores().size()) / 2;
		}

		return media;
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
