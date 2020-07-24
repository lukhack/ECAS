/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.DtProcesoMaterialesEntity;
import co.com.lk.Entity.ma.Dtmaterialprocesado;
import co.com.lk.helper.facesMenssage;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author lukhack
 */
@Named
@ViewScoped
public class UiMaterialProceso extends UiManager<Dtmaterialprocesado> {
    @Inject
    UsuarioB usuario;
     
    @Inject
    UiTerceroTipoManager tipo;
    
    
    
    public UiMaterialProceso() {
        super(new Dtmaterialprocesado());
    }

    @Override
    public List<Dtmaterialprocesado> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void save(Dtmaterialprocesado obj, Integer tipoProceso, List<String> updateObjecView) {
        try{
            obj.setTipoproceso(tipoProceso);
            super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
    }
    
    
    public void save(Dtmaterialprocesado obj,DtProcesoMaterialesEntity materialesProcesos, Integer tipoProceso, List<String> updateObjecView) {
        try{
            Double pendienteProcesar=(materialesProcesos.getMaterialIngresado()-(materialesProcesos.getMaterialDesperdicio() + materialesProcesos.getMaterialProcesado()) );
            System.err.println("cantidad disponible: "+pendienteProcesar);
            obj.setTipoproceso(tipoProceso);
            
            if((obj.getCantidad()+obj.getDesperdicio()) > pendienteProcesar)
                throw new Exception("Los materiales procesados no pueden superar los materiales Ingresados + desperdicio");
            
            super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(3, ex.getMessage(), "");
        
        }
    }
    
    @Override
    public void save(Dtmaterialprocesado obj, List<String> updateObjecView) {
        try{
            super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(1, "Error procesando los datos", "");
        
        }
    }
    
    @Override
    public void saveList(List<Dtmaterialprocesado> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(1, "Error procesando los datos", "");
        
        }
        
    }
    
    @Override
    public String reinit(){
        
        getObj().setFecha(new Date());
        getObj().setTipoproceso(2);
        getObj().setUsuario_id(usuario.getTbUiUsuario());
        getObj().setDtEcaSucursalid(usuario.getTbUiUsuario().getDtecassucursal());
        getObj().setDesperdicio(0D);
        
        setObj(new Dtmaterialprocesado());
        return null;
    }

    @Override
    public Dtmaterialprocesado getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
