/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import connection.ConnectionBD;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import modeloBeans.Usuario;
import view.TelaLogin;
import view.TelaPrincipal;


public class UsuarioDao {
   TelaPrincipal view;
   TelaLogin lview;
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
   
   public TelaPrincipal consulta(){
        
        conexao.getConexao();
        try {
            
            conexao.executaSql("select *from usuarios where user_nome='"+lview.getjTextFieldUsuario().getText()+"'");
            conexao.rs.first();
            
            
            if(conexao.rs.getString("user_senha").equals(lview.getjPasswordFieldSenha().getText())){
                
              lview.getjPanelLoader().show();
              lview.getjPanelLogin().hide();    
        
        new java.util.Timer().schedule(new TimerTask() {
           @Override
           public void run() {
            
            view = new TelaPrincipal(lview.getjTextFieldUsuario().getText());
            view.setExtendedState(MAXIMIZED_BOTH);
            view.show();
       
    
            lview.dispose();
           
           }
       },1000*4);
        
            }else{
                JOptionPane.showMessageDialog(null, "Senha invalida!");
            }
            
        } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null," Usuario não encontrado!","",JOptionPane.ERROR_MESSAGE);
        } finally{
                conexao.closeConnection();
    }  
return view;    
}
    

    
}
