package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Cidade;
import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    private static final String INSERT = "INSERT INTO cidade(id, nome, estado_id)" +
            "VALUES(?, ?, ?)";

    private static final String FIND_ALL = "SELECT c.id, c.nome, e.id AS estado_id, e.nome AS estado_nome " +
            "FROM cidade c INNER JOIN estado e ON c.estado_id = e.id";

    private static final String FIND_BY_ID =
            "SELECT c.id, c.nome, e.id AS estado_id, e.nome AS estado_nome " +
                    "FROM cidade c INNER JOIN estado e ON c.estado_id = e.id WHERE c.id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM cidade WHERE id = ?";

    private static final String UPDATE = "UPDATE cidade SET nome = ?, estado_id = ?" +
            "WHERE id = ?";

    public List<Cidade> findAll() throws SQLException {
        List<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));

                Estado estado = new Estado();
                estado.setId(rs.getInt("estado_id"));
                estado.setNome(rs.getString("estado_nome"));

                cidade.setEstado(estado);

                retorno.add(cidade);
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

    public Cidade findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Cidade();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("id"));

                Estado estado = new Estado();
                estado.setId(rs.getInt("estado_id"));
                estado.setNome(rs.getString("estado_nome"));

                retorno.setEstado(estado);
            }

        } finally {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }

        return retorno;
    }

    public void insert(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setInt(3, cidade.getEstado().getId());

            pstmt.executeUpdate();
        } finally {
            if (conn != null)
                conn.close();
            if (pstmt != null)
                pstmt.close();
        }
    }

    public void update(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, cidade.getNome());
            pstmt.setInt(2, cidade.getEstado().getId());
            pstmt.setInt(3, cidade.getId());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
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
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
