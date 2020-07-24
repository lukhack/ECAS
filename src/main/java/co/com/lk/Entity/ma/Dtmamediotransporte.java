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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmamediotransporte", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmamediotransporte.findAll", query = "SELECT d FROM Dtmamediotransporte d"),
    @NamedQuery(name = "Dtmamediotransporte.findById", query = "SELECT d FROM Dtmamediotransporte d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmamediotransporte.findByMediotransporte", query = "SELECT d FROM Dtmamediotransporte d WHERE d.mediotransporte = :mediotransporte")})
public class Dtmamediotransporte implements Serializable {
    private static final String FINDALL="Dtmamediotransporte.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "mediotransporte")
    private String mediotransporte;
    
    @Column(name = "placavehiculo")
    private boolean placavehiculo;
    
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtmamediotransporteId", fetch = FetchType.LAZY)
    private List<Dttercero> dtterceroList;
    
  

    public Dtmamediotransporte() {
    }

    public Dtmamediotransporte(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    @XmlTransient
    public List<Dttercero> getDtterceroList() {
        return dtterceroList;
    }

    public void setDtterceroList(List<Dttercero> dtterceroList) {
        this.dtterceroList = dtterceroList;
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
        final Dtmamediotransporte other = (Dtmamediotransporte) obj;
        if (!Objects.equals(this.mediotransporte, other.mediotransporte)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtmamediotransporte[ id=" + id + " ]";
    }

    public String getMediotransporte() {
        return mediotransporte;
    }

    public void setMediotransporte(String mediotransporte) {
        this.mediotransporte = mediotransporte;
    }

    public boolean isPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(boolean placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    
}
