/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dteca;
import co.com.lk.Entity.ma.Dtmaparameter;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtECASController extends UiManager<Dteca>{
    
    @Inject
    DtECASucursalController sucursalController;
    
    
    @Inject
    DtParameterController parameterController;
            
    
    public DtECASController() {
        super(new Dteca());
        findList();
    }

    @Override
    public List<Dteca> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dteca obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dteca> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }

    @Override
    public Dteca getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selectObjec(Dteca obj) throws Exception {
        parameterController.newObject();
        sucursalController.newObject();
        super.selectObjec(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    public void addSucursal(){
        try {
            getObj().getDtecassucursalList().add(sucursalController.getObj());
            sucursalController.newObejc(sucursalController.getObj());
        } catch (Exception ex) {
            Logger.getLogger(DtECASController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectParameter(List<Dtmaparameter> parameters){
        
        parameterController.setList(parameters);
    }

   
    
    
    public String  reinitParameter() throws Exception {
        parameterController.getList().add(parameterController.getObj());
        setObj(new Dteca()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public DtECASucursalController getSucursalController() {
        return sucursalController;
    }

    public void setSucursalController(DtECASucursalController sucursalController) {
        this.sucursalController = sucursalController;
    }

    public DtParameterController getParameterController() {
        return parameterController;
    }

    public void setParameterController(DtParameterController parameterController) {
        this.parameterController = parameterController;
    }

    
    
    
    
    
    
}
