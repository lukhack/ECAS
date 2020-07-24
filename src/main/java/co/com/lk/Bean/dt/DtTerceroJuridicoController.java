/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.ma.Dttercerojuridico;
import co.com.lk.Entity.ma.Dtterceronatural;
import co.com.lk.connection.NewHibernateUtil;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtTerceroJuridicoController extends UiManager<Dttercerojuridico>{
    
    @Inject
    DtTerceroController tercero;
    
    public DtTerceroJuridicoController() {
        super(new Dttercerojuridico());
        getObj().setDttercero(new Dttercero());
        findList();
    }

    public List<Dttercerojuridico>  getList(Dtecassucursal sucursal) {
        System.err.println("data: "+sucursal.getId());
        Predicate<Dttercerojuridico> predicate=(t) -> {
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
    
    
    @Override
    public void save(Dttercerojuridico obj) {
         try{
            
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                
                try{
                    Transaction tr = session.getTransaction();
                    tr.begin();
                    
                    AtomicReference<String> exception=new AtomicReference<>("");
                    
                    try{
                        session.saveOrUpdate(obj.getDttercero());
                        obj.getDttercero().setDttercerojuridico(obj);
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
    public void save(Dttercerojuridico obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dttercerojuridico> getListFilter() {
        return super.getListFilter(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public void saveList(List<Dttercerojuridico> obj) throws Exception {
        try{
            
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                
                try{
                    Transaction tr = session.getTransaction();
                    tr.begin();
                    
                    AtomicReference<String> exception=new AtomicReference<>("");
                    
                    obj.stream().forEach(x->{
                        try{
                            session.saveOrUpdate(x.getDttercero());
                            x.getDttercero().setDttercerojuridico(x);
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
    

    
    public void saveJuridico(Dttercerojuridico obj) throws Exception {
        try{
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                try{
                    Transaction tr = session.getTransaction();
                    tr.begin();
                    session.saveOrUpdate(obj.getDttercero());
                    session.save(obj);
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

    @Override
    public Dttercerojuridico getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String  reinit() throws Exception {
        System.err.println(tercero.getUsuario().getTbUiUsuario());
        Dtecassucursal dt=tercero.getUsuario().getTbUiUsuario().getDtecassucursal();
        getObj().getDttercero().setDtEcassucursalid(dt);
        
        saveJuridico(getObj());
        
        setObj(new Dttercerojuridico()); 
        getObj().setDttercero(new Dttercero());
        
        return null;
    }

    public DtTerceroController getTercero() {
        return tercero;
    }

    public void setTercero(DtTerceroController tercero) {
        this.tercero = tercero;
    }

    @Override
    public List<Dttercerojuridico> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
}
