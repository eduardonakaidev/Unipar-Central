package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Endereco;
import com.pccasa.unipar.central.models.Cidade;
import com.pccasa.unipar.central.repositories.EnderecoDAO;

import java.sql.SQLException;
import java.util.List;

public class EnderecoService {
    public void validar(Endereco endereco) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        if (endereco == null) {
            throw new EntidadeNaoInformadaException("Endereço");
        }

        if (endereco.getLogradouro() == null || endereco.getLogradouro().isBlank() || endereco.getLogradouro().isEmpty()) {
            throw new CampoNaoInformadoException("Logradouro");
        }

        if (endereco.getLogradouro().length() > 100) {
            throw new TamanhoCampoInvalidoException("Logradouro", 100);
        }

        if (endereco.getNumero() <= 0) {
            throw new TamanhoCampoInvalidoException("Número", 1);
        }

        if (endereco.getBairro() == null || endereco.getBairro().isBlank() || endereco.getBairro().isEmpty()) {
            throw new CampoNaoInformadoException("Bairro");
        }

        if (endereco.getBairro().length() > 100) {
            throw new TamanhoCampoInvalidoException("Bairro", 100);
        }

        if (endereco.getCep() <= 0) {
            throw new TamanhoCampoInvalidoException("CEP", 1);
        }

        if (endereco.getComplemento() != null && endereco.getComplemento().length() > 100) {
            throw new TamanhoCampoInvalidoException("Complemento", 100);
        }

        if (endereco.getCidade() == null) {
            throw new CampoNaoInformadoException("Cidade");
        }
    }

    public List<Endereco> findAll() throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado = enderecoDAO.findAll();

        return resultado;
    }

    public Endereco findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco retorno = enderecoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um endereço com o id " + id + " informado.");
        }

        return retorno;
    }

    public void insert(Endereco endereco) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(endereco);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
    }

    public void update(Endereco endereco) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(endereco);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    }

    public void delete(int id) throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(id);
    }
}
