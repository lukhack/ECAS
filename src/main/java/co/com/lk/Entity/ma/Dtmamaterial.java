/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmamaterial", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmamaterial.findAll", query = "SELECT d FROM Dtmamaterial d"),
    @NamedQuery(name = "Dtmamaterial.findById", query = "SELECT d FROM Dtmamaterial d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmamaterial.findByMaterial", query = "SELECT d FROM Dtmamaterial d WHERE d.material = :material")})
public class Dtmamaterial implements Serializable {
    
    private static final String FINDALL="Dtmamaterial.findAll";
    private static final String FINDID="Dtmamaterial.findById";
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "codReferencia")
    private String codReferencia;
    
    @Size(max = 45)
    @Column(name = "material")
    private String material;
    
    @Size(max = 256)
    @Column(name = "receptor")
    private String receptor;
    
    
    @Column(name = "pesokg")
    private Double pesokg=1d;
    
    
    @Column(name = "showbascula")
    private boolean showbascula;
    
    @JoinColumn(name = "dtmagrupomaterial_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmamaterialgrupo dtmagrupomaterial;
    
    @JoinColumn(name = "unidadMedida", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtmaunidadmedida unidadMedida;
    
    
    
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "material")
    private List<DtmamaterialMarca> dtmamaterialMarcas;
    
    @Transient
    private Number total;

    public Dtmamaterial() {
    }

    public Dtmamaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Dtmamaterialgrupo getDtmagrupomaterial() {
        return dtmagrupomaterial;
    }

    public void setDtmagrupomaterial(Dtmamaterialgrupo dtmagrupomaterial) {
        this.dtmagrupomaterial = dtmagrupomaterial;
    }

    
 

   

    public Dtmaunidadmedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Dtmaunidadmedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }

    public List<DtmamaterialMarca> getDtmamaterialMarcas() {
        return dtmamaterialMarcas;
    }

    public void setDtmamaterialMarcas(List<DtmamaterialMarca> dtmamaterialMarcas) {
        this.dtmamaterialMarcas = dtmamaterialMarcas;
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
        final Dtmamaterial other = (Dtmamaterial) obj;
        if (!Objects.equals(this.codReferencia, other.codReferencia)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public boolean isShowbascula() {
        return showbascula;
    }

    public void setShowbascula(boolean showbascula) {
        this.showbascula = showbascula;
    }
    
    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmamaterial[ id=" + id + " ]";
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public Double getPesokg() {
        return pesokg;
    }

    public void setPesokg(Double pesokg) {
        this.pesokg = pesokg;
    }
    
    
    
    
}
