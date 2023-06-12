package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.models.PessoaJuridica;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.repositories.PessoaJuridicaDAO;

import java.sql.SQLException;
import java.util.List;

public class PessoaJuridicaService {
    private final PessoaJuridicaDAO pessoaJuridicaDAO;

    public PessoaJuridicaService() {
        this.pessoaJuridicaDAO = new PessoaJuridicaDAO();
    }

    public void validar(PessoaJuridica pessoaJuridica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        if (pessoaJuridica == null) {
            throw new EntidadeNaoInformadaException("Pessoa Jurídica");
        }

        if (pessoaJuridica.getCnpj() == null || pessoaJuridica.getCnpj().isBlank() || pessoaJuridica.getCnpj().isEmpty()) {
            throw new CampoNaoInformadoException("CNPJ");
        }

        if (pessoaJuridica.getRazaoSocial() == null || pessoaJuridica.getRazaoSocial().isBlank() || pessoaJuridica.getRazaoSocial().isEmpty()) {
            throw new CampoNaoInformadoException("Razão Social");
        }

        if (pessoaJuridica.getRazaoSocial().length() > 100) {
            throw new TamanhoCampoInvalidoException("Razão Social", 100);
        }

        if (pessoaJuridica.getCnaePrincipal() == null || pessoaJuridica.getCnaePrincipal().isBlank() || pessoaJuridica.getCnaePrincipal().isEmpty()) {
            throw new CampoNaoInformadoException("CNAE Principal");
        }

        if (pessoaJuridica.getCnaePrincipal().length() > 50) {
            throw new TamanhoCampoInvalidoException("CNAE Principal", 50);
        }

        if (pessoaJuridica.getFantasia() == null || pessoaJuridica.getFantasia().isBlank() || pessoaJuridica.getFantasia().isEmpty()) {
            throw new CampoNaoInformadoException("Fantasia");
        }

        if (pessoaJuridica.getFantasia().length() > 100) {
            throw new TamanhoCampoInvalidoException("Fantasia", 100);
        }
    }

    public List<PessoaJuridica> findAll() throws SQLException {
        return pessoaJuridicaDAO.findAll();
    }

    public PessoaJuridica findByCnpj(String cnpj) throws SQLException, TamanhoCampoInvalidoException, Exception {
        PessoaJuridica retorno = (PessoaJuridica) pessoaJuridicaDAO.findAll();

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma pessoa jurídica com o CNPJ " + cnpj + " informado.");
        }

        return retorno;
    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(pessoaJuridica);

        pessoaJuridicaDAO.insert(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        validar(pessoaJuridica);

        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void deleteByCnpj(String cnpj) throws SQLException {
        pessoaJuridicaDAO.delete(cnpj);
    }
}
