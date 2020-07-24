/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.pr;

import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Entity.ma.Dtecassucursal;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import co.com.lk.Entity.ma.Dttercero;
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
@Table(name = "pr_recolecciondesperdicio", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrRecoleccionDesperdicio.findAll", query = "SELECT d FROM PrRecoleccionDesperdicio d"),
    @NamedQuery(name = "PrRecoleccionDesperdicio.findAllxEca", query = "SELECT d FROM PrRecoleccionDesperdicio d where d.ecasucursal_id.id = ?0")})

public class PrRecoleccionDesperdicio implements Serializable {
    private static final String FINDALL="PrRecoleccionDesperdicio.findAll";
    private static final String FINDALLXECA="PrRecoleccionDesperdicio.findAllxEca";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecharecoleccion")
    @Temporal(TemporalType.TIMESTAMP)
    Date fecharecoleccion;
    
    @Column(name = "cantidad")
    Double cantidad;
    
    
    @Column(name = "observacion")
    String observacion;
    
    
    @Column(name = "placavehiculorecolector")
    String placavehiculorecolector;
    
    @ManyToOne
    @JoinColumn(name = "encargado_id",referencedColumnName = "id")
    Dttercero encargado_id ;
    
    
    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    TbUiUsuario usuario_id ;
    
    @ManyToOne
    @JoinColumn(name = "ecasucursal_id",referencedColumnName = "id")
    Dtecassucursal ecasucursal_id ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecharecoleccion() {
        return fecharecoleccion;
    }

    public void setFecharecoleccion(Date fecharecoleccion) {
        this.fecharecoleccion = fecharecoleccion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getPlacavehiculorecolector() {
        return placavehiculorecolector;
    }

    public void setPlacavehiculorecolector(String placavehiculorecolector) {
        this.placavehiculorecolector = placavehiculorecolector;
    }

    public Dttercero getEncargado_id() {
        return encargado_id;
    }

    public void setEncargado_id(Dttercero encargado_id) {
        this.encargado_id = encargado_id;
    }

    public TbUiUsuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(TbUiUsuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Dtecassucursal getEcasucursal_id() {
        return ecasucursal_id;
    }

    public void setEcasucursal_id(Dtecassucursal ecasucursal_id) {
        this.ecasucursal_id = ecasucursal_id;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrRecoleccionDesperdicio other = (PrRecoleccionDesperdicio) obj;
        if (!Objects.equals(this.observacion, other.observacion)) {
            return false;
        }
        if (!Objects.equals(this.placavehiculorecolector, other.placavehiculorecolector)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecharecoleccion, other.fecharecoleccion)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        return Objects.equals(this.encargado_id, other.encargado_id);
    }
    
    

    
    

    
}
