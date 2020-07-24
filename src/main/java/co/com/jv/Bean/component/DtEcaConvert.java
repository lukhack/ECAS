/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jv.Bean.component;

import co.com.lk.Bean.dt.DtECASController;
import co.com.lk.Entity.ma.Dteca;
import java.io.Serializable;
import java.util.Objects;
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

@FacesConverter(value = "ecasConvert")
@Named
@ViewScoped
public class DtEcaConvert implements Converter,Serializable {
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("")) {
            DtECASController service = (DtECASController) fc.getViewRoot().getViewMap().get("dtECASController");
            try{
                Dteca ms=service.getList().stream().filter(x->Objects.equals(x.getId(), Integer.valueOf(value))).findAny().orElse(new Dteca());
                System.err.println("suscursal 2: "+ms.getNombre());
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
                     return String.valueOf(((Dteca) object).getId());
                }else {
                    System.err.println("data 2: Null");
                    return null;
                }
        }catch(Exception ex){
                ex.printStackTrace();
                return null;
        }
    }   
}        
