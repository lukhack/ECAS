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
@Table(name = "dtmacondiciontercero", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmacondiciontercero.findAll", query = "SELECT u FROM Dtmacondiciontercero u"),
    @NamedQuery(name = "Dtmacondiciontercero.findById", query = "SELECT u FROM Dtmacondiciontercero u WHERE u.id = :id"),
    @NamedQuery(name = "Dtmacondiciontercero.findByCondicion", query = "SELECT u FROM Dtmacondiciontercero u WHERE u.condicion = :condicion")})
public class Dtmacondiciontercero implements Serializable {
    
    private static final String FINDALL="Dtmacondiciontercero.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "condicion")
    private String condicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtmacondicionrecicladorId")
    private List<Dtterceronatural> dtterceronaturalList;

    public Dtmacondiciontercero() {
    }

    public Dtmacondiciontercero(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
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
        final Dtmacondiciontercero other = (Dtmacondiciontercero) obj;
        if (!Objects.equals(this.condicion, other.condicion)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

   

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Uimacondiciontercero[ id=" + id + " ]";
    }
    
}
