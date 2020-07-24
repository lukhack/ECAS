/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import co.com.lk.Entity.ma.Dtecamaterial;
import co.com.lk.Entity.ma.Dttercero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtfacturadetalle", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtfacturadetalle.findAll", query = "SELECT d FROM Dtfacturadetalle d"),
    @NamedQuery(name = "Dtfacturadetalle.findByIddetalleFactura", query = "SELECT d FROM Dtfacturadetalle d WHERE d.iddetalleFactura = :iddetalleFactura"),
    @NamedQuery(name = "Dtfacturadetalle.findByCantidad", query = "SELECT d FROM Dtfacturadetalle d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Dtfacturadetalle.findByValor", query = "SELECT d FROM Dtfacturadetalle d WHERE d.valor = :valor"),
    @NamedQuery(name = "Dtfacturadetalle.findByIva", query = "SELECT d FROM Dtfacturadetalle d WHERE d.iva = :iva"),
    @NamedQuery(name = "Dtfacturadetalle.findBySubTotal", query = "SELECT d FROM Dtfacturadetalle d WHERE d.subTotal = :subTotal"),
    @NamedQuery(name = "Dtfacturadetalle.findxEcasxTipoFacturaMesAnio", query = "SELECT d FROM Dtfacturadetalle d INNER JOIN FETCH d.dtFacturaVentaid f  WHERE  f.dtTipoFacturaid.id=?0  and f.dtEcassucursalid.id=?1 and  to_char(f.fecha, 'MM')=?2 and to_char(f.fecha, 'yyyy')=?3"),
    @NamedQuery(name = "Dtfacturadetalle.findxEcasxTipoFacturaMesAnioRecilador", query = "SELECT d FROM Dtfacturadetalle d INNER JOIN FETCH d.dtFacturaVentaid f  WHERE  f.dtTipoFacturaid.id=?0  and f.dtEcassucursalid.id=?1 and to_char(f.fecha, 'MM')=?2 and to_char(f.fecha, 'yyyy')=?3 ORDER BY f.tercero"),
     @NamedQuery(name = "Dtfacturadetalle.findxEcasxTipoFactura", query = "SELECT d FROM Dtfacturadetalle d INNER JOIN FETCH d.dtFacturaVentaid f  WHERE  f.dtTipoFacturaid.id in (1,6)  and f.dtEcassucursalid.id=?0 "),
   @NamedQuery(name = "Dtfacturadetalle.findxEcasxTipoFacturaFecha", query = "SELECT d FROM Dtfacturadetalle d INNER JOIN FETCH d.dtFacturaVentaid f  WHERE  f.dtTipoFacturaid.id=?0  and f.dtEcassucursalid.id=?1 and f.fecha=?2"),
    @NamedQuery(name = "Dtfacturadetalle.findxECAxTipoFactura", query = "SELECT d FROM Dtfacturadetalle d INNER JOIN FETCH d.dtFacturaVentaid f INNER JOIN FETCH f.dtTipoFacturaid t INNER JOIN FETCH f.dtEcassucursalid cs INNER JOIN FETCH cs.dtEcaid c  WHERE   c.id=?0 and t.id in(1,6)")})
public class Dtfacturadetalle implements Serializable {
    
    private static final String FINDALL="Dtfacturadetalle.findAll";
    private static final String FINDALLXCLIENTEXTIPOFACTURA="Dtfacturadetalle.findxClientexTipoFactura";
    private static final String FINDALLXCLIENTEXTIPOFACTURAMESDIA="Dtfacturadetalle.findxEcasxTipoFacturaMesAnio";
    private static final String FINDALLXCLIENTEXTIPOFACTURAMESDIARECICLADOR="Dtfacturadetalle.findxEcasxTipoFacturaMesAnioRecilador";
    private static final String FINDALLXCLIENTEXTIPOFACTURAFECHA="Dtfacturadetalle.findxEcasxTipoFacturaFecha";
    private static final String FINDALLXECAXTIPOFACTURA="Dtfacturadetalle.findxEcasxTipoFactura";
    private static final String FINDALLXECAXDETALLETIPOFACTURA="Dtfacturadetalle.findxECAxTipoFactura";

    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalleFactura")
    private Integer iddetalleFactura;
    
    @Column(name = "cantidad")
    private Double cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    
    @Column(name = "iva")
    private Double iva;
    
    @Column(name = "subTotal")
    private Double subTotal;
    
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Size(max = 1)
    @Column(name = "clasificacion")
    private String clasificacion="S";
    
    
    @Column(name = "convenio")
    private boolean convenio=false;
            
    @JoinColumn(name = "dtMaterial_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Dtecamaterial materialid;
    
    @JoinColumn(name = "dtFacturaVenta_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtfactura dtFacturaVentaid;
    
    @JoinColumn(name = "conveniotercero_id", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Dttercero terceroconvenio_id;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "materialid")
    private List<Dtfacturadetallematerial> dtFacturaDetalle;
    

    public Dtfacturadetalle() {
        dtFacturaDetalle=new ArrayList<>();
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    

    public Dtfacturadetalle(Integer iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
    }

    public Integer getIddetalleFactura() {
        return iddetalleFactura;
    }

    public void setIddetalleFactura(Integer iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
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

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Dtfactura getDtFacturaVentaid() {
        return dtFacturaVentaid;
    }

    public Dttercero getTercero() {
        System.err.println("tercero: "+getDtFacturaVentaid().getTercero());
        return getDtFacturaVentaid().getTercero();
    }
    
    public void setDtFacturaVentaid(Dtfactura dtFacturaVentaid) {
        this.dtFacturaVentaid = dtFacturaVentaid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Dtfacturadetallematerial> getDtFacturaDetalle() {
        return dtFacturaDetalle;
    }

    public void setDtFacturaDetalle(List<Dtfacturadetallematerial> dtFacturaDetalle) {
        this.dtFacturaDetalle = dtFacturaDetalle;
    }

    public boolean isConvenio() {
        return convenio;
    }

    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }

    public Dttercero getTerceroconvenio_id() {
        return terceroconvenio_id;
    }

    public void setTerceroconvenio_id(Dttercero terceroconvenio_id) {
        this.terceroconvenio_id = terceroconvenio_id;
    }
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleFactura != null ? iddetalleFactura.hashCode() : 0);
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
        final Dtfacturadetalle other = (Dtfacturadetalle) obj;
        if (this.convenio != other.convenio) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.clasificacion, other.clasificacion)) {
            return false;
        }
        if (!Objects.equals(this.iddetalleFactura, other.iddetalleFactura)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.iva, other.iva)) {
            return false;
        }
        if (!Objects.equals(this.subTotal, other.subTotal)) {
            return false;
        }
        if (!Objects.equals(this.materialid, other.materialid)) {
            return false;
        }
        if (!Objects.equals(this.dtFacturaVentaid, other.dtFacturaVentaid)) {
            return false;
        }
        if (!Objects.equals(this.terceroconvenio_id, other.terceroconvenio_id)) {
            return false;
        }
        return Objects.equals(this.dtFacturaDetalle, other.dtFacturaDetalle);
    }

    

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtfacturadetalle[ iddetalleFactura=" + iddetalleFactura + " ]";
    }

    public Dtecamaterial getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Dtecamaterial materialid) {
        this.materialid = materialid;
    }
    
    
    
}
