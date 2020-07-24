/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.view;

import java.io.Serializable;
import co.com.lk.Entity.ma.Dtmamaterial;
/**
 *
 * @author lukhack
 */
public class dtmaterialConsolidado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Dtmamaterial material;
    
    Double totalkg;
    
    Double totalPesos;

    public dtmaterialConsolidado(Dtmamaterial material, Double totalkg, Double totalPesos) {
        this.material = material;
        this.totalkg = totalkg;
        this.totalPesos = totalPesos;
    }
    
    
    public Dtmamaterial getMaterial() {
        return material;
    }

    public void setMaterial(Dtmamaterial material) {
        this.material = material;
    }

    public Double getTotalkg() {
        return totalkg;
    }

    public void setTotalkg(Double totalkg) {
        this.totalkg = totalkg;
    }

    public Double getTotalPesos() {
        return totalPesos;
    }

    public void setTotalPesos(Double totalPesos) {
        this.totalPesos = totalPesos;
    }
    
    
    
    
    
}
