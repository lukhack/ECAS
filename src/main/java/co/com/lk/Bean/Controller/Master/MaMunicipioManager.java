/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller.Master;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Master.Mamunicipio;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.omnifaces.cdi.Eager;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class MaMunicipioManager extends UiManager<Mamunicipio>{
    
    
    public MaMunicipioManager() {
        super(new Mamunicipio());
        findList();
    }

    @Override
    public List<Mamunicipio> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Mamunicipio obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
