/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import façade.Facade;
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
     
    TelaPrincipal aview = new TelaPrincipal();
     Atividade atvmodel;
     FormAtiv atview;
     TelaCadUser uview;
     Usuario umodel;
     AtividadeDao atvdao = new AtividadeDao();
     UsuarioDao udao = new UsuarioDao();
     Facade facade = new Facade();
     
     
    
    
    
    public ButtonController(TelaCadUser view, Usuario model){
        this.umodel = model;
        this.uview = view;
    }
    
    public ButtonController(FormAtiv view,Atividade model){
        this.atvmodel = model;
        this.atview = view;
    }
    
    public ButtonController(TelaPrincipal view){
        
        this.aview = view;
    }
    
    
    
    public void pesquisarAtvButtonAct(){
        
        
        atvmodel.setPesquisa(atview.getjTextFieldPesquisar().getText());
        Atividade atv;
        
        atv = facade.pesquisar(atvmodel);
        atview.getjTextFieldCod().setText(String.valueOf(atv.getCodigo()));
        atview.getjTextFieldName().setText(atv.getNome());
        atview.getjTextAreaDescricao().setText(atv.getDescricao());
        atview.getjComboBoxCursos().setSelectedItem(atv.getCurso());
        atview.getjTextFieldMat().setText(atv.getAluno());
        atview.getjLabelPendente().setText(atv.getSituacao());
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
            facade.excluir(atvmodel);
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
            atvmodel.setCategoria((String)atview.getjComboBoxCat().getSelectedItem());
            atvmodel.setAluno(atview.getjTextFieldMat().getText());
            atvmodel.setSituacao("pendente");
            
            facade.create(atvmodel);
            atview.getjButtonCancelar().setEnabled(false);
            atview.getjComboBoxCat().setEnabled(false);
            atview.limparCampos();
            atview.desabilitarB();
            atview.bloquearCampos();
            atview.preencherTabelas("SELECT *FROM atividades order by nome_atv");    
        
        }else{

            atvmodel.setCodigo(Integer.parseInt(atview.getjTextFieldCod().getText()));
            atvmodel.setNome(atview.getjTextFieldName().getText());
            atvmodel.setCurso((String) atview.getjComboBoxCursos().getSelectedItem());
            atvmodel.setDescricao(atview.getjTextAreaDescricao().getText());
            atvmodel.setCategoria((String)atview.getjComboBoxCat().getSelectedItem());
            facade.editar(atvmodel);
            atview.getjButtonCancelar().setEnabled(false);
            atview.desabilitarB();
            atview.limparCampos();
            atview.preencherTabelas("SELECT *FROM atividades order by nome_atv");
            
            }
    
    }
    
    
    
    public void salvarUserButtonAct(){
        
        if(uview.getjTextFieldUser().getText().isEmpty()&&uview.getjPasswordFieldPt1().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"algum campo vazio");
            uview.getjTextFieldUser().requestFocus();
        }
        
        if(uview.getjPasswordFieldPt2().getText().equals(uview.getjPasswordFieldPt1().getText())){
       
            umodel.setUsername(uview.getjTextFieldUser().getText());
            umodel.setPassword(uview.getjPasswordFieldPt1().getText());
            umodel.setTipo((String) uview.getjComboBoxTipo().getSelectedItem());
            facade.createUser(umodel);   
            aview = new TelaPrincipal(uview.getjLabelLogin().getText());
            aview.show();
            uview.dispose();
        
                }else{
             JOptionPane.showMessageDialog(null, "erro ao confirmar senha do usuario corretamente");
            uview.getjPasswordFieldPt1().setText("");
            uview.getjPasswordFieldPt2().setText("");
            uview.getjPasswordFieldPt2().requestFocus();
        
        
        
        
        }
        
    }
       public void voltarTp(){
           aview = new TelaPrincipal(atview.getjLabelLoginA().getText());
           atview.dispose();
           aview.show();
       }
    
    
       public void butaoAcessarAct(){
        
            aview=udao.consulta();
            
       
   
}
}

