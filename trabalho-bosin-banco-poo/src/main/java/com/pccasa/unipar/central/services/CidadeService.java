/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.Exceptions.TamanhoMaximoDoCampoExcedidoException;
import com.pccasa.unipar.central.Exceptions.ValorInvalidoException;
import com.pccasa.unipar.central.models.Cidade;
import com.pccasa.unipar.central.repositories.CidadeDAO;

import java.sql.SQLException;
import java.util.List;
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
      public List<Cidade> findAll() throws SQLException {

          CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado = cidadeDAO.findAll();

        return resultado;
    }
      public Cidade findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade retorno = cidadeDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return cidadeDAO.findById(id);
    }

    public void insert(Cidade cidade) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException, TamanhoCampoInvalidoException {
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);
    }

    public void update(Cidade cidade) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException, TamanhoCampoInvalidoException {
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
    }

    public void delete(int id) throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(id);

    }
}
