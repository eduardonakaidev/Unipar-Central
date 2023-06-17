/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

/**
 *
 * @author eduar
 */
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.enuns.TipoOperadoraEnum;
import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.models.Pessoa;
import com.pccasa.unipar.central.models.Telefone;
import com.pccasa.unipar.central.services.TelefoneService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class TelefoneExecution {
    public String Insert() {
        try {
            Telefone telefone = new Telefone();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de telefone: ");
            telefone.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o numero de telefone: ");
            telefone.setNumero(scanner.nextLine());

            System.out.println("Informe a operadora (1 - TIM, 2 - CLARO, 3 - VIVO, 4 - OI, 5 - CORREIOS, 6 - LARICELL, 7 - TESLA, 8 - IPHONE, 9 - OUTROS): ");
            String tipoContaStr = scanner.next();
            TipoOperadoraEnum tipoOp;

            switch (tipoContaStr) {
                case "1":
                    tipoOp = TipoOperadoraEnum.TIM;
                    break;
                case "2":
                    tipoOp = TipoOperadoraEnum.CLARO;
                    break;
                case "3":
                    tipoOp = TipoOperadoraEnum.VIVO;
                    break;
                case "4":
                    tipoOp = TipoOperadoraEnum.OI;
                    break;
                case "5":
                    tipoOp = TipoOperadoraEnum.CORREIOS;
                    break;
                case "6":
                    tipoOp = TipoOperadoraEnum.LARICELL;
                    break;
                case "7":
                    tipoOp = TipoOperadoraEnum.TESLA;
                    break;
                case "8":
                    tipoOp = TipoOperadoraEnum.IPHONE;
                    break;
                case "9":
                    tipoOp = TipoOperadoraEnum.OUTROS;
                    break;
                case "44":
                    tipoOp = TipoOperadoraEnum.VALOR44;
                    break;
                case "21":
                    tipoOp = TipoOperadoraEnum.VALOR21;
                    break;
                case "45":
                    tipoOp = TipoOperadoraEnum.VALOR45;
                    break;
                case "11":
                    tipoOp = TipoOperadoraEnum.VALOR11;
                    break;
                case "34":
                    tipoOp = TipoOperadoraEnum.VALOR34;
                    break;
                default:

                    tipoOp = null;
                    break;
            }
            telefone.setOperadora(tipoOp);
            scanner.nextLine();

            

            System.out.println("Informe o id de agencia atrelada a essa telefone: ");
            Agencia agencia = new Agencia();
            agencia.setId(scanner.nextInt());
            telefone.setAgencia(agencia);

            System.out.println("Informe o id de pessoa atrelada a essa telefone: ");
            Pessoa pessoa = new Pessoa();
            pessoa.setId(scanner.nextInt());
            telefone.setPessoa(pessoa);

            TelefoneService telefoneService = new TelefoneService();
            telefoneService.insert(telefone);
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
            TelefoneService telefoneService = new TelefoneService();
            List<Telefone> procurarPorTelefone = telefoneService.findAll();
            Telefone telefone = new Telefone();
            telefone.toString();
            String msg = "Todos os itens encontrados " + procurarPorTelefone.toString();
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
            TelefoneService telefoneService = new TelefoneService();
            Telefone telefone = new Telefone();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de telefone para realizar a busca: ");
            int id = scanner.nextInt();
            telefone.setId(id);
         
            String msg = "Item encontrado: " + telefoneService.findById(telefone.getId());
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

            TelefoneService telefoneService = new TelefoneService();
            Telefone telefone = new Telefone();

            System.out.println("Informe o ID de telefone: ");
            telefone.setId(scanner.nextInt());
            telefoneService.delete(telefone.getId());
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
            Telefone telefone = new Telefone();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de telefone: ");
            telefone.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o numero da telefone: ");
            telefone.setNumero(scanner.nextLine());

            System.out.println("Informe a operadora (1 - TIM, 2 - CLARO, 3 - VIVO, 4 - OI, 5 - CORREIOS, 6 - LARICELL, 7 - TESLA, 8 - IPHONE, 9 - OUTROS): ");
            String tipoContaStr = scanner.next();
            TipoOperadoraEnum tipoOp;

            switch (tipoContaStr) {
                case "1":
                    tipoOp = TipoOperadoraEnum.TIM;
                    break;
                case "2":
                    tipoOp = TipoOperadoraEnum.CLARO;
                    break;
                case "3":
                    tipoOp = TipoOperadoraEnum.VIVO;
                    break;
                case "4":
                    tipoOp = TipoOperadoraEnum.OI;
                    break;
                case "5":
                    tipoOp = TipoOperadoraEnum.CORREIOS;
                    break;
                case "6":
                    tipoOp = TipoOperadoraEnum.LARICELL;
                    break;
                case "7":
                    tipoOp = TipoOperadoraEnum.TESLA;
                    break;
                case "8":
                    tipoOp = TipoOperadoraEnum.IPHONE;
                    break;
                case "9":
                    tipoOp = TipoOperadoraEnum.OUTROS;
                    break;
                case "44":
                    tipoOp = TipoOperadoraEnum.VALOR44;
                    break;
                case "21":
                    tipoOp = TipoOperadoraEnum.VALOR21;
                    break;
                case "45":
                    tipoOp = TipoOperadoraEnum.VALOR45;
                    break;
                case "11":
                    tipoOp = TipoOperadoraEnum.VALOR11;
                    break;
                case "34":
                    tipoOp = TipoOperadoraEnum.VALOR34;
                    break;
                default:

                    tipoOp = null;
                    break;
            }
            telefone.setOperadora(tipoOp);
            scanner.nextLine();

            

            System.out.println("Informe o id de agencia atrelada a essa telefone: ");
            Agencia agencia = new Agencia();
            agencia.setId(scanner.nextInt());
            telefone.setAgencia(agencia);

            System.out.println("Informe o id de pessoa atrelada a essa telefone: ");
            Pessoa pessoa = new Pessoa();
            pessoa.setId(scanner.nextInt());
            telefone.setPessoa(pessoa);

            TelefoneService telefoneService = new TelefoneService();
            telefoneService.update(telefone);
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
