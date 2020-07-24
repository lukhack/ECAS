/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jv.Bean.component;

import co.com.lk.Entity.Master.TbUiRol;
import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.global.GlobalMaestros;
import co.com.lk.global.GlobalMenu;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author julig
 */

@Named
@ViewScoped
@FacesConverter(value = "usuarioConvert")
public class UserConvert implements Converter,Serializable {
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("")) {
            GlobalMaestros service = (GlobalMaestros) fc.getExternalContext().getApplicationMap().get("globalMaestros");
            try{
                TbUiUsuario ms=service.getUsuarios().stream().filter(x->x.getId()==Long.parseLong(value)).findAny().orElse(new TbUiUsuario());
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
                     return String.valueOf(((TbUiUsuario) object).getId());
                }else {
                    return null;
                }
        }catch(Exception ex){
                ex.printStackTrace();
                return null;
        }
    }   
}        
