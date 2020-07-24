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
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import org.hibernate.Session;
//import org.primefaces.PrimeFaces;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaProcesoRecoleccionCotroller extends UiManager<Dtmaterialprocesado>{
    private ScheduleModel eventModel;
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    @Inject
    UsuarioB usuario;
    
    
    private Date currentDate = new Date();
    
     
    
    public DtMaProcesoRecoleccionCotroller() {
        super(new Dtmaterialprocesado());
    }
    
     @PostConstruct
    public void init() {
         
       eventModel = new LazyScheduleModel() {
            @Override
            public void loadEvents(Date start, Date end) {
            
            }
        };
    
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

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        //PrimeFaces.current().ajax().update("frmApp:dataViewDialog");
        //PrimeFaces.current().executeScript("PF('eventViewDialog').show()");
        RequestContext.getCurrentInstance().update("frmApp:dataViewDialog");
        RequestContext.getCurrentInstance().execute("PF('eventViewDialog').show()");
    }
    
    
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        Date fecha=(Date) selectEvent.getObject();
        //PrimeFaces.current().ajax().update("frmApp:dataViewDialog");
        //PrimeFaces.current().executeScript("PF('eventViewDialog').show()");
        RequestContext.getCurrentInstance().update("frmApp:dataViewDialog");
        RequestContext.getCurrentInstance().execute("PF('eventViewDialog').show()");
            
    }
    

    public Date getCurrentDate() {
        return currentDate;
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

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
    
    
    
    
}
