package com.pccasa.unipar.central.services;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Banco;
import com.pccasa.unipar.central.repositories.BancoDAO;

import java.sql.SQLException;
import java.util.List;

public class BancoService {

    public void validar(Banco banco) throws EntidadeNaoInformadaException,
            CampoNaoInformadoException, TamanhoCampoInvalidoException {

        if (banco == null) {
            throw new EntidadeNaoInformadaException("Banco");
        }

        if (banco.getNome() == null ||
                banco.getNome().isEmpty() ||
                banco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (banco.getNome().length() > 60) {
            throw new TamanhoCampoInvalidoException("Nome", 60);
        }

        // adicione mais metodos de validações se possivel logica complexa para mim por agora
    }

    public List<Banco> findAll() throws SQLException {

        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> resultado = bancoDAO.findAll();

        return resultado;
    }

    public Banco findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {

        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);

        BancoDAO bancoDAO = new BancoDAO();

        Banco retorno = bancoDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar um banco com o id " + id + " informado.");

        return retorno;

    }

    public void insert(Banco banco) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        validar(banco);//validar todas as exceções
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);

    }

    public void update(Banco banco) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);

    }

    public void delete(int id) throws SQLException {

        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(id);

    }
}