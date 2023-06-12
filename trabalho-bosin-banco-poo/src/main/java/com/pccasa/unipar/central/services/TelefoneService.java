package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Telefone;
import com.pccasa.unipar.central.repositories.TelefoneDAO;

import java.sql.SQLException;
import java.util.List;

public class TelefoneService {
    public void validar(Telefone telefone) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        if (telefone == null) {
            throw new EntidadeNaoInformadaException("Telefone");
        }

        if (telefone.getNumero() == null || telefone.getNumero().isBlank() || telefone.getNumero().isEmpty()) {
            throw new CampoNaoInformadoException("Número de telefone");
        }

        if (telefone.getNumero().length() > 20) {
            throw new TamanhoCampoInvalidoException("Número de telefone", 20);
        }
    }

    public void insert(Telefone telefone) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException, SQLException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
    }

    public void update(Telefone telefone) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException, SQLException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }

    public void delete(int id) throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);
    }

    public Telefone findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        Telefone retorno = telefoneDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um telefone com o ID " + id + " informado.");
        }

        return retorno;
    }

    public List<Telefone> findAll() throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> resultado = telefoneDAO.findAll();
        return resultado;
    }
}