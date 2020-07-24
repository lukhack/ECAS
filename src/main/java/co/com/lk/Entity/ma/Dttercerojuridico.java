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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dttercerojuridico", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dttercerojuridico.findAll", query = "SELECT d FROM Dttercerojuridico d"),
    @NamedQuery(name = "Dttercerojuridico.findByDtterceroId", query = "SELECT d FROM Dttercerojuridico d WHERE d.dtterceroId = :dtterceroId"),
    @NamedQuery(name = "Dttercerojuridico.findByRazonSocial", query = "SELECT d FROM Dttercerojuridico d WHERE d.razonSocial = :razonSocial")})
public class Dttercerojuridico implements Serializable {
    
    private static final String FINDALL="Dttercerojuridico.findAll";
    private static final long serialVersionUID = 1L;
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer dtterceroId;
    
    @Size(max = 45)
    @Column(name = "razonSocial")
    private String razonSocial;
    
    @Column(name = "dv")
    private Integer dv;
    
    @JoinColumn(name = "dttercero_id", nullable = false,unique = true)
    @OneToOne(optional = false)
    private Dttercero dttercero;

    public Dttercerojuridico() {
        dttercero=new Dttercero();
    }

    public Dttercerojuridico(Integer dtterceroId) {
        this.dtterceroId = dtterceroId;
    }

    public Integer getDtterceroId() {
        return dtterceroId;
    }

    public void setDtterceroId(Integer dtterceroId) {
        this.dtterceroId = dtterceroId;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Dttercero getDttercero() {
        return dttercero;
    }

    public void setDttercero(Dttercero dttercero) {
        this.dttercero = dttercero;
    }

    public Integer getDv() {
        return dv;
    }

    public void setDv(Integer dv) {
        this.dv = dv;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtterceroId != null ? dtterceroId.hashCode() : 0);
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
        final Dttercerojuridico other = (Dttercerojuridico) obj;
        if (!Objects.equals(this.razonSocial, other.razonSocial)) {
            return false;
        }
        if (!Objects.equals(this.dtterceroId, other.dtterceroId)) {
            return false;
        }
        return Objects.equals(this.dv, other.dv);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dttercerojuridico[ dtterceroId=" + dtterceroId + " ]";
    }
    
}
