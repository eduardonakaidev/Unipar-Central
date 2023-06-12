package com.pccasa.unipar.central.teste;
import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.services.PaisService;

import java.sql.SQLException;
import java.util.List;

public class PaisServiceTest {
    public static void main(String[] args) {
        PaisService paisService = new PaisService();

        try {
            List<Pais> paises = paisService.findAll();

            if (paises.isEmpty()) {
                System.out.println("Não foram encontrados países.");
            } else {
                System.out.println("Países encontrados:");
                for (Pais pais : paises) {
                    System.out.println(pais);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar os países: " + e.getMessage());
        }
    }
}
