/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.Usuario;


public class UsuarioDao {
   
   ConnectionBD conexao = new ConnectionBD();
   
   public void create(Usuario user){
        conexao.getConexao();
        PreparedStatement stmt;
        
        try {
            
            stmt = conexao.con.prepareStatement("insert into usuarios(user_nome,user_senha,user_tipo)VALUES(?,?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getTipo());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!: Já existe esse usuario cadastrado");
        }finally{
            conexao.closeConnection();
        }
    }
    
    
    
}
