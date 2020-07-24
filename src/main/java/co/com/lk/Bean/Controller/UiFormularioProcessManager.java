/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.Controller.Master.MaBarrioManager;
import co.com.lk.Bean.Controller.Master.MaComunaManager;
import co.com.lk.Bean.Controller.Master.MaDepartamentoManager;
import co.com.lk.Bean.Controller.Master.MaMunicipioManager;
import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.Dtformulario;
import co.com.lk.Entity.Dtformulariovalidaciones;
import co.com.lk.Entity.Dtgrupo;
import co.com.lk.Entity.Dtrespuestadetalle;
import co.com.lk.Entity.DtrespuestadetallePK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FlowEvent;
import co.com.lk.Entity.Dtrespuestaform;
import co.com.lk.Entity.Dtrespuestaz;
import co.com.lk.connection.NewHibernateUtil;
import co.com.lk.helper.facesMenssage;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
/**
 *
 * @author julig
 */
@Named
@javax.faces.view.ViewScoped
public class UiFormularioProcessManager extends UiManager<Dtgrupo>{
    
    @Inject
    private UiFormularioManager uiFormulario;
    
    @Inject
    private UiListaManager uiList;
    
    
    @Inject
    private MaComunaManager maComuna;
    
    
    @Inject
    private MaBarrioManager maBarrio;
    
    
    @Inject
    private MaDepartamentoManager maDepartamento;
    
    
    
    @Inject
    private MaMunicipioManager maMunicipio;
    
    Map<String,List<Map<String,String>>> formDetalle;
    
    Integer activeIndex=0;
    
    TabView tabview;
    
    public UiFormularioProcessManager() {
        super(new Dtgrupo());
        findList();
        
    }
    
    @PostConstruct
    public void init(){
         formDetalle = new HashMap<>();
    }

    @Override
    public List<Dtgrupo> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Dtformulario> getListFormulario(List<Dtformulario> formulario) {
        Predicate<Dtformulario> predicateForm=((Dtformulario t) -> {
            if(t.getPrecargado())
                return false;
            else 
                return Objects.equals(t.getPadre(), "0");
        });
        return formulario.stream().filter(predicateForm).collect(Collectors.toList()) ; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Dtformulario> getListFormularioDetalle(List<Dtformulario> formulario,String codPreg) {
        Predicate<Dtformulario> predicateForm=((Dtformulario t) -> {
            if(t.getPrecargado())
                return false;
            else return t.getPadre().equals(codPreg);
        });
        
        Comparator<Dtformulario> comparator = Comparator.comparingInt(Dtformulario::getOrden);
        
        return formulario.stream().filter(predicateForm).sorted(comparator).collect(Collectors.toList()) ; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void onSelectList(AjaxBehaviorEvent event){
            String value=(String) ((SelectOneMenu)event.getSource()).getValue();
            String codPreg = (String) event.getComponent().getAttributes().get("codPreg");
            System.out.println(value+":"+codPreg);
            
          Dtformulario frm= uiFormulario.getFormulario().stream().filter(x->Objects.equals(x.getCodPreg(), codPreg)).findFirst().orElse(null);
          if(Objects.nonNull(frm)){
              if(frm.getTieneValidacion()){
                   Dtformulariovalidaciones validacion= frm.getDtformulariovalidacionesCollection().stream().filter(x-> Stream.of(x.getValorRest().split(",")).anyMatch(y->Objects.equals(y, value))).findFirst().orElse(null);
                   if(Objects.nonNull(validacion))
                       Stream.of(validacion.getPregCargar().split(",")).forEach(x->{
                          Dtformulario frm2= uiFormulario.getFormulario().stream().filter(r->Objects.equals(r.getCodPreg(), x)).findFirst().orElse(null);
                          if(Objects.nonNull(frm2))
                              frm2.setVisible(validacion.getVisible());
                       
                       });
                }
          }
    }
    
    
    public void onCheckList(AjaxBehaviorEvent event){
            String value=(Boolean) ((SelectBooleanCheckbox)event.getSource()).getValue()?"1":"0";
            String codPreg = (String) event.getComponent().getAttributes().get("codPreg");
            
          Dtformulario frm= uiFormulario.getFormulario().stream().filter(x->Objects.equals(x.getCodPreg(), codPreg)).findFirst().orElse(null);
          if(Objects.nonNull(frm)){
              if(frm.getTieneValidacion()){
                   Dtformulariovalidaciones validacion= frm.getDtformulariovalidacionesCollection().stream().filter(x-> Stream.of(x.getValorRest().split(",")).anyMatch(y->Objects.equals(y, value))).findFirst().orElse(null);
                   if(Objects.nonNull(validacion))
                       Stream.of(validacion.getPregCargar().split(",")).forEach(x->{
                          Dtformulario frm2= uiFormulario.getFormulario().stream().filter(r->Objects.equals(r.getCodPreg(), x)).findFirst().orElse(null);
                          if(Objects.nonNull(frm2))
                              frm2.setVisible(validacion.getVisible());
                        });
                
               }
          
          }
              
    }
    
    
    public List<Map<String,String>> getListMapFormulario(String codPreg) {
       return formDetalle.get(codPreg);
    }
    
    
    public void addDetalle(List<Dtformulario> formulario,String codPreg,String nameForm){
        Predicate<Dtformulario> predicateForm=((Dtformulario t) -> {
            if(t.getPrecargado())
                return false;
            else return t.getPadre().equals(codPreg);
        });
        
        Map<Object,Object> view = FacesContext.getCurrentInstance().getAttributes();
                    
        ExternalContext  request = FacesContext.getCurrentInstance().getExternalContext();
        
                
        Map<String,String> requestParams = request.getRequestParameterMap();
        
        HashMap<String,String> dtvalue= new LinkedHashMap<>();
        
        AtomicReference<String> data=new AtomicReference<>();
        
        Comparator<Dtformulario> comparator = Comparator.comparingInt(Dtformulario::getOrden);
        
        List<Dtformulario> forms= formulario.stream().filter(predicateForm).sorted(comparator).collect(Collectors.toList()) ; //To change body of generated methods, choose Tools | Templates.
         
       
        if(Objects.isNull(formDetalle.get(codPreg)))
            formDetalle.put(codPreg, new ArrayList());
        
        dtvalue.put("id", String.valueOf(formDetalle.get(codPreg).size()+1));
        
        forms.stream().filter(predicateForm).forEach(x->{
            
        data.set("");
            if(!x.getTipo().equals("Text"))
                data.set("_input");
            
            
            String txtProperty = requestParams.get(nameForm.concat(x.getCodPreg()).concat(data.get()));
            System.err.println("1:"+x.getCodPreg()+":"+txtProperty);
            
            dtvalue.put(x.getCodPreg(), txtProperty);
        });
        
        //PrimeFaces.current().resetInputs("panel-"+codPreg);
        RequestContext.getCurrentInstance().reset("panel-"+codPreg);
        formDetalle.get(codPreg).add(dtvalue);
        
    
    }
    
    public String traslateList(List<Dtformulario> formulario,String codpreg,String value){
         AtomicReference<String> data=new AtomicReference(value);
         
         Dtformulario frm = formulario.stream().filter(x->Objects.equals(x.getCodPreg(), codpreg) &&  
                 (Objects.equals(x.getTipo() ,"List")|| Objects.equals(x.getTipo() ,"ListM")|| Objects.equals(x.getTipo() ,"CheckList"))).findFirst().orElse(null);
         
         if(Objects.nonNull(frm))
           if(Objects.equals(frm.getTipo() ,"List"))  
                data.set(uiList.getList().stream().filter(x->Objects.equals(x.getKeylist(), frm.getOpcResp())).map(y->{
                   return y.getDtlistadetalleList().stream().filter(x->Objects.equals(String.valueOf(x.getCodigo()), value)).findFirst().map(x->x.getDescripcion()).orElse("");
               }).findFirst().orElse("")
              ); 
          else if(Objects.equals(frm.getOpcResp(),"ListTableComuna"))
                data.set(maComuna.getList().stream().filter(x->Objects.equals(String.valueOf(x.getId()), value)).map(x->x.getComuma()).findFirst().orElse(""));
          else if(Objects.equals(frm.getOpcResp(),"ListTableBarrio"))
                data.set(maBarrio.getList().stream().filter(x->Objects.equals(String.valueOf(x.getId()), value)).map(x->x.getBarrio()).findFirst().orElse(""));
           else if(Objects.equals(frm.getOpcResp(),"ListTableDepartamento"))
                data.set(maDepartamento.getList().stream().filter(x->Objects.equals(String.valueOf(x.getId()), value)).map(x->x.getDepartamento()).findFirst().orElse(""));
            else if(Objects.equals(frm.getOpcResp(),"ListTableMunicipio"))
                data.set(maMunicipio.getList().stream().filter(x->Objects.equals(String.valueOf(x.getId()), value)).map(x->x.getMunicipio()).findFirst().orElse(""));
            else if(Objects.equals(frm.getTipo() ,"CheckList"))
                data.set(Objects.equals("on", value)?"Si":"No");
                
         
        return data.get();
    }
    
    public void remove(Map<String,String> data,String codPreg){
         formDetalle.get(codPreg).removeIf(x->Objects.equals(x, data));
         
         AtomicInteger i=new AtomicInteger(0);
         formDetalle.get(codPreg).stream().forEach(x->{
             i.set(i.get()+1);
             x.put("id", String.valueOf(i.get()));
         });
         
    }
    
    public void save(String nameForm){
        ExternalContext  request = FacesContext.getCurrentInstance().getExternalContext();
        Map<String,String> requestParams = request.getRequestParameterMap();
        
        Predicate<Dtformulario> predicateForm=((Dtformulario t) -> {
            return !Objects.equals(t.getTipo(), "Detalle");
        });
        
        
        AtomicReference<String> data=new AtomicReference<>();
        Dtrespuestaform respuestaForm=new Dtrespuestaform();
        respuestaForm.setDtrespuestadetalleCollection(new ArrayList());
        respuestaForm.setDtrespuestazCollection(new ArrayList());    
          
        respuestaForm.setFecha(new Date());
        respuestaForm.setUsuario(uiFormulario.getUsuario().getTbUiUsuario());
        
        
        try{
            
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                
                try{
                    
                    Transaction tr = session.getTransaction();
                    tr.begin();
                   
                    session.saveOrUpdate(respuestaForm);  //guardamos el obj viejo
                    
                    uiFormulario.getFormulario().stream().filter(predicateForm).forEach((Dtformulario x)->{
                    data.set("");
                        if(!x.getTipo().equals("Text"))
                            data.set("_input");
                        String txtProperty="-88";
                        try{
                            txtProperty = requestParams.get(nameForm.concat(x.getCodPreg()).concat(data.get()));
                            if(txtProperty.equals(""))
                                txtProperty="-88";

                        }catch(Exception ex){
                            txtProperty="-88";
                        }

                        respuestaForm.getDtrespuestazCollection().add(new Dtrespuestaz(x.getOrden(),respuestaForm.getId(), 0, 0, x.getCodPreg(), txtProperty, new Date()));

                    });
                    
                    
                    getUiFormulario().getFormulario().stream().filter(x->Objects.equals(x.getTipo(), "Detalle")).forEach((Dtformulario x)->{
                        if(Objects.nonNull(formDetalle.get(x.getCodPreg())))
                            formDetalle.get(x.getCodPreg()).stream().forEach(y->{
                                AtomicInteger id=new AtomicInteger();
                                id.set(Integer.valueOf(y.get("id")));

                                AtomicInteger orden=new AtomicInteger(1);
                                y.entrySet().stream().forEach(y2->{
                                    Dtformulario frm= getUiFormulario().getFormulario().stream().filter(r-> !Objects.equals(y2.getKey(), "id") && Objects.equals(y2.getKey(),r.getCodPreg())).findFirst().orElse(null);
                                    if(Objects.nonNull(frm)){
                                        Dtrespuestadetalle detalle= new Dtrespuestadetalle();

                                        detalle.setDtrepuestadetallePK(new DtrespuestadetallePK(respuestaForm.getId(), id.get(), 0, y2.getKey(), x.getCodPreg()));
                                        detalle.setOrden(orden.get());


                                        String txtProperty="-88";
                                        if(!Objects.isNull(y2.getValue()))
                                            if(!txtProperty.equals(""))
                                                txtProperty=y2.getValue();

                                        detalle.setRespuesta(txtProperty);
                                        detalle.setFecha(new Date());


                                        respuestaForm.getDtrespuestadetalleCollection().add(detalle);
                                        orden.set(orden.get()+1);
                                    }
                                });


                            });
                    });
                    
                    tr.commit();
                    facesMenssage.addMensaje(2, "Datos procesados exitosamente", "");
                    
                    activeIndex=0;
                    //RequestContext.getCurrentInstance().reset("frmApp");
                    //RequestContext.getCurrentInstance().update("frmApp");
                    
                    //RequestContext.getCurrentInstance().reset("frmApp");
                    //RequestContext.getCurrentInstance().update("frmApp");
                    
                    
                    formDetalle = new HashMap<>();
                    

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
        }catch(Exception ex){
            ex.printStackTrace();
            facesMenssage.addMensaje(1, ex.getMessage(), "");
        }
    }
    
    
    public void resetform(){
        activeIndex=0;
        
        //PrimeFaces.current().resetInputs("frmApp");
        //PrimeFaces.current().ajax().update("frmApp");
        RequestContext.getCurrentInstance().reset("frmApp");
        RequestContext.getCurrentInstance().update("frmApp");
        formDetalle = new HashMap<>();
    }
    
    public void nextTabView(Integer position){
        activeIndex=position;
        
    }
    
    public void backTabView(){
        tabview.setActiveIndex(tabview.getActiveIndex()-1); 
    }
    
    public void onFlowProcess(FlowEvent event) {
        //PrimeFaces.current().ajax().update("formsg:msgs");
        RequestContext.getCurrentInstance().update("formsg:msgs");
        //RequestContext.getCurrentInstance().update("formsg:msgs");
    }

    public Map<String, List<Map<String, String>>> getFormDetalle() {
        return formDetalle;
    }

    public void setFormDetalle(Map<String, List<Map<String, String>>> formDetalle) {
        this.formDetalle = formDetalle;
    }

    public UiFormularioManager getUiFormulario() {
        return uiFormulario;
    }

    public void setUiFormulario(UiFormularioManager uiFormulario) {
        this.uiFormulario = uiFormulario;
    }

    public UiListaManager getUiList() {
        return uiList;
    }

    public void setUiList(UiListaManager uiList) {
        this.uiList = uiList;
    }

    public MaComunaManager getMaComuna() {
        return maComuna;
    }

    public void setMaComuna(MaComunaManager maComuna) {
        this.maComuna = maComuna;
    }

    public MaBarrioManager getMaBarrio() {
        return maBarrio;
    }

    public void setMaBarrio(MaBarrioManager maBarrio) {
        this.maBarrio = maBarrio;
    }

    public Integer getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(Integer activeIndex) {
        this.activeIndex = activeIndex;
    }

    public TabView getTabview() {
        return tabview;
    }

    public void setTabview(TabView tabview) {
        this.tabview = tabview;
    }

    public MaDepartamentoManager getMaDepartamento() {
        return maDepartamento;
    }

    public void setMaDepartamento(MaDepartamentoManager maDepartamento) {
        this.maDepartamento = maDepartamento;
    }

    public MaMunicipioManager getMaMunicipio() {
        return maMunicipio;
    }

    public void setMaMunicipio(MaMunicipioManager maMunicipio) {
        this.maMunicipio = maMunicipio;
    }
    
    
    
}
