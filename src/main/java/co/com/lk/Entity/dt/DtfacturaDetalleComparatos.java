/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import co.com.lk.Entity.ma.Dtmamaterial;
import java.io.Serializable;

/**
 *
 * @author lukhack
 */
public class DtfacturaDetalleComparatos implements Serializable, Cloneable {
  
    Dtmamaterial material;
    Dtfacturadetalle listInic;
    
    Dtfacturadetalle listCompara;
    
    

    public DtfacturaDetalleComparatos() {
    }
    
    public Dtfacturadetalle getListInic() {
        return listInic;
    }

    public void setListInic(Dtfacturadetalle listInic) {
        this.listInic = listInic;
    }

    public Dtfacturadetalle getListCompara() {
        return listCompara;
    }

    public void setListCompara(Dtfacturadetalle listCompara) {
        this.listCompara = listCompara;
    }

    public Dtmamaterial getMaterial() {
        return material;
    }

    public void setMaterial(Dtmamaterial material) {
        this.material = material;
    }
    
    
    
}
