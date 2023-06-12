/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.models;

import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Pessoa {
      private int id;
    private String email;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    private ArrayList<Telefone> telefones = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(int id, String email) {
        this.id = id;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", email=" + email + ", enderecos=" + enderecos + ", telefones=" + telefones + '}';
    }
}
