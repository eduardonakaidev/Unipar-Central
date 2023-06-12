package com.pccasa.unipar.central.teste;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.PessoaJuridica;
import com.pccasa.unipar.central.services.PessoaJuridicaService;

import java.sql.SQLException;
import java.util.List;

public class PessoaJuridicaServiceTest {
    public static void main(String[] args) {
        PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();

        try {
            List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaService.findAll();

            if (pessoasJuridicas.isEmpty()) {
                System.out.println("Não foram encontradas pessoas jurídicas.");
            } else {
                System.out.println("Pessoas jurídicas encontradas:");
                for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                    System.out.println(pessoaJuridica);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar as pessoas jurídicas: " + e.getMessage());
        }

        // Exemplo de inserção de uma pessoa jurídica
        PessoaJuridica novaPessoaJuridica = new PessoaJuridica();
        novaPessoaJuridica.setCnpj("12345678901234");
        novaPessoaJuridica.setRazaoSocial("Empresa ABC");
        novaPessoaJuridica.setCnaePrincipal("123456");
        novaPessoaJuridica.setFantasia("Empresa ABC Fantasia");

        try {
            pessoaJuridicaService.insert(novaPessoaJuridica);
            System.out.println("Pessoa jurídica inserida com sucesso!");
        } catch (SQLException | EntidadeNaoInformadaException | CampoNaoInformadoException | TamanhoCampoInvalidoException e) {
            System.out.println("Ocorreu um erro ao inserir a pessoa jurídica: " + e.getMessage());
        }
    }
}
