/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionBD;
import controle.ButtonController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.Atividade;
import modeloBeans.Usuario;

/**
 *
 * @author sKY_FALL
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenu
     */
     ConnectionBD conecta = new ConnectionBD();
     ButtonController controller;
    
    public TelaPrincipal(String user) {
        
        initComponents();
        conecta.getConexao();
        jLabelUser.setText(user);
    }

    public TelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBG = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanelCabeçalho = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jLabelHead = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelBG.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(85, 65, 117));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanelBG.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, 210, 640));

        jPanelCabeçalho.setBackground(new java.awt.Color(255, 153, 153));

        button1.setLabel("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("button2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCabeçalhoLayout = new javax.swing.GroupLayout(jPanelCabeçalho);
        jPanelCabeçalho.setLayout(jPanelCabeçalhoLayout);
        jPanelCabeçalhoLayout.setHorizontalGroup(
            jPanelCabeçalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeçalhoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        jPanelCabeçalhoLayout.setVerticalGroup(
            jPanelCabeçalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeçalhoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelCabeçalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanelBG.add(jPanelCabeçalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 610, 130));

        jLabelHead.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelHead.setText("Sistema de Gerenciamento das Atividades Complementares");
        jPanelBG.add(jLabelHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        jLabel1.setText("Seja Bem-vindo");
        jPanelBG.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabelUser.setText("jLabel2");
        jPanelBG.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
       FormAtiv view = new FormAtiv();
       Atividade model = new Atividade();
       controller = new ButtonController(view,model);
       view.controller = this.controller;
       view.setVisible(true);
       dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
         
        try{
            conecta.getConexao();
            conecta.executaSql("SELECT *FROM usuarios where user_nome='"+getjLabelUser().getText()+"'");
            conecta.rs.first();
            
            if(conecta.rs.getString("user_tipo").equals("Coordenador")){
                
                TelaCadUser uview = new TelaCadUser();
                Usuario model = new Usuario();
                controller = new ButtonController(uview,model);
                uview.controller = this.controller;
                uview.setVisible(true);
                dispose();
                
            }else{
                JOptionPane.showMessageDialog(null, "vc nao tem permissao");
            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"vc nao tem permissao"+ ex);
        }
    }//GEN-LAST:event_button2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label jLabelHead;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBG;
    private javax.swing.JPanel jPanelCabeçalho;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jLabelUser
     */
    public javax.swing.JLabel getjLabelUser() {
        return jLabelUser;
    }
}