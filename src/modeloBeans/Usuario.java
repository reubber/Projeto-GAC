/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

/**
 *
 * @author rBBr
 */

public class Usuario {
    private Integer id;
    private String username;
    private String password;
    private String tipo;

    /**
     * @return the username
     */
    
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    
    public void setId(Integer id) {
        this.id = id;
    }

}
