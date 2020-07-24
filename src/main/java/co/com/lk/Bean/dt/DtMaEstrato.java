/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtmaestrato;
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
public class DtMaEstrato extends UiManager<Dtmaestrato>{
    
    
    
    public DtMaEstrato() {
        super(new Dtmaestrato());
        findList();
    }

    @Override
    public List<Dtmaestrato> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtmaestrato obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtmaestrato> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
   
   
    public String  reinit() throws Exception {
        setObj(new Dtmaestrato()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    
    
    
    
    
    
}
