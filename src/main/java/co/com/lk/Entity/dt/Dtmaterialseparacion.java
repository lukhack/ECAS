/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtmaterialprocesado;
import co.com.lk.Entity.ma.Dttercero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmaterialseparacion", schema = "generic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmaterialseparacion.findAll", query = "SELECT d FROM Dtmaterialseparacion d")})
public class Dtmaterialseparacion implements Serializable {
    
    private static final String FINDALL="Dtmaterialseparacion.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantSacos")
    private Double cantSacos;
    
    @Column(name = "cantPeso")
    private Double cantPeso;
    
    @Column(name = "cantDesperdicio")
    private Double cantDesperdicio;
    
    
    @JoinColumn(name = "dttercero", referencedColumnName = "id")
    @ManyToOne
    private Dttercero dttercero;
    
    
    @JoinColumn(name = "dtecaSucursal", referencedColumnName = "id")    
    @ManyToOne(optional = false)
    private Dtecassucursal dtEcassucursalid;
    
    
    
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")    
    @ManyToOne(optional = false)
    private TbUiUsuario usuarioId;
    
    
    
    @ManyToMany(mappedBy = "dtmaterialseparacionCollection",cascade = {CascadeType.ALL})
    private Collection<Dtmaterialprocesado> dtmaterialprocesadoCollection;

    public Dtmaterialseparacion() {
        dtmaterialprocesadoCollection=new ArrayList<>();
    }

    public Dtmaterialseparacion(Integer id) {
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

    public Double getCantSacos() {
        return cantSacos;
    }

    public void setCantSacos(Double cantSacos) {
        this.cantSacos = cantSacos;
    }

    public Double getCantPeso() {
        return cantPeso;
    }

    public void setCantPeso(Double cantPeso) {
        this.cantPeso = cantPeso;
    }

    public Double getCantDesperdicio() {
        return cantDesperdicio;
    }

    public void setCantDesperdicio(Double cantDesperdicio) {
        this.cantDesperdicio = cantDesperdicio;
    }

    public Dttercero getDttercero() {
        return dttercero;
    }

    public void setDttercero(Dttercero dttercero) {
        this.dttercero = dttercero;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public TbUiUsuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(TbUiUsuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    

    @XmlTransient
    public Collection<Dtmaterialprocesado> getDtmaterialprocesadoCollection() {
        return dtmaterialprocesadoCollection;
    }

    public void setDtmaterialprocesadoCollection(Collection<Dtmaterialprocesado> dtmaterialprocesadoCollection) {
        this.dtmaterialprocesadoCollection = dtmaterialprocesadoCollection;
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
        if (!(object instanceof Dtmaterialseparacion)) {
            return false;
        }
        Dtmaterialseparacion other = (Dtmaterialseparacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtmaterialseparacion_1[ id=" + id + " ]";
    }
    
}
