
import co.com.lk.Bean.Controller.UiMaterialProceso;
import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.DtProcesoMaterialesEntity;
import co.com.lk.Entity.view.ViewMaterialProcesado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukhack
 */
@Named(value="dtProcesoMaterialesController")
@ViewScoped
public class DtProcesoMaterialesController extends UiManager<ViewMaterialProcesado> implements Serializable{
    @Inject
    UsuarioB usuario;
    
    @Inject
    UiMaterialProceso proceso;
    
    private List<DtProcesoMaterialesEntity> filterProcesos;
    private DtProcesoMaterialesEntity datosProcesados;
    public DtProcesoMaterialesController(){
        super(new ViewMaterialProcesado());
        
    }
    
    public List<DtProcesoMaterialesEntity> getListProcesos(List<String> notShowdataFilter){
        List<DtProcesoMaterialesEntity> data= new ArrayList<>();
        
        
        findLikeParameter(getObj().getClass().getName(), "FINDBYSURUCAL", usuario.getTbUiUsuario().getDtecassucursal().getId()).stream()
            .forEach(x->{
                DtProcesoMaterialesEntity materialesProcesos=  new DtProcesoMaterialesEntity();
                materialesProcesos.setMaterial(x.getDtMaterialid());
                materialesProcesos.setMaterialIngresado(x.getCantidadingreso());
                materialesProcesos.setMaterialDesperdicio(x.getCantidadDesperdicio());
                materialesProcesos.setMaterialProcesado(x.getCantidadProcesada());
                materialesProcesos.setCantidadventa(x.getCantidadventa());
                data.add(materialesProcesos);
        });
        
        return data;
    }
    
    
    public List<DtProcesoMaterialesEntity> getListEca(Integer eca){
        List<DtProcesoMaterialesEntity> data= new ArrayList<>();
        
        
        findLikeParameter(getObj().getClass().getName(), "FINDBYSURUCAL", eca).stream()
            .forEach(x->{
                DtProcesoMaterialesEntity materialesProcesos=  new DtProcesoMaterialesEntity();
                materialesProcesos.setMaterial(x.getDtMaterialid());
                materialesProcesos.setMaterialIngresado(x.getCantidadingreso());
                materialesProcesos.setMaterialDesperdicio(x.getCantidadDesperdicio());
                materialesProcesos.setMaterialProcesado(x.getCantidadProcesada());
                materialesProcesos.setCantidadventa(x.getCantidadventa());
                data.add(materialesProcesos);
        });
        
        return data;
    }
    
    public void selectObjec(DtProcesoMaterialesEntity materialesProcesos){
         proceso.getObj().setDtMaterial_id(materialesProcesos.getMaterial());
         proceso.getObj().setDtEcaSucursalid(usuario.getTbUiUsuario().getDtecassucursal());
         proceso.getObj().setUsuario_id(usuario.getTbUiUsuario());
         proceso.getObj().setTipoproceso(1);
         proceso.getObj().setFecha(new Date());
         this.datosProcesados=materialesProcesos;
         
    }

    public List<DtProcesoMaterialesEntity> getFilterProcesos() {
        return filterProcesos;
    }

    public void setFilterProcesos(List<DtProcesoMaterialesEntity> filterProcesos) {
        this.filterProcesos = filterProcesos;
    }

    public UiMaterialProceso getProceso() {
        return proceso;
    }

    public void setProceso(UiMaterialProceso proceso) {
        this.proceso = proceso;
    }

    public DtProcesoMaterialesEntity getDatosProcesados() {
        return datosProcesados;
    }

    public void setDatosProcesados(DtProcesoMaterialesEntity datosProcesados) {
        this.datosProcesados = datosProcesados;
    }

    
    
    
}



