/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.component;
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
@FacesConverter("booleanConverter") 
public class booleanConverter implements Converter,Serializable{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         Boolean result = Boolean.parseBoolean(value);
        System.out.println("#BooleanToYNConverter.getAsObject param is: " + value);
        return result;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("#BooleanToYNConverter.getAsObject param is: " + value);
         if ((value != null) && ((Boolean) value)) {
                System.out.println("#BooleanToYNConverter.getAsString returns Y");
                return "true";
            } else {
                System.out.println("#BooleanToYNConverter.getAsString returns N");
                return "false";
            }
    }

}
