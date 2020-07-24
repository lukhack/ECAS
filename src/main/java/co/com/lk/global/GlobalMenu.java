/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.global;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.TbUiModulo;
import co.com.lk.Entity.Master.TbUiRol;
import co.com.lk.Interfaces.genericImp;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class GlobalMenu implements Serializable{
    private List<TbUiModulo> modulos;
    private List<TbUiRol> roles;
    private genericImp dao;  
    public GlobalMenu() {
        try {
            dao = new genericDAO(); 
            modulos = dao.findAll(new TbUiModulo().getClass().getName());
            roles = dao.findAll(new TbUiRol().getClass().getName());
        } catch (Exception ex) {
            Logger.getLogger(GlobalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TbUiModulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<TbUiModulo> modulos) {
        this.modulos = modulos;
    }

    public List<TbUiRol> getRoles() {
        return roles;
    }

    public void setRoles(List<TbUiRol> roles) {
        this.roles = roles;
    }
    
    
    
    
}
