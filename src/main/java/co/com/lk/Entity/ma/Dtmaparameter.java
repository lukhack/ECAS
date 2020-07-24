/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmaparameter", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmaparameter.findAll", query = "SELECT d FROM Dtmaparameter d"),
    @NamedQuery(name = "Dtmaparameter.findById", query = "SELECT d FROM Dtmaparameter d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmaparameter.findByDescripcion", query = "SELECT d FROM Dtmaparameter d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Dtmaparameter.findByPrefijo", query = "SELECT d FROM Dtmaparameter d WHERE d.prefijo = :prefijo"),
    @NamedQuery(name = "Dtmaparameter.findByResolucion", query = "SELECT d FROM Dtmaparameter d WHERE d.resolucion = :resolucion"),
    @NamedQuery(name = "Dtmaparameter.findByFechaResolucio", query = "SELECT d FROM Dtmaparameter d WHERE d.fechaResolucio = :fechaResolucio"),
    @NamedQuery(name = "Dtmaparameter.findByConsInicial", query = "SELECT d FROM Dtmaparameter d WHERE d.consInicial = :consInicial"),
    @NamedQuery(name = "Dtmaparameter.findByConsFinal", query = "SELECT d FROM Dtmaparameter d WHERE d.consFinal = :consFinal"),
    @NamedQuery(name = "Dtmaparameter.findByConsActual", query = "SELECT d FROM Dtmaparameter d WHERE d.consActual = :consActual"),
    @NamedQuery(name = "Dtmaparameter.findByVigente", query = "SELECT d FROM Dtmaparameter d WHERE d.vigente = :vigente")})
public class Dtmaparameter implements Serializable {
    
    private static final String FINDALL="Dtmaparameter.findAll";

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fechaResolucio")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucio;
    @Column(name = "vigente")
    private Boolean vigente;
    
    @Size(max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Size(max = 2)
    @Column(name = "simbSeparacion")
    private String simbSeparacion;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "prefijo")
    private String prefijo;
    @Size(max = 100)
    @Column(name = "resolucion")
    private String resolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consInicial")
    private int consInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consFinal")
    private int consFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consActual")
    private Integer consActual;
    
    @JoinColumn(name = "dtTipoFactura_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmatipofactura dtTipoFacturaid;
    
    @ManyToMany(mappedBy = "dtmaparameterList", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Dteca> dtecaList;
    
    @ManyToMany(mappedBy = "dtmaparameterList", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Dtecassucursal> dtecassucursalList;
    
    public Dtmaparameter() {
    }

    public Dtmaparameter(Integer id) {
        this.id = id;
    }

    public Dtmaparameter(Integer id, String prefijo, int consInicial, int consFinal, int consActual) {
        this.id = id;
        this.prefijo = prefijo;
        this.consInicial = consInicial;
        this.consFinal = consFinal;
        this.consActual = consActual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getFechaResolucio() {
        return fechaResolucio;
    }

    public void setFechaResolucio(Date fechaResolucio) {
        this.fechaResolucio = fechaResolucio;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public Dtmatipofactura getDtTipoFacturaid() {
        return dtTipoFacturaid;
    }

    public void setDtTipoFacturaid(Dtmatipofactura dtTipoFacturaid) {
        this.dtTipoFacturaid = dtTipoFacturaid;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public int getConsInicial() {
        return consInicial;
    }

    public void setConsInicial(int consInicial) {
        this.consInicial = consInicial;
    }

    public int getConsFinal() {
        return consFinal;
    }

    public void setConsFinal(int consFinal) {
        this.consFinal = consFinal;
    }

    public Integer getConsActual() {
        return consActual;
    }

    public void setConsActual(Integer consActual) {
        this.consActual = consActual;
    }

    public String getSimbSeparacion() {
        return simbSeparacion;
    }

    public void setSimbSeparacion(String simbSeparacion) {
        this.simbSeparacion = simbSeparacion;
    }
    
    

    @XmlTransient
    public List<Dteca> getDtecaList() {
        return dtecaList;
    }

    public void setDtecaList(List<Dteca> dtecaList) {
        this.dtecaList = dtecaList;
    }

    @XmlTransient
    public List<Dtecassucursal> getDtecassucursalList() {
        return dtecassucursalList;
    }

    public void setDtecassucursalList(List<Dtecassucursal> dtecassucursalList) {
        this.dtecassucursalList = dtecassucursalList;
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
        final Dtmaparameter other = (Dtmaparameter) obj;
        if (this.consInicial != other.consInicial) {
            return false;
        }
        if (this.consFinal != other.consFinal) {
            return false;
        }
        if (this.consActual != other.consActual) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.prefijo, other.prefijo)) {
            return false;
        }
        if (!Objects.equals(this.resolucion, other.resolucion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaResolucio, other.fechaResolucio)) {
            return false;
        }
        if (!Objects.equals(this.vigente, other.vigente)) {
            return false;
        }
        return Objects.equals(this.dtTipoFacturaid, other.dtTipoFacturaid);
    }

    

   

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmaparameter[ id=" + id + " ]";
    }
    
}
