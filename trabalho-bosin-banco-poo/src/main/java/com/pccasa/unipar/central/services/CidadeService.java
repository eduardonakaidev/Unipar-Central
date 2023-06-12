/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Cidade;
/**
 *
 * @author eduar
 */
public class CidadeService {
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(cidade == null){
            throw new EntidadeNaoInformadaException("Cidade");
        }
        
        if(cidade.getNome() == null || 
            cidade.getNome().isBlank() ||
            cidade.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(cidade.getNome().length() > 58){
            throw new TamanhoCampoInvalidoException("Nome",58);
        }

    }
}
