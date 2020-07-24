/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import co.com.lk.Entity.ma.Dtecamaterial;
import java.io.Serializable;

/**
 *
 * @author lukhack
 */
public class DtProcesoMaterialesEntity implements Serializable{
    
    private Dtecamaterial material;
    
    
    private Double MaterialIngresado;
    
    private Double MaterialBodega;
    
    private Double MaterialDisponible;
    
    private Double MaterialRecoleccion;
    
    
    private Double MaterialDesperdicio;
    
    
    private Double MaterialProcesado;
    
    private Double cantidadventa;
    
    public void DtProcesoMateriales(){
    
    }

    public Dtecamaterial getMaterial() {
        return material;
    }

    public void setMaterial(Dtecamaterial material) {
        this.material = material;
    }

    public Double getMaterialBodega() {
        return MaterialBodega;
    }

    public void setMaterialBodega(Double MaterialBodega) {
        this.MaterialBodega = MaterialBodega;
    }

    public Double getMaterialDisponible() {
        return MaterialDisponible;
    }

    public void setMaterialDisponible(Double MaterialDisponible) {
        this.MaterialDisponible = MaterialDisponible;
    }

    public Double getMaterialDesperdicio() {
        return MaterialDesperdicio;
    }

    public void setMaterialDesperdicio(Double MaterialDesperdicio) {
        this.MaterialDesperdicio = MaterialDesperdicio;
    }

    public Double getMaterialProcesado() {
        return MaterialProcesado;
    }

    public void setMaterialProcesado(Double MaterialProcesado) {
        this.MaterialProcesado = MaterialProcesado;
    }

    public Double getMaterialIngresado() {
        return MaterialIngresado;
    }

    public void setMaterialIngresado(Double MaterialIngresado) {
        this.MaterialIngresado = MaterialIngresado;
    }

    

   

    public Double getMaterialRecoleccion() {
        return MaterialRecoleccion;
    }

    public void setMaterialRecoleccion(Double MaterialRecoleccion) {
        this.MaterialRecoleccion = MaterialRecoleccion;
    }

    public Double getCantidadventa() {
        return cantidadventa;
    }

    public void setCantidadventa(Double cantidadventa) {
        this.cantidadventa = cantidadventa;
    }
    
    
}
