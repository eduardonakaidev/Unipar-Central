package com.pccasa.unipar.central.services;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.repositories.AgenciaDAO;

import java.sql.SQLException;
import java.util.List;

public class AgenciaService {

    public void validar(Agencia agencia) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException, TamanhoCampoInvalidoException {

        if (agencia == null) {
            throw new EntidadeNaoInformadaException("Agencia");
        }

        if (agencia.getCodigo() == null ||
                agencia.getCodigo().isEmpty() ||
                agencia.getCodigo().isBlank()) {
            throw new CampoNaoInformadoException("Código");
        }

        if (agencia.getCodigo().length() > 10) {
            throw new TamanhoCampoInvalidoException("Código", 10);
        }

        if (agencia.getRazaoSocial() == null ||
                agencia.getRazaoSocial().isEmpty() ||
                agencia.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razão Social");
        }

        if (agencia.getRazaoSocial().length() > 100) {
            throw new TamanhoCampoInvalidoException("Razão Social", 100);
        }

        if (agencia.getCnpj() == null ||
                agencia.getCnpj().isEmpty() ||
                agencia.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("CNPJ");
        }

        if (agencia.getCnpj().length() > 14) {
            throw new TamanhoCampoInvalidoException("CNPJ", 14);
        }

        // Adicione aqui as demais validações necessárias de acordo com suas regras de negócio
    }

    public List<Agencia> findAll() throws SQLException {

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> resultado = agenciaDAO.findAll();

        return resultado;
    }

    public Agencia findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {

        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);

        AgenciaDAO agenciaDAO = new AgenciaDAO();

        Agencia retorno = agenciaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma agência com o id " + id + " informado.");

        return retorno;

    }

    public void insert(Agencia agencia) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        validar(agencia);//validar todas as exceções
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);

    }

    public void update(Agencia agencia) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);

    }

    public void delete(int id) throws SQLException {

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(id);

    }
}
