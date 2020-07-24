/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller.Master;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Master.Mapatameter;
import co.com.lk.Entity.Master.Mapatametertipo;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class MaParamtersManager extends UiManager<Mapatameter>{
    
    Map<Mapatametertipo,Mapatameter> parameter;
    private boolean enposicion = false;
    
    public MaParamtersManager() {
        super(new Mapatameter());
        findList();
        
        parameter=new HashMap<>();
    }
    
    @PostConstruct
    public void init(){
       parameter= getList().stream().filter(x->x.getActivo()).collect(Collectors.toMap(Mapatameter::getTipo, x->x));
    }
    
    
    public   void  Increment(Mapatametertipo key) throws Exception{
        enposicion=true;
        
        Mapatameter pr=parameter.get(key);
        pr.setOldNumfactura(pr.getNumfactura());
        try {
            Integer increment= pr.getNumfactura() + 1 ;
            parameter.get(key).setNumfactura(increment);
            
            new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    while (enposicion == true) {
                        try {
                            // Esperar a apuntar
                            wait();
                        } catch (InterruptedException e) { }
                    }
                }
            }).start();
            
            
        } catch (Exception ex) {
            parameter.get(key).setNumfactura(pr.getOldNumfactura());
            throw new Exception("Se encontraron problemas al generar el consecutivo");
        
        }
        
    }
    
    
    public synchronized  void  Save(Mapatametertipo key) throws Exception{
        Mapatameter pr=parameter.get(key);
        try {
            save(parameter.get(key));
            enposicion=false;
            notify();
        } catch (Exception ex) {
            parameter.get(key).setNumfactura(pr.getOldNumfactura());
            enposicion=false;
            throw new Exception("Se encontraron problemas al generar el consecutivo");
        }
        
    }
    
    public synchronized void stopError(Mapatametertipo key) {
        Mapatameter pr=parameter.get(key);
        parameter.get(key).setNumfactura(pr.getOldNumfactura());
        
        enposicion=false;
        notify();
    }
    
    public synchronized void stop() {
        enposicion=false;
        notify();
    }

    public Map<Mapatametertipo, Mapatameter> getParameter() {
        return parameter;
    }

    public void setParameter(Map<Mapatametertipo, Mapatameter> parameter) {
        this.parameter = parameter;
    }

    
    
    
}
