/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sKY_FALL
 */
public  class Tabela extends AbstractTableModel{
    private ArrayList linhas;
    private String[] colunas;
    
    
    public Tabela(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }

   
    public int getColumnCount(){
        return colunas.length;
    }
    
    
    public int getRowCount(){
        return linhas.size();
    }
    
    
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
   
    public Object getValueAt(int numLin, int numCol){
       Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
    
    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
}
