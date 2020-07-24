/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.dt.Dtfactura;
import co.com.lk.Entity.ma.Dtecamaterial;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import co.com.lk.Entity.ma.Dtmaterialprocesado;
import co.com.lk.connection.NewHibernateUtil;
import co.com.lk.helper.facesMenssage;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import org.hibernate.Session;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaProcesoCotroller extends UiManager<Dtmaterialprocesado>{
    
    @Inject
    UsuarioB usuario;
    
    Double cantidadDisponible;
    
    public DtMaProcesoCotroller() {
        super(new Dtmaterialprocesado());
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String  reinit() throws Exception {
        setObj(new Dtmaterialprocesado()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    public void onSelectMaterial(AjaxBehaviorEvent event){
        Dtecamaterial material=(Dtecamaterial) ((SelectOneMenu)event.getSource()).getValue();
        getObj().setDtMaterial_id(material);
        getObj().setCantidadDisponible(0.0);
        
    }

   
    
    
    
    public void save(Dtfactura obj, List<String> updateObjecView,String tipo) {
        try{
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                try{
                    
                    
                    facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
                }catch(Exception ex){
                    ex.printStackTrace();
                    session.getTransaction().rollback();
                    throw new Exception("Error procesando los datos");
                }
            }catch(Exception ex){
                throw new Exception(ex.getMessage());
            }
        }catch(Exception ex){
            ex.printStackTrace();
            facesMenssage.addMensaje(1, ex.getMessage(), "");
        }
    }

    @Override
    public List<Dtmaterialprocesado> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dtmaterialprocesado getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
