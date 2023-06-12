package com.pccasa.unipar.central.teste;

import com.pccasa.unipar.central.models.Conta;
import com.pccasa.unipar.central.services.ContaService;

import java.sql.SQLException;
import java.util.List;

public class ContaServiceTeste {
    public static void main(String[] args) {
        ContaService contaService = new ContaService();

        try {
            List<Conta> listaContas = contaService.findAll();

            if (listaContas.isEmpty()) {
                System.out.println("Não há contas cadastradas.");
            } else {
                System.out.println("Lista de Contas:");
                for (Conta conta : listaContas) {
                    System.out.println(conta);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contas: " + e.getMessage());
        }
    }
}