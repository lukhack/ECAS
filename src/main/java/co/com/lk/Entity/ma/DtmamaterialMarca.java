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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmamaterialmarca", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtmamaterialMarca.findAll", query = "SELECT d FROM DtmamaterialMarca d")})
public class DtmamaterialMarca implements Serializable {
    private static final String FINDALL="DtmamaterialMarca.findAll";

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "marca")
    private String marca;
    
    
    @Column(name = "descripcion")
    private String descripcion;
    
    
    @JoinColumn(name = "idmateria", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtmamaterial material;
    
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "idmaterialmarca")
    private List<DtmamaterialMarcaPresentacion> dtmarcasPresentaciones;
    
    
    public DtmamaterialMarca() {
    }

    public DtmamaterialMarca(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dtmamaterial getMaterial() {
        return material;
    }

    public void setMaterial(Dtmamaterial material) {
        this.material = material;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<DtmamaterialMarcaPresentacion> getDtmarcasPresentaciones() {
        return dtmarcasPresentaciones;
    }

    public void setDtmarcasPresentaciones(List<DtmamaterialMarcaPresentacion> dtmarcasPresentaciones) {
        this.dtmarcasPresentaciones = dtmarcasPresentaciones;
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
        final DtmamaterialMarca other = (DtmamaterialMarca) obj;
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.material, other.material);
    }

    
   

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmamaterial[ id=" + id + " ]";
    }
    
}
