/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.models;

/**
 *
 * @author eduar
 */
public class Conta {
    private int id;
    private String conta; 
    private String agencia;
    private String tipo;
    private int digito;
    private double saldo;
    private Pessoa pessoa;
    private Transacao transacao;

    public Conta() {
    }

    public Conta(int id, String conta, String agencia, String tipo, int digito, double saldo, Pessoa pessoa, Transacao transacao) {
        this.id = id;
        this.conta = conta;
        this.agencia = agencia;
        this.tipo = tipo;
        this.digito = digito;
        this.saldo = saldo;
        this.pessoa = pessoa;
        this.transacao = transacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", conta=" + conta + ", agencia=" + agencia + ", tipo=" + tipo + ", digito=" + digito + ", saldo=" + saldo + ", pessoa=" + pessoa + ", transacao=" + transacao + '}';
    }
}
