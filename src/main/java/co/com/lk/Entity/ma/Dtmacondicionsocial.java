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
@Table(name = "dtmacondicionsocial", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmacondicionsocial.findAll", query = "SELECT d FROM Dtmacondicionsocial d"),
    @NamedQuery(name = "Dtmacondicionsocial.findById", query = "SELECT d FROM Dtmacondicionsocial d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmacondicionsocial.findByCondicionSocial", query = "SELECT d FROM Dtmacondicionsocial d WHERE d.condicionSocial = :condicionSocial")})
public class Dtmacondicionsocial implements Serializable {
    
    private static final String FINDALL="Dtmacondicionsocial.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 200)
    @Column(name = "CondicionSocial")
    private String condicionSocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtmacondicionsocialId")
    private List<Dtterceronatural> dtterceronaturalList;

    public Dtmacondicionsocial() {
    }

    public Dtmacondicionsocial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCondicionSocial() {
        return condicionSocial;
    }

    public void setCondicionSocial(String condicionSocial) {
        this.condicionSocial = condicionSocial;
    }

    @XmlTransient
    public List<Dtterceronatural> getDtterceronaturalList() {
        return dtterceronaturalList;
    }

    public void setDtterceronaturalList(List<Dtterceronatural> dtterceronaturalList) {
        this.dtterceronaturalList = dtterceronaturalList;
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
        final Dtmacondicionsocial other = (Dtmacondicionsocial) obj;
        if (!Objects.equals(this.condicionSocial, other.condicionSocial)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtmacondicionsocial[ id=" + id + " ]";
    }
    
}
