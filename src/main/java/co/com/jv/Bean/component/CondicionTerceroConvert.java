/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jv.Bean.component;

import co.com.lk.Bean.dt.DtMaCodicionTercero;
import co.com.lk.Entity.ma.Dtmacondiciontercero;
import java.io.Serializable;
import java.util.Objects;
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
@Named
@ViewScoped
@FacesConverter(value = "condicionTerceroConvert")
public class CondicionTerceroConvert implements Converter,Serializable {
    @Inject
    DtMaCodicionTercero Obj;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("")) {
            try{
               return Obj.getList().stream().filter(y->Objects.equals(y.getId(), Integer.valueOf(value))).findFirst().orElse(null);
            }catch(Exception ex){   
               return null;
            }
        }else{
            System.err.println("suscursal 3");
            return null;
        }
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        try{ 
            if(object != null && !object.equals("")) {
                return String.valueOf(((Dtmacondiciontercero) object).getId());
            }else{
                return null;
            }
        }catch(Exception ex){
               //ex.printStackTrace();
                return null;
        }
    }   
}        
