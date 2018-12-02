/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import connection.ConnectionBD;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeloBeans.Tabela;
import view.FormAtiv;

/**
 *
 * @author sKY_FALL
 */
public class TabelaDao {
    
    ConnectionBD conexao = new ConnectionBD();
    FormAtiv view = new FormAtiv();
    private Component rootPane;
    
    
    
    public void preencherTabelas(String sql){
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID","Nome","Curso","Descrição"};
        conexao.getConexao();
        conexao.executaSql(sql);
       
        try
        {
          conexao.rs.first();
            do{
            dados.add(new Object[]{conexao.rs.getInt("cod_atv"),conexao.rs.getString("nome_atv"),conexao.rs.getString("curso"),conexao.rs.getString("descricao")});
            
            }while(conexao.rs.next());
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList"+ex);
        }
        
        Tabela modelo = new Tabela(dados,colunas);
        view.getjTableDadosAtividade().setModel(modelo);
        view.configTabela();
    
        conexao.closeConnection();  
        
 }
   public void xxx (String sql){
        
       ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID","Nome","Curso","Descrição"};
        conexao.getConexao();
        conexao.executaSql(sql);
       
        try
        {
          conexao.rs.first();
            do{
            dados.add(new Object[]{conexao.rs.getInt("cod_atv"),conexao.rs.getString("nome_atv"),conexao.rs.getString("curso"),conexao.rs.getString("descricao")});
            
            }while(conexao.rs.next());
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList"+ex);
        }
   
            Tabela modelo = new Tabela(dados,colunas);
        view.getjTableDadosAtividade().setModel(modelo);
        view.configTabela();
    
        conexao.closeConnection();
   
   
   
   }
   
}
