/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.domain.animaisM;
import banco.DAO.DAO;
import banco.DAO.controleDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.mensagens;

/**
 *
 * @author Fellipe Luann
 */
public class animaisDAO extends DAO{
    public void salvarAnimais(animaisM animais) throws Exception {
        if (animais.getId() == 0) {
            inserirAnimais(animais);
        } else {
            alterarAnimais(animais);
        }
    }
    
    public void inserirAnimais(animaisM animais) throws Exception {
        try {

            String sql = "insert into animais(nome,responsavel_id,raça_id,genero,especie_id,idade,observation) values (?,?,?,?,?,?,?)";
            stm = conector.prepareStatement(sql);
            stm.setString(1, animais.getNome());
            stm.setInt(2, animais.getProtetor_id().getId());
            stm.setInt(3, animais.getRaça_id().getId());
            stm.setString(4, animais.getGênero());
            stm.setInt(5, animais.getEspécie_id().getId());
            stm.setString(6, animais.getIdade());
            stm.setString(7, animais.getObservações());
            stm.executeUpdate();
            stm.close();
            mensagens.info("Animal inserido com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao inserir Animal: " + ex);
        }
    }
    
    public void alterarAnimais(animaisM animais) throws Exception {
        try {
            String sql = "update animais set nome=?, responsavel_id=?, raça_id=?, genero=?, especie_id=?, idade=?, observation=? where id=?";
            stm = conector.prepareStatement(sql);
            stm.setString(1, animais.getNome());
            stm.setInt(2, animais.getProtetor_id().getId());
            stm.setInt(3, animais.getRaça_id().getId());
            stm.setString(4, animais.getGênero());
            stm.setInt(5, animais.getEspécie_id().getId());
            stm.setString(6, animais.getIdade());
            stm.setString(7, animais.getObservações());
            stm.setInt(8, animais.getId());
            stm.executeUpdate();
            mensagens.info("Animal alterado com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao alterar Animal : " + ex);
        }
    }
    
    public void excluirAnimal(animaisM animais) throws Exception {
        try {
            String sql = "delete from animais where id=?";
            stm = conector.prepareStatement(sql);
            stm.setInt(1, animais.getId());
            stm.executeUpdate();
            mensagens.info("Animal excluído com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao excluir Animal : " + ex);
        }
    }
    
    public ObservableList<animaisM> listar_animais(String txtPesquisarAnimais) throws Exception {
        String sql = "select * from animais where nome like ?";
        stm = conector.prepareStatement(sql);
        stm.setString(1, "%" + txtPesquisarAnimais + "%");
        rs = stm.executeQuery();
        ObservableList listaAnimais = FXCollections.observableArrayList();
        while (rs.next()) {
            animaisM animais = new animaisM();
            animais.setId(rs.getInt("id"));
            animais.setNome(rs.getString("nome"));
            animais.setProtetor_id(controleDAO.getControleBanco().getProtetor_DAO().buscaProtetor(rs.getInt("responsavel_id")));
            animais.setRaça_id(controleDAO.getControleBanco().getRaça_DAO().buscaRaça(rs.getInt("raça_id")));
            animais.setGênero(rs.getString("genero"));
            animais.setEspécie_id(controleDAO.getControleBanco().getEspécie_DAO().buscaEspécie(rs.getInt("especie_id")));
            animais.setIdade(rs.getString("idade"));
            animais.setObservações(rs.getString("observation"));
            listaAnimais.add(animais);
        }
        return listaAnimais;
    }
    
    public animaisM buscaAnimais(int id) throws SQLException{
        String sql = "select * from animais where id like ?";
        stm = conector.prepareStatement(sql);
        stm.setInt(1, id);
        animaisM animM = null;
        rs = stm.executeQuery();
        while(rs.next()){
           animM = new animaisM((rs.getInt("id")), 
                   rs.getString("nome")
           );
        }
        stm.close();
        return animM;
    }
    
    public List<animaisM> comboAnimais() {
        List<animaisM> dadosAnimais = new ArrayList<>();
        try {
            //String sql = "select * from funcionario f inner join cargo c on f.cargo_id = c.id where c.nome = 'Vendedor';";
            String sql = "select * from animais";
            stm = conector.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dadosAnimais.add(new animaisM(rs.getInt(1), rs.getString(2)));
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            mensagens.erro("Erro ao carregar Animais cadastrados : \n" + ex);
        }
        return dadosAnimais;
    }
}
