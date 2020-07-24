/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import co.com.lk.Entity.ma.DtmamaterialMarcaPresentacion;
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
@Table(name = "dtfacturadetallematerial", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtfacturadetallematerial.findAll", query = "SELECT d FROM Dtfacturadetallematerial d")})
public class Dtfacturadetallematerial implements Serializable {
    private static final String FINDALL="Dtfacturadetallematerial.findAll";

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cantidad")
    private Double cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    
    @JoinColumn(name = "idmateriapresentacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DtmamaterialMarcaPresentacion materialid;
    
    
    @JoinColumn(name = "idfacturadetalle", referencedColumnName = "iddetalleFactura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtfacturadetalle facturaDetalle;
    

    public Dtfacturadetallematerial() {
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Dtfacturadetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(Dtfacturadetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DtmamaterialMarcaPresentacion getMaterialid() {
        return materialid;
    }

    public void setMaterialid(DtmamaterialMarcaPresentacion materialid) {
        this.materialid = materialid;
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
        final Dtfacturadetallematerial other = (Dtfacturadetallematerial) obj;
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return Objects.equals(this.materialid, other.materialid);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtfacturadetalle[ iddetalleFactura=" + id + " ]";
    }

}
