/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.executions;
import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.models.Banco;
import com.pccasa.unipar.central.services.AgenciaService;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author eduar
 */
public class Agenciaexecution {
      public String Insert() {
        try {
            Agencia agencia = new Agencia();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de agencia: ");
            agencia.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o código da agencia: ");
            agencia.setCodigo(scanner.nextLine());
            System.out.println("Informe o dígito de agencia: ");
            agencia.setDigito(scanner.nextLine());
            System.out.println("Informe a razão social da agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj da agencia: ");
            agencia.setCnpj(scanner.nextLine());
            System.out.println("Informe o ra de agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o id do banco: ");
            Banco bancoPOJO = new Banco();
            bancoPOJO.setId(scanner.nextInt());
            agencia.setBanco(bancoPOJO);
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.insert(agencia);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (CampoNaoInformadoException | EntidadeNaoInformadaException | TamanhoCampoInvalidoException | SQLException ex) {
            String msg = "Erro ao inserir " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public void FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void FindById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void DeleteById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
