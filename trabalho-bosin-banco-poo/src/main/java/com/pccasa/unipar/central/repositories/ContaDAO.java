package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Conta;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private static final String INSERT = "INSERT INTO conta(id, conta, agencia, tipo, digito, saldo) " +
            "VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, conta, agencia, tipo, digito, saldo FROM conta";

    private static final String FIND_BY_ID =
            "SELECT id, conta, agencia, tipo, digito, saldo FROM conta WHERE id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM conta WHERE id = ?";

    private static final String UPDATE = "UPDATE conta SET conta = ?, agencia = ?, tipo = ?, digito = ?, saldo = ? " +
            "WHERE id = ?";

    public List<Conta> findAll() throws SQLException {
        List<Conta> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setConta(rs.getString("conta"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setTipo(rs.getString("tipo"));
                conta.setDigito(rs.getInt("digito"));
                conta.setSaldo(rs.getDouble("saldo"));

                retorno.add(conta);
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

    public Conta findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Conta retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Conta();
                retorno.setId(rs.getInt("id"));
                retorno.setConta(rs.getString("conta"));
                retorno.setAgencia(rs.getString("agencia"));
                retorno.setTipo(rs.getString("tipo"));
                retorno.setDigito(rs.getInt("digito"));
                retorno.setSaldo(rs.getDouble("saldo"));
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

    public void insert(Conta conta) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getConta());
            pstmt.setString(3, conta.getAgencia());
            pstmt.setString(4, conta.getTipo());
            pstmt.setInt(5, conta.getDigito());
            pstmt.setDouble(6, conta.getSaldo());
            pstmt.executeUpdate();
        } finally {
            if (conn != null)
                conn.close();
            if (pstmt != null)
                pstmt.close();
        }
    }

    public void update(Conta conta) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, conta.getConta());
            pstmt.setString(2, conta.getAgencia());
            pstmt.setString(3, conta.getTipo());
            pstmt.setInt(4, conta.getDigito());
            pstmt.setDouble(5, conta.getSaldo());
            pstmt.setInt(6, conta.getId());
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
