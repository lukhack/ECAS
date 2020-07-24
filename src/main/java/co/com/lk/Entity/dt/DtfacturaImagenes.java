/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import java.io.Serializable;
import java.util.Objects;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtfacturaimagen", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtfacturaImagenes.findAll", query = "SELECT d FROM DtfacturaImagenes d")})
public class DtfacturaImagenes implements Serializable {
    private static final String FINDALL="DtfacturaImagenes.findAll";

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imagen")
    private String imagen;
    
    @JoinColumn(name = "idfacutra", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtfactura dtFactura;

    public DtfacturaImagenes() {
    }

    public DtfacturaImagenes(String name, String imagen, Dtfactura dtFactura) {
        this.name = name;
        this.imagen = imagen;
        this.dtFactura = dtFactura;
    }
    
    

    public Dtfactura getDtFactura() {
        return dtFactura;
    }

    public void setDtFactura(Dtfactura dtFactura) {
        this.dtFactura = dtFactura;
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
        final DtfacturaImagenes other = (DtfacturaImagenes) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

   
    
    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtfacturadetalle[ id=" + id + " ]";
    }

    
    
}
