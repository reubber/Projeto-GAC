/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rBBr
 */

public class ConnectionBD {
        private static final String DRIVER = "org.postgresql.Driver";
        private static final String URL ="jdbc:postgresql://localhost:5432/projetogerenciador";
        private static final String usuario ="postgres";
        private static final String senha = "qwe123";
        public  Statement stmt;
        public  Connection con;
        public  ResultSet rs;
        
        public void getConexao(){                      //metodo responsavel por criar conexao com a base de dados
            
           
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL,usuario,senha);
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro na conexao: ",ex);
            }
        }
        
        public void executaSql(String sql){
            try {
                
                stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao executar sql: "+ex.getMessage());
            }
        }
        
        
        
        public void closeConnection(){
            
            try{
                con.close();
               
            }catch(SQLException ex){
                 JOptionPane.showMessageDialog(null, "Erro ao connectar com o banco"+ex.getMessage());
                
            }
        }        
        
    }
