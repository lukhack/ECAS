/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.session;

import co.com.lk.Entity.Master.TbUiModulo;
import co.com.lk.Entity.Master.TbUiUsuario;
import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@SessionScoped
public class UsuarioB implements  Serializable{
    TbUiUsuario tbUiUsuario;
    
   
    
    public UsuarioB() {
        tbUiUsuario = new TbUiUsuario();
        
    }
    
    
    
    public boolean getRenderModulo(int modulo){
        TbUiModulo u=tbUiUsuario.getMaModulos().stream().filter(x->x.getId()==modulo).findAny().orElse(null);
        return u!=null;
    }
    
    public boolean checkUsuario(){  
        try{
            ///System.out.println("cambie");
            TbUiUsuario tusuario =(TbUiUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
            
            return Objects.isNull(tusuario.getId());
        }catch(Exception ex){
            return true;
        }
    }
    
    public TbUiUsuario getTbUiUsuario() {
        return tbUiUsuario;
    }

    public void setTbUiUsuario(TbUiUsuario tbUiUsuario) {
        this.tbUiUsuario = tbUiUsuario;
    }
    
    
    
    
   
}
