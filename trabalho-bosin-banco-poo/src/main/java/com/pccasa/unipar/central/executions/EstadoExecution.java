/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;


import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.services.EstadoService;

import com.pccasa.unipar.central.models.Estado;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class EstadoExecution {
    
    public String Insert() {
        try {
            Estado estado = new Estado();
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Informe o id de estado: ");
            estado.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da estado: ");
            estado.setNome(scanner.nextLine());

            System.out.println("Informe a sigla da estado: ");
            estado.setSigla(scanner.nextLine());

            
            
            System.out.println("Informe o id de país atrelado a esse estado: ");
            Pais pais = new Pais();
            pais.setId(scanner.nextInt());
            estado.setPais(pais);

            EstadoService estadoService = new EstadoService();
            estadoService.insert(estado);
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
            EstadoService estadoService = new EstadoService();
            List<Estado> procurarPorEstado = estadoService.findAll();
            Estado estadoPOJO = new Estado();
            estadoPOJO.toString();
            String msg = "Todos os itens encontrados " + procurarPorEstado.toString();
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
            EstadoService estadoService = new EstadoService();
            Estado estado = new Estado();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID do estado para realizar a busca: ");
            int id = scanner.nextInt();
            estado.setId(id);
            Estado estadoPOJO = new Estado();
            estadoPOJO.toString();
            String msg = "Item encontrado: " + estadoService.findById(estado.getId());
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

            EstadoService estadoService = new EstadoService();
            Estado estado = new Estado();

            System.out.println("Informe o ID de estado: ");
            estado.setId(scanner.nextInt());
            estadoService.delete(estado.getId());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        Estado estado = new Estado();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o id de estado: ");
        estado.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Informe o nome da estado: ");
        estado.setNome(scanner.nextLine());
        System.out.println("Informe a sigla da estado: ");
        estado.setSigla(scanner.nextLine());
        
        System.out.println("Informe o id de país atrelado a esse estado: ");
        Pais pais = new Pais();
        pais.setId(scanner.nextInt());
        estado.setPais(pais);
        EstadoService estadoService = new EstadoService();
        estadoService.update(estado);
        String msg = "Update realizado com sucesso";
        System.out.println(msg);
        return msg;
    }
}
