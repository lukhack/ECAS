/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller.Master;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Master.Mapatametertipo;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class MaParamtersTipoManager extends UiManager<Mapatametertipo>{
    
    
    public MaParamtersTipoManager() {
        super(new Mapatametertipo());
        findList();
    }

    @Override
    public List<Mapatametertipo> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
