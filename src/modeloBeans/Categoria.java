/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;


public class Categoria {
   private int id_cat;
   private String Nome;
   private int horas;

    /**
     * @return the id_cat
     */
    public int getId_cat() {
        return id_cat;
    }

    /**
     * @param id_cat the id_cat to set
     */
    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }
   
}
