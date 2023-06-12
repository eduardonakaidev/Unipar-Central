package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Transacao;
import com.pccasa.unipar.central.repositories.TransacaoDAO;

import java.sql.SQLException;
import java.util.List;

public class TransacaoService {
    public void validar(Transacao transacao) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        if (transacao == null) {
            throw new EntidadeNaoInformadaException("Transação");
        }

        if (transacao.getTipo() == null || transacao.getTipo().isBlank() || transacao.getTipo().isEmpty()) {
            throw new CampoNaoInformadoException("Tipo");
        }

        if (transacao.getTipo().length() > 100) {
            throw new TamanhoCampoInvalidoException("Tipo", 100);
        }

        if (transacao.getDataHora() == null) {
            throw new CampoNaoInformadoException("Data e Hora");
        }

        if (transacao.getValor() <= 0) {
            throw new TamanhoCampoInvalidoException("Valor", 1);
        }
    }

    public List<Transacao> findAll() throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> resultado = transacaoDAO.findAll();

        return resultado;
    }

    public Transacao findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao retorno = transacaoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma transação com o id " + id + " informado.");
        }

        return retorno;
    }

    public void insert(Transacao transacao) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(transacao);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }

    public void update(Transacao transacao) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(transacao);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void delete(int id) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);
    }
}