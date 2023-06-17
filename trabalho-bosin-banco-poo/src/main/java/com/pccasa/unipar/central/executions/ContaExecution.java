/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.models.Conta;
import com.pccasa.unipar.central.models.Pessoa;
import com.pccasa.unipar.central.services.ContaService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class ContaExecution {
      public String Insert() {
        try {
            Conta conta = new Conta();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de conta: ");
            conta.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o número da conta: ");
            conta.setConta(scanner.nextLine());

            System.out.println("Informe o dígito de conta: ");
            conta.setDigito(scanner.nextLine());

            System.out.println("Saldo da conta (padrão inicia-se em zero)!");
            conta.setSaldo(0);

            

           

            

            System.out.println("Informe o id da agencia atrelada a essa conta: ");
            Agencia agencia = new Agencia();
            agencia.setId(scanner.nextInt());
            conta.setAgencia(agencia);

            System.out.println("Informe o id de pessoa atrelada a essa conta: ");
            Pessoa pessoa = new Pessoa();
            pessoa.setId(scanner.nextInt());
            conta.setPessoa(pessoa);
            ContaService contaService = new ContaService();
            contaService.insert(conta);
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
            ContaService contaService = new ContaService();
            List<Conta> procurarPorConta = contaService.findAll();
            Conta conta = new Conta();
            conta.toString();
            String msg = "Todos os itens encontrados " + procurarPorConta.toString();
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
            ContaService contaService = new ContaService();
            Conta conta = new Conta();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID da conta para realizar a busca: ");
            int id = scanner.nextInt();
            conta.setId(id);
            
            conta.toString();
            String msg = "Item encontrado: " + contaService.findById(conta.getId());
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

            ContaService contaService = new ContaService();
            Conta conta = new Conta();

            System.out.println("Informe o ID de conta: ");
            conta.setId(scanner.nextInt());
            contaService.delete(conta.getId());
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
            Conta conta = new Conta();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de conta: ");
            conta.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o número da conta: ");
            conta.setConta(scanner.nextLine());

            System.out.println("Informe o dígito de conta: ");
            conta.setDigito(scanner.nextLine());

            System.out.println("Informe o saldo da conta(Cuidado com o valor que irá adicionar a conta): ");
            conta.setSaldo(scanner.nextDouble());

           

        
    
            System.out.println("Informe o id da agencia atrelada a essa conta: ");
            Agencia agencia = new Agencia();
            agencia.setId(scanner.nextInt());
            conta.setAgencia(agencia);

            System.out.println("Informe o id de pessoa atrelada a essa conta: ");
            Pessoa pessoaPOJO = new Pessoa();
            pessoaPOJO.setId(scanner.nextInt());
            conta.setPessoa(pessoaPOJO);
            ContaService contaService = new ContaService();
            contaService.update(conta);
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
