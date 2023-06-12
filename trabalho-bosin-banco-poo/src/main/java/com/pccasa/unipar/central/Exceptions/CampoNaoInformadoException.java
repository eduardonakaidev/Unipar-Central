/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.pccasa.unipar.central.Exceptions;

/**
 *
 * @author eduar
 */
public class CampoNaoInformadoException extends Exception {

    public CampoNaoInformadoException(String campo) {
        super("O campo " + campo + " não foi informado. Verifique!");
    }
}
