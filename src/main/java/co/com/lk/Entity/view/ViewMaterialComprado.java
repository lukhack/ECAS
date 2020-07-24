/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.view;

import co.com.lk.Entity.PK.ViewMaterialCompradoPK;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtecamaterial;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "v_materialcomprado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewMaterialComprado.findAll", query = "SELECT v FROM ViewMaterialComprado v")})
public class ViewMaterialComprado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @EmbeddedId
    ViewMaterialCompradoPK compradoPK;
    
    Double cantidad;
    
    
    @JoinColumn(name = "material_id",referencedColumnName = "id",insertable = false,updatable = false)
    @ManyToOne
    private Dtecamaterial dtMaterialid;
    
    @JoinColumn(name = "dtEcassucursal_id",referencedColumnName = "id",insertable = false,updatable = false)
    @ManyToOne
    private Dtecassucursal dtEcassucursalid;
    

    public ViewMaterialComprado() {
    }

    public Dtecamaterial getDtMaterialid() {
        return dtMaterialid;
    }

    public void setDtMaterialid(Dtecamaterial dtMaterialid) {
        this.dtMaterialid = dtMaterialid;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public ViewMaterialCompradoPK getCompradoPK() {
        return compradoPK;
    }

    public void setCompradoPK(ViewMaterialCompradoPK compradoPK) {
        this.compradoPK = compradoPK;
    }

    
}
