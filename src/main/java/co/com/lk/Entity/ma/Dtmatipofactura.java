/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import co.com.lk.Entity.dt.Dtfactura;
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
@Table(name = "dtmatipofactura", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmatipofactura.findAll", query = "SELECT d FROM Dtmatipofactura d"),
    @NamedQuery(name = "Dtmatipofactura.findById", query = "SELECT d FROM Dtmatipofactura d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmatipofactura.findByTipo", query = "SELECT d FROM Dtmatipofactura d WHERE d.tipo = :tipo")})
public class Dtmatipofactura implements Serializable {

    
    private static final String FINDALL="Dtmatipofactura.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtTipoFacturaid", fetch = FetchType.LAZY)
    private List<Dtfactura> dtfacturaList;

    private static final long serialVersionUID = 1L;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtTipoFacturaid", fetch = FetchType.LAZY)
    private List<Dtmaparameter> dtmaparameterList;

    public Dtmatipofactura() {
    }

    public Dtmatipofactura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public List<Dtmaparameter> getDtmaparameterList() {
        return dtmaparameterList;
    }

    public void setDtmaparameterList(List<Dtmaparameter> dtmaparameterList) {
        this.dtmaparameterList = dtmaparameterList;
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
        final Dtmatipofactura other = (Dtmatipofactura) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmatipofactura[ id=" + id + " ]";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Dtfactura> getDtfacturaList() {
        return dtfacturaList;
    }

    public void setDtfacturaList(List<Dtfactura> dtfacturaList) {
        this.dtfacturaList = dtfacturaList;
    }
    
}
