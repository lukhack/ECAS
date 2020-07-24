/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.ma.Dtterceroruta;
import co.com.lk.Entity.ma.Dttercerorutacoordenada;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class UiTerceroRutaCoordenadaManager extends UiManager<Dttercerorutacoordenada>{
    
    
    public UiTerceroRutaCoordenadaManager() {
        super(new Dttercerorutacoordenada());
        findList();
    }

    @Override
    public List<Dttercerorutacoordenada> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dttercerorutacoordenada obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dttercerorutacoordenada getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String reinit(Dtterceroruta Dttercero) throws Exception{
        getObj().setDtterceroruta(Dttercero);
        return super.reinit();
    }
   
    
    
    
    
}
