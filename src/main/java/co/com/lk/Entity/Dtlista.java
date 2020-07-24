/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "dtlista", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtlista.findAll", query = "SELECT d FROM Dtlista d"),
    @NamedQuery(name = "Dtlista.findById", query = "SELECT d FROM Dtlista d WHERE d.id = :id"),
    @NamedQuery(name = "Dtlista.findByKeylist", query = "SELECT d FROM Dtlista d WHERE d.keylist = :keylist")})
public class Dtlista implements Serializable {
    
    private static final String FINDALL="Dtlista.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "KEYLIST")
    private String keylist;
    @OneToMany(mappedBy = "idlistatipo")
    private List<Dtlistadetalle> dtlistadetalleList;

    public Dtlista() {
    }

    public Dtlista(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeylist() {
        return keylist;
    }

    public void setKeylist(String keylist) {
        this.keylist = keylist;
    }

    @XmlTransient
    public List<Dtlistadetalle> getDtlistadetalleList() {
        return dtlistadetalleList;
    }

    public void setDtlistadetalleList(List<Dtlistadetalle> dtlistadetalleList) {
        this.dtlistadetalleList = dtlistadetalleList;
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
        if (!(object instanceof Dtlista)) {
            return false;
        }
        Dtlista other = (Dtlista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtlista[ id=" + id + " ]";
    }
    
}
