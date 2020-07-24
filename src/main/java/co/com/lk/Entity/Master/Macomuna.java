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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "macomuna", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Macomuna.findAll", query = "SELECT m FROM Macomuna m"),
    @NamedQuery(name = "Macomuna.findById", query = "SELECT m FROM Macomuna m WHERE m.id = :id"),
    @NamedQuery(name = "Macomuna.findByComuma", query = "SELECT m FROM Macomuna m WHERE m.comuma = :comuma")})
public class Macomuna implements Serializable { 
    
    private static final String FINDALL="Macomuna.findAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "comuma")
    private String comuma;
    
    @JoinColumn(name = "idMunicipio", referencedColumnName = "id")
    @ManyToOne
    private Mamunicipio idMunicipio;
        
    
    
    @OneToMany(mappedBy = "idcomuna")
    private List<Mabarrio> mabarrioList;

    public Macomuna() {
    }

    public Macomuna(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComuma() {
        return comuma;
    }

    public void setComuma(String comuma) {
        this.comuma = comuma;
    }

    public Mamunicipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Mamunicipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @XmlTransient
    public List<Mabarrio> getMabarrioList() {
        return mabarrioList;
    }

    public void setMabarrioList(List<Mabarrio> mabarrioList) {
        this.mabarrioList = mabarrioList;
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
        if (!(object instanceof Macomuna)) {
            return false;
        }
        Macomuna other = (Macomuna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Master.Macomuna[ id=" + id + " ]";
    }
    
}
