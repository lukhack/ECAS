/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import co.com.lk.Entity.Master.TbUiUsuario;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtrespuestaform", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtrespuestaform.findAll", query = "SELECT d FROM Dtrespuestaform d"),
    @NamedQuery(name = "Dtrespuestaform.findByUusarioId", query = "SELECT d FROM Dtrespuestaform d WHERE d.usuario.id  = ?1")})
public class Dtrespuestaform implements Serializable {
    
    private static final String FINDALL="Dtrespuestaform.findAll";
    private static final String FINDUSUARIO="Dtrespuestaform.findByUusarioId";
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private TbUiUsuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtrespuestaform",orphanRemoval = true)
    private Collection<Dtrespuestadetalle> dtrespuestadetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtrespuestaform",orphanRemoval = true)
    private Collection<Dtrespuestaz> dtrespuestazCollection;

    public Dtrespuestaform() {
    }

    public Dtrespuestaform(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TbUiUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUiUsuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Dtrespuestadetalle> getDtrespuestadetalleCollection() {
        return dtrespuestadetalleCollection;
    }

    public void setDtrespuestadetalleCollection(Collection<Dtrespuestadetalle> dtrespuestadetalleCollection) {
        this.dtrespuestadetalleCollection = dtrespuestadetalleCollection;
    }

    @XmlTransient
    public Collection<Dtrespuestaz> getDtrespuestazCollection() {
        return dtrespuestazCollection;
    }

    public void setDtrespuestazCollection(Collection<Dtrespuestaz> dtrespuestazCollection) {
        this.dtrespuestazCollection = dtrespuestazCollection;
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
        if (!(object instanceof Dtrespuestaform)) {
            return false;
        }
        Dtrespuestaform other = (Dtrespuestaform) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtrespuestaform[ id=" + id + " ]";
    }
    
}
