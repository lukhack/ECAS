/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.PK;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lukhack
 */
@Embeddable
public class ViewMaterialCompradoPK implements Serializable  {
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_id")
    private Integer dtMaterialid;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtEcassucursal_id")
    private Integer dtEcassucursalid;
    
    public ViewMaterialCompradoPK(){
    
    }

    public Integer getDtMaterialid() {
        return dtMaterialid;
    }

    public void setDtMaterialid(Integer dtMaterialid) {
        this.dtMaterialid = dtMaterialid;
    }

    public Integer getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Integer dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    
    
}
