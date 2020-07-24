/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

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
@Table(name = "dtmamaterialmarca_presentacion", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtmamaterialMarcaPresentacion.findAll", query = "SELECT d FROM DtmamaterialMarcaPresentacion d")})
public class DtmamaterialMarcaPresentacion implements Serializable {
    private static final String FINDALL="DtmamaterialMarcaPresentacion.findAll";

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "presentacion")
    String presentacion;
    
    @Column(name = "valor")
    Double valor;
            
    
    @JoinColumn(name = "idunidadMedida", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtmaunidadmedida idunidadMedida;
    
    @JoinColumn(name = "idmaterialmarca", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtmamaterialMarca idmaterialmarca;
    
    public DtmamaterialMarcaPresentacion() {
    }

    public DtmamaterialMarcaPresentacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Dtmaunidadmedida getIdunidadMedida() {
        return idunidadMedida;
    }

    public void setIdunidadMedida(Dtmaunidadmedida idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
    }

    public DtmamaterialMarca getIdmaterialmarca() {
        return idmaterialmarca;
    }

    public void setIdmaterialmarca(DtmamaterialMarca idmaterialmarca) {
        this.idmaterialmarca = idmaterialmarca;
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
        final DtmamaterialMarcaPresentacion other = (DtmamaterialMarcaPresentacion) obj;
        if (!Objects.equals(this.presentacion, other.presentacion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.idunidadMedida, other.idunidadMedida)) {
            return false;
        }
        return Objects.equals(this.idmaterialmarca, other.idmaterialmarca);
    }
    
    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtmamaterial[ id=" + id + " ]";
    }
    
}
