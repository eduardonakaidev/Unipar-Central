package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

public class EstadoService {
    private final EstadoDAO estadoDAO;

    public EstadoService() {
        this.estadoDAO = new EstadoDAO();
    }

    public void validar(Estado estado) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        if (estado == null) {
            throw new EntidadeNaoInformadaException("Estado");
        }

        if (estado.getNome() == null || estado.getNome().isBlank() || estado.getNome().isEmpty()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (estado.getSigla() == null || estado.getSigla().isBlank() || estado.getSigla().isEmpty()) {
            throw new CampoNaoInformadoException("Sigla");
        }

        if (estado.getNome().length() > 60) {
            throw new TamanhoCampoInvalidoException("Nome", 60);
        }

        if (estado.getSigla().length() != 2) {
            throw new TamanhoCampoInvalidoException("Sigla", 2);
        }
    }

    public List<Estado> findAll() throws SQLException {
        return estadoDAO.findAll();
    }

    public Estado findById(int id) throws SQLException, EntidadeNaoInformadaException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        Estado estado = estadoDAO.findById(id);

        if (estado == null) {
            throw new Exception("Não foi possível encontrar um estado com o ID: " + id + " informado.");
        }

        return estado;
    }

    public void insert(Estado estado) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(estado);
        estadoDAO.insert(estado);
    }

    public void update(Estado estado) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(estado);
        estadoDAO.update(estado);
    }

    public void delete(int id) throws SQLException {
        estadoDAO.delete(id);
    }
}
