/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jv.Bean.component;

import java.io.Serializable;
import java.util.Objects;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import co.com.lk.Bean.dt.DtMaMaterialesController;
import co.com.lk.Entity.ma.Dtecamaterial;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
@FacesConverter(value = "materialConvert")
public class MaterialConvert implements Converter,Serializable {
    
    @Inject
    DtMaMaterialesController object;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equals("")) {
            try{
                DtMaMaterialesController service = (DtMaMaterialesController) fc.getViewRoot().getViewMap().get("dtMaMaterialesController");
               return service.getList().stream().filter(y->Objects.equals(y.getId(), Integer.valueOf(value))).findFirst().orElse(null);
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
            if(object != null && !Objects.equals(object, "")) {
                return String.valueOf(((Dtecamaterial) object).getId());
            }else{
                return null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }   

    public DtMaMaterialesController getObject() {
        return object;
    }

    public void setObject(DtMaMaterialesController object) {
        this.object = object;
    }
    
    
}        
