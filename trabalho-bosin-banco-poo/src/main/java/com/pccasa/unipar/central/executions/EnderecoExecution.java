/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.services.EnderecoService;
import com.pccasa.unipar.central.models.Endereco;
import com.pccasa.unipar.central.models.Cidade;
import com.pccasa.unipar.central.models.Pessoa;
import java.sql.SQLException;
import java.util.List;
        import java.util.Scanner;
/**
 *
 * @author eduar
 */
public class EnderecoExecution {
     public String Insert() {
        try {
            Endereco endereco = new Endereco();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de endereco: ");
            endereco.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da rua: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.println("Informe o número da casa: ");
            endereco.setNumero(scanner.nextLine());

            System.out.println("Informe o bairro: ");
            endereco.setBairro(scanner.nextLine());

            System.out.println("Informe o cep: ");
            endereco.setCep(scanner.nextLine());
            
            System.out.println("Informe o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            
            System.out.println("Informe o id de pessoa atrelada a esse endereço: ");
            Pessoa pessoa = new Pessoa();
            pessoa.setId(scanner.nextInt());
            endereco.setPessoa(pessoa);
            
            System.out.println("Informe o id da agencia atrelada a esse endereço: ");
            Cidade cidade = new Cidade();
            cidade.setId(scanner.nextInt());
            endereco.setCidade(cidade);

            EnderecoService enderecoService = new EnderecoService();
            enderecoService.insert(endereco);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (CampoNaoInformadoException | EntidadeNaoInformadaException | TamanhoCampoInvalidoException | SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindAll() {
        try {
            EnderecoService enderecoService = new EnderecoService();
            List<Endereco> procurarPorEndereco = enderecoService.findAll();
            Endereco endereco = new Endereco();
            endereco.toString();
            String msg = "Todos os itens encontrados " + procurarPorEndereco.toString();
            System.out.println(msg);
            return msg;
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindById() {
        try {
            EnderecoService enderecoService = new EnderecoService();
            Endereco endereco = new Endereco();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de endereço para realizar a busca: ");
            int id = scanner.nextInt();
            endereco.setId(id);
            Endereco enderecoPOJO = new Endereco();
            enderecoPOJO.toString();
            String msg = "Item encontrado: " + enderecoService.findById(endereco.getId());
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String DeleteById() {
        try {
            Scanner scanner = new Scanner(System.in);

            EnderecoService enderecoService = new EnderecoService();
            Endereco endereco = new Endereco();

            System.out.println("Informe o ID de endereco: ");
            endereco.setId(scanner.nextInt());
            enderecoService.delete(endereco.getId());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() {
        try {
            Endereco endereco = new Endereco();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de endereco: ");
            endereco.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da rua: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.println("Informe o número da casa: ");
            endereco.setNumero(scanner.nextLine());

            System.out.println("Informe o bairro: ");
            endereco.setBairro(scanner.nextLine());

            System.out.println("Informe o cep: ");
            endereco.setCep(scanner.nextLine());
            
            System.out.println("Informe o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            
            
            System.out.println("Informe o id de pessoa atrelada a esse endereço: ");
            Pessoa pessoa = new Pessoa();
            pessoa.setId(scanner.nextInt());
            endereco.setPessoa(pessoa);
            
            System.out.println("Informe o id da agencia atrelada a esse endereço: ");
            Cidade cidade  = new Cidade();
            cidade.setId(scanner.nextInt());
            endereco.setCidade(cidade);
            
            EnderecoService enderecoService = new EnderecoService();
            enderecoService.update(endereco);
            String msg = "Update realizado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (CampoNaoInformadoException | EntidadeNaoInformadaException | TamanhoCampoInvalidoException | SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }
}
