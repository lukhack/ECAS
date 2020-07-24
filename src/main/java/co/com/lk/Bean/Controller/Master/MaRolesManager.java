/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller.Master;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Master.TbUiRol;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class MaRolesManager extends UiManager<TbUiRol>{
    
    
    public MaRolesManager() {
        super(new TbUiRol());
        findList();
    }

    @Override
    public List<TbUiRol> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
