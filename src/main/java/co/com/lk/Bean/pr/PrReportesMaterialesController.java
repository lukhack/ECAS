/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.pr;

import co.com.lk.Bean.dt.DtMaFacturacionCotroller;
import co.com.lk.Bean.dt.DtMaMaterialesCategoriaController;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.dt.Dtfacturadetalle;
import co.com.lk.Entity.view.dtmaterialConsolidado;
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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class PrReportesMaterialesController implements Serializable{
    
    private BarChartModel animatedModel2;
    private PieChartModel animatedModel3;
    private PieChartModel animatedModel4;
       
    Date fechaInicio;
    Date fechaFin;
    
    
    @Inject
    DtMaMaterialesCategoriaController material;
    
    
    @Inject
    DtMaFacturacionCotroller facturacion;
    
    
    
    @Inject
    UsuarioB usuarioB;
    
    Map<Integer,Number> certificadoMateriales;
    
    List<dtmaterialConsolidado> materialCosolidado;
    public PrReportesMaterialesController() {
         materialCosolidado=new ArrayList();
    }
    
    
    
    @PostConstruct
    public void init(){
        try{ 
        createAnimatedModelsChar3();
         createAnimatedModelsChar2();
         createAnimatedModelsChar4();
         }catch(Exception ex){
         
         }
    }
   
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
    
    public PieChartModel getAnimatedModel3() {
        return animatedModel3;
    }

    public PieChartModel getAnimatedModel4() {
        return animatedModel4;
    }

    public void setAnimatedModel4(PieChartModel animatedModel4) {
        this.animatedModel4 = animatedModel4;
    }
    
    
    
    public void processDataClienteFilter(){
       facturasDetalle=new ArrayList<>();
        
       
        
         try{
            
             
            }catch(Exception ex){
                ex.printStackTrace();
                facturasDetalle=new ArrayList<>();
            }
         
         
        
    }
    
    public void processDataFilter(){
        Map<Object,Number> dts=new HashMap<>();
        facturasDetalle=new ArrayList<>();
       materialCosolidado=new ArrayList();
       
        
         try{
             
          
            
            
            dts = facturasDetalle.stream().collect(Collectors.toMap(x-> x.getMaterialid().getMaterial().getMaterial(), y->(Number)y.getCantidad(),((s,r)-> (Double)s+(Double)r),HashMap::new));

            }catch(Exception ex){
                ex.printStackTrace();
                facturasDetalle=new ArrayList<>();
            }
         
            BarChartModel model = new BarChartModel();
            ChartSeries boys = new ChartSeries();
            boys.setLabel("Consolidado de Materiales(Kg)");

            boys.setData(dts);
            animatedModel2 = new BarChartModel();
            model.addSeries(boys);
            animatedModel2=model;
            animatedModel2.setTitle("Consolidado total de Materiales por Kg");
            animatedModel2.setAnimate(true);
            animatedModel2.setLegendPosition("ne");
            Axis yAxis = animatedModel2.getAxis(AxisType.Y);
            Axis xAxis = animatedModel2.getAxis(AxisType.X);
            xAxis.setTickAngle(90);
            yAxis.setMin(0);
        
    }
    
    
    
    
    
    
    private void createAnimatedModelsChar2() {
        animatedModel3 = new PieChartModel();
        Map<String,Number> dts = facturasDetalle.stream().collect(Collectors.toMap(x-> x.getMaterialid().getMaterial().getMaterial(), y->(Number)y.getCantidad(),((s,r)-> (Double)s+(Double)r),HashMap::new));
        animatedModel3.setData(dts);
 
        animatedModel3.setTitle("Materiales");
        animatedModel3.setLegendPosition("w");
        animatedModel3.setShowDataLabels(true);
        animatedModel3.setShadow(true);
        animatedModel3.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
    }
    
    
     List<Dtfacturadetalle> facturasDetalleEcas=new ArrayList<>();
    private void createAnimatedModelsChar4() {
        try{
         if(facturasDetalleEcas.isEmpty())
            facturasDetalleEcas= facturacion.getFacturaDetalle().findLikeParameter(facturacion.getFacturaDetalle().getObj().getClass().getName(), "FINDALLXECAXDETALLETIPOFACTURA", usuarioB.getTbUiUsuario().getDtEcaPadre().getId());
        }catch(Exception ex){
        
        }
        animatedModel3 = new PieChartModel();
        Map<String,Number> dts = facturasDetalleEcas.stream().collect(Collectors.toMap(x-> x.getMaterialid().getMaterial().getMaterial(), y->(Number)y.getCantidad(),((s,r)-> (Double)s+(Double)r),HashMap::new));
        animatedModel3.setData(dts);
 
        animatedModel3.setTitle("Materiales");
        animatedModel3.setLegendPosition("w");
        animatedModel3.setShowDataLabels(true);
        animatedModel3.setShadow(true);
        animatedModel3.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
        
    }
    
    private void createAnimatedModelsChar3() {
       
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Consolidado total de Materiales por Kg");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        animatedModel2.setMouseoverHighlight(false);
        animatedModel2.setStacked(true);
        animatedModel2.setShowPointLabels(true);
        
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        Axis xAxis = animatedModel2.getAxis(AxisType.X);
        xAxis.setTickAngle(90);
        yAxis.setMin(0);
    }
    
     List<Dtfacturadetalle> facturasDetalle=new ArrayList<>();
     
     private BarChartModel initBarModel() {
        //clientes. 
        Map<Object,Number> dts=new HashMap<>();
        
        if(facturasDetalle.isEmpty()){
            try{
               
            
            }catch(Exception ex){
               // ex.printStackTrace();
                facturasDetalle=new ArrayList<>();
            }
        }
        
         
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Consolidado de Materiales(Kg)");
        
        boys.setData(dts);
        
 
        model.addSeries(boys);
        return model;
    }
    

    public Map<Integer, Number> getCertificadoMateriales() {
        return certificadoMateriales;
    }

    public void setCertificadoMateriales(Map<Integer, Number> certificadoMateriales) {
        this.certificadoMateriales = certificadoMateriales;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Dtfacturadetalle> getFacturasDetalle() {
        return facturasDetalle;
    }

    public void setFacturasDetalle(List<Dtfacturadetalle> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }

   
     
     
    
}
