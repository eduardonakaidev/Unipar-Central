/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.services.BancoService;
import com.pccasa.unipar.central.models.Banco;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author eduar
 */
public class BancoExeciton {
    
    public String Insert() {
        try {
            Banco banco = new Banco();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de banco: ");
            banco.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o nome da banco: ");
            banco.setNome(scanner.nextLine());
            System.out.println("Informe o ra de aluno que está cadastrando esse banco: : ");
            banco.setRegistroAcademico(scanner.nextLine());
            BancoService bancoService = new BancoService();
            bancoService.insert(banco);
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
            BancoService bancoService = new BancoService();
            List<Banco> procurarPorBanco = bancoService.findAll();
            Banco bancoPOJO = new Banco();
            bancoPOJO.toString();
            String msg = "Todos os itens encontrados " + procurarPorBanco.toString();
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
            BancoService bancoService = new BancoService();
            Banco banco = new Banco();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID do banco para realizar a busca: ");
            int id = scanner.nextInt();
            banco.setId(id);
            
            banco.toString();
            String msg = "Item encontrado: " + bancoService.findById(banco.getId());
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

            BancoService bancoService = new BancoService();
            Banco banco = new Banco();

            System.out.println("Informe o ID de banco: ");
            banco.setId(scanner.nextInt());
            bancoService.delete(banco.getId());
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
            Banco banco = new Banco();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de banco: ");
            banco.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o nome da banco: ");
            banco.setNome(scanner.nextLine());
            System.out.println("Informe o ra de aluno que está dando update nesse banco: ");
            banco.setRegistroAcademico(scanner.nextLine());
            BancoService bancoService = new BancoService();
            bancoService.update(banco);
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
