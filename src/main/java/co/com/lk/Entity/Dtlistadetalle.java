/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtlistadetalle", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtlistadetalle.findAll", query = "SELECT d FROM Dtlistadetalle d"),
    @NamedQuery(name = "Dtlistadetalle.findById", query = "SELECT d FROM Dtlistadetalle d WHERE d.id = :id"),
    @NamedQuery(name = "Dtlistadetalle.findByCodigo", query = "SELECT d FROM Dtlistadetalle d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Dtlistadetalle.findByOrden", query = "SELECT d FROM Dtlistadetalle d WHERE d.orden = :orden"),
    @NamedQuery(name = "Dtlistadetalle.findByDescripcion", query = "SELECT d FROM Dtlistadetalle d WHERE d.descripcion = :descripcion")})
public class Dtlistadetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id")
    private String id;
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Orden")
    private int orden;
    @Size(max = 200)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "idlistatipo", referencedColumnName = "id")
    @ManyToOne
    private Dtlista idlistatipo;

    public Dtlistadetalle() {
    }

    public Dtlistadetalle(String id) {
        this.id = id;
    }

    public Dtlistadetalle(String id, int orden) {
        this.id = id;
        this.orden = orden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dtlista getIdlistatipo() {
        return idlistatipo;
    }

    public void setIdlistatipo(Dtlista idlistatipo) {
        this.idlistatipo = idlistatipo;
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
        if (!(object instanceof Dtlistadetalle)) {
            return false;
        }
        Dtlistadetalle other = (Dtlistadetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtlistadetalle[ id=" + id + " ]";
    }
    
}
