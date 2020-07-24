/*
A JSF2 Leaflet wrapper component for OpenStreetMap
Copyright (C) 2015 Leonardo Ciocari

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.*/

package co.com.lk.Bean.Controller;


import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.Mamunicipio;
import co.com.lk.Entity.TbLayer;
import co.com.lk.Entity.ma.Dtmamaterial;
import co.com.lk.Interfaces.genericImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
//import org.primefaces.PrimeFaces;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;

@Named
@ViewScoped 
public class MapBean implements Serializable { // "implements Serializable" to fix WELD-000072

    private MapModel simpleModel=new DefaultMapModel();
    private String typeMap="ROADMAP"; 
    private Marker marker;
    private Map<Integer,TbLayer> layerMap = new HashMap();
    private String nombre="lukas";
    private String latLog="6.25184, -75.56359";
    private boolean selectedCars;
    private TreeNode[] selectedNodes2;
    private int zoom=13;
    private String positionStreet;
    private String mensaje;
    private String mensajeActividad="";
    
    private Mamunicipio dependencia;
    private List<Mamunicipio> dependencias;
    
    private String direAutocompet;
    private int dialosType;
    
    private genericImp dao;
    
    private TreeNode root;
    private StreamedContent file;
    
    
    
    @Inject
    private UsuarioB usuarioB;  
    
    
    
    
    private boolean activarPuntos;
    private boolean activarPuntosErr;
    private String images;
    
    private BarChartModel barModel;
    
    private Dtmamaterial meteriales; 
    
    public MapBean()
    {
        meteriales = new Dtmamaterial();
          dependencia = new Mamunicipio();
          dependencias= new ArrayList<>();
          dao = new genericDAO();
          barModel=new BarChartModel();
    }
            
    
    @PostConstruct
    public void init(){
        System.out.println("ApplicationContainer injected: ");
        try {
          
           
        } catch (Exception ex) {
            ex.printStackTrace();
           
        }
    }
    

    

    

    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();
        System.out.println("co.com.lk.Bean.MapBean.onMarkerDrag()"+marker.getLatlng().getLat());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
    }
    
    

   
    
    public Polygon crearPolygon(int id,String idlayer, int polyN){
        List<LatLng> coord1 = new ArrayList<>();
        String color="";
        switch(polyN){
            case 1:
                coord1.add(new LatLng(4.867439690471111, -74.07339479370114));
                coord1.add(new LatLng(4.864660247185872, -74.07614137573239));
                coord1.add(new LatLng(4.860811768309156, -74.07421018524167));
                coord1.add(new LatLng(4.870090841059394, -74.06708623809811));
                color="#82FA58";
            break;
            case 2:
                coord1.add(new LatLng(4.874537908894723, -74.06300928039548));
                coord1.add(new LatLng(4.871630214024203, -74.06309511108395));
                coord1.add(new LatLng(4.871715734641126, -74.05983354492184));
                color="#ffffff";
            break;
            case 3:
                coord1.add(new LatLng(4.86287809662465, -74.05867483062741));
                coord1.add(new LatLng(4.864417486091284, -74.06378175659177));
                coord1.add(new LatLng(4.868094902233847, -74.06215097351071));
                coord1.add(new LatLng(4.86287809662465, -74.05867483062741));
                color="#000000";
            break;
        }
        
        
        Polygon polygon = new Polygon();        
        polygon.setFillColor(color);
        polygon.setFillOpacity(0.35);
        polygon.setStrokeOpacity(0.35);
        polygon.setId(idlayer);
        polygon.getPaths().stream().collect(Collectors.toCollection(()->coord1));
        polygon.setData(polyN);
        coord1.stream().forEach((e)->polygon.getPaths ().add(e)); 
        
        return polygon;
    }
    
    public void function(int layer){
        
        if(layerMap.get(layer).getVisibled()){
                 simpleModel.addOverlay(layerMap.get(layer).getLayer());
        }else{    
             /*
                simpleModel.getPolygons().stream().filter((p) -> (Integer.valueOf(layer)==(int) p.getData())).forEach((p) -> 
                {
                   simpleModel.getPolygons().remove(p);
                }); */
             for (Iterator<Polygon> iter = simpleModel.getPolygons().listIterator(); iter.hasNext(); ) {
                    Polygon p = iter.next();
                    if (Integer.valueOf(layer)==(int) p.getData()) {
                        iter.remove();
                        return;
                    }
                }
             
            
         }/*
        for(Polygon p:simpleModel.getPolygons()){
        if(Integer.valueOf(layer)==(int) p.getData()){
        if(layerMap.get(layer).getVisibled()){
        p.setFillOpacity(1);
        p.setStrokeOpacity(1);
        }else{
        p.setFillOpacity(0);
        p.setStrokeOpacity(0);
        }
        }
        }    */   
    }
    
    public void chanlistenSelecOneMenu(AjaxBehaviorEvent event){
        /*dependencia=  (TbMaMunicipios) ((SelectOneMenu) event.getSource()).getValue();
        if(dependencia!=null){
            
            try {
                dependencia.setMaCapaTipos(dao.findLikeParameter(new TbMaArea().getClass().getName(),"FINDIDDEPENDENCIA",dependencia.getId()));
                
                RequestContext context = RequestContext.getCurrentInstance();
                //System.err.println("hola "+dependencia.getDependencia());
                latLog=dependencia.getLocalizacion().getCoordinate().x+","+dependencia.getLocalizacion().getCoordinate().y;
                this.zoom=10;
                context.execute("findPosition("+dependencia.getLocalizacion().getCoordinate().x+","+dependencia.getLocalizacion().getCoordinate().y+",14);");  
                createTreeNode();
            } catch (Exception ex) {
                Logger.getLogger(MapBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }
    
    private void createTreeNode() {
         
        try {
            TreeNode root2 = new CheckboxTreeNode(dependencia, null);
            
            /*dependencia.getMaCapaTipos().stream().filter(x->x.getEstado()) .forEach(x->{
                TreeNode documents = new CheckboxTreeNode(x, root2);
               
            });*/
            
            root=root2;
        } catch (Exception ex) {
            Logger.getLogger(MapBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    double xy=0;
    
    public void displaySelectedMultiple(TreeNode[] nodes) {
        try {
            /*List<MaIUCargas> data=new ArrayList<>();
            Polygon polygon = new Polygon();
            simpleModel = new DefaultMapModel();
            zoom=14;
            GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));
                                            
            if (nodes!=null){
                for(TreeNode node : nodes) {
                    
                    if(node.getData() instanceof TbMaSubArea){
                       
                        TbMaSubArea capa=((TbMaSubArea)node.getData());
                        String id=capa.getId();
                        System.out.println("codigo: "+id);
                        data= (List<MaIUCargas>) dao.findLikeParameter(moCarga.getClass().getName(), "FINDIDBARRIO", id);
                            
                        
                        for(TbMaSubAreaSpatial sas: capa.getSubAreaSpatial()){
                             List<LatLng> coord1=new ArrayList<>();
                            System.err.println("id: "+sas.getId());
                            Arrays.asList(sas.getGeometry().getCoordinates()).stream().forEach((e)->{
                                coord1.add(new LatLng(e.y, e.x));
                            });
                            MaIUInforme iu= gbMaestrosBean.getUinformes().stream().filter(y->y.getCodBarrio().equals(capa.getId())).findAny().orElse(null);
                            
                            polygon = new Polygon();        
                            polygon.setFillOpacity(0.35);
                            polygon.setStrokeOpacity(0.35);
                            polygon.setPaths(coord1);
                            polygon.setData(capa);
                            if(iu!=null){
                                if(iu.getRealizada()==0 && iu.getAsignada()==0 && iu.getDescarga()==0){
                                    polygon.setFillColor("#A9A9A9");
                                }else if(iu.getRealizada()==iu.getTotal())
                                    //polygon.setFillColor("#A901DB");
                                    polygon.setFillColor("#A9A9A9");
                                else if(iu.getNuevos()!=iu.getTotal())
                                   // polygon.setFillColor("#FF8000");
                                    polygon.setFillColor("#A9A9A9");
                                else
                                    polygon.setFillColor("#00b200");
                                    polygon.setFillColor("#A901DB");
                            }else{
                                polygon.setFillColor("#A9A9A9");
                            }
                        simpleModel.addOverlay(polygon);
                    }
                        
                        if(activarPuntos){
                                data.stream().forEach(x->{
                                    Marker mk;
                                    Coordinate c;
                                    Point point;
                                    
                                    if(x.getCoodenadas() != null){
                                         if(x.getEstado().trim().toUpperCase().equals("S")){
                                            Double[] cd= processCoordiate(x.getCoodenadas());
                                            c=new Coordinate(cd[0],cd[1]);
                                            mk=new Marker(new LatLng(cd[1],cd[0]));
                                            mk.setTitle("Nombre Formulario: "+x.getNoform());
                                            mk.setDraggable(false);
                                            mk.setData(x);

                                            point = factory.createPoint(c);

                                            boolean poligonContaint=false;
                                            boolean poligonDistan=false;
                                            
                                            
                                            
                                            for(TbMaSubAreaSpatial sas: capa.getSubAreaSpatial()){
                                                if(sas.getGeometry().contains(point)){
                                                    poligonContaint=true;
                                               }
                                            }
                                            
                                            
                                            if(poligonContaint){
                                                Integer candidato=Integer.valueOf(x.getCandidato());
                                                switch(candidato){
                                                    case 1:
                                                        mk.setIcon("images/marker1.png");
                                                        break;
                                                    case 2:
                                                        mk.setIcon("images/marker2.png");
                                                        break;
                                                    case 3:
                                                        mk.setIcon("images/marker3.png");
                                                        break;
                                                    case 4:
                                                        mk.setIcon("images/marker4.png");
                                                        break;
                                                    case 5:
                                                        mk.setIcon("images/marker5.png");
                                                        break;
                                                    default:
                                                        mk.setIcon("images/marker6.png");
                                                        break;
                                                }
                                                
                                                simpleModel.addOverlay(mk);
                                            }else{
                                               
                                            }
                                            
                                            
                                            
                                        }
                                    }
                                 });    
                                
                            }
                }else if(node.getData() instanceof TbMaArea){
                       
                        TbMaArea capa=((TbMaArea)node.getData());
                        String id=capa.getId();
                        data= (List<MaIUCargas>) dao.findLikeParameter(moCarga.getClass().getName(), "FINDIDCOMUNA", id);
                            
                        
                      if(Objects.nonNull(capa.getGeometry())){
                             List<LatLng> coord1=new ArrayList<>();
                            System.err.println("id: "+capa.getId());
                            if(activarPuntosErr){
                                Arrays.asList(capa.getGeometry().getCoordinates()).stream().forEach((e)->{
                                    coord1.add(new LatLng(e.y, e.x));
                                });
                            }
                            
                            polygon = new Polygon();        
                            polygon.setFillOpacity(0.35);
                            polygon.setStrokeOpacity(0.35);
                            polygon.setPaths(coord1);
                            polygon.setData(capa);
                           
                            polygon.setFillColor(colorPoligon(capa));
                                
                        simpleModel.addOverlay(polygon);
                    }
                        
                        if(activarPuntos){
                                data.stream().forEach(x->{
                                    Marker mk;
                                    Coordinate c;
                                    Point point;
                                    
                                    if(x.getCoodenadas() != null){
                                         if(x.getEstado().trim().toUpperCase().equals("S")){
                                            Double[] cd= processCoordiate(x.getCoodenadas());
                                            c=new Coordinate(cd[0],cd[1]);
                                            mk=new Marker(new LatLng(cd[1],cd[0]));
                                            mk.setTitle("Numero Formulario: "+x.getNoform());
                                            mk.setDraggable(false);
                                            mk.setData(x);

                                            point = factory.createPoint(c);

                                            boolean poligonContaint=false;
                                            boolean poligonDistan=false;
                                            
                                             poligonContaint=true;
                                             
                                            
                                            if(poligonContaint){
                                                Integer candidato=Integer.valueOf(x.getCandidato());
                                                switch(candidato){
                                                    case 1:
                                                        mk.setIcon("images/marker1.png");
                                                        break;
                                                    case 2:
                                                        mk.setIcon("images/marker2.png");
                                                        break;
                                                    case 3:
                                                        mk.setIcon("images/marker3.png");
                                                        break;
                                                    case 4:
                                                        mk.setIcon("images/marker4.png");
                                                        break;
                                                    case 5:
                                                        mk.setIcon("images/marker5.png");
                                                        break;
                                                    default:
                                                        mk.setIcon("images/marker6.png");
                                                        break;
                                                }
                                                
                                                simpleModel.addOverlay(mk);
                                            }
                                            
                                            
                                            
                                        }
                                    }
                                 });    
                                
                            }
                }
            }
            }*/
        } catch (Exception ex) {
            Logger.getLogger(MapBean.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    /*
    private String colorPoligon(TbMaArea capa){
        Map<String,Integer> map=new LinkedHashMap<>();
        capa.getCargas().stream().filter(x->!(Objects.equals(x.getCandidato(), "6") ||  Objects.equals(x.getCandidato(), "-88"))).forEach(y->{
                if(Objects.isNull(map.get(y.getCandidato())))
                    map.put(y.getCandidato(),1);
                else
                    map.put(y.getCandidato(),map.get(y.getCandidato())+1);
        });
        
        AtomicInteger key=new AtomicInteger(0);
        AtomicInteger value=new AtomicInteger(0);
        
        map.entrySet().stream().forEach(x->{
            if(Objects.equals(key.get(), 0)){
                key.set(Integer.valueOf(x.getKey()));
                value.set(x.getValue());
            }
                
            if(x.getValue()>value.get()){
                value.set(x.getValue());
                key.set(Integer.valueOf(x.getKey()));
            }
                
        
        });
        Integer i=key.get();
        System.err.println("id: "+i);
        switch(i){
            case 1:
                return "#9ef8f6";
            case 2:
                return "#e704c5";
            case 3:
                return "#01e735";
            case 4:
                return "#ffa900";
            case 5:
                return "#f3ff00";
            default:
                return "#c3c3c3";
        }
        
    }*/


     private Double[] processCoordiate(String coordinate){
          Double[] cd=new Double[2];
         try{
         String[] dt=coordinate.split(":");
         cd[0]=Double.valueOf(dt[0]);
         cd[1]=Double.valueOf(dt[1]);
        }catch(Exception ex){
            cd[0]=0.0;
            cd[1]=0.0;
        } finally{
            return cd;
         }
        //System.err.println("x:"+cd[0]+" y:"+cd[1]);
         
     }
     
      
     
     public String traducirCandidato(Integer id){
         
         switch(id){
            case 1:
                 return "Candidato 1";
            case 2:
                return "Candidato 2";
            case 3:
                return "Candidato 3";
            case 4:
                return "Candidato 4";
            case 5:
                return "Candidato 5";
            default:
                return "Candidato 6";
         }
         
     }
     
    
      
     
    public void openStreeView(){
        //System.out.println("hola mundo");
        RequestContext context= RequestContext.getCurrentInstance();
        if(dependencia!=null){
            //latLog=dependencia.getLocalizacion().getCoordinate().x+","+dependencia.getLocalizacion().getCoordinate().y;
            //PrimeFaces.current().executeScript("PF('dialogProcesarSueloStreetview').show()");
            context.execute("PF('dialogProcesarSueloStreetview').show()");
            if(positionStreet!=null){
                //PrimeFaces.current().executeScript("showStreeView("+positionStreet+");");
                context.execute("showStreeView("+positionStreet+");");
            }else{
               // context.executeScript("showStreeView("+dependencia.getLocalizacion().getCoordinate().x+","+dependencia.getLocalizacion().getCoordinate().y+");");
            }
        }else{
            mensaje="Debes seleccionar un Municipio para ejecutar esta acción";
            context.execute("PF('dialogMensaje').show()");
            //PrimeFaces.current().executeScript("PF('dialogMensaje').show()");
        }
    }
    
    public void openMarker(){
        RequestContext context= RequestContext.getCurrentInstance();
        if(dependencia!=null){
             //latLog=dependencia.getLocalizacion().getCoordinate().x+","+dependencia.getLocalizacion().getCoordinate().y;
                context.execute("PF('dialogProcesarSueloGeo').show()");                
                //PrimeFaces.current().executeScript("PF('dialogProcesarSueloGeo').show()");
                if(positionStreet!=null){
                    context.execute("showMarkerView("+positionStreet+");");
                    //PrimeFaces.current().executeScript("showMarkerView("+positionStreet+");");
                }else{
                    context.execute("showMarkerView("+latLog+");");
                    //PrimeFaces.current().executeScript("showMarkerView("+positionStreet+");");
                }
                //PrimeFaces.current().ajax().update("formSearchGeo");
                context.update("formSearchGeo"); 
                     
                
        }else{
            mensaje="Debes seleccionar un Municipio para ejecutar esta acción";
            //PrimeFaces.current().executeScript("PF('dialogMensaje').show()");
            RequestContext.getCurrentInstance().execute("PF('dialogMensaje').show()");
        }
    }
    
    public void calDistanciaActividad(){
        
        
    }
    
    
    
    public void openDialogInforme(){
         RequestContext context= RequestContext.getCurrentInstance();
         try {
                if(dependencia!=null){
                    switch(dialosType){
                        case 1:
                                
                            context.execute("PF('dialogProcesarSueloDireccion').show()");
                            //actividadEconomica=null;
                            //filterCatastrals1=null;
                            context.update("formSueloDireccion");
                            context.execute("PF('tbdirecciones').filter();");
                            //PrimeFaces.current().executeScript("PF('dialogProcesarSueloDireccion').show()");
                            //PrimeFaces.current().executeScript("formSueloDireccion");
                            //PrimeFaces.current().executeScript("PF('tbdirecciones').filter();");
                             
                        break;
                        case 2:
                             context.execute("PF('dialogProcesarActividad').show()");
                             //actividadEconomica=null;
                             //filterCatastrals2=null;
                             context.update("formSueloActividad");
                             context.execute("PF('tbdireccionesActvidad').filter();");
                            //PrimeFaces.current().executeScript("PF('dialogProcesarActividad').show()");
                            //PrimeFaces.current().executeScript("formSueloActividad");
                            //PrimeFaces.current().executeScript("PF('tbdireccionesActvidad').filter();");
                            break;
                        case 3:
                            openMarker();

                            break;
                        case 4:
                             context.execute("PF('dialogInformeSuelos').show()");
                             //PrimeFaces.current().executeScript("PF('dialogInformeSuelos').show()");
                            break;
                        default:
                            mensaje="Debes seleccionar un tipo de informe.";
                            context.execute("PF('dialogMensaje').show()");
                            //PrimeFaces.current().executeScript("PF('dialogMensaje').show()");
                        break;

                    }
                }else{
                    mensaje="Debes seleccionar un municipio";
                    context.execute("PF('dialogMensaje').show()");
                    //PrimeFaces.current().executeScript("PF('dialogMensaje').show()");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(MapBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void geocoding(){
         RequestContext context= RequestContext.getCurrentInstance();
         if(dependencia.getId()!=null){
            StringBuilder direccion = new StringBuilder();
            direccion.append(direAutocompet);
            direccion.append(" "/*+dependencia.getDependencia()*/);
            direccion.append(" Colombia");
            context.execute("geocodeAddress('"+direccion.toString()+"');");
            //PrimeFaces.current().executeScript("geocodeAddress('"+direccion.toString()+"');");
         }else{
             context.execute("geoCodingError('Debes seleccionar un Municipio')");
             //PrimeFaces.current().executeScript("geoCodingError('Debes seleccionar un Municipio')");
         }
        
    }
    
    
    public  PieChartModel paintchar(/*TbMaMunicipios*/Object dependencia){
        
        
       
        Map<String,Number> map=new LinkedHashMap<>();
        /*dependencia.getComunas().stream().forEach(x->{
            x.getCargas().stream().forEach(y->{
                    if(Objects.isNull(map.get(traducirCandidato(Integer.valueOf(y.getCandidato())))))
                            map.put(traducirCandidato(Integer.valueOf(y.getCandidato())),1);
                    else
                        map.put(traducirCandidato(Integer.valueOf(y.getCandidato())),map.get(traducirCandidato(Integer.valueOf(y.getCandidato()))).intValue()+1);
            });
            
        });*/
        
        
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Candidatos");
        
        PieChartModel pieModel1 = new PieChartModel();
        pieModel1.setData(map);
        
        pieModel1.setTitle("Por cuál de las siguientes personas del usted votaría para la Alcaldía");
        pieModel1.setLegendPosition("e");
        pieModel1.setFill(true);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(150);
        pieModel1.setShadow(true);
        
        return pieModel1;
    
    }   
                
      
   
    
    public void showDialog(String dialog){
        if(dependencia!=null){
            if(dialog.equals("dialogProcesarSuelo"))
                dialosType=0;
            
            String execute="PF('"+dialog+"').show()";
            RequestContext.getCurrentInstance().execute(execute);
            //PrimeFaces.current().executeScript(execute);
            
        }else{
            mensaje="Debes seleccionar un Municipio para ejecutar esta acción";
            RequestContext.getCurrentInstance().execute("PF('dialogMensaje').show()");
            //PrimeFaces.current().executeScript("PF('dialogMensaje').show()");
        }
    }
    public void newMapModel(){
        simpleModel=new DefaultMapModel();
    }
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    
    
    
    public void selectOptionMapListener(String typemap){
       this.typeMap= typemap;
    }
    
    public void setTypeMap(String typeMap) {
        this.typeMap = typeMap;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mamunicipio> getDependencias() {
        return dependencias;
    }

    public void setDependencias(List<Mamunicipio> dependencias) {
        this.dependencias = dependencias;
    }

    

    public Mamunicipio getDependencia() {
        return dependencia;
    }

    public void setDependencia(Mamunicipio dependencia) {
        this.dependencia = dependencia;
    }

    
    

    public String getTypeMap() {
        return typeMap;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }
    
    public MapModel getDraggableModel() {
        return simpleModel;
    }

    public Map<Integer, TbLayer> getLayerMap() {
        return layerMap;
    }

    public void setLayerMap(Map<Integer, TbLayer> layerMap) {
        this.layerMap = layerMap;
    }

    public boolean getSelectedCars() {
        return selectedCars;
    }

    public void setSelectedCars(boolean selectedCars) {
        this.selectedCars = selectedCars;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDireAutocompet() {
        return direAutocompet;
    }

    public void setDireAutocompet(String direAutocompet) {
        this.direAutocompet = direAutocompet;
    }

    public String getLatLog() {
        return latLog;
    }

    public void setLatLog(String latLog) {
        this.latLog = latLog;
    }

    public TreeNode[] getSelectedNodes2() {
        return selectedNodes2;
    }

    public void setSelectedNodes2(TreeNode[] selectedNodes2) {
        this.selectedNodes2 = selectedNodes2;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    
    public String getPositionStreet() {
        return positionStreet;
    }

    public void setPositionStreet(String positionStreet) {
        this.positionStreet = positionStreet;
    }

   
    public String getMensajeActividad() {
        return mensajeActividad;
    }

    public void setMensajeActividad(String mensajeActividad) {
        this.mensajeActividad = mensajeActividad;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public int getDialosType() {
        return dialosType;
    }

    public void setDialosType(int dialosType) {
        this.dialosType = dialosType;
    }


    public UsuarioB getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
        this.usuarioB = usuarioB;
    }
    /*
    public GbMaestrosBean getGbMaestrosBean() {
        return gbMaestrosBean;
    }

    public void setGbMaestrosBean(GbMaestrosBean gbMaestrosBean) {
        this.gbMaestrosBean = gbMaestrosBean;
    }*/

    
    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public boolean isActivarPuntos() {
        return activarPuntos;
    }

    public void setActivarPuntos(boolean activarPuntos) {
        this.activarPuntos = activarPuntos;
    }

    public boolean getActivarPuntosErr() {
        return activarPuntosErr;
    }

    public void setActivarPuntosErr(boolean activarPuntosErr) {
        this.activarPuntosErr = activarPuntosErr;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }


    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public Dtmamaterial getMeteriales() {
        return meteriales;
    }

    public void setMeteriales(Dtmamaterial meteriales) {
        this.meteriales = meteriales;
    }

    

    
    

    
    
    
    
   
     
}
