/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.Exceptions.TamanhoMaximoDoCampoExcedidoException;
import com.pccasa.unipar.central.Exceptions.ValorInvalidoException;
import com.pccasa.unipar.central.models.Cidade;
import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.services.CidadeService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class CidadeExecution {
     public String Insert() throws TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException, TamanhoCampoInvalidoException {
        try {
            Cidade cidade = new Cidade();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de cidade: ");
            cidade.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o nome da cidade: ");
            cidade.setNome(scanner.nextLine());
            System.out.println("Informe o ra do aluno que está cadastrando essa cidade: ");
            cidade.setRegistroAcademico(scanner.nextLine());
            System.out.println("Informe o id do estado atrelado a esta cidade: ");
            Estado estado = new Estado();
            estado.setId(scanner.nextInt());
            cidade.setEstado(estado);
            CidadeService cidadeService = new CidadeService();
            cidadeService.insert(cidade);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (CampoNaoInformadoException | EntidadeNaoInformadaException | SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindAll() {
        try {
            CidadeService cidadeService = new CidadeService();
            List<Cidade> procurarPorCidade = cidadeService.findAll();
            Cidade cidade = new Cidade();
            cidade.toString();
            String msg = "Todos os itens encontrados " + procurarPorCidade.toString();
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
            CidadeService cidadeService = new CidadeService();
            Cidade cidade = new Cidade();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID da cidade para realizar a busca: ");
            int id = scanner.nextInt();
            cidade.setId(id);
            
            cidade.toString();
            String msg = "Item encontrado: " + cidadeService.findById(cidade.getId());
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

            CidadeService cidadeService = new CidadeService();
            Cidade cidade = new Cidade();

            System.out.println("Informe o ID de cidade: ");
            cidade.setId(scanner.nextInt());
            cidadeService.delete(cidade.getId());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() throws TamanhoMaximoDoCampoExcedidoException {
        try {
            Cidade cidade = new Cidade();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de cidade: ");
            cidade.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o nome da cidade: ");
            cidade.setNome(scanner.nextLine());
            System.out.println("Informe o ra do aluno que está dando update nessa cidade: ");
            cidade.setRegistroAcademico(scanner.nextLine());
            System.out.println("Informe o id do estado atrelada a essa cidade: ");
            Estado estado = new Estado();
            estado.setId(scanner.nextInt());
            cidade.setEstado(estado);
            CidadeService cidadeService = new CidadeService();
            cidadeService.update(cidade);
            String msg = "Update realizado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (CampoNaoInformadoException | EntidadeNaoInformadaException | SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        } catch (ValorInvalidoException | TamanhoCampoInvalidoException ex) {
             Logger.getLogger(CidadeExecution.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
}
