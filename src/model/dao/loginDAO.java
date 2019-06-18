/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import banco.DAO.DAO;
import java.sql.SQLException;
import model.domain.protetorM;
import util.mensagens;

/**
 *
 * @author Fellipe Luann
 */
public class loginDAO extends DAO {

    public loginDAO() {
        super();
    }

    public boolean autenticarUser(String cpf) {
        try {
            String sql = "SELECT cpf FROM protetores WHERE cpf=?";

            stm = conector.prepareStatement(sql);
            stm.setString(1, cpf);
            rs = stm.executeQuery();

            if (rs.next()) {
                return cpf.equals(rs.getString(1));
            } else {
                mensagens.erro("Usuário incorreto.");
            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
            mensagens.erro("Não foi possível autenticar usuário : \n" + ex);
        }

        return false;
    }

    public boolean autenticarSenha(String cpf, String senha) {
        try {
            String sql = "SELECT cpf, senha FROM protetores WHERE cpf=? AND senha=? ";

            stm = conector.prepareStatement(sql);
            stm.setString(1, cpf);
            stm.setString(2, senha);
            rs = stm.executeQuery();

            if (rs.next()) {
                return rs.getString(1).equals(cpf) && rs.getString(2).equals(senha);
            } else {
                mensagens.erro("Senha incorreta.");
            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
            mensagens.erro("Não foi possível autenticar a senha do usuário : \n" + ex);
        }

        return false;
    }

    public protetorM usuarioLogado(String login) {

        protetorM user = null;

        try {
            String sql = "select * from protetores where cpf = ?";

            stm = conector.prepareStatement(sql);
            stm.setString(1, login);
            rs = stm.executeQuery();
            while (rs.next()) {
                protetorM protetores = new protetorM();
                protetores.setId(rs.getInt("id"));
                protetores.setNome(rs.getString("nome"));
                protetores.setCpf(rs.getString("cpf"));
                protetores.setSenha(rs.getString("senha"));
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            mensagens.erro("Erro ao consultar usuário logado : \n" + ex);
        }

        return user;
    }

}
