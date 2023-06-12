package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.PessoaJuridica;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    private static final String INSERT = "INSERT INTO pessoajuridica(cnpj, razaosocial, cnaeprincipal, fantasia) " +
            "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT cnpj, razaosocial, cnaeprincipal, fantasia FROM pessoajuridica";

    private static final String DELETE_BY_CNPJ =
            "DELETE FROM pessoajuridica WHERE cnpj = ?";

    private static final String UPDATE = "UPDATE pessoajuridica SET razaosocial = ?, cnaeprincipal = ?, fantasia = ? " +
            "WHERE cnpj = ?";

    public List<PessoaJuridica> findAll() throws SQLException {
        List<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setRazaoSocial(rs.getString("razaosocial"));
                pessoaJuridica.setCnaePrincipal(rs.getString("cnaeprincipal"));
                pessoaJuridica.setFantasia(rs.getString("fantasia"));
                retorno.add(pessoaJuridica);
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

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaJuridica.getCnpj());
            pstmt.setString(2, pessoaJuridica.getRazaoSocial());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
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

    public void update(PessoaJuridica pessoaJuridica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(3, pessoaJuridica.getFantasia());
            pstmt.setString(4, pessoaJuridica.getCnpj());
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

    public void delete(String cnpj) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_CNPJ);
            pstmt.setString(1, cnpj);
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
