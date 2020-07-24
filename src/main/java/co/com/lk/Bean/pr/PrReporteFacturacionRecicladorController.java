/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.pr;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.rp.Prfacturadetalle;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class PrReporteFacturacionRecicladorController extends UiManager<Prfacturadetalle>{

    public PrReporteFacturacionRecicladorController(Prfacturadetalle obj) {
        super(obj);
    }
    
    
    PrReporteFacturacionRecicladorController() {
       super(new Prfacturadetalle());
    }

   @PostConstruct
    public void init() {
        try{
            System.err.println("soy un error de datos");
        
        }catch(Exception ex){
        
        }
    }
    
    

    @Override
    public List<Prfacturadetalle> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    public List<Prfacturadetalle> findListId(Integer idtipoFactura, Integer idsucursal,String mes,String anio){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLXRECICLADORMESDIA", idtipoFactura,idsucursal,mes,anio);
    }
    
    
    
    
    
    
    
    
}
