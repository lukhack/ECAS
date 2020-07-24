/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author julig
 */
@Entity
@Table(name = "uitercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uitercero.findAll", query = "SELECT u FROM Uitercero u")})
public class Uitercero implements Serializable {
    
    private static final String FINDALL="Uitercero.findAll";
    private static final long serialVersionUID = 1L;
    
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "Razonsocial")
    private String razonsocial;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "ext1")
    private String ext1;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    
    
    @JoinColumn(name = "idmunicipio", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Mamunicipio idmunicipio;
    
    @JoinColumn(name = "idtercerotipo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Uitercerotipo tercerotipo;
    
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.MERGE},fetch = FetchType.LAZY,optional = true,orphanRemoval = true)
    @JoinTable(
            name = "iutercerousuario",
            joinColumns = @JoinColumn(name = "idtercero"),
            inverseJoinColumns = @JoinColumn(name = "idusuario")
    )
    TbUiUsuario usuario;
    
    
    public Uitercero() {
        this.tercerotipo = new Uitercerotipo();
       
    }

    public Uitercero(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    

    public Mamunicipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Mamunicipio idmunicipio) {
        this.idmunicipio = idmunicipio;
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
        if (!(object instanceof Uitercero)) {
            return false;
        }
        Uitercero other = (Uitercero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Uitercero[ id=" + id + " ]";
    }


    public Uitercerotipo getTercerotipo() {
        return tercerotipo;
    }

    public void setTercerotipo(Uitercerotipo tercerotipo) {
        this.tercerotipo = tercerotipo;
    }
    public TbUiUsuario getUsuario() {
        return usuario;
    }
    public void setUsuario(TbUiUsuario usuario) {
        this.usuario = usuario;
    }
   

    

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
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


    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    
}
