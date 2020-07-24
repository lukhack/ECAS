/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmamaterialgrupo;
import co.com.lk.Entity.ma.Dtmaparameter;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaMaterialesGrupoController extends UiManager<Dtmamaterialgrupo>{
    
    @Inject
    DtMaMaterialesCategoriaController maMaterialesController;
    
    
    public DtMaMaterialesGrupoController() {
        super(new Dtmamaterialgrupo());
        findList();
    }

    @Override
    public List<Dtmamaterialgrupo> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmamaterialgrupo obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmamaterialgrupo> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }

    @Override
    public Dtmamaterialgrupo getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selectObjec(Dtmamaterialgrupo obj) throws Exception {
        maMaterialesController.newObject();
        super.selectObjec(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    public void addSucursal(){
        try {
            getObj().getDtmamaterialList().add(maMaterialesController.getObj());
            maMaterialesController.newObejc(maMaterialesController.getObj());
        } catch (Exception ex) {
            Logger.getLogger(DtMaMaterialesGrupoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

   
    public String  reinit() throws Exception {
        setObj(new Dtmamaterialgrupo()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    

    public DtMaMaterialesCategoriaController getMaMaterialesController() {
        return maMaterialesController;
    }

    public void setMaMaterialesController(DtMaMaterialesCategoriaController maMaterialesController) {
        this.maMaterialesController = maMaterialesController;
    }

   
    
}
