/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import co.com.lk.Entity.Master.Mamunicipio;
import co.com.lk.Entity.dt.Dtfactura;
import co.com.lk.Entity.view.ViewMaterialProcesado;
import co.com.lk.Entity.view.v_ecasconsolidado;
import co.com.lk.helper.JsonToPointDeserializer;
import co.com.lk.helper.PointToJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.locationtech.jts.geom.Geometry;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtecassucursal", schema = "ecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtecassucursal.findAll", query = "SELECT d FROM Dtecassucursal d"),
    @NamedQuery(name = "Dtecassucursal.findByECAId", query = "SELECT d FROM Dtecassucursal d WHERE d.dtEcaid.id = ?0"),
    @NamedQuery(name = "Dtecassucursal.findById", query = "SELECT d FROM Dtecassucursal d WHERE d.id =?0")})
public class Dtecassucursal implements Serializable {
    
    private static final String FINDALL="Dtecassucursal.findAll";
    private static final String FINDID="Dtecassucursal.findById";
    private static final String FINDIDECA="Dtecassucursal.findByECAId";
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Size(max = 200)
    @Column(name = "Direccion")
    private String direccion;
    
    @Size(max = 200)
    @Column(name = "filial")
    private String filial;
    
    /*@Column(name = "pocision",columnDefinition = "Point",nullable = true)
    @JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(using = JsonToPointDeserializer.class)
    private Geometry pocision;*/
    
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    
    @Size(max = 200)
    @Column(name = "correo")
    private String correo;
    
    
    @Column(name = "logo")
    private String logo;
    
    @Column(name = "basculamanual")
    private Boolean basculamanual;
    
    @Column(name = "showreport")
    private Boolean showreport;
    
    
    @Column(name = "parameterGlobal")
    private Boolean parameterGlobal;
    
    
    @JoinColumn(name = "dtEca_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dteca dtEcaid;
    
    
    @JoinColumn(name = "mamunicipio_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mamunicipio mamunicipioId;
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtEcassucursalid")
    private List<Dttercero> dtterceroList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtEcassucursalid")
    private List<ViewMaterialProcesado> viewMaterialprocesado;
    
    @JoinTable(name = "dtecasucursalparameter", schema = "ecas", joinColumns = {
    @JoinColumn(name = "dtEcassucursal_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "dtParameter_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Dtmaparameter> dtmaparameterList;
    
    
    
    
    
    @OneToOne(mappedBy = "dtEcassucursalid", fetch = FetchType.LAZY)
    private v_ecasconsolidado v_ecasconsolidado;
    
    
    @OneToMany(mappedBy = "dtEcaSucursalid", fetch = FetchType.LAZY)
    private Collection<Dtmaterialprocesado> dtmaterialprocesadoCollection;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtEcassucursalid", fetch = FetchType.LAZY)
    private List<Dtfactura> dtfacturaList;
    
    
    @OneToMany(mappedBy = "dtEcassucursalid", fetch = FetchType.LAZY)
    private Collection<Dttercero> dtTercero;
    
    
    

    public Dtecassucursal() {
        dtmaparameterList=new ArrayList<>();
    }

    public Dtecassucursal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Boolean getParameterGlobal() {
        return parameterGlobal;
    }

    public void setParameterGlobal(Boolean parameterGlobal) {
        this.parameterGlobal = parameterGlobal;
    }

    public Dteca getDtEcaid() {
        return dtEcaid;
    }

    public void setDtEcaid(Dteca dtEcaid) {
        this.dtEcaid = dtEcaid;
    }

    public Mamunicipio getMamunicipioId() {
        return mamunicipioId;
    }

    public void setMamunicipioId(Mamunicipio mamunicipioId) {
        this.mamunicipioId = mamunicipioId;
    }

    @XmlTransient
    public List<Dttercero> getDtterceroList() {
        return dtterceroList;
    }

    public void setDtterceroList(List<Dttercero> dtterceroList) {
        this.dtterceroList = dtterceroList;
    }


    public Collection<Dttercero> getDtTercero() {
        return dtTercero;
    }

    public void setDtTercero(Collection<Dttercero> dtTercero) {
        this.dtTercero = dtTercero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.parameterGlobal);
        hash = 79 * hash + Objects.hashCode(this.direccion);
        hash = 79 * hash + Objects.hashCode(this.filial);
        //hash = 79 * hash + Objects.hashCode(this.pocision);
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + Objects.hashCode(this.correo);
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
        final Dtecassucursal other = (Dtecassucursal) obj;
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.filial, other.filial)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.parameterGlobal, other.parameterGlobal)) {
            return false;
        }
        /*if (!Objects.equals(this.pocision, other.pocision)) {
            return false;
        }*/
        return true;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    
    

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtecassucursal[ id=" + id + " ]";
    }
    @XmlTransient
    public List<Dtmaparameter> getDtmaparameterList() {
        return dtmaparameterList;
    }
    public void setDtmaparameterList(List<Dtmaparameter> dtmaparameterList) {
        this.dtmaparameterList = dtmaparameterList;
    }
    
    @XmlTransient
    public List<Dtfactura> getDtfacturaList() {
        return dtfacturaList;
    }
    public void setDtfacturaList(List<Dtfactura> dtfacturaList) {
        this.dtfacturaList = dtfacturaList;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    /*public Geometry getPocision() {
        return pocision;
    }

    public void setPocision(Geometry pocision) {
        this.pocision = pocision;
    }*/

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getBasculamanual() {
        return basculamanual;
    }

    public void setBasculamanual(Boolean basculamanual) {
        this.basculamanual = basculamanual;
    }
    
    

    @XmlTransient
    public Collection<Dtmaterialprocesado> getDtmaterialprocesadoCollection() {
        return dtmaterialprocesadoCollection;
    }

    public void setDtmaterialprocesadoCollection(Collection<Dtmaterialprocesado> dtmaterialprocesadoCollection) {
        this.dtmaterialprocesadoCollection = dtmaterialprocesadoCollection;
    }

    public List<ViewMaterialProcesado> getViewMaterialprocesado() {
        return viewMaterialprocesado;
    }

    public void setViewMaterialprocesado(List<ViewMaterialProcesado> viewMaterialprocesado) {
        this.viewMaterialprocesado = viewMaterialprocesado;
    }

    public Boolean getShowreport() {
        return showreport;
    }

    public void setShowreport(Boolean showreport) {
        this.showreport = showreport;
    }

    public v_ecasconsolidado getV_ecasconsolidado() {
        return v_ecasconsolidado;
    }

    public void setV_ecasconsolidado(v_ecasconsolidado v_ecasconsolidado) {
        this.v_ecasconsolidado = v_ecasconsolidado;
    }
    
    
  
}
