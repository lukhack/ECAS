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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "mapatametertipo", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mapatametertipo.findAll", query = "SELECT m FROM Mapatametertipo m")
    , @NamedQuery(name = "Mapatametertipo.findById", query = "SELECT m FROM Mapatametertipo m WHERE m.id = :id")
    , @NamedQuery(name = "Mapatametertipo.findByTipo", query = "SELECT m FROM Mapatametertipo m WHERE m.tipo = :tipo")})
public class Mapatametertipo implements Serializable {
    
    private static final String FINDALL="Mapatametertipo.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Tipo")
    private String tipo;
    
    @OneToMany(mappedBy = "tipo")
    List<Mapatameter> parameter;
    
    public Mapatametertipo() {
    }

    public Mapatametertipo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<Mapatameter> getParameter() {
        return parameter;
    }

    public void setParameter(List<Mapatameter> parameter) {
        this.parameter = parameter;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mapatametertipo)) {
            return false;
        }
        Mapatametertipo other = (Mapatametertipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Mapatametertipo[ id=" + id + " ]";
    }
    
}
