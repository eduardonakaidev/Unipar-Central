package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.models.PessoaFisica;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.repositories.PessoaFisicaDAO;

import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {
    public void validar(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        if (pessoaFisica == null) {
            throw new EntidadeNaoInformadaException("Pessoa Física");
        }

        if (pessoaFisica.getNome() == null || pessoaFisica.getNome().isBlank() || pessoaFisica.getNome().isEmpty()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (pessoaFisica.getNome().length() > 100) {
            throw new TamanhoCampoInvalidoException("Nome", 100);
        }

        if (pessoaFisica.getDocumento() == null || pessoaFisica.getDocumento().isBlank() || pessoaFisica.getDocumento().isEmpty()) {
            throw new CampoNaoInformadoException("Documento");
        }

        if (pessoaFisica.getDocumento().length() > 20) {
            throw new TamanhoCampoInvalidoException("Documento", 20);
        }

        if (pessoaFisica.getTipoPessoa() == null || pessoaFisica.getTipoPessoa().isBlank() || pessoaFisica.getTipoPessoa().isEmpty()) {
            throw new CampoNaoInformadoException("Tipo de Pessoa");
        }

        if (pessoaFisica.getDataDeNascimento() == null) {
            throw new CampoNaoInformadoException("Data de Nascimento");
        }
    }

    public void insert(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException, SQLException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException, SQLException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void delete(int id) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(id);
    }

    public PessoaFisica findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica retorno = pessoaFisicaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma pessoa física com o ID " + id + " informado.");
        }

        return retorno;
    }

    public List<PessoaFisica> findAll() throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> resultado = pessoaFisicaDAO.findAll();
        return resultado;
    }
}
