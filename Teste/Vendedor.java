package Teste;

import java.time.*;


import java.time.LocalDate;

public class Vendedor extends Pessoa implements Comparable<Vendedor> {
    private String matricula;
    private double percentualComissao;
    private LocalDate dtAdmissao;

    public Vendedor(String nome, String cpf, String matricula, double percentualComissao, LocalDate dtAdmissao) {
        super(nome, cpf);
        this.matricula = matricula;
        this.percentualComissao = percentualComissao;
        this.dtAdmissao = dtAdmissao;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public LocalDate getDtAdmissao() {
        return dtAdmissao;
    }

    @Override
    public int compareTo(Vendedor outroVendedor) {
        return this.getNome().compareTo(outroVendedor.getNome());
    }

    @Override
    public String toString() {
        return "Vendedor > " + " Nome: " + super.getNome() + " CPF: " + super.getCpf() + " Matricula: " + matricula + " Percentual Comissão: " + percentualComissao + " Data Cadastro: " + dtAdmissao;
    }
}
