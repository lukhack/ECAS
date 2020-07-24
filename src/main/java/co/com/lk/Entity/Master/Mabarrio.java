/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

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
@Table(name = "mabarrio", schema = "maestros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mabarrio.findAll", query = "SELECT m FROM Mabarrio m"),
    @NamedQuery(name = "Mabarrio.findById", query = "SELECT m FROM Mabarrio m WHERE m.id = :id"),
    @NamedQuery(name = "Mabarrio.findByCodigo", query = "SELECT m FROM Mabarrio m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Mabarrio.findByBarrio", query = "SELECT m FROM Mabarrio m WHERE m.barrio = :barrio")})
public class Mabarrio implements Serializable {
    
    private static final String FINDALL="Mabarrio.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 100)
    @Column(name = "barrio")
    private String barrio;
    
    @JoinColumn(name = "idcomuna", referencedColumnName = "id")
    @ManyToOne
    private Macomuna idcomuna;
    
    @JoinColumn(name = "idMunicipio", referencedColumnName = "id")
    @ManyToOne
    private Mamunicipio idMunicipio;

    public Mabarrio() {
    }

    public Mabarrio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Macomuna getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(Macomuna idcomuna) {
        this.idcomuna = idcomuna;
    }

    public Mamunicipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Mamunicipio idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        if (!(object instanceof Mabarrio)) {
            return false;
        }
        Mabarrio other = (Mabarrio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Master.Mabarrio[ id=" + id + " ]";
    }
    
}
