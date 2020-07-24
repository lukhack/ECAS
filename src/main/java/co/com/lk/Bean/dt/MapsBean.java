/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class MapsBean  implements Serializable {
    private MapModel geoModel;
    private String centerGeoMap = "6.245008, -75.573775";
    private Integer zoom=13;
    private String typeMap="ROADMAP"; 
    
    GeocodeResult coder =  new GeocodeResult();
    
    private Marker marker;
    
    public MapsBean() {
         
    }
    
            
    
    
     
    
    

    public MapModel getGeoModel() {
        return geoModel;
    }

    public void setGeoModel(MapModel geoModel) {
        this.geoModel = geoModel;
    }

    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    public void setCenterGeoMap(String centerGeoMap) {
        this.centerGeoMap = centerGeoMap;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public GeocodeResult getCoder() {
        return coder;
    }

    public void setCoder(GeocodeResult coder) {
        this.coder = coder;
    }

    public String getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(String typeMap) {
        this.typeMap = typeMap;
    }
    
     
     
    
}
