/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.dt.Dtfactura;
import co.com.lk.Entity.dt.Dtfacturadetalle;
import co.com.lk.Entity.ma.Dteca;
import co.com.lk.helper.facesMenssage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaFacturacionDetalleController extends UiManager<Dtfacturadetalle>{
    
    List<Dtfacturadetalle> listDetalle;
    public DtMaFacturacionDetalleController() {
        super(new Dtfacturadetalle());
    }
    
    @PostConstruct
    public void init(){
        super.setObj(new Dtfacturadetalle());
        listDetalle=new ArrayList<>();
    }

    @Override
    public List<Dtfacturadetalle> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtfacturadetalle obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtfacturadetalle> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }

    @Override
    public Dtfacturadetalle getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    public String  reinit(Dtfactura factura) throws Exception {
        getObj().setDtFacturaVentaid(factura);
        setObj(new Dtfacturadetalle()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    public List<Dtfacturadetalle> findListDetalleEca(Dteca eca){
        listDetalle=super.findLikeParameter(getObj().getClass().getName(), "FINDALLXECAXDETALLETIPOFACTURA", eca.getId());
        return listDetalle;
    }
    
    public List<Dtfacturadetalle> findListDetalleId(Integer idtipoFactura, Integer ecasucursal, String mes, String anio){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLXCLIENTEXTIPOFACTURAMESDIA", idtipoFactura,ecasucursal,mes,anio);
    }
    
    
    public List<Dtfacturadetalle> findListDetalleIdFecha(Integer idtipoFactura, Integer ecasucursal, Date fecha){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLXCLIENTEXTIPOFACTURAFECHA", idtipoFactura,ecasucursal,fecha);
    }

    public List<Dtfacturadetalle> findListDetalleRecilador(Integer idtipoFactura, Integer ecasucursal, String mes, String anio){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLXCLIENTEXTIPOFACTURAMESDIARECICLADOR", idtipoFactura,ecasucursal,mes,anio);
    }
    
    public List<Dtfacturadetalle> findListDetalleEca(Integer ecasucursal){
        return super.findLikeParameter(getObj().getClass().getName(), "FINDALLXECAXTIPOFACTURA", ecasucursal);
    }

    public List<Dtfacturadetalle> getListDetalle() {
        return listDetalle;
    }

    public void setListDetalle(List<Dtfacturadetalle> listDetalle) {
        this.listDetalle = listDetalle;
    }
    
    
    
    
    
}
