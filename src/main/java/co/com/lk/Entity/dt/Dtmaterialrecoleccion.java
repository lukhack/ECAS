/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.ma.Dtterceroruta;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmaterialrecoleccion", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmaterialrecoleccion.findAll", query = "SELECT d FROM Dtmaterialrecoleccion d")})
public class Dtmaterialrecoleccion implements Serializable {
    
    private static final String FINDALL="Dtmaterialrecoleccion.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "cantidadSacos")
    private Double cantidadSacos;
    
    @JoinColumn(name = "dttercero", referencedColumnName = "id")
    @ManyToOne
    private Dttercero dttercero;
    
    @JoinColumn(name = "dtterceroruta", referencedColumnName = "id")
    @ManyToOne
    private Dtterceroruta dtterceroruta;
    
    
    
    @JoinColumn(name = "dtecaSucursal", referencedColumnName = "id")    
    @ManyToOne(optional = false)
    private Dtecassucursal dtEcassucursalid;
    
    public Dtmaterialrecoleccion() {
    }

    public Dtmaterialrecoleccion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getCantidadSacos() {
        return cantidadSacos;
    }

    public void setCantidadSacos(Double cantidadSacos) {
        this.cantidadSacos = cantidadSacos;
    }

    public Dttercero getDttercero() {
        return dttercero;
    }

    public void setDttercero(Dttercero dttercero) {
        this.dttercero = dttercero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public Dtterceroruta getDtterceroruta() {
        return dtterceroruta;
    }

    public void setDtterceroruta(Dtterceroruta dtterceroruta) {
        this.dtterceroruta = dtterceroruta;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtmaterialrecoleccion)) {
            return false;
        }
        Dtmaterialrecoleccion other = (Dtmaterialrecoleccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtmaterialrecoleccion[ id=" + id + " ]";
    }
    
}
