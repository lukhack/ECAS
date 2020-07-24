/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtsubgrupo", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtsubgrupo.findAll", query = "SELECT d FROM Dtsubgrupo d"),
    @NamedQuery(name = "Dtsubgrupo.findById", query = "SELECT d FROM Dtsubgrupo d WHERE d.id = :id"),
    @NamedQuery(name = "Dtsubgrupo.findBySubgrupo", query = "SELECT d FROM Dtsubgrupo d WHERE d.subgrupo = :subgrupo")})
public class Dtsubgrupo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idSub")
    private String idSub;
    @Size(max = 100)
    @Column(name = "subgrupo")
    private String subgrupo;
    @Column(name = "detalle")
    private Boolean detalle;

    

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "columna")
    private Integer columna;
    
    
    @JoinColumn(name = "grupo", referencedColumnName = "id")
    @ManyToOne
    private Dtgrupo grupo;
    
    @OneToMany(mappedBy = "subGrupo")
    
    @OrderBy("orden")
    private Collection<Dtformulario> dtformularioCollection;
    
    public Dtsubgrupo() {
    }

    public Dtsubgrupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Dtgrupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Dtgrupo grupo) {
        this.grupo = grupo;
    }

    @XmlTransient
    public Collection<Dtformulario> getDtformularioCollection() {
        return dtformularioCollection;
    }

    public void setDtformularioCollection(Collection<Dtformulario> dtformularioCollection) {
        this.dtformularioCollection = dtformularioCollection;
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
        if (!(object instanceof Dtsubgrupo)) {
            return false;
        }
        Dtsubgrupo other = (Dtsubgrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtsubgrupo[ id=" + id + " ]";
    }


    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public String getIdSub() {
        return idSub;
    }

    public void setIdSub(String idSub) {
        this.idSub = idSub;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public Boolean getDetalle() {
        return detalle;
    }

    public void setDetalle(Boolean detalle) {
        this.detalle = detalle;
    }

    
    
    
}
