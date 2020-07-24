/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.pr;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.rp.PrComprasMes;
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
public class PrReporteFacturacionMesController extends UiManager<PrComprasMes>{

    public PrReporteFacturacionMesController(PrComprasMes obj) {
        super(obj);
    }
    
    
    PrReporteFacturacionMesController() {
       super(new PrComprasMes());
    }

   @PostConstruct
    public void init() {
        try{
            System.err.println("soy un error de datos");
        
        }catch(Exception ex){
        
        }
    }
    
    

    @Override
    public List<PrComprasMes> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    public List<PrComprasMes> findListId(Integer idtipoFactura, Integer ecaSurcursal){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLTIPOFACTURA", idtipoFactura,ecaSurcursal);
    }
    
    public List<PrComprasMes> findListIdAsc(Integer idtipoFactura, Integer ecaSurcursal){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLTIPOFACTURAASC", idtipoFactura,ecaSurcursal);
    }
    
    
    
    
    
    
    
    
}
