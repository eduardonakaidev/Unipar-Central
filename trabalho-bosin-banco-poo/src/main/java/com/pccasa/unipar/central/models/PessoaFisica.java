/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.models;

import java.sql.Date;

/**
 *
 * @author eduar
 */
public class PessoaFisica extends Pessoa{
    private String nome;
    private String documento;
    private String Cpf ;
    private String tipoPessoa;
    private Date dataDeNascimento;
    private String Rg;
    private Pessoa pessoa ;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
  
     
    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String documento, String Cpf, String tipoPessoa, Date dataDeNascimento) {
        this.nome = nome;
        this.documento = documento;
        this.Cpf = Cpf;
        this.tipoPessoa = tipoPessoa;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "nome=" + nome + ", documento=" + documento + ", tipoPessoa=" + tipoPessoa + ", dataDeNascimento=" + dataDeNascimento + '}';
    }
    
}
