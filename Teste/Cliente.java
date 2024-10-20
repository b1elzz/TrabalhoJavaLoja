package Teste;

import java.time.*;

import java.time.LocalDate;

public class Cliente extends Pessoa implements Comparable<Cliente> {
    private LocalDate dtCadastro;

    public Cliente(String nome, String cpf, LocalDate dtCadastro) {
        super(nome, cpf);
        this.dtCadastro = dtCadastro;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return this.getNome().compareTo(outroCliente.getNome());
    }

    @Override
    public String toString() {
        return "Cliente > " + " Nome: " + super.getNome() + " CPF: " + super.getCpf() + " Data Cadastro: " + dtCadastro;
    }
}

