package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.PessoaFisica;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    private static final String INSERT = "INSERT INTO pessoafisica(email, nome, documento, tipo_pessoa, data_nascimento) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT id, email, nome, documento, tipo_pessoa, data_nascimento FROM pessoafisica";
    private static final String FIND_BY_ID = "SELECT id, email, nome, documento, tipo_pessoa, data_nascimento FROM pessoafisica WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM pessoafisica WHERE id = ?";
    private static final String UPDATE = "UPDATE pessoafisica SET email = ?, nome = ?, documento = ?, tipo_pessoa = ?, data_nascimento = ? WHERE id = ?";

    public List<PessoaFisica> findAll() throws SQLException {
        List<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setId(rs.getInt("id"));
                pessoaFisica.setEmail(rs.getString("email"));
                pessoaFisica.setNome(rs.getString("nome"));
                pessoaFisica.setDocumento(rs.getString("documento"));
                pessoaFisica.setTipoPessoa(rs.getString("tipo_pessoa"));
                pessoaFisica.setDataDeNascimento(rs.getDate("data_nascimento"));
                retorno.add(pessoaFisica);
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

    public PessoaFisica findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retorno = new PessoaFisica();
                retorno.setId(rs.getInt("id"));
                retorno.setEmail(rs.getString("email"));
                retorno.setNome(rs.getString("nome"));
                retorno.setDocumento(rs.getString("documento"));
                retorno.setTipoPessoa(rs.getString("tipo_pessoa"));
                retorno.setDataDeNascimento(rs.getDate("data_nascimento"));
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

    public void insert(PessoaFisica pessoaFisica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaFisica.getEmail());
            pstmt.setString(2, pessoaFisica.getNome());
            pstmt.setString(3, pessoaFisica.getDocumento());
            pstmt.setString(4, pessoaFisica.getTipoPessoa());
            pstmt.setDate(5, pessoaFisica.getDataDeNascimento());
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

    public void update(PessoaFisica pessoaFisica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaFisica.getEmail());
            pstmt.setString(2, pessoaFisica.getNome());
            pstmt.setString(3, pessoaFisica.getDocumento());
            pstmt.setString(4, pessoaFisica.getTipoPessoa());
            pstmt.setDate(5, pessoaFisica.getDataDeNascimento());
            pstmt.setInt(6, pessoaFisica.getId());
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
