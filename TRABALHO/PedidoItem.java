package TRABALHO;

public class PedidoItem {
    private Produto produto;
    private int quantidade;

    public PedidoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Pedido Item > " + " Produto: " + getProduto() + " Quantidade: " + quantidade;
    }
}
