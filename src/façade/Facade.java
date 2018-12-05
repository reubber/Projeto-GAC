/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package façade;

import modelDao.AtividadeDao;
import modelDao.UsuarioDao;
import modeloBeans.Atividade;
import modeloBeans.Usuario;


/**
 *
 * @author reubber
 */

public class Facade {
   
   AtividadeDao atvdao;
   UsuarioDao udao;
   
    public Facade(){
        
        atvdao = new AtividadeDao();
        udao = new UsuarioDao();
    }
    
    public void create(Atividade atv){
        atvdao.create(atv);
        
    }
    public void editar(Atividade atv){
        atvdao.editar(atv);
    }
    
   public Atividade pesquisar(Atividade atv){
        atvdao.search(atv);
       
   return atv;
   }
   
   public void excluir(Atividade atv){
        atvdao.excluir(atv);
   }
   
   public void createUser(Usuario user){
       udao.create(user);
   }
   
   
            
    



}


