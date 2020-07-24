/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.dt.Dtfacturadetalle;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import co.com.lk.Entity.dt.Dtfacturadetallematerial;
import javax.annotation.PostConstruct;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaFacturacionDetalleMaterialController extends UiManager<Dtfacturadetallematerial>{
    
    public DtMaFacturacionDetalleMaterialController() {
        super(new Dtfacturadetallematerial());
    }
    
    @PostConstruct
    public void init(){
        super.setObj(new Dtfacturadetallematerial());
    }

    @Override
    public List<Dtfacturadetallematerial> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtfacturadetallematerial obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtfacturadetallematerial> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }

    @Override
    public Dtfacturadetallematerial getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String  reinit(Dtfacturadetalle obj) throws Exception {
        getObj().setFacturaDetalle(obj);
        setObj(new Dtfacturadetallematerial());
        return null;
    }

    
    
    
    
    
    
}
