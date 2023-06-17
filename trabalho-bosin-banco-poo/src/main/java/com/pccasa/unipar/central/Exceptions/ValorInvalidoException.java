/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.Exceptions;

/**
 *
 * @author eduar
 */
public class ValorInvalidoException extends Exception{
    public ValorInvalidoException(String campo) {
        super("" + campo + " é inválido de acordo com o que você está inserindo");
    }
}
