package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
    private static final String INSERT = "INSERT INTO agencia(id, codigo, razao_social, cnpj) " +
            "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, codigo, razao_social, cnpj FROM agencia";

    private static final String FIND_BY_ID =
            "SELECT id, codigo, razao_social, cnpj FROM agencia WHERE id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM agencia WHERE id = ?";

    private static final String UPDATE = "UPDATE agencia SET codigo = ?, razao_social = ?, cnpj = ? " +
            "WHERE id = ?";

    public List<Agencia> findAll() throws SQLException {
        ArrayList<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Agencia agencia = new Agencia();
                agencia.setId(rs.getInt("id"));
                agencia.setCodigo(rs.getString("codigo"));
                agencia.setRazaoSocial(rs.getString("razao_social"));
                agencia.setCnpj(rs.getString("cnpj"));

                retorno.add(agencia);
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

    public Agencia findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;

        try{
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new Agencia();
                retorno.setId(rs.getInt("id"));
                retorno.setCodigo(rs.getString("codigo"));
                retorno.setRazaoSocial(rs.getString("razao_social"));
                retorno.setCnpj(rs.getString("cnpj"));
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

    public void insert(Agencia agencia) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getCnpj());

            pstmt.executeUpdate();
        }finally{
            if(conn != null)
                conn.close();

            if(pstmt != null)
                pstmt.close();
        }
    }

    public void update(Agencia agencia) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getRazaoSocial());
            pstmt.setString(3, agencia.getCnpj());
            pstmt.setInt(4, agencia.getId());

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
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }finally{
            if(pstmt != null)
                pstmt.close();

            if(conn != null)
                conn.close();
        }
    }
}
