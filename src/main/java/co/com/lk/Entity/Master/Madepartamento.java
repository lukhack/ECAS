/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author julig
 */
@Entity
@Table(name = "madepartamento", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Madepartamento.findAll", query = "SELECT m FROM Madepartamento m")
    , @NamedQuery(name = "Madepartamento.findById", query = "SELECT m FROM Madepartamento m WHERE m.id = :id")
    , @NamedQuery(name = "Madepartamento.findByDepartamento", query = "SELECT m FROM Madepartamento m WHERE m.departamento = :departamento")})
public class Madepartamento implements Serializable {

    @Size(max = 100)
    @Column(name = "departamento")
    private String departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento", fetch = FetchType.LAZY)
    private List<Mamunicipio> mamunicipioList;
    
    private static final String FINDALL="Madepartamento.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Collection<Mamunicipio> mamunicipioCollection;

    public Madepartamento() {
    }

    public Madepartamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Collection<Mamunicipio> getMamunicipioCollection() {
        return mamunicipioCollection;
    }

    public void setMamunicipioCollection(Collection<Mamunicipio> mamunicipioCollection) {
        this.mamunicipioCollection = mamunicipioCollection;
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
        if (!(object instanceof Madepartamento)) {
            return false;
        }
        Madepartamento other = (Madepartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Madepartamento[ id=" + id + " ]";
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    
    
}
