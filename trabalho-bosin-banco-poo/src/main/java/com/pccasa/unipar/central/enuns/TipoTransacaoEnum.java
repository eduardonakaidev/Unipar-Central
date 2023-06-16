/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.pccasa.unipar.central.enuns;

/**
 *
 * @author eduar
 */
public enum TipoTransacaoEnum {
     DEBITO(1),
    CREDITO(2),
    PIX(3),
    OUTROS(0);

    private final int numero;

    private TipoTransacaoEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public static TipoTransacaoEnum paraEnum(int codigo) {
        for (TipoTransacaoEnum tipo : TipoTransacaoEnum.values()) {
            if (tipo.getNumero()== codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido!");
    } 
}
