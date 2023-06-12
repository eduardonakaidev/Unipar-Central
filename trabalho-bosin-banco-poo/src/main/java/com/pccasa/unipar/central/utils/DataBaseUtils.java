/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduar
 */
public class DataBaseUtils {
     public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://3.142.131.90:5435/uniparcentral", 
                "aluno", "aluno");//jdbc:postgresql: - padrão
    }
}
