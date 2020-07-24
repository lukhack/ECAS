/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "dtmamaterialgrupo", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtmamaterialgrupo.findAll", query = "SELECT d FROM Dtmamaterialgrupo d"),
    @NamedQuery(name = "Dtmamaterialgrupo.findByIddtmagrupomaterial", query = "SELECT d FROM Dtmamaterialgrupo d WHERE d.id = :id"),
    @NamedQuery(name = "Dtmamaterialgrupo.findByNombre", query = "SELECT d FROM Dtmamaterialgrupo d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Dtmamaterialgrupo.findByDescripcion", query = "SELECT d FROM Dtmamaterialgrupo d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Dtmamaterialgrupo.findByEstado", query = "SELECT d FROM Dtmamaterialgrupo d WHERE d.estado = :estado")})
public class Dtmamaterialgrupo implements Serializable {
    private static final String FINDALL="Dtmamaterialgrupo.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtmagrupomaterial", fetch = FetchType.LAZY)
    private List<Dtmamaterial> dtmamaterialList;

    public Dtmamaterialgrupo() {
        dtmamaterialList=new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Dtmamaterial> getDtmamaterialList() {
        return dtmamaterialList;
    }

    public void setDtmamaterialList(List<Dtmamaterial> dtmamaterialList) {
        this.dtmamaterialList = dtmamaterialList;
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
        final Dtmamaterialgrupo other = (Dtmamaterialgrupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmagrupomaterial[ id=" + id + " ]";
    }
    
}
