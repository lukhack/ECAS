/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Dtlista;
import co.com.lk.Entity.Dtlistadetalle;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class UiListaManager extends UiManager<Dtlista>{
    
    
    public UiListaManager() {
        super(new Dtlista());
        findList();
    }
    
    
    @PostConstruct
    public void init(){
    }
    
    @Override
    public List<Dtlista> getList() {
        return super.getList(); 
    }
    
    
    public List<Dtlistadetalle> getListKey(String listaKey) {
        Predicate<Dtlista> predicateForm=((Dtlista t) -> {
            return Objects.equals(t.getKeylist(), listaKey);
        });
        
        return super.getList().stream().filter(predicateForm).findFirst().orElse(new Dtlista()).getDtlistadetalleList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
    
    
    
}
