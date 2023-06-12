/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.models;

/**
 *
 * @author eduar
 */
public class PessoaJuridica extends Pessoa{
     private String cnpj;
    private String razaoSocial;
    private String cnaePrincipal;
    private String fantasia;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String razaoSocial, String cnaePrincipal, String fantasia) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", cnaePrincipal=" + cnaePrincipal + ", fantasia=" + fantasia + '}';
    }
}
