/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julig
 */
@Entity
@Table(name = "mapatameter", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mapatameter.findAll", query = "SELECT m FROM Mapatameter m")
    , @NamedQuery(name = "Mapatameter.findById", query = "SELECT m FROM Mapatameter m WHERE m.id = :id")
    , @NamedQuery(name = "Mapatameter.findByNumInicial", query = "SELECT m FROM Mapatameter m WHERE m.numInicial = :numInicial")
    , @NamedQuery(name = "Mapatameter.findByNumFinal", query = "SELECT m FROM Mapatameter m WHERE m.numFinal = :numFinal")
    , @NamedQuery(name = "Mapatameter.findByNumfactura", query = "SELECT m FROM Mapatameter m WHERE m.numfactura = :numfactura")
    , @NamedQuery(name = "Mapatameter.findByPrefijo", query = "SELECT m FROM Mapatameter m WHERE m.prefijo = :prefijo")
    , @NamedQuery(name = "Mapatameter.findByNResolucionDian", query = "SELECT m FROM Mapatameter m WHERE m.nResolucionDian = :nResolucionDian")
    , @NamedQuery(name = "Mapatameter.findByFechaResolucion", query = "SELECT m FROM Mapatameter m WHERE m.fechaResolucion = :fechaResolucion")
    , @NamedQuery(name = "Mapatameter.findByActivo", query = "SELECT m FROM Mapatameter m WHERE m.activo = :activo")})
public class Mapatameter implements Serializable {
    
    private static final String FINDALL="Mapatameter.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numInicial")
    private Integer numInicial;
    @Column(name = "numFinal")
    private Integer numFinal;
    @Column(name = "numfactura")
    private Integer numfactura;
    @Size(max = 45)
    @Column(name = "prefijo")
    private String prefijo;
    @Column(name = "NResolucionDian")
    private Integer nResolucionDian;
    @Column(name = "fechaResolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;
    @Column(name = "activo")
    private Boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "idtipo")
    private Mapatametertipo tipo;
    
    @Transient
    private Integer OldNumfactura;
    
    public Mapatameter() {
    }

    public Mapatameter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumInicial() {
        return numInicial;
    }

    public void setNumInicial(Integer numInicial) {
        this.numInicial = numInicial;
    }

    public Integer getNumFinal() {
        return numFinal;
    }

    public void setNumFinal(Integer numFinal) {
        this.numFinal = numFinal;
    }

    public Integer getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(Integer numfactura) {
        this.numfactura = numfactura;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Integer getNResolucionDian() {
        return nResolucionDian;
    }

    public void setNResolucionDian(Integer nResolucionDian) {
        this.nResolucionDian = nResolucionDian;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Mapatametertipo getTipo() {
        return tipo;
    }

    public void setTipo(Mapatametertipo tipo) {
        this.tipo = tipo;
    }

    public Integer getOldNumfactura() {
        return OldNumfactura;
    }

    public void setOldNumfactura(Integer OldNumfactura) {
        this.OldNumfactura = OldNumfactura;
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
        if (!(object instanceof Mapatameter)) {
            return false;
        }
        Mapatameter other = (Mapatameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Mapatameter[ id=" + id + " ]";
    }
    
}
