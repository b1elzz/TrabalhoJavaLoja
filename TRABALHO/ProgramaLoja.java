package TRABALHO;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class ProgramaLoja {
    private static Loja loja = new Loja();
    private static TecladoUtil teclado = new TecladoUtil();

    public static void main(String[] args) {
        boolean sair = true;

        do {
            try {

                mostrarMenu();
                int opcao = teclado.lerInt("Digite a opção: ");
                teclado.limparBuffer();
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
                teclado.lerString(" ");
            }
        } while (sair);
    }

    private static void mostrarMenu() {

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
    }

    private static void cadastrarProduto() {
        String nome = teclado.lerString("Nome do produto: ");
        double valor = teclado.lerDouble("Valor do produto: ");
        int quantidadeMaxima = teclado.lerInt("Estoque Disponivel: ");
        int codigo = teclado.lerInt("Código do produto: ");

        Produto produto = new Produto(nome, valor, quantidadeMaxima, codigo);
        try{
            System.out.println("PRODUTO CADASTRADO COM SUCESSO!");
            loja.cadastrarProduto(produto);
        } catch(RegistroDuplicadoException e){
            System.out.println(e.getMessage());
        }
    }

    private static void cadastrarCliente() {
        String nome = teclado.lerString("Nome do cliente: ");
        String cpf = teclado.lerString("Cpf do cliente: ");
        LocalDate dtCadastro = LocalDate.now();

        Cliente cliente = new Cliente(nome, cpf, dtCadastro);

        try{
            System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
        loja.cadastrarCliente(cliente);
        } catch(RegistroDuplicadoException e){
            System.out.println(e.getMessage());
        }
    }

    private static void cadastrarVendedor() {

        String nome = teclado.lerString("Nome do vendedor: ");
        String cpf = teclado.lerString("CPF do vendedor: ");
        String matricula = teclado.lerString("Matricula do vendedor: ");
        double percentualComissao = teclado
                .lerDouble("Percentual de comissão (Colocar em decimal! Exemplo: 0,10 = 10%): ");
        LocalDate dtAdmissao = LocalDate.now();

        Vendedor vendedor = new Vendedor(nome, cpf, matricula, percentualComissao, dtAdmissao);

        try{
            System.out.println("VENDEDOR CADASTRADO COM SUCESSO!");
        loja.cadastrarVendedor(vendedor);
        } catch(RegistroDuplicadoException e){
            System.out.println(e.getMessage());
        }
    }

    private static void listarClientes() {
        System.out.println("Clientes cadastrados: ");
        for (Cliente cliente : loja.listarClientes()) {
            System.out.println(cliente);
        }
    }

    private static void listarProdutos() {
        System.out.println("Produtos cadastrados: ");
        for (Produto produto : loja.listarProdutos()) {
            System.out.println(produto);
        }
    }

    private static void listarVendedores() {
        System.out.println("Vendedores cadastrados: ");
        for (Vendedor vendedor : loja.listarVendedores()) {
            System.out.println(vendedor);
        }
    }

    private static void listarPedidos() {
        System.out.println("Pedidos cadastrados: ");
        for (Pedido pedido : loja.listarPedidos()) {
            System.out.println(pedido);
        }
    }

    private static void adicionarPedido() {
        try {

            String cpfCliente = teclado.lerString("CPF do cliente: ");
            Cliente cliente = loja.buscarCliente(cpfCliente);

            String cpfVendedor = teclado.lerString("CPF do vendedor: ");
            Vendedor vendedor = loja.buscarVendedor(cpfVendedor);

            Pedido pedido = new Pedido(cliente, vendedor);

            boolean adicionarMaisItens;
            do {

                int codigoProduto = teclado.lerInt("Código do produto: ");
                Produto produto = loja.buscarProduto(codigoProduto);

                int quantidade = teclado.lerInt("Quantidade: ");

                pedido.adicionarItem(produto, quantidade);

                teclado.limparBuffer();
                String adicionar = teclado.lerString("Adicionar mais itens? (Sim/Não)").toLowerCase();
                
                if (adicionar.equals("sim")) {
                    adicionarMaisItens = true;
                } else if (adicionar.equals("não") || adicionar.equals("nao")) {
                    adicionarMaisItens = false;
                } else {
                    System.out.println("Opção invalida! Considerado como não =D ");
                    adicionarMaisItens = false;
                }

            } while (adicionarMaisItens);
            
            System.out.println("PEDIDO REALIZADO COM SUCESSO!");
            loja.cadastrarPedido(pedido);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
