/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;

import com.pccasa.unipar.central.enuns.TipoTransacaoEnum;
import com.pccasa.unipar.central.models.Transacao;
import com.pccasa.unipar.central.services.TransacaoService;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author eduar
 */
public class TransacaoExecution {
      public String Insert() {
        try {
            Transacao transacao = new Transacao();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de transação: ");
            transacao.setId(scanner.nextInt());
            System.out.println("Informe o valor da transação: ");
            transacao.setValor(scanner.nextDouble());

            Calendar cal = Calendar.getInstance();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH) + 1;
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minuto = cal.get(Calendar.MINUTE);
            int segundo = cal.get(Calendar.SECOND);

            Timestamp dataHora = new Timestamp(cal.getTimeInMillis());
            transacao.setDataHora(dataHora);
            scanner.nextLine();
            System.out.println("Informe o tipo da conta (1 - CRÉDITO, 2 - DÉBITO, 3 - PIX, 0 - OUTROS): ");
            String tipoTransaStr;
            tipoTransaStr = scanner.nextLine();
            TipoTransacaoEnum tipoTransacao;

            switch (tipoTransaStr) {
                case "1":
                    tipoTransacao = TipoTransacaoEnum.CREDITO;
                    break;
                case "2":
                    tipoTransacao = TipoTransacaoEnum.DEBITO;
                    break;
                case "3":
                    tipoTransacao = TipoTransacaoEnum.PIX;
                    break;
                case "0":
                    tipoTransacao = TipoTransacaoEnum.OUTROS;
                    break;
                default:

                    tipoTransacao = null;
                    break;
            }
            transacao.setTipo(tipoTransacao);

            System.out.println("Informe o ra do aluno realizando essa transação: ");
            transacao.setRegistroAcademico(scanner.nextLine());

            System.out.println("Informe a conta de origem dessa transação: ");
            transacao.setConta_origem(scanner.nextInt());

            System.out.println("Informe a conta de destino dessa transação: ");
            transacao.setConta_destino(scanner.nextInt());

            TransacaoService transacaoService = new TransacaoService();
            transacaoService.insert(transacao);
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
            TransacaoService transacaoService = new TransacaoService();
            List<Transacao> procurarPorTransacao = transacaoService.findAll();
            Transacao transacao = new Transacao();
            transacao.toString();
            String msg = "Todos os itens encontrados " + procurarPorTransacao.toString();
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
            TransacaoService transacaoService = new TransacaoService();
            Transacao transacao = new Transacao();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID da transação: ");
            int id = scanner.nextInt();
            transacao.setId(id);
           
            String msg = "Item encontrado: " + transacaoService.findById(transacao.getId());
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

            TransacaoService transacaoService = new TransacaoService();
            Transacao  transacao = new Transacao();

            System.out.println("Informe o ID de transacao: ");
            transacao.setId(scanner.nextInt());
            transacaoService.delete(transacao.getId());
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
            Transacao transacao = new Transacao();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de transacao: ");
            transacao.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o valor da transacao: ");
            transacao.setValor(scanner.nextDouble());

            Calendar cal = Calendar.getInstance();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH) + 1;
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minuto = cal.get(Calendar.MINUTE);
            int segundo = cal.get(Calendar.SECOND);

            Timestamp dataHora = new Timestamp(cal.getTimeInMillis());
            transacao.setDataHora(dataHora);
            scanner.nextLine();

            System.out.println("Informe o tipo da conta (1 - CRÉDITO, 2 - DÉBITO, 3 - PIX, 0 - OUTROS): ");
            String tipoTransaStr = scanner.next();
            TipoTransacaoEnum tipoTransacao;

            switch (tipoTransaStr) {
                case "1":
                    tipoTransacao = TipoTransacaoEnum.CREDITO;
                    break;
                case "2":
                    tipoTransacao = TipoTransacaoEnum.DEBITO;
                    break;
                case "3":
                    tipoTransacao = TipoTransacaoEnum.PIX;
                    break;
                case "0":
                    tipoTransacao = TipoTransacaoEnum.OUTROS;
                    break;
                default:

                    tipoTransacao = null;
                    break;
            }
            transacao.setTipo(tipoTransacao);
            scanner.nextLine();
            System.out.println("Informe o ra do aluno que está realizando update nessa transacao: ");
      

            System.out.println("Informe a conta de origem: ");
            transacao.setConta_origem(scanner.nextInt());

            System.out.println("Informe a conta de destino: ");
            transacao.setConta_destino(scanner.nextInt());

            TransacaoService transacaoService = new TransacaoService();
            transacaoService.update(transacao);
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
