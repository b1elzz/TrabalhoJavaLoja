package TRABALHO;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loja {
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) throws RegistroDuplicadoException {
        for (Cliente cliente2 : clientes) {
            if(cliente2.getCpf().equals(cliente.getCpf())){
                throw new RegistroDuplicadoException("O CPF: " + cliente.getCpf() + " Já esta cadastrado em nosso sistema de clientes!");
            }
        }
        clientes.add(cliente);
    }

    public void cadastrarVendedor(Vendedor vendedor) throws RegistroDuplicadoException {
        for (Vendedor vendedor2 : vendedores) {
            if(vendedor2.getCpf().equals(vendedor.getCpf())){
                throw new RegistroDuplicadoException("O CPF: " + vendedor.getCpf() + " Já esta cadastrado em nosso sistema de vendedores!");
            } else if(vendedor2.getMatricula().equals(vendedor.getMatricula())){
                throw new RegistroDuplicadoException("A matricula: " + vendedor.getMatricula() + " Já esta cadastrada em nosso sistema de vendedores!");
            }
        }
        
        vendedores.add(vendedor);
    }

    public void cadastrarProduto(Produto produto) throws RegistroDuplicadoException {
        for (Produto produto2 : produtos) {
            if(produto2.getCodigo() == produto.getCodigo()){
                throw new RegistroDuplicadoException("O código: " + produto.getCodigo() + " Já esta cadastrado em nosso sistema de produtos!");
            }
        }

        produtos.add(produto);
    }

    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientesOrdenados = new ArrayList<>(clientes);
        Collections.sort(clientesOrdenados);
        return clientesOrdenados;
    }

    public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedoresOrdenados = new ArrayList<>(vendedores);
        Collections.sort(vendedoresOrdenados);
        return vendedoresOrdenados;
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtosOrdenados = new ArrayList<>(produtos);
        Collections.sort(produtosOrdenados);
        return produtosOrdenados;
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public double totalBrutoDeVendas() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total = total + pedido.getTotal();
        }
        return total;
    }

    public double totalLiquidoDeVendas() {
        double totalLiquido = 0;
        for (Pedido pedido : pedidos) {
            double totalComDesconto = pedido.getTotal() * (1 - pedido.getVendedor().getPercentualComissao());
            totalLiquido = totalLiquido + totalComDesconto;
        }
        return totalLiquido;
    }

    public Cliente buscarCliente(String cpf) throws RegistroNaoEncontradoException {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new RegistroNaoEncontradoException("Cliente não encontrado");
    }

    public Vendedor buscarVendedor(String cpf) throws RegistroNaoEncontradoException {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        throw new RegistroNaoEncontradoException("Vendedor não encontrado");
    }

    public Produto buscarProduto(int codigo) throws RegistroNaoEncontradoException {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        throw new RegistroNaoEncontradoException("Produto não encontrado");
    }

}
