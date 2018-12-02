/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import connection.ConnectionBD;
import java.sql.*;
import javax.swing.JOptionPane;
import modeloBeans.Atividade;



/**
 *
 * @author sKY_FALL
 */

public class AtividadeDao {
    
    ConnectionBD conexao = new ConnectionBD();
    int catCod;
    
    
    public void create(Atividade atv){
        buscarCatCod(atv.getCategoria());
        conexao.getConexao();
        
        PreparedStatement stmt;
        
        try {
            
            
            stmt = conexao.con.prepareStatement("insert into atividades (nome_atv,descricao,curso,categ_atv,matricula) VALUES(?,?,?,?,?)");
            stmt.setString(1,atv.getNome());
            stmt.setString(2,atv.getDescricao());
            stmt.setString(3,atv.getCurso());
            stmt.setInt(4, catCod);
            stmt.setString(5,atv.getAluno());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!:" +ex);
        }finally{
            conexao.closeConnection();
        }
    }
    
    public void editar(Atividade atv){
        conexao.getConexao();
        buscarCatCod(atv.getCategoria());
        try {
            
            PreparedStatement stmt = conexao.con.prepareStatement("UPDATE atividades set nome_atv=?,descricao=?,curso=?,categ_atv=? WHERE cod_atv=?");
            stmt.setString(1, atv.getNome());
            stmt.setString(2, atv.getDescricao());
            stmt.setString(3, atv.getCurso());
            stmt.setInt(4, catCod);
            stmt.setInt(5, atv.getCodigo());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null,"dados alterados com êxito!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao alterar os dados!!!" +ex);
        }finally{
            conexao.closeConnection();
        }
    }    
    
    public void excluir(Atividade atv){
        conexao.getConexao();
        
        try{
           PreparedStatement stmt = conexao.con.prepareStatement("DELETE FROM atividades WHERE cod_atv=?"); 
           stmt.setInt(1, atv.getCodigo());
           stmt.execute();
           JOptionPane.showMessageDialog(null,"Sucesso ao excluir os dados!");
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"erro ao excluir os dados!" +ex);
            
        }finally{
           conexao.closeConnection();
        }
    }
    
public Atividade search(Atividade atv){
            
            conexao.getConexao();
            conexao.executaSql("SELECT *FROM atividades where nome_atv like'%"+atv.getPesquisa()+"%'");
        try {
            conexao.rs.first();
            atv.setCodigo(conexao.rs.getInt("cod_atv"));
            atv.setNome(conexao.rs.getString("nome_atv"));
            atv.setDescricao(conexao.rs.getString("descricao"));
            atv.setCurso(conexao.rs.getString("curso"));
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao buscar nome da atividade! "+ex);
        }finally{
            conexao.closeConnection();
        }
            return atv;  
        
    }

        public void buscarCatCod(String nome){
            conexao.getConexao();
            conexao.executaSql("select *from categorias where categ_nome ='"+nome+"'");
        try {
            
            conexao.rs.first();
            catCod = conexao.rs.getInt("id_categ");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao encontra o index da categoria"+ ex);
        }
            finally
        {
           
            
        }
        }
    
    
}
