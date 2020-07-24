/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmacondicionsocial;
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
public class DtMaCodicionSocial extends UiManager<Dtmacondicionsocial>{
    
    
    Dtmacondicionsocial objData;
    
    public DtMaCodicionSocial() {
        super(new Dtmacondicionsocial());
        objData=new Dtmacondicionsocial();
        findList();
    }

    @Override
    public List<Dtmacondicionsocial> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmacondicionsocial obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmacondicionsocial> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    public void newObject(){
        objData=new Dtmacondicionsocial();
    }

    public Dtmacondicionsocial getObjData() {
        return objData;
    }

    public void setObjData(Dtmacondicionsocial objData) {
        this.objData = objData;
    }

   
    @Override
    public String  reinit() throws Exception {
        setObj(new Dtmacondicionsocial()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    
    
    
    
    
    
}
