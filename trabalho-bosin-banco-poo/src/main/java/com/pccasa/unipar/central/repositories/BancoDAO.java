package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.models.Banco;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {
    private static final String INSERT = "INSERT INTO banco (id, nome, agencia_id) VALUES (?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, nome, agencia_id FROM banco";

    private static final String FIND_BY_ID = "SELECT id, nome, agencia_id FROM banco WHERE id = ?";

    private static final String DELETE_BY_ID = "DELETE FROM banco WHERE id = ?";

    private static final String UPDATE = "UPDATE banco SET nome = ?, agencia_id = ? WHERE id = ?";

    public List<Banco> findAll() throws SQLException {
        List<Banco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId(rs.getInt("id"));
                banco.setNome(rs.getString("nome"));
                // Recuperar a Agencia correspondente pelo ID
                int agenciaId = rs.getInt("agencia_id");
                AgenciaDAO agenciaDAO = new AgenciaDAO();
                Agencia agencia = agenciaDAO.findById(agenciaId);
                banco.setAgencia(agencia);

                retorno.add(banco);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public Banco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Banco retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Banco();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                // Recuperar a Agencia correspondente pelo ID
                int agenciaId = rs.getInt("agencia_id");
                AgenciaDAO agenciaDAO = new AgenciaDAO();
                Agencia agencia = agenciaDAO.findById(agenciaId);
                retorno.setAgencia(agencia);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public void insert(Banco banco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.setInt(3, banco.getAgencia().getId());
            pstmt.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    public void update(Banco banco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, banco.getNome());
            pstmt.setInt(2, banco.getAgencia().getId());
            pstmt.setInt(3, banco.getId());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
