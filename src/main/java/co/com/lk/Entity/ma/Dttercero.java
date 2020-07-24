/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import co.com.lk.Entity.Master.Mamunicipio;
import co.com.lk.Entity.dt.Dtmaterialrecoleccion;
import co.com.lk.Entity.dt.Dtmaterialseparacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dttercero", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dttercero.findAll", query = "SELECT d FROM Dttercero d"),
    @NamedQuery(name = "Dttercero.findById", query = "SELECT d FROM Dttercero d WHERE d.id = :id"),
    @NamedQuery(name = "Dttercero.findByCargoPersonas", query = "SELECT d FROM Dttercero d WHERE d.cargoPersonas = :cargoPersonas"),
    @NamedQuery(name = "Dttercero.findByTelefono", query = "SELECT d FROM Dttercero d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Dttercero.findByDireccion", query = "SELECT d FROM Dttercero d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Dttercero.findByDocumento", query = "SELECT d FROM Dttercero d WHERE d.documento = ?1")})
public class Dttercero implements Serializable {
    private static final String FINDALL="Dttercero.findAll";
    private static final String FINDDOCUMENTO="Dttercero.findByDocumento";
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cargoPersonas")
    private Integer cargoPersonas;
    
    @Size(max = 15)
    @Column(name = "documento",unique = true)
    private String documento;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 200)
    @Column(name = "correo")
    private String correo;
    
    
    
    @JoinColumn(name = "dtmamediotransporte_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Dtmamediotransporte dtmamediotransporteId;
    
    @JoinColumn(name = "dtmatipodocumento_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Dtmatipodocumento dtmatipodocumentoId;
    
    @JoinColumn(name = "dtEcassucursal_id", referencedColumnName = "id")    
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Dtecassucursal dtEcassucursalid;
    
    @JoinColumn(name = "idmunicipio", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mamunicipio idmunicipio;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dttercero",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Dttercerojuridico dttercerojuridico;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dttercero",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Dtterceronatural dtterceronatural;
    
    @OneToMany(mappedBy = "idtercero", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Dtterceroruta> dttercerorutaList;
    
    @OneToMany(mappedBy = "dttercero")
    private Collection<Dtmaterialseparacion> dtmaterialseparacionCollection;
    
    @OneToMany(mappedBy = "dttercero")
    private Collection<Dtmaterialrecoleccion> dtmaterialrecoleccionCollection;
    
    
    public Dttercero() {
        dttercerorutaList=new ArrayList<>();
    }

    public Dttercero(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public Integer getCargoPersonas() {
        return cargoPersonas;
    }

    public void setCargoPersonas(Integer cargoPersonas) {
        this.cargoPersonas = cargoPersonas;
    }


    public Dtmamediotransporte getDtmamediotransporteId() {
        return dtmamediotransporteId;
    }

    public void setDtmamediotransporteId(Dtmamediotransporte dtmamediotransporteId) {
        this.dtmamediotransporteId = dtmamediotransporteId;
    }

    public Dtmatipodocumento getDtmatipodocumentoId() {
        return dtmatipodocumentoId;
    }

    public void setDtmatipodocumentoId(Dtmatipodocumento dtmatipodocumentoId) {
        this.dtmatipodocumentoId = dtmatipodocumentoId;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public Mamunicipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Mamunicipio idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Dttercerojuridico getDttercerojuridico() {
        return dttercerojuridico;
    }

    public void setDttercerojuridico(Dttercerojuridico dttercerojuridico) {
        this.dttercerojuridico = dttercerojuridico;
    }

    public Dtterceronatural getDtterceronatural() {
        return dtterceronatural;
    }

    public void setDtterceronatural(Dtterceronatural dtterceronatural) {
        this.dtterceronatural = dtterceronatural;
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
        if (!(object instanceof Dttercero)) {
            return false;
        }
        Dttercero other = (Dttercero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dttercero[ id=" + id + " ]";
    }
    @XmlTransient
    public List<Dtterceroruta> getDttercerorutaList() {
        return dttercerorutaList;
    }
    public void setDttercerorutaList(List<Dtterceroruta> dttercerorutaList) {
        this.dttercerorutaList = dttercerorutaList;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Dtmaterialseparacion> getDtmaterialseparacionCollection() {
        return dtmaterialseparacionCollection;
    }

    public void setDtmaterialseparacionCollection(Collection<Dtmaterialseparacion> dtmaterialseparacionCollection) {
        this.dtmaterialseparacionCollection = dtmaterialseparacionCollection;
    }

    @XmlTransient
    public Collection<Dtmaterialrecoleccion> getDtmaterialrecoleccionCollection() {
        return dtmaterialrecoleccionCollection;
    }

    public void setDtmaterialrecoleccionCollection(Collection<Dtmaterialrecoleccion> dtmaterialrecoleccionCollection) {
        this.dtmaterialrecoleccionCollection = dtmaterialrecoleccionCollection;
    }
    
}
