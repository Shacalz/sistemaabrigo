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
import model.domain.protetorM;
import util.mensagens;

/**
 *
 * @author Fellipe Luann
 */
public class protetorDAO extends DAO{
    public void salvarProtetor(protetorM protetor) throws Exception {
        if (protetor.getId() == 0) {
            inserirProtetor(protetor);
        } else {
            alterarProtetor(protetor);
        }
    }
    
    public void inserirProtetor(protetorM protetor) throws Exception {
        try {
            String sql = "insert into protetores(nome,cpf,celular,email,endereco,bairro,estado,tipo,senha) values (?,?,?,?,?,?,?,?,?)";
            stm = conector.prepareStatement(sql);
            stm.setString(1, protetor.getNome());
            stm.setString(2, protetor.getCpf());
            stm.setString(3, protetor.getCelular());
            stm.setString(4, protetor.getEmail());
            stm.setString(5, protetor.getEndereco());
            stm.setString(6, protetor.getBairro());
            stm.setString(7, protetor.getEstado());
            stm.setString(8, protetor.getTipo());
            stm.setString(9, protetor.getSenha());
            stm.executeUpdate();
            stm.close();
            mensagens.info("Protetor inserido com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao inserir Protetor: " + ex);
        }
    }
    
    public void alterarProtetor(protetorM protetor) throws Exception {

        try {

            String sql = "update protetores set nome=?, cpf=?, celular=?, email=?, endereco=?, bairro=?, estado=?, tipo=?, senha=? where id=?";
            stm = conector.prepareStatement(sql);
            stm.setString(1, protetor.getNome());
            stm.setString(2, protetor.getCpf());
            stm.setString(3, protetor.getCelular());
            stm.setString(4, protetor.getEmail());
            stm.setString(5, protetor.getEndereco());
            stm.setString(6, protetor.getBairro());
            stm.setString(7, protetor.getEstado());
            stm.setString(8, protetor.getTipo());
            stm.setString(9, protetor.getSenha());
            stm.setInt(10, protetor.getId());
            stm.executeUpdate();
            mensagens.info("Protetor alterado com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao alterar Protetor : " + ex);
        }
    }
    
    public void excluirProtetor(protetorM protetor) throws Exception {
        try {
            String sql = "delete from protetores where id=?";
            stm = conector.prepareStatement(sql);
            stm.setInt(1, protetor.getId());
            stm.executeUpdate();
            mensagens.info("Protetor excluído com sucesso!");
        } catch (SQLException ex) {
            mensagens.erro("Erro ao excluir Protetor : " + ex);
        }
    }
    
    public ObservableList<protetorM> listar_protetores(String txtPesquisarProtetores) throws Exception {
        String sql = "select * from protetores where nome like ?";
        stm = conector.prepareStatement(sql);
        stm.setString(1, "%" + txtPesquisarProtetores + "%");
        rs = stm.executeQuery();
        ObservableList listaProtetores = FXCollections.observableArrayList();
        while (rs.next()) {
            protetorM protetor = new protetorM();
            protetor.setId(rs.getInt("id"));
            protetor.setNome(rs.getString("nome"));
            protetor.setCpf(rs.getString("cpf"));
            protetor.setCelular(rs.getString("celular"));
            protetor.setEmail(rs.getString("email"));
            protetor.setEndereco(rs.getString("endereco"));
            protetor.setBairro(rs.getString("bairro"));
            protetor.setEstado(rs.getString("estado"));
            protetor.setTipo(rs.getString("tipo"));
            protetor.setSenha(rs.getString("senha"));
            listaProtetores.add(protetor);
        }
        return listaProtetores;
    }
    
    public protetorM buscaProtetor(int id) throws SQLException{
        String sql = "select * from protetores where id like ?";
        stm = conector.prepareStatement(sql);
        stm.setInt(1, id);
        protetorM protM = null;
        rs = stm.executeQuery();
        while(rs.next()){
           protM = new protetorM((rs.getInt("id")), 
                   rs.getString("nome")
           );
        }
        stm.close();
        return protM;
    }
    
    public List<protetorM> comboProtetoresResponsáveis() {
        List<protetorM> dadosProtetoresResponsáveis = new ArrayList<>();
        try {
            String sql = "select * from protetores";
            stm = conector.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dadosProtetoresResponsáveis.add(new protetorM(rs.getInt(1), rs.getString(2)));
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            mensagens.erro("Erro ao carregar Espécies cadastradas : \n" + ex);
        }
        return dadosProtetoresResponsáveis;
    }
    
}
