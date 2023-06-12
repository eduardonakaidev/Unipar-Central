package com.pccasa.unipar.central.services;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Conta;
import com.pccasa.unipar.central.repositories.ContaDAO;

import java.sql.SQLException;
import java.util.List;

public class ContaService {

    public void validar(Conta conta) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException, TamanhoCampoInvalidoException {

        if (conta == null) {
            throw new EntidadeNaoInformadaException("Conta");
        }

        if (conta.getConta() == null ||
                conta.getConta().isEmpty() ||
                conta.getConta().isBlank()) {
            throw new CampoNaoInformadoException("Conta");
        }

        if (conta.getConta().length() > 20) {
            throw new TamanhoCampoInvalidoException("Conta", 20);
        }

        if (conta.getAgencia() == null ||
                conta.getAgencia().isEmpty() ||
                conta.getAgencia().isBlank()) {
            throw new CampoNaoInformadoException("Agência");
        }

        if (conta.getAgencia().length() > 10) {
            throw new TamanhoCampoInvalidoException("Agência", 10);
        }

        if (conta.getTipo() == null ||
                conta.getTipo().isEmpty() ||
                conta.getTipo().isBlank()) {
            throw new CampoNaoInformadoException("Tipo");
        }

        if (conta.getTipo().length() > 20) {
            throw new TamanhoCampoInvalidoException("Tipo", 20);
        }
    }


    public List<Conta> findAll() throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        List<Conta> resultado = contaDAO.findAll();
        return resultado;
    }

    public Conta findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        ContaDAO contaDAO = new ContaDAO();
        Conta retorno = contaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma conta com o ID " + id + " informado.");
        }

        return retorno;
    }

    public void insert(Conta conta) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
    }

    public void update(Conta conta) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }

    public void delete(int id) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);
    }
}


