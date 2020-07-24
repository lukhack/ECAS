/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dttercero;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author julig
 */
@Entity
@Table(name = "mamunicipio", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mamunicipio.findAll", query = "SELECT m FROM Mamunicipio m")
    , @NamedQuery(name = "Mamunicipio.findById", query = "SELECT m FROM Mamunicipio m WHERE m.id = :id")
    , @NamedQuery(name = "Mamunicipio.findByMunicipio", query = "SELECT m FROM Mamunicipio m WHERE m.municipio = :municipio")})
public class Mamunicipio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "codDane")
    private Integer codDane;
    
    private static final String FINDALL="Mamunicipio.findAll";
    @Size(max = 100)
    @Column(name = "municipio")
    private String municipio;
    
    
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch =FetchType.EAGER)
    private Madepartamento idDepartamento;
    
    @OneToMany(mappedBy = "idMunicipio")
    private Collection<Mabarrio> mabarrioCollection;
    
    @OneToMany(mappedBy = "idMunicipio")
    private Collection<Macomuna> macomunaCollection;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mamunicipioId")
    private List<Dtecassucursal> dtecassucursalList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<Dttercero> dtterceroList;
    
    public Mamunicipio() {
    }

    public Mamunicipio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodDane() {
        return codDane;
    }

    public void setCodDane(Integer codDane) {
        this.codDane = codDane;
    }


    public Madepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Madepartamento idDepartamento) {
        this.idDepartamento = idDepartamento;
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
        if (!(object instanceof Mamunicipio)) {
            return false;
        }
       Mamunicipio other = (Mamunicipio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Mamunicipio[ id=" + id + " ]";
    }



    @XmlTransient
    public Collection<Mabarrio> getMabarrioCollection() {
        return mabarrioCollection;
    }

    public void setMabarrioCollection(Collection<Mabarrio> mabarrioCollection) {
        this.mabarrioCollection = mabarrioCollection;
    }


    public Collection<Macomuna> getMacomunaCollection() {
        return macomunaCollection;
    }

    public void setMacomunaCollection(Collection<Macomuna> macomunaCollection) {
        this.macomunaCollection = macomunaCollection;
    }


    @XmlTransient
    public List<Dtecassucursal> getDtecassucursalList() {
        return dtecassucursalList;
    }

    public void setDtecassucursalList(List<Dtecassucursal> dtecassucursalList) {
        this.dtecassucursalList = dtecassucursalList;
    }

    @XmlTransient
    public List<Dttercero> getDtterceroList() {
        return dtterceroList;
    }

    public void setDtterceroList(List<Dttercero> dtterceroList) {
        this.dtterceroList = dtterceroList;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    

}
