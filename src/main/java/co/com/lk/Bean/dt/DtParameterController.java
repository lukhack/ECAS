/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmaparameter;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class DtParameterController extends UiManager<Dtmaparameter>{
    
    
    Dtmaparameter objData;
    
    public DtParameterController() {
        super(new Dtmaparameter());
        objData=new Dtmaparameter();
        findList();
    }

    @Override
    public List<Dtmaparameter> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmaparameter obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmaparameter> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }

    @Override
    public Dtmaparameter getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void newObject(){
        objData=new Dtmaparameter();
    }

    public Dtmaparameter getObjData() {
        return objData;
    }

    public void setObjData(Dtmaparameter objData) {
        this.objData = objData;
    }

   
    public String  reinit() throws Exception {
        setObj(new Dtmaparameter()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    
    
    
    
    
    
}
