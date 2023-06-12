package com.pccasa.unipar.central.teste;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.PessoaFisica;
import com.pccasa.unipar.central.services.PessoaFisicaService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaServiceTest {
    public static void main(String[] args) {
        PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();

        try {
            // Inserção de pessoa física
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setNome("João da Silva");
            pessoaFisica.setDocumento("1234567890");
            pessoaFisica.setTipoPessoa("PF");
            pessoaFisica.setDataDeNascimento(Date.valueOf("1990-01-01"));
            pessoaFisicaService.insert(pessoaFisica);
            System.out.println("Pessoa física inserida com sucesso.");

            // Atualização de pessoa física
            pessoaFisica.setNome("Maria Santos");
            pessoaFisicaService.update(pessoaFisica);
            System.out.println("Pessoa física atualizada com sucesso.");

            // Busca por ID
            int id = pessoaFisica.getId(); // Supondo que a classe PessoaFisica tenha o atributo 'id'
            PessoaFisica pessoaEncontrada = pessoaFisicaService.findById(id);
            System.out.println("Pessoa física encontrada: " + pessoaEncontrada);

            // Listagem de todas as pessoas físicas
            List<PessoaFisica> listaPessoas = pessoaFisicaService.findAll();
            System.out.println("Lista de pessoas físicas:");
            for (PessoaFisica pessoa : listaPessoas) {
                System.out.println(pessoa);
            }

            // Exclusão de pessoa física
            pessoaFisicaService.delete(id);
            System.out.println("Pessoa física excluída com sucesso.");
        } catch (EntidadeNaoInformadaException | CampoNaoInformadoException | TamanhoCampoInvalidoException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao manipular pessoa física: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
}