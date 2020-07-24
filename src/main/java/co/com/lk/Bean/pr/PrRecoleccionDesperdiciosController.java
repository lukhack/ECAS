/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.pr;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.pr.PrRecoleccionDesperdicio;
import java.util.Date;
import java.util.List;import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class PrRecoleccionDesperdiciosController extends UiManager<PrRecoleccionDesperdicio>{
        
    @Inject
    UsuarioB usuario;
  
    
    public PrRecoleccionDesperdiciosController() {
        super(new PrRecoleccionDesperdicio());
        //findList();
    }

    @Override
    public List<PrRecoleccionDesperdicio> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(PrRecoleccionDesperdicio obj) {
        try {
            obj.setFecharecoleccion(new Date());
            obj.setUsuario_id(usuario.getTbUiUsuario());
            obj.setEcasucursal_id(usuario.getTbUiUsuario().getDtecassucursal());
            
            super.save(obj); //To change body of generated methods, choose Tools | Templates.
            newObejc(new PrRecoleccionDesperdicio());
        } catch (Exception ex) {
            Logger.getLogger(PrRecoleccionDesperdiciosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<PrRecoleccionDesperdicio> findListDetalleEca(Integer ecasucursal){
        System.err.println("Data sucursal: "+ecasucursal);
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLXECA", ecasucursal);
    }
}
