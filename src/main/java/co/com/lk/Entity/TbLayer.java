/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import org.primefaces.model.map.Polygon;

/**
 *
 * @author julig
 */
public class TbLayer implements  Serializable{
    private int id;
    private String Nombre;
    private Polygon layer; 
    private boolean Visibled;
    public TbLayer() {
    }

    public TbLayer(int id, String Nombre, Polygon layer) {
        this.id = id;
        this.Nombre = Nombre;
        this.layer = layer;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Polygon getLayer() {
        return layer;
    }

    public void setLayer(Polygon layer) {
        this.layer = layer;
    }

    public boolean getVisibled() {
        return Visibled;
    }

    public void setVisibled(boolean Visibled) {
        this.Visibled = Visibled;
    }

    
    
    
    
    
}
