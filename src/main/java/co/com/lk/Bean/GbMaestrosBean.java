/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Interfaces.genericImp;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Likas
 */
@Named
@ApplicationScoped
public class GbMaestrosBean  implements  Serializable{
    
    
    
    private genericImp dao;    
    
    public GbMaestrosBean() {
        dao = new genericDAO(); 
        
    }
    
    @PostConstruct
    public void init(){
        try{
        }catch(Exception ex){
            
        }
    }

    public genericImp getDao() {
        return dao;
    }

    public void setDao(genericImp dao) {
        this.dao = dao;
    }
    
    
    
    
 }
