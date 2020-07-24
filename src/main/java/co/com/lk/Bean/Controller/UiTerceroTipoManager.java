/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dttercerotipo;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class UiTerceroTipoManager extends UiManager<Dttercerotipo>{
    
    
    public UiTerceroTipoManager() {
        super(new Dttercerotipo());
        findList();
    }

    @Override
    public List<Dttercerotipo> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dttercerotipo obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dttercerotipo getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
