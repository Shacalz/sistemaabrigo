/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import banco.DAO.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.domain.raçaM;
import util.mensagens;

/**
 *
 * @author Fellipe Luann
 */
public class raçaDAO extends DAO{
    public void salvarRaça(raçaM raça) throws Exception {
        if (raça.getId() == 0) {
            inserirRaça(raça);
        } else {
            alterarRaça(raça);
        }
    }
    
    public void inserirRaça(raçaM raça) throws Exception {
        try {
            String sql = "insert into raça(nome) values (?)";
            stm = conector.prepareStatement(sql);
            stm.setString(1, raça.getNome());
            stm.executeUpdate();
            stm.close();
            mensagens.info("Raça inserida com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao inserir Raça: " + ex);
        }
    }
    
    public void alterarRaça(raçaM raça) throws Exception {
        try {
            String sql = "update raça set nome=? where id=?";
            stm = conector.prepareStatement(sql);
            stm.setString(1, raça.getNome());
            stm.setInt(2, raça.getId());
            stm.executeUpdate();
            mensagens.info("Raça alterada com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao alterar Raça : " + ex);
        }
    }
    
    public void excluirRaça(raçaM raça) throws Exception {
        try {
            String sql = "delete from raça where id=?";
            stm = conector.prepareStatement(sql);
            stm.setInt(1, raça.getId());
            stm.executeUpdate();
            mensagens.info("Raça excluída com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao excluir Raça : " + ex);
        }
    }
    
    public ObservableList<raçaM> listar_raça(String txtPesquisarProtetores) throws Exception {
        String sql = "select * from raça where nome like ?";
        stm = conector.prepareStatement(sql);
        stm.setString(1, "%" + txtPesquisarProtetores + "%");
        rs = stm.executeQuery();
        ObservableList listaRaça = FXCollections.observableArrayList();
        while (rs.next()) {
            raçaM raça = new raçaM();
            raça.setId(rs.getInt("id"));
            raça.setNome(rs.getString("nome"));
            listaRaça.add(raça);
        }
        return listaRaça;
    }
    
    public raçaM buscaRaça(int id) throws SQLException{
        String sql = "select * from raça where id like ?";
        stm = conector.prepareStatement(sql);
        stm.setInt(1, id);
        raçaM raçM = null;
        rs = stm.executeQuery();
        while(rs.next()){
           raçM = new raçaM((rs.getInt("id")), 
                   rs.getString("nome")
           );
        }
        stm.close();
        return raçM;
    }
    
    public List<raçaM> comboRaçaAnimais() {
        List<raçaM> dadosRaçaAnimais = new ArrayList<>();
        try {
           // String sql = "select * from funcionario f inner join cargo c on f.cargo_id = c.id where c.nome = 'Vendedor';";
            String sql = "select * from raça";

            stm = conector.prepareStatement(sql);
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                dadosRaçaAnimais.add(new raçaM(rs.getInt(1), rs.getString(2)));
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            mensagens.erro("Erro ao carregar Raças cadastradas : \n" + ex);
        }
        return dadosRaçaAnimais;
    }
    
}
