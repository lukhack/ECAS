/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller.Master;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Master.Mabarrio;
import java.io.Serializable;
import java.util.List;
import java.util.PropertyResourceBundle;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class MaPropertiesBungleManager implements  Serializable{
    
    
    public MaPropertiesBungleManager() {
       
    }

    
    
    public PropertyResourceBundle getBundle(String nameBean) {  
        FacesContext context = FacesContext.getCurrentInstance(); 
        return context.getApplication().evaluateExpressionGet(context, nameBean, PropertyResourceBundle.class); 
    } 
    
    
}
