/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.IUBitacora;
import co.com.lk.Interfaces.genericImp;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;

/**
 *
 * @author julig
 */

@Named
@javax.faces.view.ViewScoped
public class bitacoraBean implements Serializable{
    IUBitacora bitacora;
    List<IUBitacora> bitacoras;
    
     private genericImp dao;
    public bitacoraBean() {
        bitacora =new IUBitacora();
        
        dao=new genericDAO();
        try {
            bitacoras=new  genericDAO().findAll(bitacora.getClass().getName());
        } catch (Exception ex) {    
            Logger.getLogger(bitacoraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IUBitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(IUBitacora bitacora) {
        this.bitacora = bitacora;
    }

    public List<IUBitacora> getBitacoras() {
        return bitacoras;
    }

    public void setBitacoras(List<IUBitacora> bitacoras) {
        this.bitacoras = bitacoras;
    }

    public genericImp getDao() {
        return dao;
    }

    public void setDao(genericImp dao) {
        this.dao = dao;
    }
    
    
    
    
    
    
}
