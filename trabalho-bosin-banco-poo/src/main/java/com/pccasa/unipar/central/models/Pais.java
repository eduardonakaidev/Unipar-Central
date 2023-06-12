/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.models;

/**
 *
 * @author eduar
 */
public class Pais extends AbstractBaseEntiny {
     private String nome;
    private String sigla;

    public Pais() {
        
    }

    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + super.getId() + "ra=" + super.getRegistroAcademico() + "nome=" + nome + ", sigla=" + sigla + '}';
    }
}
