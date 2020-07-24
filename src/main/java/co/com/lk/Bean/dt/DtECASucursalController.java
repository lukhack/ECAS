/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.ma.Dteca;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.helper.facesMenssage;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.locationtech.jts.geom.Geometry;
import org.primefaces.context.RequestContext;
//import org.primefaces.PrimeFaces;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtECASucursalController extends UiManager<Dtecassucursal>{
    
    
    Dtecassucursal objData;
    
    @Inject
    MapsBean gmap;
    
    public DtECASucursalController() {
        super(new Dtecassucursal());
        objData=new Dtecassucursal();
        
    }
    
    @PostConstruct
    public void init(){
        findList();
        geoEcas();
    }

    @Override
    public List<Dtecassucursal> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dtecassucursal obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dtecassucursal> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }
    
    public List<Dtecassucursal> getListECAId(Integer idCliente) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            setList((List<Dtecassucursal>) findLikeParameter(getObj().getClass().getName(), "FINDIDECA", idCliente));
            return getList();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(DtECASucursalController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Dtecassucursal> findList() {
        return super.findList(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public List<Dtecassucursal> getListAllECAId() {
        try {
            //To change body of generated methods, choose Tools | Templates.
            
            findList(); 
            if(Objects.nonNull(getList()))
              setList(getList().stream().filter(x->x.getShowreport()).collect(Collectors.toList()));
            
            return getList();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(DtECASucursalController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void newObject(){
        objData=new Dtecassucursal();
    }

    public Dtecassucursal getObjData() {
        return objData;
    }

    public void setObjData(Dtecassucursal objData) {
        this.objData = objData;
    }
    
    public void selectObjecGeo(Dtecassucursal obj) throws Exception {
        setObj(obj);
        StringBuilder sb=new StringBuilder();
        
        sb.append(obj.getDireccion()).append(", ");
        sb.append(obj.getMamunicipioId().getMunicipio()).append(", ");
        sb.append(obj.getMamunicipioId().getIdDepartamento().getDepartamento());
        
        /* //To change body of generated methods, choose Tools | Templates.
        StringBuilder sb=new StringBuilder();
        
        sb.append("https://maps.googleapis.com/maps/api/geocode/json?address=");
        
        sb.append(obj.getDireccion().replace(" ", "%20").replace("#","")).append("+");
        sb.append(obj.getMamunicipioId().getMunicipio()).append("+");
        sb.append(obj.getMamunicipioId().getIdDepartamento().getDepartamento());
        sb.append("&key=AIzaSyAAsbelbQ71UwxP3ut3SiozFDWHneQm5J4"); 
        
        System.err.println("url: "+sb.toString());
        LatLng coord1= MapJson.readJson(sb.toString());
       ;*/
        
        /*se comenta esta liena por problemas con el jboss y el datasoruce
        if(Objects.isNull(obj.getPocision()))
            //PrimeFaces.current().executeScript("geocodec('"+sb.toString()+"')");
            RequestContext.getCurrentInstance().execute("geocodec('"+sb.toString()+"')");
        else{
            gmap.setGeoModel(new DefaultMapModel());
            
            gmap.setMarker(new Marker(new LatLng(obj.getPocision().getCoordinate().x, obj.getPocision().getCoordinate().y), obj.getFilial()+"<br/> Dirección"+obj.getDireccion()));
            gmap.getMarker().setDraggable(true);
            
            gmap.getGeoModel().addOverlay(gmap.getMarker());
            
        }*/
           
    }
    
    
    public void onMarkerDrag(MarkerDragEvent event) {
        gmap.setMarker(event.getMarker());
        LatLng latlng= gmap.getMarker().getLatlng();
        Geometry   geo =  new org.locationtech.jts.geom.GeometryFactory().createPoint(new org.locationtech.jts.geom.Coordinate(latlng.getLat(), latlng.getLng()));
        /*se comenta esta liena por problemas con el jboss y el datasoruce
            getObj().setPocision(geo);
        */
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Lat:" + gmap.getMarker().getLatlng().getLat() + ", Lng:" + gmap.getMarker().getLatlng().getLng(),""));
    }
    
    
    public void onMarkerSelect(OverlaySelectEvent event) {
        Marker marker=(Marker) event.getOverlay();
        gmap.setMarker(marker);
        setObj((Dtecassucursal)marker.getData());
        System.err.println("object: "+getObj().getId());
    }
    
    
    public void geoEcas(){
        gmap.setGeoModel(new DefaultMapModel());
        /*se comenta esta liena por problemas con el jboss y el datasoruce
        
        getList().stream().forEach(x->{
            if(Objects.nonNull(x.getPocision())){
               Marker marker=new Marker(new LatLng(x.getPocision().getCoordinate().x, x.getPocision().getCoordinate().y), x.getFilial()+" Dirección"+x.getDireccion());
               marker.setData(x);
               marker.setIcon("images/casa.png");
               gmap.getGeoModel().addOverlay(marker);
            }
        });
        
        */
    }
    
     public void onGeocode(GeocodeEvent event) {
         gmap.setGeoModel(new DefaultMapModel());
         System.err.println("soy un geocoding");
         List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            gmap.setCenterGeoMap(center.getLat() + "," + center.getLng());
             
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                Marker mk=new Marker(result.getLatLng(), result.getAddress());
                
                mk.setDraggable(true);
                Geometry   geo =  new org.locationtech.jts.geom.GeometryFactory().createPoint(new org.locationtech.jts.geom.Coordinate(result.getLatLng().getLat(), result.getLatLng().getLng()));
       
                /*se comenta esta liena por problemas con el jboss y el datasoruce
                    getObj().setPocision(geo);
                */
                gmap.getGeoModel().addOverlay(mk);
            }
        }
    }
    
    public Point point(Double x,Double y){
        Coordinate cor=new Coordinate(x,y);
        GeometryFactory geometryFactory = new GeometryFactory();         
        Point point = geometryFactory.createPoint(cor);
        return point;
     }
    
    public String  reinit(Dteca dt) throws Exception {
        if(Objects.isNull(getObj().getDtEcaid()))
            getObj().setDtEcaid(dt);
        
        setObj(new Dtecassucursal()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public MapsBean getGmap() {
        return gmap;
    }

    public void setGmap(MapsBean gmap) {
        this.gmap = gmap;
    }

    
    
    
    
    
    
}
