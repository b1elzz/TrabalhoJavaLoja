package TRABALHO;

import java.util.List;
import java.util.ArrayList;


public class Pedido {
    private List<PedidoItem> itens;
    private Cliente cliente;
    private Vendedor vendedor;
    private double total;

    public Pedido(Cliente cliente, Vendedor vendedor) {
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = 0;
    }

    public void adicionarItem(Produto produto, int quantidade) throws Exception {
        for (PedidoItem item : itens) {
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                throw new ItemDuplicadoException("Item já adicionado ao pedido.");
            }
        }
    
        if (quantidade > produto.getQuantidadeMaxima()) {
            throw new QuantidadeNaoPermitidaException("Quantidade não permitida para o produto " + produto.getNome());
        }
    
        PedidoItem novoItem = new PedidoItem(produto, quantidade);
        itens.add(novoItem);
        total = total + produto.getValor() * quantidade;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Pedido> " + " Cliente: " + cliente.getNome() + " Vendedor: " + vendedor.getNome() + " Total: " + total;
    }
}
