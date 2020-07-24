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
@Table(name = "dtgrupo", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtgrupo.FindALL", query = "SELECT d FROM Dtgrupo d"),
    @NamedQuery(name = "Dtgrupo.findById", query = "SELECT d FROM Dtgrupo d WHERE d.id = :id"),
    @NamedQuery(name = "Dtgrupo.findByGrupo", query = "SELECT d FROM Dtgrupo d WHERE d.grupo = :grupo")})
public class Dtgrupo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idCampo")
    private String idCampo;
    @Size(max = 100)
    @Column(name = "Grupo")
    private String grupo;
    
    private static final String FINDALL="Dtgrupo.FindALL";
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "grupo")
    @OrderBy("id")
    private Collection<Dtsubgrupo> dtsubgrupoCollection;

    public Dtgrupo() {
    }

    public Dtgrupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Collection<Dtsubgrupo> getDtsubgrupoCollection() {
        return dtsubgrupoCollection;
    }

    public void setDtsubgrupoCollection(Collection<Dtsubgrupo> dtsubgrupoCollection) {
        this.dtsubgrupoCollection = dtsubgrupoCollection;
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
        if (!(object instanceof Dtgrupo)) {
            return false;
        }
        Dtgrupo other = (Dtgrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtgrupo[ id=" + id + " ]";
    }

    public String getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(String idCampo) {
        this.idCampo = idCampo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
}
