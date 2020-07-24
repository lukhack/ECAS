/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmaestadocivil;
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
public class DtMaEstadoCivil extends UiManager<Dtmaestadocivil>{
    
    
    Dtmaestadocivil objData;
    
    public DtMaEstadoCivil() {
        super(new Dtmaestadocivil());
        objData=new Dtmaestadocivil();
        findList();
    }

    @Override
    public List<Dtmaestadocivil> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmaestadocivil obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmaestadocivil> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    public void newObject(){
        objData=new Dtmaestadocivil();
    }

    public Dtmaestadocivil getObjData() {
        return objData;
    }

    public void setObjData(Dtmaestadocivil objData) {
        this.objData = objData;
    }

   
    public String  reinit() throws Exception {
        setObj(new Dtmaestadocivil()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    
    
    
    
    
    
}
