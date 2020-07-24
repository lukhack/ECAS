/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.rp;

import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtmatipofactura;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "v_reportefacturadia", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrComprasDia.findAll", query = "SELECT d FROM PrComprasDia d order by d.fecha"),
    @NamedQuery(name = "PrComprasDia.reporteTipoFactura", query = "SELECT d FROM PrComprasDia d where d.dtTipoFacturaid.id=?0 and d.sucursal.id=?1 and d.mes=?2 and d.anio=?3")})
public class PrComprasDia implements Serializable {
    private static final String FINDALL="PrComprasDia.findAll";
    private static final String FINDALLTIPOFACTURA="PrComprasDia.reporteTipoFactura";
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "mes")
    private String mes;
    
    @Column(name = "anio")
    private String anio;
    
    @Column(name = "cantidad")
    private Double cantidad;
    
    
    @Column(name = "total")
    private Double total;
    
    @JoinColumn(name = "dtecassucursal_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtecassucursal sucursal;
    
    @JoinColumn(name = "dtTipoFactura_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmatipofactura dtTipoFacturaid;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dtecassucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Dtecassucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Dtmatipofactura getDtTipoFacturaid() {
        return dtTipoFacturaid;
    }

    public void setDtTipoFacturaid(Dtmatipofactura dtTipoFacturaid) {
        this.dtTipoFacturaid = dtTipoFacturaid;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
