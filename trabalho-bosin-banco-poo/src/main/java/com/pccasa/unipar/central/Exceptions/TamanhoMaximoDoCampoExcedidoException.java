/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.pccasa.unipar.central.Exceptions;

/**
 *
 * @author eduar
 */
public class TamanhoMaximoDoCampoExcedidoException extends Exception {
 public TamanhoMaximoDoCampoExcedidoException(String campo, int tamanho) {
        super("" + campo + " foi informado com tamanho superior a (" + tamanho + " caracteres)");
    }
   
}
