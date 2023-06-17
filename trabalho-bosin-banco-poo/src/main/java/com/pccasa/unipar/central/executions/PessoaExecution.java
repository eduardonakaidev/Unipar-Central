/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.services.PessoaService;
import java.util.Scanner;
import com.pccasa.unipar.central.models.Pessoa;
import java.util.List;
/**
 *
 * @author eduar
 */
public class PessoaExecution {
      public String Insert() {
        try {
            Pessoa pessoa = new Pessoa();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de pessoa: ");
            pessoa.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o email da pessoa: ");
            pessoa.setEmail(scanner.nextLine());
            
            PessoaService pessoaService = new PessoaService();
            pessoaService.insert(pessoa);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindAll() {
        try {
            PessoaService pessoaService = new PessoaService();
            List<Pessoa> procurarPorPessoa = pessoaService.findAll();
            Pessoa pessoa = new Pessoa();
           
            String msg = "Todos os itens encontrados " + procurarPorPessoa.toString();
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindById() {
        try {
            PessoaService pessoaService = new PessoaService();
            Pessoa pessoa = new Pessoa();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de pessoa para realizar a busca: ");
            int id = scanner.nextInt();
            pessoa.setId(id);
           
            String msg = "Item encontrado: " + pessoaService.findById(pessoa.getId());
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

            PessoaService pessoaService = new PessoaService();
            Pessoa pessoa = new Pessoa();

            System.out.println("Informe o ID de pessoa: ");
            pessoa.setId(scanner.nextInt());
            pessoaService.delete(pessoa.getId());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() {
        try {
            Pessoa pessoa = new Pessoa();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de pessoa: ");
            pessoa.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o email da pessoa: ");
            pessoa.setEmail(scanner.nextLine());
            
            PessoaService pessoaService = new PessoaService();
            pessoaService.update(pessoa);
            String msg = "Update realizado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }
}
