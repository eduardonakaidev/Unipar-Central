/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.pccasa.unipar.central.Exceptions;

/**
 *
 * @author eduar
 */
public class SaldoZerado extends Exception{
     public SaldoZerado(String campo) {
        super(""+campo+" tem que ser iniciado em 0");
    }
  
}
