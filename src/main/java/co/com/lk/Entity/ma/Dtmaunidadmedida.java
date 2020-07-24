/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtmaunidadmedida", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmaunidadmedida.findAll", query = "SELECT d FROM Dtmaunidadmedida d"),
    @NamedQuery(name = "Dtmaunidadmedida.findById", query = "SELECT d FROM Dtmaunidadmedida d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmaunidadmedida.findByUnidadMedida", query = "SELECT d FROM Dtmaunidadmedida d WHERE d.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Dtmaunidadmedida.findByDescripcion", query = "SELECT d FROM Dtmaunidadmedida d WHERE d.descripcion = :descripcion")})
public class Dtmaunidadmedida implements Serializable {
    private static final String FINDALL="Dtmaunidadmedida.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "unidadMedida")
    private String unidadMedida;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    public Dtmaunidadmedida() {
    }

    public Dtmaunidadmedida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        final Dtmaunidadmedida other = (Dtmaunidadmedida) obj;
        if (!Objects.equals(this.unidadMedida, other.unidadMedida)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmaunidadmedida[ id=" + id + " ]";
    }
    
}
