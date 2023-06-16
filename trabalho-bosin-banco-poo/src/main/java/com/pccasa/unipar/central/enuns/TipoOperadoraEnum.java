/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.pccasa.unipar.central.enuns;

/**
 *
 * @author eduar
 */
public enum TipoOperadoraEnum {
     TIM(1),
    CLARO(2),
    VIVO(3),
    OI(4),
    CORREIOS(5),
    LARICELL(6),
    TESLA(7),
    IPHONE(8),
    OUTROS(9),
    VALOR44(44),
    VALOR21(21),
    VALOR45(45),
    VALOR11(11),
    VALOR34(34);
    

    private final int numero;

    private TipoOperadoraEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    public static TipoOperadoraEnum paraEnum(int codigo) {
        for (TipoOperadoraEnum tipo : TipoOperadoraEnum.values()) {
            if (tipo.getNumero()== codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido!");
    } 
}
