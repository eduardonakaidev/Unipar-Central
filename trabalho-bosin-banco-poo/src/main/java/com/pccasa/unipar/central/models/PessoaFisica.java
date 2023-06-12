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
    private String tipoPessoa;
    private Date dataDeNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String documento, String tipoPessoa, Date dataDeNascimento) {
        this.nome = nome;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
        this.dataDeNascimento = dataDeNascimento;
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

    @Override
    public String toString() {
        return "PessoaFisica{" + "nome=" + nome + ", documento=" + documento + ", tipoPessoa=" + tipoPessoa + ", dataDeNascimento=" + dataDeNascimento + '}';
    }
    
}
