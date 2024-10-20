package Teste;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static Loja loja = new Loja();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = true;

        do {
            try {
                mostrarMenu();
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        cadastrarCliente();
                        break;
                    case 3:
                        cadastrarVendedor();
                        break;
                    case 4:
                        listarClientes();
                        break;
                    case 5:
                        listarProdutos();
                        break;
                    case 6:
                        listarVendedores();
                        break;
                    case 7:
                        listarPedidos();
                        break;
                    case 8:
                        adicionarPedido();
                        break;
                    case 9:
                        System.out.println("Total bruto de vendas: " + loja.totalBrutoDeVendas());
                        break;
                    case 10:
                        System.out.println("Total líquido de vendas: " + loja.totalLiquidoDeVendas());
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        sair = false;
                        break;
                    default:
                        System.out.println("Opção inválida");

                }

            } catch (InputMismatchException e) {
                System.out.println("Opções apenas números inteiros validos!");
                scanner.nextLine();
            }
        } while (sair);
    }

    private static void mostrarMenu(){
        
            System.out.println("========================================");
            System.out.println("|              MENU                    |");
            System.out.println("========================================");
            System.out.println("|  1. Cadastro de Produtos             |");
            System.out.println("|  2. Cadastro de Clientes             |");
            System.out.println("|  3. Cadastro de Vendedores           |");
            System.out.println("|  4. Listar Clientes                  |");
            System.out.println("|  5. Listar Produtos                  |");
            System.out.println("|  6. Listar Vendedores                |");
            System.out.println("|  7. Listar Pedidos                   |");
            System.out.println("|  8. Adicionar Pedido                 |");
            System.out.println("|  9. Total Bruto de Vendas            |");
            System.out.println("| 10. Total Líquido de Vendas          |");
            System.out.println("|  0. Sair                             |");
            System.out.println("=======================================");
            System.out.print("Escolha uma opção: ");
        
    }

    private static void cadastrarProduto() {
        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.println("Quantidade máxima: ");
        int quantidadeMaxima = scanner.nextInt();
        System.out.println("Código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = new Produto(nome, valor, quantidadeMaxima, codigo);
        loja.cadastrarProduto(produto);
    }

    private static void cadastrarCliente() {
        System.out.println("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("CPF do cliente: ");
        String cpf = scanner.nextLine();
        LocalDate dtCadastro = LocalDate.now();

        Cliente cliente = new Cliente(nome, cpf, dtCadastro);
        loja.cadastrarCliente(cliente);
    }

    private static void cadastrarVendedor() {
        System.out.println("Nome do vendedor: ");
        String nome = scanner.nextLine();
        System.out.println("CPF do vendedor: ");
        String cpf = scanner.nextLine();
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.println("Percentual de comissão (Colocar em decimal! Exemplo: 0,10 = 10%): ");
        double percentualComissao = scanner.nextDouble();
        LocalDate dtAdmissao = LocalDate.now();

        Vendedor vendedor = new Vendedor(nome, cpf, matricula, percentualComissao, dtAdmissao);
        loja.cadastrarVendedor(vendedor);
    }

    private static void listarClientes() {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : loja.listarClientes()) {
            System.out.println(cliente);
        }
    }

    private static void listarProdutos() {
        System.out.println("Produtos cadastrados:");
        for (Produto produto : loja.listarProdutos()) {
            System.out.println(produto);
        }
    }

    private static void listarVendedores() {
        System.out.println("Vendedores cadastrados:");
        for (Vendedor vendedor : loja.listarVendedores()) {
            System.out.println(vendedor);
        }
    }

    private static void listarPedidos() {
        System.out.println("Pedidos cadastrados:");
        for (Pedido pedido : loja.listarPedidos()) {
            System.out.println(pedido);
        }
    }

    private static void adicionarPedido() {
        try {
            System.out.println("CPF do cliente: ");
            String cpfCliente = scanner.nextLine();
            Cliente cliente = loja.buscarCliente(cpfCliente);

            System.out.println("CPF do vendedor: ");
            String cpfVendedor = scanner.nextLine();
            Vendedor vendedor = loja.buscarVendedor(cpfVendedor);

            Pedido pedido = new Pedido(cliente, vendedor);

            boolean adicionarMaisItens;
            do {
                System.out.println("Código do produto: ");
                int codigoProduto = scanner.nextInt();
                Produto produto = loja.buscarProduto(codigoProduto);

                System.out.println("Quantidade: ");
                int quantidade = scanner.nextInt();

                pedido.adicionarItem(produto, quantidade);

                System.out.println("Adicionar mais itens? (true/false)");
                adicionarMaisItens = scanner.nextBoolean();

            } while (adicionarMaisItens);

            loja.cadastrarPedido(pedido);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
