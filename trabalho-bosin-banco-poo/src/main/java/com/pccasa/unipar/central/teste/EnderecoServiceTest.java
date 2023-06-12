package com.pccasa.unipar.central.teste;

import com.pccasa.unipar.central.models.Endereco;
import com.pccasa.unipar.central.repositories.EnderecoDAO;


import java.sql.SQLException;
import java.util.List;

public class EnderecoServiceTest {
    public static void main(String[] args) {
        EnderecoServiceTest enderecoDAOTest = new EnderecoServiceTest();
        enderecoDAOTest.testFindAll();
        enderecoDAOTest.testInsert();
    }

    public void testFindAll() {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            List<Endereco> enderecos = enderecoDAO.findAll();

            System.out.println("Lista de Endereços:");
            for (Endereco endereco : enderecos) {
                System.out.println(endereco);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar endereços: " + e.getMessage());
        }
    }

    public void testInsert() {
        try {
            Endereco endereco = new Endereco();
            endereco.setLogradouro("Rua Teste");
            endereco.setNumero(123);
            endereco.setBairro("Bairro Teste");
            endereco.setCep(12345678);
            endereco.setComplemento("Complemento Teste");

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecoDAO.insert(endereco);

            System.out.println("Endereço inserido com sucesso!");

            // Deletar o endereço inserido
            enderecoDAO.delete(endereco.getId());

            System.out.println("Endereço deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir ou deletar endereço: " + e.getMessage());
        }
    }
}
