/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fellipe Luann
 */
public class DAO {
    protected Connection conector = conexãoBancoDAO.instancia().getConnection();
    protected ResultSet rs;
    protected PreparedStatement stm;    
}
