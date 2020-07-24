/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmamediotransporte;
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
public class DtMaMedioTransporte extends UiManager<Dtmamediotransporte>{
    
    
    Dtmamediotransporte objData;
    
    public DtMaMedioTransporte() {
        super(new Dtmamediotransporte());
        objData=new Dtmamediotransporte();
        findList();
    }

    @Override
    public List<Dtmamediotransporte> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmamediotransporte obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmamediotransporte> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    public void newObject(){
        objData=new Dtmamediotransporte();
    }

    public Dtmamediotransporte getObjData() {
        return objData;
    }

    public void setObjData(Dtmamediotransporte objData) {
        this.objData = objData;
    }

   
    public String  reinit() throws Exception {
        setObj(new Dtmamediotransporte()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public List<Dtmamediotransporte> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
}
