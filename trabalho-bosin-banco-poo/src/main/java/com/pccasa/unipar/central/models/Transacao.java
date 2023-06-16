/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.models;

import com.pccasa.unipar.central.enuns.TipoTransacaoEnum;
import java.sql.Timestamp;

/**
 *
 * @author eduar
 */
public class Transacao extends AbstractBaseEntiny{
      private TipoTransacaoEnum tipo;
    private Timestamp dataHora;
    private double valor;
      private int conta_origem;
    private int conta_destino;

    public Transacao() {
    }

    public Transacao(TipoTransacaoEnum tipo, Timestamp dataHora, double valor, int conta_origem, int conta_destino) {
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.valor = valor;
        this.conta_origem = conta_origem;
        this.conta_destino = conta_destino;
    }

    

  

   

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public int getConta_origem() {
        return conta_origem;
    }

    public void setConta_origem(int conta_origem) {
        this.conta_origem = conta_origem;
    }

    public int getConta_destino() {
        return conta_destino;
    }

    public void setConta_destino(int conta_destino) {
        this.conta_destino = conta_destino;
    }

    @Override
    public String toString() {
        return "Transacao{" + "tipo=" + tipo + ", dataHora=" + dataHora + ", valor=" + valor + ", conta_origem=" + conta_origem + ", conta_destino=" + conta_destino + '}';
    }
    

}
