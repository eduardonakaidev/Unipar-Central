/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class PaisDAO {
     private static final String INSERT = "INSERT INTO pais(id, nome, sigla, ra)" + 
            "VALUES(?, ?, ?, ?)";
    
    private static final String FIND_ALL = "SELECT id, nome, sigla, ra FROM pais";
    
    private static final String FIND_BY_ID = 
            "SELECT id, nome, sigla, ra FROM pais WHERE id = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM pais WHERE id = ?";
    
    private static final String UPDATE = "UPDATE pais SET nome = ?, sigla = ?, ra = ?" + 
            "WHERE id = ?";
    
    public List<Pais> findAll() throws SQLException{
        
        ArrayList<Pais> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = new DataBaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();//executa FIND_ALL, retorna o resultado
            
            while(rs.next()){//enquanto não acabar
                Pais pais = new Pais();//para utilizar para setar no arraylist de retorno
                pais.setId(rs.getInt("id"));//getInt - pq id é inteiro
                pais.setNome(rs.getString("nome"));
                pais.setRegistroAcademico(rs.getString("ra"));
                pais.setSigla(rs.getString("sigla"));
                
                retorno.add(pais);
            }
            
        }finally{
            
            if(rs != null){
                rs.close();
            }
            
            if(pstmt != null){
                pstmt.close();
            }
            
            if(conn != null){
                conn.close();
            }
            
        }
        
        return retorno;
        
    }
    
    public Pais findById(int id) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pais retorno = null;
        
        try{
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Pais();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setRegistroAcademico(rs.getString("ra"));
                retorno.setSigla(rs.getString("sigla"));
            }
            
        }finally{
            
            if(rs != null)
                rs.close();
            
            if(pstmt != null)
                pstmt.close();
            
            if(conn != null)
                conn.close();
            
        }
        
        return retorno;
        
    }
    
    public void insert(Pais pais) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pais.getId());
            pstmt.setString(2, pais.getNome());
            pstmt.setString(3, pais.getSigla());
            pstmt.setString(4, pais.getRegistroAcademico());
            
            pstmt.executeUpdate();
            
        }finally{
            
            if(conn != null)
                conn.close();
            
            if(pstmt != null)
                pstmt.close();
            
        }
        
    }
    
    public void update(Pais pais) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pais.getNome());
            pstmt.setString(2, pais.getSigla());
            pstmt.setString(3, pais.getRegistroAcademico());
            pstmt.setInt(4, pais.getId());
            
            pstmt.executeUpdate();
            
        }finally{
            
           if(pstmt != null)
              pstmt.close();
           
           if(conn != null)
               conn.close();
            
        }
        
    }
    
    public void delete(int id) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
        conn = new DataBaseUtils().getConnection();
        pstmt = conn.prepareStatement(DELETE_BY_ID);
        
        pstmt.executeUpdate();
            
        }finally{
            
           if(pstmt != null)
              pstmt.close();
           
           if(conn != null)
               conn.close();
            
        }
    
    }
}
