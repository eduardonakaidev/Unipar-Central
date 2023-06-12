package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    private static final String INSERT = "INSERT INTO estado(id, nome, sigla, pais_id)" +
            "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT e.id, e.nome, e.SIGLA, p.id AS pais_id, p.nome AS pais_nome " +
            "FROM estado e INNER JOIN pais p ON e.pais_id = p.id";

    private static final String FIND_BY_ID =
            "SELECT e.id, e.nome, e.sigla, p.id AS pais_id, p.nome AS pais_nome " +
                    "FROM estado e INNER JOIN pais p ON e.pais_id = p.id WHERE e.id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM estado WHERE id = ?";

    private static final String UPDATE = "UPDATE estado SET nome = ?, sigla = ?, pais_id = ? " +
            "WHERE id = ?";

    public List<Estado> findAll() throws SQLException {

        ArrayList<Estado> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            conn = new DataBaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();//executa FIND_ALL, retorna o resultado

            while(rs.next()){//enquanto não acabar
                Estado estado = new Estado();//para utilizar para setar no arraylist de retorno
                estado.setId(rs.getInt("id"));//getInt - pq id é inteiro
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));

                Pais pais = new Pais();
                pais.setId(rs.getInt("pais_id"));
                pais.setNome(rs.getString("pais_nome"));

                estado.setPais(pais);

                retorno.add(estado);
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

    public Estado findById(int id) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Estado retorno = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new Estado();
                retorno.setId(rs.getInt("id"));//getInt - pq id é inteiro
                retorno.setNome(rs.getString("nome"));
                retorno.setSigla(rs.getString("sigla"));

                Pais pais = new Pais();
                pais.setId(rs.getInt("pais_id"));
                pais.setNome(rs.getString("pais_nome"));

                retorno.setPais(pais);
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

    public void insert(Estado estado) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSigla());
            pstmt.setInt(4, estado.getPais().getId());

            pstmt.executeUpdate();

        }finally{

            if(conn != null)
                conn.close();

            if(pstmt != null)
                pstmt.close();

        }

    }

    public void update(Estado estado) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.setInt(3, estado.getPais().getId());
            pstmt.setInt(4, estado.getId());

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
