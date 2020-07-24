/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jv.Bean.component;

import co.com.lk.Entity.Master.TbUiRol;
import co.com.lk.global.GlobalMenu;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author julig
 */

@FacesConverter(value = "rolConvert")
@ViewScoped
@Named
public class RolConvert implements Converter,Serializable {
    
    @Inject
    GlobalMenu globalMenu;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("")) {
            try{
                TbUiRol ms=globalMenu.getRoles().stream().filter(x->x.getId()==Long.parseLong(value)).findAny().orElse(new TbUiRol());
                //System.err.println("suscursal 2: "+ms.getNombre());
                return  ms;
            }catch(Exception ex){
                ex.printStackTrace();
                return null;
            }
         }
        else {
            System.err.println("suscursal 3");
            return null;
        }
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        try{ 
            
                if(object != null && !object.equals("")) {
                    System.err.println("data 2: "+((TbUiRol) object).getId());
                     return String.valueOf(((TbUiRol) object).getId());

                }else {
                    System.err.println("data 2: Null");
                    
                    return null;
                }
        }catch(Exception ex){
                ex.printStackTrace();
                return null;
        }
    }  

    public GlobalMenu getGlobalMenu() {
        return globalMenu;
    }

    public void setGlobalMenu(GlobalMenu globalMenu) {
        this.globalMenu = globalMenu;
    }
    
    
}        
