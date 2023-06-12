/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.pccasa.unipar.central.Exceptions;

/**
 *
 * @author eduar
 */
public class TamanhoCampoInvalidoException extends Exception{

   
    public TamanhoCampoInvalidoException(String campo,int tamanho) {
        super("O campo " + campo + " foi informado com tamanho(" + tamanho + " caracteres) inválido. Verifique!");
    }
}
