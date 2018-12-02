/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import modelDao.AtividadeDao;
import modelDao.UsuarioDao;
import modeloBeans.Atividade;
import modeloBeans.Usuario;
import view.FormAtiv;
import view.TelaCadUser;
import view.TelaPrincipal;

/**
 *
 * @author rBBr
 */

public class ButtonController {
     TelaPrincipal a;
     Atividade atvmodel = new Atividade();
     FormAtiv atview = new FormAtiv();
     TelaCadUser uview = new TelaCadUser();
     AtividadeDao atvdao = new AtividadeDao();
     Usuario umodel = new Usuario();
     UsuarioDao udao = new UsuarioDao();
    
    
    
    public ButtonController(TelaCadUser view, Usuario model){
        this.umodel = model;
        this.uview = view;
    }
    
    public ButtonController(FormAtiv view,Atividade model){
        this.atvmodel = model;
        this.atview = view;
    }
    
    
    
    public void pesquisarAtvButtonAct(){
        
        atvmodel.setPesquisa(atview.getjTextFieldPesquisar().getText());
        Atividade atv;
        atv = atvdao.search(atvmodel);
        atview.getjTextFieldCod().setText(String.valueOf(atv.getCodigo()));
        atview.getjTextFieldName().setText(atv.getNome());
        atview.getjTextAreaDescricao().setText(atv.getDescricao());
        atview.getjComboBoxCursos().setSelectedItem(atv.getCurso());
        atview.preencherTabelas("SELECT *FROM atividades where nome_atv like'%"+atv.getPesquisa()+"%'"); 
        atview.desabilitarB();
        atview.bloquearCampos();
        atview.getjButtonExcluir().setEnabled(true);
        atview.getjButtonAlterar().setEnabled(true);

    }
    
    public void editarAtvButtonAct(){
        
        atview.setFlag(2);
        atview.permitirCampos();
        atview.desabilitarB();
        atview.getjButtonSalvar().setEnabled(true);
        atview.getjButtonCancelar().setEnabled(true);
        atview.preencherTabelas("SELECT *FROM atividades order by nome_atv");
       
    
    }
    
    public void novoAtvButtonAct(){
        
        atview.setFlag(1);
        atview.desabilitarB();
        atview.allowButtton();
        atview.permitirCampos();
        atview.limparCampos();
        atview.getjComboBoxCat().setEnabled(true);
        
    }
    
    public void excluirAtvButtonAct(){
        
        int i = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir essa atividade?");
        if(i == JOptionPane.YES_OPTION){
            atvmodel.setCodigo(Integer.parseInt(atview.getjTextFieldCod().getText()));
            atvdao.excluir(atvmodel);
            atview.limparCampos();
            atview.desabilitarB();
            atview.bloquearCampos();
            atview.getjButtonCancelar().setEnabled(false);
            atview.preencherTabelas("SELECT *FROM atividades order by nome_atv");
        
    }
    
    } 
    
    public void salvarAtvButtonAct(){
        
      if(atview.getjTextFieldName().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "preencha o nome para continuar");
            atview.getjTextFieldName().requestFocus();
        }else
        
            if(atview.getFlag() ==1){
            
            atvmodel.setNome(atview.getjTextFieldName().getText());
            atvmodel.setDescricao(atview.getjTextAreaDescricao().getText());
            atvmodel.setCurso((String) atview.getjComboBoxCursos().getSelectedItem());
           
            atvdao.create(atvmodel);
            atview.getjButtonCancelar().setEnabled(false);
            atview.limparCampos();
            atview.desabilitarB();
            atview.bloquearCampos();
            atview.preencherTabelas("SELECT *FROM atividades order by nome_atv");    
        
        }else{

            atvmodel.setCodigo(Integer.parseInt(atview.getjTextFieldCod().getText()));
            atvmodel.setNome(atview.getjTextFieldName().getText());
            atvmodel.setCurso((String) atview.getjComboBoxCursos().getSelectedItem());
            atvmodel.setDescricao(atview.getjTextAreaDescricao().getText());
            atvdao.editar(atvmodel);
            atview.getjButtonCancelar().setEnabled(false);
            atview.desabilitarB();
            atview.limparCampos();
            atview.preencherTabelas("SELECT *FROM atividades order by nome_atv");
            
            }
    
    }
    
    
    
    public void salvarUserButtonAct(){
        
        
        umodel.setUsername(uview.getjTextFieldUser().getText());
        umodel.setPassword(uview.getjPasswordFieldPt1().getText());
        umodel.setTipo((String) uview.getjComboBoxTipo().getSelectedItem());
        udao.create(umodel);
        a= new TelaPrincipal(null);
        a.show();
              
        
    }
       
        
   /* public void atualizarjTable(){
            
            tdao.preencherTabelas("SELECT *FROM atividades order by nome_atv");
            
    }*/
   
}

