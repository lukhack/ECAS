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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "dteca" , schema = "ecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dteca.findAll", query = "SELECT d FROM Dteca d"),
    @NamedQuery(name = "Dteca.findById", query = "SELECT d FROM Dteca d WHERE d.id = :id"),
    @NamedQuery(name = "Dteca.findByNombre", query = "SELECT d FROM Dteca d WHERE d.nombre = :nombre")})
public class Dteca implements Serializable {

    
    private static final String FINDALL="Dteca.findAll";
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "nit")
    private String nit;
    
    @Size(max = 100)
    @Column(name = "RazonSocial")
    private String nombre;
    
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtEcaid",orphanRemoval = true)
    private List<Dtecassucursal> dtecassucursalList;
    
     @JoinTable(name = "dtecaparameter",  schema = "ecas",  joinColumns = {
        @JoinColumn(name = "dtEca_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "dtParameter_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Dtmaparameter> dtmaparameterList;
     
    public Dteca() {
        dtecassucursalList=new ArrayList<>();
        dtmaparameterList=new ArrayList<>();
    }

    public Dteca(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public List<Dtecassucursal> getDtecassucursalList() {
        return dtecassucursalList;
    }

    public void setDtecassucursalList(List<Dtecassucursal> dtecassucursalList) {
        this.dtecassucursalList = dtecassucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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
        final Dteca other = (Dteca) obj;
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dteca[ id=" + id + " ]";
    }


    @XmlTransient
    public List<Dtmaparameter> getDtmaparameterList() {
        return dtmaparameterList;
    }

    public void setDtmaparameterList(List<Dtmaparameter> dtmaparameterList) {
        this.dtmaparameterList = dtmaparameterList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
