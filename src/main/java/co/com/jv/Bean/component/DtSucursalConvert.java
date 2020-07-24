/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jv.Bean.component;

import co.com.lk.Bean.dt.DtECASucursalController;
import co.com.lk.Entity.ma.Dtecassucursal;
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

@ViewScoped
@Named
@FacesConverter(value = "sucursalConvert")
public class DtSucursalConvert implements Converter,Serializable {
    
    @Inject
    DtECASucursalController obj;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("")) {
            DtECASucursalController service = (DtECASucursalController) fc.getViewRoot().getViewMap().get("dtECASucursalController");
            try{
                System.err.println("data 1 : "+value);
                Dtecassucursal ms=obj.getList().stream().filter(x->Objects.equals(x.getId(), Integer.valueOf(value))).findAny().orElse(new Dtecassucursal());
                ms.getDtTercero().stream().forEach(x->{
                    System.err.println("nombre: "+x.getDocumento());
                });
                
                System.err.println("data 2: "+ms.getId());
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
            if(Objects.nonNull(object)) {
                return String.valueOf(((Dtecassucursal) object).getId());
            }else{
                return null;
            }
        }catch(Exception ex){
                ex.printStackTrace();
                return null;
        }
    }   
}        
