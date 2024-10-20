package Teste;

public class Produto implements Comparable<Produto> {
    private String nome;
    private double valor;
    private int quantidadeMaxima;
    private int codigo;

    public Produto(String nome, double valor, int quantidadeMaxima, int codigo) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeMaxima = quantidadeMaxima;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Double.compare(outroProduto.getValor(), this.valor);
    }

    @Override
    public String toString() {
        return "Produto> " + " Nome: " + nome + " Valor: " + valor + " Quantidade Maxima: " + quantidadeMaxima + " Codigo: " + codigo;
    }
}
