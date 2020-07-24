/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Master.Uitercero;
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
public class UiTerceroManager extends UiManager<Uitercero>{
    
    @Inject
    UiTerceroTipoManager tipo;
    
    public UiTerceroManager() {
        super(new Uitercero());
        findList();
    }

    @Override
    public List<Uitercero> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Uitercero obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
    
}
