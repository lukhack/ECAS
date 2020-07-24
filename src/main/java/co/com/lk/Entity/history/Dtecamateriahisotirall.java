/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.history;

import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Entity.ma.*;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dteca_mamaterial_historial", schema = "historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtecamateriahisotirall.findAll", query = "SELECT d FROM Dtecamateriahisotirall d"),
    @NamedQuery(name = "Dtecamateriahisotirall.findById", query = "SELECT d FROM Dtecamateriahisotirall d WHERE d.id = :id"),
    @NamedQuery(name = "Dtecamateriahisotirall.findByFecha", query = "SELECT d FROM Dtecamateriahisotirall d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Dtecamateriahisotirall.findByValorCompra", query = "SELECT d FROM Dtecamateriahisotirall d WHERE d.valorCompra = :valorCompra"),
    @NamedQuery(name = "Dtecamateriahisotirall.findByValorVenta", query = "SELECT d FROM Dtecamateriahisotirall d WHERE d.valorVenta = :valorVenta")})
public class Dtecamateriahisotirall implements Serializable {
    private static final String FINDALL="Dtecamateriahisotirall.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorCompra")
    private Double valorCompra;
    
    @Column(name = "valorVenta")
    private Double valorVenta;
    
    
    
    @JoinColumn(name = "dteca_material_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtecamaterial dtecamateria_id;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TbUiUsuario usuario_id;
    

    public Dtecamateriahisotirall() {
    }

    public Dtecamateriahisotirall(Integer id) {
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

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
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
        final Dtecamateriahisotirall other = (Dtecamateriahisotirall) obj;
        return (Objects.equals(this.dtecamateria_id.getId(),other.dtecamateria_id.getId()));
            
        
    }

    public Dtecamaterial getDtecamateria_id() {
        return dtecamateria_id;
    }

    public void setDtecamateria_id(Dtecamaterial dtecamateria_id) {
        this.dtecamateria_id = dtecamateria_id;
    }

    public TbUiUsuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(TbUiUsuario usuario_id) {
        this.usuario_id = usuario_id;
    }

   

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtecamaterial[ id=" + id + " ]";
    }
    
}
