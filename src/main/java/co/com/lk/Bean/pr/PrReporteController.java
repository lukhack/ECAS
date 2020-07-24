/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.pr;

import co.com.lk.Bean.dt.DtMaFacturacionCotroller;
import co.com.lk.Bean.dt.DtMaMaterialesCategoriaController;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.dt.Dtfactura;
import co.com.lk.Entity.dt.Dtfacturadetalle;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.pr.PrRecoleccionDesperdicio;
import co.com.lk.Entity.rp.PrComprasDia;
import co.com.lk.Entity.rp.PrComprasMes;
import co.com.lk.Entity.rp.Prfacturadetalle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class PrReporteController implements  Serializable{
    @Inject
    UsuarioB usuarioBean;
    
    @Inject
    PrReporteFacturacionMesController reporteMesFacturacion;
    
    @Inject
    PrReporteFacturacionDiaController reporteDiaFacturacion;
    
    @Inject
    PrReporteFacturacionRecicladorController reporteRecicladorFacturacion;
    
    @Inject
    DtMaMaterialesCategoriaController material;
    
    private DataTable   dataTable;  
    
    @Inject
    DtMaFacturacionCotroller facturacion;
    
    
    @Inject
    PrRecoleccionDesperdiciosController desperdicios;
    
    Integer nivel=1;
    
    String mes;
    String anio;
    
    Date fechaInicio;
    Date fechafin;
    Dttercero tercero;
    
    Integer tipoFactura;
    
    private LineChartModel charLineal;
    
    private BarChartModel animatedModel2;
    
    private Dtecassucursal ecasucursal;
    
    List<PrRecoleccionDesperdicio> desperdiciosDetalle=new ArrayList<>();
    List<Dtfacturadetalle> facturasDetalle=new ArrayList<>();
    List<Prfacturadetalle> prfacturasDetalle=new ArrayList<>();
    Map<Dttercero,Double> mapfacturasDetalle=new HashMap<>();
    
    
     List<Dtfacturadetalle> facturasDetallefilter;
     List<Prfacturadetalle> prfacturasDetallefilter;
    public PrReporteController() {
        //findList();
    }

    @PostConstruct
    public void init() {
        try{
            System.err.println("soy un error de datos");
        }catch(Exception ex){}
    }
    
    

    private boolean validfechafilter( Calendar calendarC){
        
        
        if(Objects.isNull(fechaInicio) && Objects.isNull(fechafin))
            return true;
        else if(Objects.nonNull(fechaInicio) && Objects.nonNull(fechafin)){
            Calendar calendarI=Calendar.getInstance();
            Calendar calendarF=Calendar.getInstance();
            calendarI.setTime(fechaInicio);
            calendarF.setTime(fechafin);
            
            return ((calendarI.getTime().before(calendarC.getTime()) && calendarF.getTime().after(calendarC.getTime())) || (Objects.equals(calendarI.compareTo(calendarC), 0) || Objects.equals(calendarF.compareTo(calendarC), 0)));
               
        }else if(Objects.nonNull(fechaInicio)){
            Calendar calendarI=Calendar.getInstance();
            calendarI.setTime(fechaInicio);
             return (calendarI.getTime().before(calendarC.getTime())  || Objects.equals(calendarI.compareTo(calendarC), 0));
           
             
        }
            
            
        return false;
    }
    
    public void reporteRecolector(){
        Predicate<Dtfacturadetalle> predicate=((Dtfacturadetalle t)->{
            Calendar calendarc=Calendar.getInstance();
            calendarc.setTime(t.getDtFacturaVentaid().getFecha());
           if(Objects.nonNull(tercero)){
                if(Objects.equals(t.getDtFacturaVentaid().getTercero(), tercero)){
                    return validfechafilter(calendarc);
                
                }else
                    return false;
                
            }else{
                return validfechafilter(calendarc);
            }
            
                    
        });
        facturasDetalle = facturacion.getFacturaDetalle().findListDetalleEca(usuarioBean.getTbUiUsuario().getDtecassucursal().getId()).stream().filter(predicate).collect(Collectors.toList());
    }
    
    
    public void reporteEca(){
        Predicate<Dtfacturadetalle> predicate=((Dtfacturadetalle t)->{
            Calendar calendarc=Calendar.getInstance();
            calendarc.setTime(t.getDtFacturaVentaid().getFecha());
            
            return validfechafilter(calendarc);
                        
        });
        facturasDetalle = facturacion.getFacturaDetalle().findListDetalleEca(ecasucursal.getId()).stream().filter(predicate).collect(Collectors.toList());
    }
    
    
    public void reporteDesperdicios(){
        Predicate<PrRecoleccionDesperdicio> predicate=((PrRecoleccionDesperdicio t)->{
            Calendar calendarc=Calendar.getInstance();
            calendarc.setTime(t.getFecharecoleccion());
            return validfechafilter(calendarc);
                    
        });
        desperdiciosDetalle = desperdicios.findListDetalleEca(usuarioBean.getTbUiUsuario().getDtecassucursal().getId()).stream().filter(predicate).collect(Collectors.toList());
    }
    
    private void createAnimatedModels() {
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Cantidad de material(Kg)");
        animatedModel2.setAnimate(true);
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        Axis xAxis = animatedModel2.getAxis(AxisType.X);
        yAxis.setMin(0);
        
        yAxis.setTickFormat("%d");
        animatedModel2.setDatatipFormat("%d");
        animatedModel2.setLegendPosition("e");
        animatedModel2.setShowPointLabels(true); 
        
        xAxis.setTickAngle(-90);
        
    }
    
    
    private void createAnimatedModelsFecha(Date fecha) {
        animatedModel2 = initBarModelFecha(fecha);
        animatedModel2.setTitle("Cantidad de material(Kg)");
        animatedModel2.setAnimate(true);
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        Axis xAxis = animatedModel2.getAxis(AxisType.X);
        yAxis.setMin(0);
        
        yAxis.setTickFormat("%d");
        animatedModel2.setDatatipFormat("%d");
        animatedModel2.setLegendPosition("e");
        animatedModel2.setShowPointLabels(true); 
        
        xAxis.setTickAngle(-90);
        
    }
    
    
    private BarChartModel initBarModelFecha(Date fecha) {
        
        facturasDetalle = facturacion.getFacturaDetalle().findListDetalleIdFecha(this.tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId(), fecha);
            
        System.err.println("mes:"+mes+":"+anio);
        System.err.println("tamaño:"+facturasDetalle.size());
        //System.err.println("cantidad: "+facturasDetalle.size()+":"+usuarioBean.getTbUiUsuario().getDtClientePadre().getId()+":"+1);
        Map<Object,Number> dts = facturasDetalle.stream().collect(Collectors.toMap(x-> x.getMaterialid().getMaterial().getMaterial() , y->(Number)y.getCantidad(),((s,r)-> (Double)s+(Double)r),HashMap::new));
        
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Cantidad de Materiales por Cliente");
        
        boys.setData(dts);
        model.addSeries(boys);
        return model;
    }
    
    
    
    
    private BarChartModel initBarModel() {
        
        facturasDetalle = facturacion.getFacturaDetalle().findListDetalleId(this.tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId(), mes, anio);
            
        System.err.println("mes:"+mes+":"+anio);
        System.err.println("tamaño:"+facturasDetalle.size());
        //System.err.println("cantidad: "+facturasDetalle.size()+":"+usuarioBean.getTbUiUsuario().getDtClientePadre().getId()+":"+1);
        Map<Object,Number> dts = facturasDetalle.stream().collect(Collectors.toMap(x-> x.getMaterialid().getMaterial().getMaterial() , y->(Number)y.getCantidad(),((s,r)-> (Double)s+(Double)r),HashMap::new));
        
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Cantidad de Materiales por Cliente");
        
        boys.setData(dts);
        model.addSeries(boys);
        return model;
    }

    public PrReporteFacturacionMesController getReporteMesFacturacion() {
        return reporteMesFacturacion;
    }

    public void setReporteMesFacturacion(PrReporteFacturacionMesController reporteMesFacturacion) {
        this.reporteMesFacturacion = reporteMesFacturacion;
    }

    public PrReporteFacturacionDiaController getReporteDiaFacturacion() {
        return reporteDiaFacturacion;
    }

    public void setReporteDiaFacturacion(PrReporteFacturacionDiaController reporteDiaFacturacion) {
       
        this.reporteDiaFacturacion = reporteDiaFacturacion;
    }
    
    public void selectFecha(Integer tipoFactura,String mes,String anio,Integer nivel){
        System.err.println("anio"+mes+":"+anio+":"+usuarioBean.getTbUiUsuario().getId());
        this.anio=anio;
        this.mes=mes;
        this.nivel=nivel;
        this.tipoFactura=tipoFactura;
        createAnimatedModels();
    }
    
    
    public void selectFechaDia(Integer tipoFactura, Date fecha){
       this.tipoFactura=tipoFactura;
        createAnimatedModelsFecha(fecha);
    }
    
    public void selectReclicladorDetallado(Integer tipoFactura,String mes,String anio,Integer nivel){
        this.anio=anio;
        this.mes=mes;
        this.nivel=nivel;
        this.tipoFactura=tipoFactura;
        facturasDetalle = facturacion.getFacturaDetalle().findListDetalleRecilador(this.tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId(), mes, anio);
    }
    
    public void selectReclicladorAgrupado(Integer tipoFactura,String mes,String anio,Integer nivel){
        this.anio=anio;
        this.mes=mes;
        this.nivel=nivel;
        this.tipoFactura=tipoFactura;
        prfacturasDetalle = reporteRecicladorFacturacion.findListId(this.tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId(), mes, anio);
    }
    
    public void selectReclicladorTotal(Integer tipoFactura,String mes,String anio,Integer nivel){
        this.anio=anio;
        this.mes=mes;
        this.nivel=nivel;
        this.tipoFactura=tipoFactura;
        List<Dtfacturadetalle> dt = facturacion.getFacturaDetalle().findListDetalleRecilador(this.tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId(), mes, anio);
        mapfacturasDetalle=dt.stream().filter(x-> Objects.nonNull(x.getTercero())).collect(Collectors.groupingBy(Dtfacturadetalle::getTercero, Collectors.summingDouble(Dtfacturadetalle::getCantidad)));
    }
    
    public List<PrComprasMes> reporteMes(Integer tipoFactura){
        //System.err.println("usuario: "+usuarioBean.getTbUiUsuario().getId());
       List<PrComprasMes> dt=reporteMesFacturacion.findListId(tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId());
       createCharLinealxmes(dt.stream().sorted((p1, p2)->p1.getAnio().concat(p1.getMes()).compareTo(p2.getAnio().concat(p2.getMes()))).collect(Collectors.toList()));
       
       
       return dt.stream().collect(Collectors.toList());
    }  
    
    
    private void createCharLinealxmes(List<PrComprasMes> datos) {
        charLineal = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        
        LineChartModel model = new LineChartModel();
        datos.stream().forEach(x->{
             series1.set(x.getMes()+"-"+x.getAnio(), x.getTotalmaterial());
        });
        
        model.addSeries(series1);
        
        charLineal = model;
        charLineal.setTitle("Comportamineto de materiales vs tiempo");
        charLineal.setLegendPosition("e");
        Axis yAxis = charLineal.getAxis(AxisType.Y);
        charLineal.setShowPointLabels(true);
        charLineal.getAxes().put(AxisType.X, new CategoryAxis("Mes - Año"));
        yAxis.setLabel("Total Materiales");
        yAxis.setMin(0);
        
    }
   
    public List<PrComprasDia> reporteDia(String mes, String anio){
        return reporteDiaFacturacion.findListId(tipoFactura, usuarioBean.getTbUiUsuario().getDtecassucursal().getId(),mes,anio);
    }  
    
    
    

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    public void setAnimatedModel2(BarChartModel animatedModel2) {
        this.animatedModel2 = animatedModel2;
    }

    public List<Dtfacturadetalle> getFacturasDetalle() {
        return facturasDetalle;
    }

    public void setFacturasDetalle(List<Dtfacturadetalle> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }

    public List<Dtfacturadetalle> getFacturasDetallefilter() {
        return facturasDetallefilter;
    }

    public void setFacturasDetallefilter(List<Dtfacturadetalle> facturasDetallefilter) {
        this.facturasDetallefilter = facturasDetallefilter;
    }

    public List<Prfacturadetalle> getPrfacturasDetalle() {
        return prfacturasDetalle;
    }

    public void setPrfacturasDetalle(List<Prfacturadetalle> prfacturasDetalle) {
        this.prfacturasDetalle = prfacturasDetalle;
    }

    public List<Prfacturadetalle> getPrfacturasDetallefilter() {
        return prfacturasDetallefilter;
    }

    public void setPrfacturasDetallefilter(List<Prfacturadetalle> prfacturasDetallefilter) {
        this.prfacturasDetallefilter = prfacturasDetallefilter;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
    
    
    public String getTotalRowsTable() {  
        return String.valueOf(dataTable.getRowCount());  
    }  

    public Map<Dttercero, Double> getMapfacturasDetalle() {
        return mapfacturasDetalle;
    }

    public void setMapfacturasDetalle(Map<Dttercero, Double> mapfacturasDetalle) {
        this.mapfacturasDetalle = mapfacturasDetalle;
    }

    public LineChartModel getCharLineal() {
        return charLineal;
    }

    public void setCharLineal(LineChartModel charLineal) {
        this.charLineal = charLineal;
    }

    public Integer getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(Integer tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Dttercero getTercero() {
        return tercero;
    }

    public void setTercero(Dttercero tercero) {
        this.tercero = tercero;
    }

    public List<PrRecoleccionDesperdicio> getDesperdiciosDetalle() {
        return desperdiciosDetalle;
    }

    public void setDesperdiciosDetalle(List<PrRecoleccionDesperdicio> desperdiciosDetalle) {
        this.desperdiciosDetalle = desperdiciosDetalle;
    }

    public Dtecassucursal getEcasucursal() {
        return ecasucursal;
    }

    public void setEcasucursal(Dtecassucursal ecasucursal) {
        this.ecasucursal = ecasucursal;
    }
    
    
}
