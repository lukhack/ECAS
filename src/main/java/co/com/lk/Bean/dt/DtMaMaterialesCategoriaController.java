/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmamaterialgrupo;
import co.com.lk.Entity.ma.Dtmamaterial;
import co.com.lk.helper.facesMenssage;
import co.com.lk.Entity.ma.Dtecamaterial;
import java.util.List;
import java.util.Objects;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaMaterialesCategoriaController extends UiManager<Dtmamaterial>{
    
    
    Dtecamaterial objData;
    
    @Inject
    MapsBean gmap;
    
    public DtMaMaterialesCategoriaController() {
        super(new Dtmamaterial());
        objData=new Dtecamaterial();
        findList();
    }
    
    
    public Dtmamaterial findMaterialId(Integer id){
        return getList().stream().filter(x->Objects.equals(x.getId(), id)).findAny().orElse(new Dtmamaterial());
    }

    @Override
    public List<Dtmamaterial> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmamaterial obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmamaterial> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }
    
    public void newObject(){
        objData=new Dtecamaterial();
    }

    public Dtecamaterial getObjData() {
        return objData;
    }

    public void setObjData(Dtecamaterial objData) {
        this.objData = objData;
    }

    
    public String  reinit(Dtmamaterialgrupo dt) throws Exception {
        System.err.println("data");
        getObj().setDtmagrupomaterial(dt);
        setObj(new Dtmamaterial()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public MapsBean getGmap() {
        return gmap;
    }

    public void setGmap(MapsBean gmap) {
        this.gmap = gmap;
    }

    
    
    
    
    
    
}
