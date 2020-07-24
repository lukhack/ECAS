/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.rp;

import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtmatipofactura;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "v_reportefacturames", schema = "procesos")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "PrComprasMes.findAll", query = "SELECT d FROM PrComprasMes d"),
    @NamedQuery(name = "PrComprasMes.reporteTipoFactura", query = "SELECT d FROM PrComprasMes d where d.dtTipoFacturaid.id=?0 and d.sucursal.id=?1 Order By anio DESC, mes DESC"),
    @NamedQuery(name = "PrComprasMes.reporteTipoFacturaAsc", query = "SELECT d FROM PrComprasMes d where d.dtTipoFacturaid.id=?0 and d.sucursal.id=?1 Order By anio ASC, mes ASC")})
    
public class PrComprasMes implements Serializable {
  
    private static final String FINDALL="PrComprasMes.findAll";
    private static final String FINDALLTIPOFACTURA="PrComprasMes.reporteTipoFactura";
    private static final String FINDALLTIPOFACTURAASC="PrComprasMes.reporteTipoFacturaAsc";
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "mes")
    private String mes;
    
    @Column(name = "anio")
    private String anio;
    
    @Column(name = "total")
    private Double total;
    
    
    @Column(name = "totalmaterial")
    private Double totalmaterial;
    
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

    public Double getTotalmaterial() {
        return totalmaterial;
    }

    public void setTotalmaterial(Double totalmaterial) {
        this.totalmaterial = totalmaterial;
    }

    
    
}
