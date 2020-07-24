/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.history.Dtecamateriahisotirall;
import co.com.lk.Entity.ma.Dtecamaterial;
import co.com.lk.helper.facesMenssage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaMaterialesController extends UiManager<Dtecamaterial>{
    @Inject
    UsuarioB usuario;
    
    
    double valorCompra;
    double valorVenta;
    
    public DtMaMaterialesController() {
        super(new Dtecamaterial());
        findList();
    }

    @Override
    public List<Dtecamaterial> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Dtecamaterial> getListMaterialEca() {
        return super.getList().stream().filter(x-> Objects.equals(x.getEcaSucursal().getId(), usuario.getTbUiUsuario().getDtecassucursal().getId())).collect(Collectors.toList()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtecamaterial obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save(Dtecamaterial obj) {
        super.save(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtecamaterial> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }

    @Override
    public Dtecamaterial getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String  reinit() throws Exception {
        
        getObj().setEcaSucursal(usuario.getTbUiUsuario().getDtecassucursal());
        getObj().setFecha(new Date());
        if(Objects.nonNull(getObj().getId())){
            System.err.println("soy lukas");
            if(!(Objects.equals(getObj().getValorCompra(), valorCompra) && Objects.equals(getObj().getValorVenta(), valorVenta))){
                System.err.println("soy sisu");
                if(Objects.isNull(getObj().getDtecahistorial())){
                    getObj().setDtecahistorial(new ArrayList<>());
                }
                Dtecamateriahisotirall dtecamateriahisotirall=new Dtecamateriahisotirall();

                dtecamateriahisotirall.setDtecamateria_id(getObj());
                dtecamateriahisotirall.setUsuario_id(usuario.getTbUiUsuario());
                dtecamateriahisotirall.setValorCompra(valorCompra);
                dtecamateriahisotirall.setValorVenta(valorVenta);
                dtecamateriahisotirall.setFecha(new Date());
                getObj().getDtecahistorial().add(dtecamateriahisotirall);
                System.err.println("soy sisus");
            }
        }
        
        
        
        save(getObj());
        setObj(new Dtecamaterial()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }
   
    public Dtecamaterial addObjs(Dtecamaterial obj) {
        obj.setEcaSucursal(usuario.getTbUiUsuario().getDtecassucursal());
        System.err.println("data: "+obj.getEcaSucursal().getId());
        super.setObj(obj); //To change body of generated methods, choose Tools | Templates.
        return super.getObj();
    }

    @Override
    public List<Dtecamaterial> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selectObjec(Dtecamaterial obj) throws Exception {
        valorCompra=obj.getValorCompra();
        valorVenta=obj.getValorVenta();
        
        super.selectObjec(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
    
}
