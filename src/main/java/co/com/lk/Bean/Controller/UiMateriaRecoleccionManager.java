/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.dt.Dtmaterialrecoleccion;
import co.com.lk.helper.facesMenssage;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class UiMateriaRecoleccionManager extends UiManager<Dtmaterialrecoleccion>{
    @Inject
    UsuarioB usuario;
     
    @Inject
    UiTerceroTipoManager tipo;
    
    public UiMateriaRecoleccionManager() {
        super(new Dtmaterialrecoleccion());
        findList();
    }

    @Override
    public List<Dtmaterialrecoleccion> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmaterialrecoleccion obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void saveList(List<Dtmaterialrecoleccion> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    public String reinit(){
        getObj().setFecha(new Date());
        getObj().setDtEcassucursalid(usuario.getTbUiUsuario().getDtecassucursal());
        return null;
    }
    
    
}
