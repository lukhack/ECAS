/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import co.com.lk.Entity.history.Dtecamateriahisotirall;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dteca_mamaterial", schema = "ecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtecamaterial.findAll", query = "SELECT d FROM Dtecamaterial d"),
    @NamedQuery(name = "Dtecamaterial.findById", query = "SELECT d FROM Dtecamaterial d WHERE d.id = :id"),
    @NamedQuery(name = "Dtecamaterial.findByFecha", query = "SELECT d FROM Dtecamaterial d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Dtecamaterial.findByValorCompra", query = "SELECT d FROM Dtecamaterial d WHERE d.valorCompra = :valorCompra"),
    @NamedQuery(name = "Dtecamaterial.findByValorVenta", query = "SELECT d FROM Dtecamaterial d WHERE d.valorVenta = :valorVenta"),
    @NamedQuery(name = "Dtecamaterial.findByEcas", query = "SELECT d FROM Dtecamaterial d WHERE d.ecaSucursal.id = ?0")})
public class Dtecamaterial implements Serializable {
    private static final String FINDALL="Dtecamaterial.findAll";

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
    @Column(name = "ValorCompra")
    private Double valorCompra;
    
    @Column(name = "valorVenta")
    private Double valorVenta;
    
    
    @JoinColumn(name = "dtmamaterial_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Dtmamaterial material;
    
    
    @JoinColumn(name = "dtEcaSucursal_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtecassucursal ecaSucursal;
    
    
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "dtecamateria_id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Dtecamateriahisotirall> dtecahistorial;

    public Dtecamaterial() {
    }

    public Dtecamaterial(Integer id) {
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

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Dtmamaterial getMaterial() {
        return material;
    }

    public void setMaterial(Dtmamaterial material) {
        this.material = material;
    }

    public Dtecassucursal getEcaSucursal() {
        return ecaSucursal;
    }

    public void setEcaSucursal(Dtecassucursal ecaSucursal) {
        this.ecaSucursal = ecaSucursal;
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
        final Dtecamaterial other = (Dtecamaterial) obj;
        return (Objects.equals(this.ecaSucursal.getId(),other.ecaSucursal.getId()) && Objects.equals(this.material.getId(), other.material.getId()));
    }

    public List<Dtecamateriahisotirall> getDtecahistorial() {
        return dtecahistorial;
    }

    public void setDtecahistorial(List<Dtecamateriahisotirall> dtecahistorial) {
        this.dtecahistorial = dtecahistorial;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtecamaterial[ id=" + id + " ]";
    }
    
}
