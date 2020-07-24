/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.dt.DtMaFacturacionDetalleMaterialController;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.dt.Dtmaterialseparacion;
import co.com.lk.helper.facesMenssage;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author lukhack
 */
@Named(value="uiMateriaSeparacion")
@ViewScoped
public class UiMaterialSeparacion extends UiManager<Dtmaterialseparacion> {
    
    @Inject
    UsuarioB usuario;
     
    @Inject
    UiTerceroTipoManager tipo;
    
    @Inject
    UiMaterialProceso materialProcesado;
    
    
    @Inject
    DtMaFacturacionDetalleMaterialController materiaPresentacionController;
    
    public UiMaterialSeparacion() {
        super(new Dtmaterialseparacion());
        
    }
    
    @PostConstruct
    public void init(){
        getObj().setFecha(new Date());
        getObj().setUsuarioId(usuario.getTbUiUsuario());
        getObj().setDtEcassucursalid(usuario.getTbUiUsuario().getDtecassucursal());
    }

    @Override
    public List<Dtmaterialseparacion> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmaterialseparacion obj, List<String> updateObjecView) {
        try{
            if(!(getObj().getDtmaterialprocesadoCollection().size()>0))
                throw new Exception("debes ingresar como mínimo un material de separación");
            
            super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            String mensaje = Objects.nonNull(ex.getMessage())?ex.getMessage():"";
            facesMenssage.addMensaje(1, "Error procesando los datos " + mensaje, "");
        
        }
        
    }
    
    @Override
    public void saveList(List<Dtmaterialseparacion> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    @Override
    public String reinit(){
        materialProcesado.reinit();
        return null;
    }

    public UiMaterialProceso getMaterialProcesado() {
        return materialProcesado;
    }

    public void setMaterialProcesado(UiMaterialProceso materialProcesado) {
        this.materialProcesado = materialProcesado;
    }

    @Override
    public Dtmaterialseparacion getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }

    public DtMaFacturacionDetalleMaterialController getMateriaPresentacionController() {
        return materiaPresentacionController;
    }

    public void setMateriaPresentacionController(DtMaFacturacionDetalleMaterialController materiaPresentacionController) {
        this.materiaPresentacionController = materiaPresentacionController;
    }
    
    
    
    
}
