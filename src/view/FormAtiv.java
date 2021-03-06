/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionBD;
import controle.ButtonController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.Atividade;
import modeloBeans.Tabela;

/**
 *
 * @author reubber
 */
public class FormAtiv extends javax.swing.JFrame {

    /**
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * @return the Curso
     */
    public javax.swing.JLabel getCurso() {
        return Curso;
    }

    /**
     * @return the jButtonAlterar
     */
    public java.awt.Button getjButtonAlterar() {
        return jButtonAlterar;
    }

    /**
     * @return the jButtonCancelar
     */
    public javax.swing.JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    /**
     * @return the jButtonExcluir
     */
    public java.awt.Button getjButtonExcluir() {
        return jButtonExcluir;
    }

    /**
     * @return the jButtonNovo
     */
    public java.awt.Button getjButtonNovo() {
        return jButtonNovo;
    }

    /**
     * @return the jButtonSalvar
     */
    public java.awt.Button getjButtonSalvar() {
        return jButtonSalvar;
    }

    /**
     * @return the jComboBoxCat
     */
    public javax.swing.JComboBox<String> getjComboBoxCat() {
        return jComboBoxCat;
    }

    /**
     * @return the jComboBoxCursos
     */
    public javax.swing.JComboBox<String> getjComboBoxCursos() {
        return jComboBoxCursos;
    }

    /**
     * @return the jTableDadosAtividade
     */
    public javax.swing.JTable getjTableDadosAtividade() {
        return jTableDadosAtividade;
    }

    /**
     * @return the jTextAreaDescricao
     */
    public javax.swing.JTextArea getjTextAreaDescricao() {
        return jTextAreaDescricao;
    }

    /**
     * @return the jTextFieldCod
     */
    public javax.swing.JTextField getjTextFieldCod() {
        return jTextFieldCod;
    }

    /**
     * @return the jTextFieldName
     */
    public javax.swing.JTextField getjTextFieldName() {
        return jTextFieldName;
    }
        ConnectionBD conexao = new ConnectionBD();
        Atividade model;
        public ButtonController controller;
    
        private int flag =0;
    /**
     * Creates new form TelaCadAtiv
     */
    public FormAtiv() {
        
        initComponents();
        preencherTabelas("SELECT *FROM atividades order by nome_atv");
        definirCategoria();
    }
    
    public FormAtiv(String user) {
        
        initComponents();
        preencherTabelas("SELECT *FROM atividades order by nome_atv");
        definirCategoria();
        jLabelLoginA.setText(user);
    }
    
    
    
    
    public void preencherTabelas(String sql){
        
       
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID","Atividade","Solicitante","Curso","Descrição","Categoria","Situação"};
        conexao.getConexao();
        conexao.executaSql(sql);
       
        try
        {
          conexao.rs.first();
            do{
            dados.add(new Object[]{conexao.rs.getInt("cod_atv"),conexao.rs.getString("nome_atv"),conexao.rs.getString("matricula"),conexao.rs.getString("curso"),conexao.rs.getString("descricao"),conexao.rs.getString("categ_atv"),conexao.rs.getString("situacao")});
            
            }while(conexao.rs.next());
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList"+ex);
        }
        
        Tabela modelo = new Tabela(dados,colunas);
        getjTableDadosAtividade().setModel(modelo);
        configTabela();
    
        conexao.closeConnection();
}
    
    
    
    
    
    public void limparCampos(){                
        
        getjTextFieldName().setText("");
        getjTextAreaDescricao().setText("");
        getjComboBoxCursos().setSelectedItem(null);
        getjTextFieldCod().setText("");
        
    }
    
    public void permitirCampos(){
        getjTextFieldName().setEnabled(true);
        getjComboBoxCursos().setEnabled(true);
        getjTextAreaDescricao().setEnabled(true);
        getjComboBoxCat().setEnabled(true);
    }
    
    public void bloquearCampos(){
        getjTextFieldName().setEnabled(false);
        getjComboBoxCursos().setEnabled(false);
        getjTextAreaDescricao().setEnabled(false);
    }
    
    public void desabilitarB(){
        getjButtonSalvar().setEnabled(false);
        getjButtonAlterar().setEnabled(false);
        getjButtonExcluir().setEnabled(false);
        getjButtonSalvar().setEnabled(false);
    }
    
    public void allowButtton(){
        getjButtonSalvar().setEnabled(true);
        getjButtonCancelar().setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelLoginA = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelNomeAtv = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldCod = new javax.swing.JTextField();
        jLabelCat = new javax.swing.JLabel();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jComboBoxCursos = new javax.swing.JComboBox<>();
        Curso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelDescricao = new javax.swing.JLabel();
        jButtonNovo = new java.awt.Button();
        jButtonSalvar = new java.awt.Button();
        jButtonAlterar = new java.awt.Button();
        jButtonExcluir = new java.awt.Button();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDadosAtividade = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDataInicio = new javax.swing.JTextField();
        jTextFieldFim = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelPendente = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro Atividades");

        jLabelLoginA.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabelLoginA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelLoginA))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCodigo.setText("Cod.:");

        jLabelNomeAtv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNomeAtv.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNomeAtv.setText("Atividade:");

        jTextFieldName.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldName.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jTextFieldName.setEnabled(false);
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jTextFieldCod.setForeground(new java.awt.Color(102, 255, 102));
        jTextFieldCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldCod.setDisabledTextColor(new java.awt.Color(51, 255, 51));
        jTextFieldCod.setEnabled(false);
        jTextFieldCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodActionPerformed(evt);
            }
        });

        jLabelCat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCat.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCat.setText("Categoria:");

        jComboBoxCat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        jComboBoxCat.setEnabled(false);
        jComboBoxCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCatActionPerformed(evt);
            }
        });

        jComboBoxCursos.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jComboBoxCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Engenharia de Software", "Engenharia de Produção", "Engenharia Mecânica", "Engenharia Civil", "Ciência da Computação" }));
        jComboBoxCursos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jComboBoxCursos.setEnabled(false);
        jComboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursosActionPerformed(evt);
            }
        });

        Curso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Curso.setForeground(new java.awt.Color(102, 102, 102));
        Curso.setText("Curso:");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jTextAreaDescricao.setRows(5);
        jTextAreaDescricao.setBorder(null);
        jTextAreaDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaDescricaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabelDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDescricao.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDescricao.setText("Descrição: ");

        jButtonNovo.setBackground(new java.awt.Color(255, 102, 102));
        jButtonNovo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNovo.setLabel("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setLabel("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAlterar.setLabel("Editar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(255, 102, 102));
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setLabel("Excluir");
        jButtonExcluir.setName("Excluir"); // NOI18N
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTableDadosAtividade.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableDadosAtividade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableDadosAtividade.setGridColor(new java.awt.Color(255, 255, 255));
        jTableDadosAtividade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDadosAtividadeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDadosAtividade);

        jButtonSearch.setText("Pesquisar");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("matricula:");

        jLabel3.setText("Data inicio");

        jSeparator1.setForeground(new java.awt.Color(255, 153, 153));

        jSeparator2.setForeground(new java.awt.Color(255, 153, 153));

        jLabelPendente.setForeground(new java.awt.Color(255, 153, 51));
        jLabelPendente.setText(".");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoutMin.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelDescricao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelCodigo)
                                    .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelNomeAtv)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Curso))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addComponent(jTextFieldFim, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(516, 516, 516)
                                .addComponent(jButtonSearch))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(116, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldMat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDescricao)
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNomeAtv)
                                    .addComponent(jLabelCat)
                                    .addComponent(jLabelPendente))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(116, 116, 116))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void configTabela(){
        
        getjTableDadosAtividade().getColumnModel().getColumn(0).setPreferredWidth(30); 
        getjTableDadosAtividade().getColumnModel().getColumn(0).setResizable(false);
        getjTableDadosAtividade().getColumnModel().getColumn(1).setPreferredWidth(280);  
        getjTableDadosAtividade().getColumnModel().getColumn(1).setResizable(false);
        getjTableDadosAtividade().getColumnModel().getColumn(2).setPreferredWidth(85); 
        getjTableDadosAtividade().getColumnModel().getColumn(2).setResizable(false);
        getjTableDadosAtividade().getColumnModel().getColumn(3).setPreferredWidth(170);  
        getjTableDadosAtividade().getColumnModel().getColumn(3).setResizable(true);
        getjTableDadosAtividade().getColumnModel().getColumn(4).setPreferredWidth(399);  
        getjTableDadosAtividade().getColumnModel().getColumn(4).setResizable(true);
        getjTableDadosAtividade().getColumnModel().getColumn(5).setPreferredWidth(70);  
        getjTableDadosAtividade().getColumnModel().getColumn(5).setResizable(true);
        getjTableDadosAtividade().getColumnModel().getColumn(6).setPreferredWidth(70);  
        getjTableDadosAtividade().getColumnModel().getColumn(6).setResizable(true);
  
        getjTableDadosAtividade().getTableHeader().setReorderingAllowed(false);             //cmd onde desabilita a reodernar o cabeçalho
        getjTableDadosAtividade().setAutoResizeMode(getjTableDadosAtividade().AUTO_RESIZE_OFF);  //cmd onde usuario nao vai poder redimencionar essa tabela
        getjTableDadosAtividade().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //cmd onde ao clicar num campo na tabela so vai poder selecionar um por vez.
    
    
    
    
}
    
    
    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodActionPerformed

    private void jComboBoxCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCatActionPerformed

    private void jComboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCursosActionPerformed

    private void jTextAreaDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaDescricaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaDescricaoMouseClicked

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        controller.novoAtvButtonAct();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        controller.salvarAtvButtonAct();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        controller.editarAtvButtonAct();
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
       controller.excluirAtvButtonAct();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limparCampos();
        getjButtonSalvar().setEnabled(!true);
        getjTextFieldName().setEnabled(!true);
        getjComboBoxCursos().setEnabled(!true);
        getjButtonCancelar().setEnabled(!true);
        getjButtonNovo().setEnabled(true);
        getjButtonExcluir().setEnabled(false);
        getjButtonAlterar().setEnabled(false); 
        getjComboBoxCat().setEnabled(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTableDadosAtividadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDadosAtividadeMouseClicked
        
        String nome_atividade = ""+getjTableDadosAtividade().getValueAt(getjTableDadosAtividade().getSelectedRow(),1);
        conexao.getConexao();
        conexao.executaSql("SELECT *FROM atividades where nome_atv='"+nome_atividade+"'");
        
        try {

            conexao.rs.first();
            getjTextFieldCod().setText(String.valueOf(conexao.rs.getInt("cod_atv")));
            getjTextFieldName().setText(conexao.rs.getString("nome_atv"));
            getjComboBoxCursos().setSelectedItem(conexao.rs.getString("curso"));
            getjTextAreaDescricao().setText(conexao.rs.getString("descricao"));
            getjTextFieldMat().setText(conexao.rs.getString("matricula"));
            
            getjButtonAlterar().setEnabled(true);
            getjButtonExcluir().setEnabled(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao selecionar dados."+ex);
        }    }//GEN-LAST:event_jTableDadosAtividadeMouseClicked

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        controller.pesquisarAtvButtonAct();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.voltarTp();
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormAtiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAtiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAtiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAtiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAtiv().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Curso;
    private javax.swing.JButton jButton1;
    private java.awt.Button jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private java.awt.Button jButtonExcluir;
    private java.awt.Button jButtonNovo;
    private java.awt.Button jButtonSalvar;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JComboBox<String> jComboBoxCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCat;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelLoginA;
    private javax.swing.JLabel jLabelNomeAtv;
    private javax.swing.JLabel jLabelPendente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableDadosAtividade;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldDataInicio;
    private javax.swing.JTextField jTextFieldFim;
    private javax.swing.JTextField jTextFieldMat;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
    
   
    
    
    public void definirCategoria(){
    
    conexao.getConexao();
    conexao.executaSql("select *from categorias order by categ_nome");
    try {
        
        conexao.rs.first();
        getjComboBoxCat().removeAllItems();
        do{
           
        getjComboBoxCat().addItem(conexao.rs.getString("categ_nome"));
        
        }while(conexao.rs.next());
        
    }catch (SQLException ex) {
       JOptionPane.showMessageDialog(rootPane,"erro ao prencher categoria" +ex);
    }
    
    finally{
    conexao.closeConnection();
}

}

    /**
     * @return the jButtonSearch
     */
    public javax.swing.JButton getjButtonSearch() {
        return jButtonSearch;
    }

    /**
     * @return the jTextFieldPesquisar
     */
    public javax.swing.JTextField getjTextFieldPesquisar() {
        return jTextFieldPesquisar;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * @return the jTextFieldMat
     */
    public javax.swing.JTextField getjTextFieldMat() {
        return jTextFieldMat;
    }

    /**
     * @param jTextFieldMat the jTextFieldMat to set
     */
    public void setjTextFieldMat(javax.swing.JTextField jTextFieldMat) {
        this.jTextFieldMat = jTextFieldMat;
    }

    /**
     * @return the jLabelPendente
     */
    public javax.swing.JLabel getjLabelPendente() {
        return jLabelPendente;
    }

    /**
     * @param jLabelPendente the jLabelPendente to set
     */
    public void setjLabelPendente(javax.swing.JLabel jLabelPendente) {
        this.jLabelPendente = jLabelPendente;
    }

    /**
     * @return the jLabelLoginA
     */
    public javax.swing.JLabel getjLabelLoginA() {
        return jLabelLoginA;
    }

    /**
     * @param jLabelLoginA the jLabelLoginA to set
     */
    public void setjLabelLoginA(javax.swing.JLabel jLabelLoginA) {
        this.jLabelLoginA = jLabelLoginA;
    }
    
    
    
}