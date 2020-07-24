/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Entity.dt.Dtmaterialseparacion;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmaterialprocesado", schema = "generic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmaterialprocesado.findAll", query = "SELECT d FROM Dtmaterialprocesado d"),
    @NamedQuery(name = "Dtmaterialprocesado.findById", query = "SELECT d FROM Dtmaterialprocesado d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmaterialprocesado.findByFecha", query = "SELECT d FROM Dtmaterialprocesado d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Dtmaterialprocesado.findByTipoproceso", query = "SELECT d FROM Dtmaterialprocesado d WHERE d.tipoproceso = :tipoproceso"),
    @NamedQuery(name = "Dtmaterialprocesado.findByCantidad", query = "SELECT d FROM Dtmaterialprocesado d WHERE d.cantidad = :cantidad")})
public class Dtmaterialprocesado implements Serializable {


    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "tipoproceso")
    private Integer tipoproceso;
   
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    
    
    @Column(name = "procesadodeseparacion")
    private boolean procesadodeseparacion=false;
    
    @Transient
    private Double cantidadDisponible;
    
    
    @Column(name = "desperdicio")
    private Double desperdicio;
    
    @JoinTable(name = "dtmaterialprocesoxseparacion", schema = "generic", joinColumns = {
        @JoinColumn(name = "procesoId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "separacionId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Dtmaterialseparacion> dtmaterialseparacionCollection;
    
    @JoinColumn(name = "dtEcaSucursal_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtecassucursal dtEcaSucursalid;
    
    @JoinColumn(name = "dtMaterial_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtecamaterial dtMaterial_id;
    
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TbUiUsuario usuario_id;
    
    
    public Dtmaterialprocesado() {
    }

    public Dtmaterialprocesado(Integer id) {
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

    public Integer getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(Integer tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Dtecassucursal getDtEcaSucursalid() {
        return dtEcaSucursalid;
    }

    public void setDtEcaSucursalid(Dtecassucursal dtEcaSucursalid) {
        this.dtEcaSucursalid = dtEcaSucursalid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        final Dtmaterialprocesado other = (Dtmaterialprocesado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.tipoproceso, other.tipoproceso)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.cantidadDisponible, other.cantidadDisponible)) {
            return false;
        }
        if (!Objects.equals(this.desperdicio, other.desperdicio)) {
            return false;
        }
        if (!Objects.equals(this.dtEcaSucursalid, other.dtEcaSucursalid)) {
            return false;
        }
        if (!Objects.equals(this.dtMaterial_id, other.dtMaterial_id)) {
            return false;
        }
        return Objects.equals(this.usuario_id, other.usuario_id);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmaterialprocesado[ id=" + id + " ]";
    }

    public Dtecamaterial getDtMaterial_id() {
        return dtMaterial_id;
    }

    public void setDtMaterial_id(Dtecamaterial dtMaterial_id) {
        this.dtMaterial_id = dtMaterial_id;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Double getDesperdicio() {
        return desperdicio;
    }

    public void setDesperdicio(Double desperdicio) {
        this.desperdicio = desperdicio;
    }

    public TbUiUsuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(TbUiUsuario usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    @XmlTransient
    public Collection<Dtmaterialseparacion> getDtmaterialseparacionCollection() {
        return dtmaterialseparacionCollection;
    }

    public void setDtmaterialseparacionCollection(Collection<Dtmaterialseparacion> dtmaterialseparacionCollection) {
        this.dtmaterialseparacionCollection = dtmaterialseparacionCollection;        
    }

    public boolean isProcesadodeseparacion() {
        return procesadodeseparacion;
    }

    public void setProcesadodeseparacion(boolean procesadodeseparacion) {
        this.procesadodeseparacion = procesadodeseparacion;
    }
    
    
    
}
