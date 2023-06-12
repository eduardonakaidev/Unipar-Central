package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Endereco;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private static final String INSERT = "INSERT INTO endereco(id, logradouro, numero, bairro, cep, complemento) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, logradouro, numero, bairro, cep, complemento FROM endereco";

    private static final String FIND_BY_ID =
            "SELECT id, logradouro, numero, bairro, cep, complemento FROM endereco WHERE id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM endereco WHERE id = ?";

    private static final String UPDATE = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cep = ?, complemento = ?" +
            " WHERE id = ?";

    public List<Endereco> findAll() throws SQLException {
        List<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getInt("cep"));
                endereco.setComplemento(rs.getString("complemento"));

                retorno.add(endereco);
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

    public Endereco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Endereco();
                retorno.setId(rs.getInt("id"));
                retorno.setLogradouro(rs.getString("logradouro"));
                retorno.setNumero(rs.getInt("numero"));
                retorno.setBairro(rs.getString("bairro"));
                retorno.setCep(rs.getInt("cep"));
                retorno.setComplemento(rs.getString("complemento"));
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

    public void insert(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setInt(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, String.valueOf(endereco.getCep())); // Convertendo para String
            pstmt.setString(6, endereco.getComplemento());

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

    public void update(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setInt(4, endereco.getCep());
            pstmt.setString(5, endereco.getComplemento());
            pstmt.setInt(6, endereco.getId());

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
