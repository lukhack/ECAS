/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author julig
 */
@Entity
@Table(name = "uitercerotipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uitercerotipo.findAll", query = "SELECT u FROM Uitercerotipo u")
    , @NamedQuery(name = "Uitercerotipo.findById", query = "SELECT u FROM Uitercerotipo u WHERE u.id = :id")
    , @NamedQuery(name = "Uitercerotipo.findByTercero", query = "SELECT u FROM Uitercerotipo u WHERE u.tercero = :tercero")})
public class Uitercerotipo implements Serializable {
    
    private static final String FINDALL="Uitercerotipo.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Tercero")
    private String tercero;
    
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tercerotipo")
    private List<Uitercero> terceroList;

    public Uitercerotipo() {
    }

    public Uitercerotipo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public List<Uitercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Uitercero> terceroList) {
        this.terceroList = terceroList;
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
        if (!(object instanceof Uitercerotipo)) {
            return false;
        }
        Uitercerotipo other = (Uitercerotipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Uitercerotipo[ id=" + id + " ]";
    }
    
}
