/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.view;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtecamaterial;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "v_materialprocesado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewMaterialProcesado.findAll", query = "SELECT v FROM ViewMaterialProcesado v"),
    @NamedQuery(name = "ViewMaterialprocesado.findByDtSucural", query = "SELECT v FROM ViewMaterialProcesado v WHERE v.dtEcassucursalid.id = ?0")})
public class ViewMaterialProcesado implements Serializable {
    private static String FINDBYSURUCAL="ViewMaterialprocesado.findByDtSucural";
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private String id;
    
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidadingreso")
    private Double cantidadingreso;
    
    @Column(name = "cantidadprocesada")
    private Double cantidadProcesada;
    
    @Column(name = "cantidaddesperdicio")
    private Double cantidadDesperdicio;
    
    
    @Column(name = "cantidadventa")
    private Double cantidadventa;
    
    @JoinColumn(name = "dtEcaSucursal_id",referencedColumnName = "id")
    @ManyToOne
    private Dtecassucursal dtEcassucursalid;
    
    
    @JoinColumn(name = "material_id",referencedColumnName = "id")
    @ManyToOne
    private Dtecamaterial dtMaterialid;

    public ViewMaterialProcesado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public Dtecamaterial getDtMaterialid() {
        return dtMaterialid;
    }

    public void setDtMaterialid(Dtecamaterial dtMaterialid) {
        this.dtMaterialid = dtMaterialid;
    }

    public Double getCantidadingreso() {
        return cantidadingreso;
    }

    public void setCantidadingreso(Double cantidadingreso) {
        this.cantidadingreso = cantidadingreso;
    }

    public Double getCantidadProcesada() {
        return cantidadProcesada;
    }

    public void setCantidadProcesada(Double cantidadProcesada) {
        this.cantidadProcesada = cantidadProcesada;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public Double getCantidadDesperdicio() {
        return cantidadDesperdicio;
    }

    public void setCantidadDesperdicio(Double cantidadDesperdicio) {
        this.cantidadDesperdicio = cantidadDesperdicio;
    }

    public Double getCantidadventa() {
        return cantidadventa;
    }

    public void setCantidadventa(Double cantidadventa) {
        this.cantidadventa = cantidadventa;
    }

    
    
    
    
}
