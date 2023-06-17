package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.models.Pessoa;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import java.util.List;

public class PessoaService {
        public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
            if (pessoa == null) {
                throw new EntidadeNaoInformadaException("Pessoa");
            }

            if (pessoa.getEmail() == null || pessoa.getEmail().isBlank() || pessoa.getEmail().isEmpty()) {
                throw new CampoNaoInformadoException("Email");
            }

            if (pessoa.getEmail().length() > 100) {
                throw new TamanhoCampoInvalidoException("Email", 100);
            }

            if (pessoa.getEnderecos() == null || pessoa.getEnderecos().isEmpty()) {
                throw new CampoNaoInformadoException("Endereços");
            }

            if (pessoa.getTelefones() == null || pessoa.getTelefones().isEmpty()) {
                throw new CampoNaoInformadoException("Telefones");
            }
        }

        //Metodos para fazer consultas muito complexos para se fazer

    public void insert(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Pessoa> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void update(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
