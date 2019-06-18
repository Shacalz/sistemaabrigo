/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import banco.DAO.DAO;
import banco.DAO.controleDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.domain.adotantesM;
import util.mensagens;

/**
 *
 * @author Fellipe Luann
 */
public class adotantesDAO extends DAO {

    public void salvarAdotantes(adotantesM adotantes) throws Exception {
        if (adotantes.getId() == 0) {
            inserirAdotantes(adotantes);
        } else {
            alterarAdotantes(adotantes);
        }
    }

    public void inserirAdotantes(adotantesM adotantes) throws Exception {
        try {
            String sql = "insert into adotantes(nome,animais_id,celular,email,endereco,bairro,cpf,estado) values (?,?,?,?,?,?,?,?)";
            stm = conector.prepareStatement(sql);
            stm.setString(1, adotantes.getNome());
            stm.setInt(2, adotantes.getAnimais_id().getId());
            stm.setString(3, adotantes.getCelular());
            stm.setString(4, adotantes.getEmail());
            stm.setString(5, adotantes.getEndereco());
            stm.setString(6, adotantes.getBairro());
            stm.setString(7, adotantes.getCpf());
            stm.setString(8, adotantes.getEstado());
            stm.executeUpdate();
            stm.close();
            mensagens.info("Adotante inserido com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao inserir Adotante : " + ex);
        }
    }

    public void alterarAdotantes(adotantesM adotantes) throws Exception {
        try {
            String sql = "update adotantes set nome=?, animais_id=?, celular=?, email=?, endereco=?, bairro=?, cpf=?, estado=? where id=?";
            stm = conector.prepareStatement(sql);
            stm.setString(1, adotantes.getNome());
            stm.setInt(2, adotantes.getAnimais_id().getId());
            stm.setString(3, adotantes.getCelular());
            stm.setString(4, adotantes.getEmail());
            stm.setString(5, adotantes.getEndereco());
            stm.setString(6, adotantes.getBairro());
            stm.setString(7, adotantes.getCpf());
            stm.setString(8, adotantes.getEstado());
            stm.setInt(9, adotantes.getId());
            stm.executeUpdate();
            mensagens.info("Adotante alterado com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao alterar Adotante : " + ex);
        }
    }

    public void excluirAdotantes(adotantesM adotantes) throws Exception {
        try {
            String sql = "delete from adotantes where id=?";
            stm = conector.prepareStatement(sql);
            stm.setInt(1, adotantes.getId());
            stm.executeUpdate();
            mensagens.info("Adotante excluído com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao excluir Adotante : " + ex);
        }
    }

    public ObservableList<adotantesM> listar_adotantes(String txtPesquisarAdotantes) throws Exception {
        String sql = "select * from adotantes where nome like ?";
        stm = conector.prepareStatement(sql);
        stm.setString(1, "%" + txtPesquisarAdotantes + "%");
        rs = stm.executeQuery();
        ObservableList listaAdotantes = FXCollections.observableArrayList();
        while (rs.next()) {
            adotantesM adotantes = new adotantesM();
            adotantes.setId(rs.getInt("id"));
            adotantes.setNome(rs.getString("nome"));
            adotantes.setAnimais_id(controleDAO.getControleBanco().getAnimais_DAO().buscaAnimais(rs.getInt("animais_id")));
            adotantes.setCelular(rs.getString("celular"));
            adotantes.setEmail(rs.getString("email"));
            adotantes.setEndereco(rs.getString("endereco"));
            adotantes.setBairro(rs.getString("bairro"));
            adotantes.setCpf(rs.getString("cpf"));
            adotantes.setEstado(rs.getString("estado"));
            listaAdotantes.add(adotantes);
        }
        return listaAdotantes;
    }

    public adotantesM buscaAdotantes(int id) throws SQLException {
        String sql = "select * from adotantes where id like ?";
        stm = conector.prepareStatement(sql);
        stm.setInt(1, id);
        adotantesM adotM = null;
        rs = stm.executeQuery();
        while (rs.next()) {
            adotM = new adotantesM((rs.getInt("id")),
                    rs.getString("nome")
            );
        }
        stm.close();
        return adotM;
    }

    public List<adotantesM> comboAnimais() {
        List<adotantesM> dadosAdotantes = new ArrayList<>();
        try {
            String sql = "select * from adotantes";
            stm = conector.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dadosAdotantes.add(new adotantesM(rs.getInt(1), rs.getString(2)));
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            mensagens.erro("Erro ao carregar Adotantes cadastrados : \n" + ex);
        }
        return dadosAdotantes;
    }

}
