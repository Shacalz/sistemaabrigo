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
import model.domain.espécieM;
import util.mensagens;

/**
 *
 * @author Fellipe Luann
 */
public class espécieDAO extends DAO{
    public void salvarEspécie(espécieM espécie) throws Exception {
        if (espécie.getId() == 0) {
            inserirEspécie(espécie);
        } else {
            alterarEspécie(espécie);
        }
    }
    
    public void inserirEspécie(espécieM espécie) throws Exception {
        try {
            String sql = "insert into especie(nome) values (?)";
            stm = conector.prepareStatement(sql);
            stm.setString(1, espécie.getNome());
            stm.executeUpdate();
            stm.close();
            mensagens.info("Espécie inserida com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao inserir Espécie: " + ex);
        }
    }
    
    public void alterarEspécie(espécieM espécie) throws Exception {
        try {
            String sql = "update especie set nome=? where id=?";
            stm = conector.prepareStatement(sql);
            stm.setString(1, espécie.getNome());
            stm.setInt(2, espécie.getId());
            stm.executeUpdate();
            mensagens.info("Espécie alterada com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao alterar Espécie : " + ex);
        }
    }
    
    public void excluirEspécie(espécieM espécie) throws Exception {
        try {
            String sql = "delete from especie where id=?";
            stm = conector.prepareStatement(sql);
            stm.setInt(1, espécie.getId());
            stm.executeUpdate();
            mensagens.info("Espécie excluída com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao excluir Espécie : " + ex);
        }
    }
    
    public ObservableList<espécieM> listar_espécie(String txtPesquisarEspécie) throws Exception {
        String sql = "select * from especie where nome like ?";
        stm = conector.prepareStatement(sql);
        stm.setString(1, "%" + txtPesquisarEspécie + "%");
        rs = stm.executeQuery();
        ObservableList listaEspécie = FXCollections.observableArrayList();
        while (rs.next()) {
            espécieM espécie = new espécieM();
            espécie.setId(rs.getInt("id"));
            espécie.setNome(rs.getString("nome"));
            listaEspécie.add(espécie);
        }
        return listaEspécie;
    }
    
    public espécieM buscaEspécie(int id) throws SQLException{
        String sql = "select * from especie where id like ?";
        stm = conector.prepareStatement(sql);
        stm.setInt(1, id);
        espécieM espécieM = null;
        rs = stm.executeQuery();
        while(rs.next()){
           espécieM = new espécieM((rs.getInt("id")), 
                   rs.getString("nome")
           );
        }
        stm.close();
        return espécieM;
    }
    
    public List<espécieM> comboEspécieAnimais() {
        List<espécieM> dadosEspécieAnimais = new ArrayList<>();
        try {
           // String sql = "select * from funcionario f inner join cargo c on f.cargo_id = c.id where c.nome = 'Vendedor';";
            String sql = "select * from especie";
            stm = conector.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dadosEspécieAnimais.add(new espécieM(rs.getInt(1), rs.getString(2)));
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            mensagens.erro("Erro ao carregar Espécies cadastradas : \n" + ex);
        }
        return dadosEspécieAnimais;
    }
    
}
