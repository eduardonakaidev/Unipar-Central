package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.models.Pessoa;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;

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
}
