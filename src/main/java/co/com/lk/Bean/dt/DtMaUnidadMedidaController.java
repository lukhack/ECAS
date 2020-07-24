/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmaunidadmedida;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaUnidadMedidaController extends UiManager<Dtmaunidadmedida>{
    
    
    Dtmaunidadmedida objData;
    
    public DtMaUnidadMedidaController() {
        super(new Dtmaunidadmedida());
        objData=new Dtmaunidadmedida();
        findList();
    }

    @Override
    public List<Dtmaunidadmedida> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmaunidadmedida obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmaunidadmedida> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    public void newObject(){
        objData=new Dtmaunidadmedida();
    }

    public Dtmaunidadmedida getObjData() {
        return objData;
    }

    public void setObjData(Dtmaunidadmedida objData) {
        this.objData = objData;
    }

   
    public String  reinit() throws Exception {
        setObj(new Dtmaunidadmedida()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    
    
    
    
    
    
}
