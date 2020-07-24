/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.view;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import co.com.lk.Entity.ma.Dtecassucursal;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "v_ecasconsolidadocompras", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "v_ecasconsolidado.findAll", query = "SELECT v FROM v_ecasconsolidado v")})
public class v_ecasconsolidado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "totalkg")
    Double totalkg;
    
    @Column(name = "totalPesos")
    Double totalPesos;
  
    @JoinColumn(name = "dtecassucursal_id",referencedColumnName = "id",insertable = false,updatable = false)
    @ManyToOne
    private Dtecassucursal dtEcassucursalid;
    

    public v_ecasconsolidado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalkg() {
        return totalkg;
    }

    public void setTotalkg(Double totalkg) {
        this.totalkg = totalkg;
    }

    public Double getTotalPesos() {
        return totalPesos;
    }

    public void setTotalPesos(Double totalPesos) {
        this.totalPesos = totalPesos;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }
    
    
    
}
