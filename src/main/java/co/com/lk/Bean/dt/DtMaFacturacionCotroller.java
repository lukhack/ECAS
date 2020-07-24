/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.application.ConsecutivoEcas;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import co.com.lk.Entity.dt.Dtfactura;
import co.com.lk.Entity.dt.DtfacturaImagenes;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtecamaterial;
import co.com.lk.Entity.ma.Dttercero; 
import co.com.lk.Entity.ma.Dttercerojuridico;
import co.com.lk.Entity.ma.Dtterceronatural;
import co.com.lk.connection.NewHibernateUtil;
import java.util.Date;
import java.util.Objects;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import org.hibernate.Session;
//import org.primefaces.PrimeFaces;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.CaptureEvent;
import java.util.*;
import java.util.stream.Collectors;
import org.primefaces.context.RequestContext;
/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtMaFacturacionCotroller extends UiManager<Dtfactura>{
    
    @Inject
    DtMaFacturacionDetalleController facturaDetalle;
    
    
    @Inject
    DtMaTipoFacturaController tipoFacturaController;
    
    
    @Inject
    DtMaFacturacionDetalleMaterialController materiaPresentacionController;
    
    @Inject
    DtMaMaterialesController material;
    
    
    @Inject
    DtTerceroController tercero;
    
    
    @Inject
    DtTerceroNaturalController terceroNatural;
    
    @Inject
    DtTerceroJuridicoController terceroJuridico;
    
    @Inject
    UsuarioB usuario;

    @Inject
    ConsecutivoEcas consecutivo;
    
    Dttercero convenioTercero;
    String imagen="";
     
    private String filename;
    
    public DtMaFacturacionCotroller() {
        super(new Dtfactura());
    }

    boolean sleppthrea=true;
    public void save(Dtfactura obj, List<String> updateObjecView,String tipo){
        try{
            if(obj.getDtfacturadetalleList().size()<1)
                throw new Exception("Debes ingresar un detalle factura para guardar");

            obj.setFecha(new Date());
            obj.setHora(new Date());
            obj.setUsuario(usuario.getTbUiUsuario());
            obj.setDtEcassucursalid(usuario.getTbUiUsuario().getDtecassucursal());
            obj.setDtTipoFacturaid(tipoFacturaController.getList().stream().filter(x->Objects.equals(x.getId(), Integer.valueOf(tipo))).findAny().orElse(null));
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                try{
                    consecutivo.procesarFactura(session, getObj(),usuario.getTbUiUsuario().getDtecassucursal(),Integer.valueOf(tipo));
                    //PrimeFaces.current().ajax().update("frmApp:dgFactura");
                    //PrimeFaces.current().executeScript("PF('dgFactura').show()");
                    RequestContext.getCurrentInstance().update("frmApp:dgFactura");
                    RequestContext.getCurrentInstance().execute("PF('dgFactura').show()");
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
    
    
    
    
    public void saveupdate(Dtfactura obj,Dtecassucursal eca, List<String> updateObjecView,String tipo){
        try{
            if(obj.getDtfacturadetalleList().size()<1)
                throw new Exception("Debes ingresar un detalle factura para guardar");

            
            obj.setHora(new Date());
            obj.setUsuario(usuario.getTbUiUsuario());
            obj.setDtEcassucursalid(eca);
            obj.setDtTipoFacturaid(tipoFacturaController.getList().stream().filter(x->Objects.equals(x.getId(), Integer.valueOf(tipo))).findAny().orElse(null));
            try(Session session= NewHibernateUtil.getSessionFactory().openSession()){
                try{
                    
                    consecutivo.procesarFactura(session, getObj(),eca,Integer.valueOf(tipo));
                    //PrimeFaces.current().ajax().update("frmApp:dgFactura");
                    //PrimeFaces.current().executeScript("PF('dgFactura').show()");
                    RequestContext.getCurrentInstance().update("frmApp:dgFactura");
                    RequestContext.getCurrentInstance().execute("PF('dgFactura').show()");
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
    public Dtfactura getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public void anadirTercero(Dtterceronatural tercero){
        try{
            Dtecassucursal dt=usuario.getTbUiUsuario().getDtecassucursal();
            tercero.getDttercero().setDtEcassucursalid(dt);
            tercero.setDttercerotipo(terceroNatural.getTipoTercero().getList().stream().filter(x-> Objects.equals(x.getId(), 1)).findFirst().orElse(null));
            terceroNatural.save(tercero);

            getObj().setTercero(tercero.getDttercero());
            terceroNatural.getList().add(tercero);
            //PrimeFaces.current().ajax().update("frmApp:pnFormTercero");
            //PrimeFaces.current().executeScript("PF('dgTercero').hide()");
            
            RequestContext.getCurrentInstance().update("frmApp:pnFormTercero");
            RequestContext.getCurrentInstance().execute("PF('dgTercero').show()");
                    

            terceroNatural.setObj(new Dtterceronatural());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
   
   
   public List<Dttercero> convenio(){
       if(getObj().getDtfacturadetalleList().isEmpty())
           return new ArrayList();
       
       return tercero.findList().stream().filter(x-> getObj().getDtfacturadetalleList().stream().filter(y->Objects.nonNull(y.getTerceroconvenio_id())).anyMatch(y-> Objects.equals(y.getTerceroconvenio_id().getId(), x.getId()))).collect(Collectors.toList());
    
        //getObj().getDtfacturadetalleList().stream().filter(x-> Objects.nonNull(x.getTerceroconvenio_id())).map(x-> x.getTerceroconvenio_id()).collect(Collectors.toList());
       
      
   
   }
   
   public void anadirTerceroJuridico(Dttercerojuridico tercero){
        try{
            Dtecassucursal dt=usuario.getTbUiUsuario().getDtecassucursal();
            tercero.getDttercero().setDtEcassucursalid(dt);
            terceroJuridico.save(tercero);

            facturaDetalle.getObj().setTerceroconvenio_id(tercero.getDttercero());
            terceroJuridico.getList().add(tercero);
            
            //PrimeFaces.current().ajax().update("frmApp:pnTerceroJuridicoSelec");
            //PrimeFaces.current().executeScript("PF('dgTerceroJuridico').hide()");
            
            RequestContext.getCurrentInstance().update("frmApp:pnTerceroJuridicoSelec");
            RequestContext.getCurrentInstance().execute("PF('dgTerceroJuridico').show()");
            

            terceroNatural.setObj(new Dtterceronatural());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
   
   
   public void anadirMaterial(Dtecamaterial mt){
        mt.setEcaSucursal(usuario.getTbUiUsuario().getDtecassucursal());
        mt.setFecha(new Date());
        material.save(mt);
        facturaDetalle.getObj().setMaterialid(mt);
        
        facturaDetalle.getObj().setValor(mt.getValorCompra());
        //PrimeFaces.current().ajax().update("frmApp:pnFormMaterial");
        //PrimeFaces.current().executeScript("PF('dgMaterialAdd').hide()");
        RequestContext.getCurrentInstance().update("frmApp:pnFormMaterial");
        RequestContext.getCurrentInstance().execute("PF('dgMaterialAdd').show()");
        
    }
    
   public void listenerTercero(AjaxBehaviorEvent event){
       
       getObj().setDttransporte_id(((Dttercero) ((SelectOneMenu) event.getSource()).getValue()).getDtmamediotransporteId());
   }
   
    public void lectorQR(ActionEvent evt){
        //System.err.println("data");
       String cedula= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cedula");
       
        try {
            getObj().setTercero((Dttercero) tercero.findIdLikeParameter(new Dttercero().getClass().getName(), "FINDDOCUMENTO", cedula));
             System.out.println("cedula: "+getObj().getTercero());
        }catch (Exception ex){
            ex.printStackTrace();
       }
       
        System.out.println("cedula: "+cedula);
    
    }
    
    public void stop(){
        consecutivo.stop();
    }
    
    public void oncapture(CaptureEvent captureEvent) {
        try {
            filename = getRandomImageName().concat( ".jpeg");
        
            System.err.println("foto: "+filename);
            byte[] data = captureEvent.getData();
            String BasicBase64format = Base64.getEncoder().encodeToString(data);
            this.imagen=BasicBase64format;
            //PrimeFaces.current().ajax().update("frmApp:dataPhoto");
            RequestContext.getCurrentInstance().update("frmApp:dataPhoto");
            
        }catch(Exception e) {
            e.printStackTrace();
            throw new FacesException("Error in writing captured image.", e);
        }
    }
    
    public void addImagenfactura(){
        getObj().getDtfacturaImagenesList().add(new DtfacturaImagenes(filename,imagen,getObj()));
        imagen="";
        
    }
    
    public void removeImg(DtfacturaImagenes obj){
        getObj().getDtfacturaImagenesList().removeIf(x->Objects.equals(obj, x));
    }
    
    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);
         
        return String.valueOf(i);
    }

    @Override
    public void saveList(List<Dtfactura> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
    
    public  List<Dtfactura> listEcas(Dtecassucursal eca, String factura) throws Exception{
        try {
            return (List<Dtfactura>)findLikeParameter(getObj().getClass().getName(), "FINDALLXECA", eca.getId(), Integer.valueOf(factura));
        } catch (Exception ex) {  
            ex.printStackTrace();
            facesMenssage.addMensaje(2, "Error Consultado datos", "");
            return new ArrayList<>();
        }
    }
    
    
    public void onSelectMaterialCompra(AjaxBehaviorEvent event){
        Dtecamaterial material=(Dtecamaterial) ((SelectOneMenu)event.getSource()).getValue();
        System.err.println("material: "+material.getValorCompra());
        facturaDetalle.getObj().setValor(material.getValorCompra());
    }
    
    public void onSelectMaterialVenta(AjaxBehaviorEvent event){
        Dtecamaterial material=(Dtecamaterial) ((SelectOneMenu)event.getSource()).getValue();
        facturaDetalle.getObj().setValor(material.getValorVenta());
    }
   
   
    public String  reinit() throws Exception {
        setObj(new Dtfactura()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    public String  reinitDetalle() throws Exception {
        facturaDetalle.getObj().setCantidad(facturaDetalle.getObj().getCantidad() * facturaDetalle.getObj().getMaterialid().getMaterial().getPesokg()); 
        total();
        facturaDetalle.reinit(getObj());
        return null;
    }
    
    public String  reinitDetalleMarterialPresentacion() throws Exception {
        total();
        materiaPresentacionController.reinit(facturaDetalle.getObj());
        return null;
    }

    public DtMaFacturacionDetalleController getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(DtMaFacturacionDetalleController facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }
    
    
    public void listenerConvenio(AjaxBehaviorEvent event){
        Dttercero select = (Dttercero)((SelectOneMenu) event.getSource()).getValue();
        System.err.println("co.com.lk.Bean.Ui.UiAcount.changePasswordListen() "+select);
        
        convenioTercero = select;
    }

    
    public void total(){
        
        getObj().setSubTotal(getObj().getDtfacturadetalleList().stream().filter(x->Objects.nonNull(x.getValor())).mapToDouble(x-> x.getValor() * x.getCantidad()).sum());
        getObj().setTotalClasificacino( getObj().getDtfacturadetalleList().stream().map(x->{
            return x.getDtFacturaDetalle().stream().mapToDouble(s-> s.getCantidad() * s.getMaterialid().getValor()).sum();
        }).mapToDouble(x-> x).sum());
        
          getObj().setTotal((getObj().getSubTotal() + getObj().getTotalClasificacino()) - getObj().getDescuento()  );
        
        System.err.println("total: " + getObj().getTotalClasificacino());
        //PrimeFaces.current().ajax().update("frmApp:pnTotales");
        RequestContext.getCurrentInstance().update("frmApp:pnTotales");
    
    }
    
    public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }

    public DtMaMaterialesController getMaterial() {
        return material;
    }

    public void setMaterial(DtMaMaterialesController material) {
        this.material = material;
    }

    public ConsecutivoEcas getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(ConsecutivoEcas consecutivo) {
        this.consecutivo = consecutivo;
    }
    
    

    @Override
    public List<Dtfactura> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public DtMaFacturacionDetalleMaterialController getMateriaPresentacionController() {
        return materiaPresentacionController;
    }

    public void setMateriaPresentacionController(DtMaFacturacionDetalleMaterialController materiaPresentacionController) {
        this.materiaPresentacionController = materiaPresentacionController;
    }

    public DtMaTipoFacturaController getTipoFacturaController() {
        return tipoFacturaController;
    }

    public void setTipoFacturaController(DtMaTipoFacturaController tipoFacturaController) {
        this.tipoFacturaController = tipoFacturaController;
    }

    public DtTerceroNaturalController getTerceroNatural() {
        return terceroNatural;
    }

    public void setTerceroNatural(DtTerceroNaturalController terceroNatural) {
        this.terceroNatural = terceroNatural;
    }

    public DtTerceroJuridicoController getTerceroJuridico() {
        return terceroJuridico;
    }

    public void setTerceroJuridico(DtTerceroJuridicoController terceroJuridico) {
        this.terceroJuridico = terceroJuridico;
    }

    public DtTerceroController getTercero() {
        return tercero;
    }

    public void setTercero(DtTerceroController tercero) {
        this.tercero = tercero;
    }

    public Dttercero getConvenioTercero() {
        return convenioTercero;
    }

    public void setConvenioTercero(Dttercero convenioTercero) {
        this.convenioTercero = convenioTercero;
    }
    
    
    
    
}
