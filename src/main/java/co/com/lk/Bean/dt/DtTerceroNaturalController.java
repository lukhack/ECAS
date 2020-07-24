/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.Controller.UiTerceroRutaManager;
import co.com.lk.Bean.Controller.UiTerceroTipoManager;
import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.ma.Dtterceronatural;
import co.com.lk.Entity.ma.Dtterceroruta;
import co.com.lk.connection.NewHibernateUtil;
import java.util.List;
import java.util.Objects;
import co.com.lk.helper.facesMenssage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
//import org.primefaces.PrimeFaces;
/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtTerceroNaturalController extends UiManager<Dtterceronatural>{
    
    @Inject
    DtTerceroController tercero;
    
    @Inject
    UiTerceroRutaManager rutaManager;
    
    @Inject
    UiTerceroTipoManager tipoTercero;
    
    List<Dtterceroruta> listRuta;
    
    @Inject
    UsuarioB usuario;
     
    public DtTerceroNaturalController() {
        super(new Dtterceronatural());
        getObj().setDttercero(new Dttercero());
        findList();
    }

   

    @Override
    public void save(Dtterceronatural obj) {
         try{
            
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                
                try{
                    Transaction tr = session.getTransaction();
                    tr.begin();
                    
                    AtomicReference<String> exception=new AtomicReference<>("");
                    
                    try{
                        session.saveOrUpdate(obj.getDttercero());
                        obj.getDttercero().setDtterceronatural(obj);
                    }catch(Exception ex){
                        exception.set(ex.getMessage());
                    }
                    
                    if(Objects.equals(exception,""))
                        throw  new Exception(exception.get());
                    
                    tr.commit();
                }catch(Exception ex){
                    ex.printStackTrace();
                    session.getTransaction().rollback();
                    throw new Exception("Error procesando los datos");
                }finally{
                    if(session != null){
                        session.close();
                    }
                }
            }catch(Exception ex){
                throw new Exception(ex.getMessage());
            }
            
           
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(1, "Error procesando los datos "+ex.getMessage(), "");
        }
    }
    
    
    

   @Override
    public void saveList(List<Dtterceronatural> obj) throws Exception {
        try{
            
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                
                try{
                    Transaction tr = session.getTransaction();
                    tr.begin();
                    
                    AtomicReference<String> exception=new AtomicReference<>("");
                    
                    obj.stream().forEach(x->{
                        try{
                            session.saveOrUpdate(x.getDttercero());
                            x.getDttercero().setDtterceronatural(x);
                        }catch(Exception ex){
                            exception.set(ex.getMessage());
                        }
                    });
                    
                    if(Objects.equals(exception,""))
                        throw  new Exception(exception.get());
                    
                    tr.commit();
                }catch(Exception ex){
                    ex.printStackTrace();
                    session.getTransaction().rollback();
                    throw new Exception("Error procesando los datos");
                }finally{
                    if(session != null){
                        session.close();
                    }
                }
            }catch(Exception ex){
                throw new Exception(ex.getMessage());
            }
            
           
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(1, "Error procesando los datos "+ex.getMessage(), "");
        }
    }
    
    public List<Dttercero> listTerceros(){
        return getList().stream().map(x->x.getDttercero()).collect(Collectors.toList());
    }
    
    public Dtterceronatural addObj(Dtterceronatural obj){
        System.err.println(usuario.getTbUiUsuario().getDtecassucursal().getId()+"data 1: "+obj.getDttercero().getId());
        Dtecassucursal dt=usuario.getTbUiUsuario().getDtecassucursal();
        obj.getDttercero().setDtEcassucursalid(dt);
        System.err.println("data 2: "+obj.getDttercero().getDtEcassucursalid().getId());
        super.setObj(obj);
        return getObj();
    
    }
    
   
    public String  reinit(Integer tipoTercero) throws Exception {
       try{Dtecassucursal dt=usuario.getTbUiUsuario().getDtecassucursal();
        getObj().getDttercero().setDtEcassucursalid(dt);
        getObj().setDttercerotipo(this.tipoTercero.getList().stream().filter(x-> Objects.equals(x.getId(), tipoTercero)).findFirst().orElse(null));
        
        this.save(getObj());
        setObj(new Dtterceronatural()); 
        
        getObj().setDttercero(new Dttercero());
        //PrimeFaces.current().ajax().update("@form");
        RequestContext.getCurrentInstance().update("@form");
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public DtTerceroController getTercero() {
        return tercero;
    }

    public void setTercero(DtTerceroController tercero) {
        this.tercero = tercero;
    }

    public List<Dtterceronatural> getList(Dtecassucursal sucursal) {
        System.err.println("data: "+sucursal.getId());
        Predicate<Dtterceronatural> predicate=(t) -> {
            try
            {
                if(Objects.isNull(t.getDttercero()))
                    return false;
                else if(Objects.isNull(t.getDttercero().getDtEcassucursalid()))
                    return false;
                else if(Objects.equals(t.getDttercero().getDtEcassucursalid().getId() ,sucursal.getId() ))
                    return true;

                return false; //To change body of generated lambdas, choose Tools | Templates.
            }catch(Exception ex){
                System.err.println("tercero: "+t.getDttercero().getId());
                ex.printStackTrace();
                return false;
            }
        };
        
        if(Objects.equals(tercero.getUsuario().getTbUiUsuario().getUiRol().getId(), 1L))
            return super.findList(); //To change body of generated methods, choose Tools | Templates.
        else
            return super.findList().stream().filter(predicate).collect(Collectors.toList());
    
    }

    public UiTerceroRutaManager getRutaManager() {
        return rutaManager;
    }

    public void setRutaManager(UiTerceroRutaManager rutaManager) {
        this.rutaManager = rutaManager;
    }

    public List<Dtterceroruta> getListRuta() {
        return listRuta;
    }

    public void setListRuta(List<Dtterceroruta> listRuta) {
        this.listRuta = listRuta;
    }

    public UiTerceroTipoManager getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(UiTerceroTipoManager tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }

    @Override
    public Dtterceronatural getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
}
