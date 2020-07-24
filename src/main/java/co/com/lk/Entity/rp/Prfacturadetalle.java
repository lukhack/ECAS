/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.rp;

import co.com.lk.Entity.ma.Dtecamaterial;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtmatipofactura;
import co.com.lk.Entity.ma.Dttercero;
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
@Table(name = "v_reportetercero", schema = "procesos")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Prfacturadetalle.findxEcasxTipoFacturaMesAnioRecilador", query = "SELECT d FROM Prfacturadetalle d WHERE d.dtTipoFacturaid.id=?0 and d.dtEcassucursalid.id=?1 and d.mes=?2 and d.anio=?3")})
public class Prfacturadetalle implements Serializable {
    
    private static final String FINDALLXRECICLADORMESDIA="Prfacturadetalle.findxEcasxTipoFacturaMesAnioRecilador";

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private Integer id;
     
    @Column(name = "cantidad")
    private Double cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    
    
    @Column(name = "mes")
    private String mes;
    
    @Column(name = "anio")
    private String anio;
    
    
    @JoinColumn(name = "dtmaterial_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtecamaterial materialid;
    
    @JoinColumn(name = "dtecassucursal_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Dtecassucursal dtEcassucursalid;
    
    @JoinColumn(name = "dttipofactura_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmatipofactura dtTipoFacturaid;
     
    @JoinColumn(name = "dttercero_id", referencedColumnName = "id",nullable = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dttercero tercero;

    public Prfacturadetalle() {
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

    public Dtecamaterial getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Dtecamaterial materialid) {
        this.materialid = materialid;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public Dtmatipofactura getDtTipoFacturaid() {
        return dtTipoFacturaid;
    }

    public void setDtTipoFacturaid(Dtmatipofactura dtTipoFacturaid) {
        this.dtTipoFacturaid = dtTipoFacturaid;
    }

    public Dttercero getTercero() {
        return tercero;
    }

    public void setTercero(Dttercero tercero) {
        this.tercero = tercero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
   
    
    
    
}
