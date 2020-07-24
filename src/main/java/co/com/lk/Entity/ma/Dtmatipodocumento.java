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
@Table(name = "dtmatipodocumento", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmatipodocumento.findAll", query = "SELECT d FROM Dtmatipodocumento d"),
    @NamedQuery(name = "Dtmatipodocumento.findById", query = "SELECT d FROM Dtmatipodocumento d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmatipodocumento.findByTipoDocumento", query = "SELECT d FROM Dtmatipodocumento d WHERE d.tipoDocumento = :tipoDocumento")})
public class Dtmatipodocumento implements Serializable {

    @Size(max = 10)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtmatipodocumentoId", fetch = FetchType.LAZY)
    private List<Dttercero> dtterceroList;
    
    private static final String FINDALL="Dtmatipodocumento.findAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    public Dtmatipodocumento() {
    }

    public Dtmatipodocumento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        final Dtmatipodocumento other = (Dtmatipodocumento) obj;
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtmatipodocumento[ id=" + id + " ]";
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Dttercero> getDtterceroList() {
        return dtterceroList;
    }

    public void setDtterceroList(List<Dttercero> dtterceroList) {
        this.dtterceroList = dtterceroList;
    }
    
}
