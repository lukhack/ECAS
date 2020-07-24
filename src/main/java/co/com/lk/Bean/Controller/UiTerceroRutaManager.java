/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.ma.Dtterceroruta;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class UiTerceroRutaManager extends UiManager<Dtterceroruta>{
    
    
    public UiTerceroRutaManager() {
        super(new Dtterceroruta());
        findList();
    }

    @Override
    public List<Dtterceroruta> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtterceroruta obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dtterceroruta getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String reinit(Dttercero tercero) throws Exception{
        getObj().setIdtercero(tercero);
        return super.reinit();
    }
    
    
    
}
