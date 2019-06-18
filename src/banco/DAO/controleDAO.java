package banco.DAO;

import model.dao.adotantesDAO;
import model.dao.animaisDAO;
import model.dao.espécieDAO;
import model.dao.loginDAO;
import model.dao.protetorDAO;
import model.dao.raçaDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fellipe Luann
 */
public class controleDAO {
    
    private static controleDAO controleBanco = new controleDAO();
    private protetorDAO protetor_DAO = new protetorDAO();
    private raçaDAO raça_DAO = new raçaDAO();
    private espécieDAO espécie_DAO = new espécieDAO();
    private animaisDAO animais_DAO = new animaisDAO();
    private adotantesDAO adotantes_DAO = new adotantesDAO();
    private loginDAO login_DAO = new loginDAO();

    public static controleDAO getControleBanco() {
        return controleBanco;
    }

    public static void setControleBanco(controleDAO controleBanco) {
        controleDAO.controleBanco = controleBanco;
    }

    public protetorDAO getProtetor_DAO() {
        return protetor_DAO;
    }

    public void setProtetor_DAO(protetorDAO protetor_DAO) {
        this.protetor_DAO = protetor_DAO;
    }

    public raçaDAO getRaça_DAO() {
        return raça_DAO;
    }

    public void setRaça_DAO(raçaDAO raça_DAO) {
        this.raça_DAO = raça_DAO;
    }

    public espécieDAO getEspécie_DAO() {
        return espécie_DAO;
    }

    public void setEspécie_DAO(espécieDAO espécie_DAO) {
        this.espécie_DAO = espécie_DAO;
    }

    public animaisDAO getAnimais_DAO() {
        return animais_DAO;
    }

    public void setAnimais_DAO(animaisDAO animais_DAO) {
        this.animais_DAO = animais_DAO;
    }   

    public adotantesDAO getAdotantes_DAO() {
        return adotantes_DAO;
    }

    public void setAdotantes_DAO(adotantesDAO adotantes_DAO) {
        this.adotantes_DAO = adotantes_DAO;
    }

    public loginDAO getLogin_DAO() {
        return login_DAO;
    }

    public void setLogin_DAO(loginDAO login_DAO) {
        this.login_DAO = login_DAO;
    }
}
