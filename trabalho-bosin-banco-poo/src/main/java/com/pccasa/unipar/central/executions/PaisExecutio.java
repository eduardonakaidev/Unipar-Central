/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.services.PaisService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class PaisExecutio {
     public String Insert() {
        try {
            Pais pais = new Pais();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de país: ");
            pais.setId(scanner.nextInt());
            scanner.nextLine();
            
            System.out.println("Informe o nome da país: ");
            pais.setNome(scanner.nextLine());
            
            System.out.println("Informe a sigla da país: ");
            pais.setSigla(scanner.nextLine());
            
            System.out.println("Informe o ra do aluno que está cadastrando esse país: ");
            pais.setRegistroAcademico(scanner.nextLine());
            
            PaisService paisService = new PaisService();
            paisService.insert(pais);
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
            PaisService paisService = new PaisService();
            List<Pais> procurarPorPais = paisService.findAll();
            Pais pais = new Pais();
            pais.toString();
            String msg = "Todos os itens encontrados " + procurarPorPais.toString();
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
            PaisService paisService = new PaisService();
            Pais pais = new Pais();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de país para realizar a busca: ");
            int id = scanner.nextInt();
            pais.setId(id);
            
           
            String msg = "Item encontrado: " + paisService.findById(pais.getId());
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String DeleteById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PaisService paisService = new PaisService();
        Pais pais = new Pais();
        System.out.println("Informe o ID de pais: ");
        pais.setId(scanner.nextInt());
        paisService.delete(pais.getId());
        String msg = "Item deletado com sucesso";
        System.out.println(msg);
        return msg;
    }

    public String Update() {
        try {
            Pais pais = new Pais();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de pais: ");
            pais.setId(scanner.nextInt());
            scanner.nextLine();
            
            System.out.println("Informe o nome da pais: ");
            pais.setNome(scanner.nextLine());
            
            System.out.println("Informe a sigla da pais: ");
            pais.setSigla(scanner.nextLine());
            
            System.out.println("Informe o ra do aluno que está realizando updata nesse país: ");
            pais.setRegistroAcademico(scanner.nextLine());
            
            PaisService paisService = new PaisService();
            paisService.update(pais);
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
