/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtrespuestaz", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtrespuestaz.findAll", query = "SELECT d FROM Dtrespuestaz d"),
    @NamedQuery(name = "Dtrespuestaz.findByOrden", query = "SELECT d FROM Dtrespuestaz d WHERE d.orden = :orden"),
    @NamedQuery(name = "Dtrespuestaz.findByForm", query = "SELECT d FROM Dtrespuestaz d WHERE d.dtrespuestazPK.form = :form"),
    @NamedQuery(name = "Dtrespuestaz.findByHogar", query = "SELECT d FROM Dtrespuestaz d WHERE d.dtrespuestazPK.hogar = :hogar"),
    @NamedQuery(name = "Dtrespuestaz.findByPersona", query = "SELECT d FROM Dtrespuestaz d WHERE d.dtrespuestazPK.persona = :persona"),
    @NamedQuery(name = "Dtrespuestaz.findByCodPreg", query = "SELECT d FROM Dtrespuestaz d WHERE d.dtrespuestazPK.codPreg = :codPreg"),
    @NamedQuery(name = "Dtrespuestaz.findByRespuesta", query = "SELECT d FROM Dtrespuestaz d WHERE d.respuesta = :respuesta"),
    @NamedQuery(name = "Dtrespuestaz.findByFecha", query = "SELECT d FROM Dtrespuestaz d WHERE d.fecha = :fecha")})
public class Dtrespuestaz implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DtrespuestazPK dtrespuestazPK;
    @Column(name = "Orden")
    private Integer orden;
    @Size(max = 1000)
    @Column(name = "Respuesta")
    private String respuesta;
    
    
    @Column(name = "Fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    
    @JoinColumn(name = "Form", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dtrespuestaform dtrespuestaform;

    public Dtrespuestaz() {
    }

    public Dtrespuestaz(DtrespuestazPK dtrespuestazPK) {
        this.dtrespuestazPK = dtrespuestazPK;
    }

    public Dtrespuestaz(int orden,int form, int hogar, int persona, String codPreg,String respuesta,Date fecha) {
        this.dtrespuestazPK = new DtrespuestazPK(form, hogar, persona, codPreg);
        this.orden=orden;
        this.respuesta=respuesta;
        this.fecha=fecha;
    }

    public DtrespuestazPK getDtrespuestazPK() {
        return dtrespuestazPK;
    }

    public void setDtrespuestazPK(DtrespuestazPK dtrespuestazPK) {
        this.dtrespuestazPK = dtrespuestazPK;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public Dtrespuestaform getDtrespuestaform() {
        return dtrespuestaform;
    }

    public void setDtrespuestaform(Dtrespuestaform dtrespuestaform) {
        this.dtrespuestaform = dtrespuestaform;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtrespuestazPK != null ? dtrespuestazPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtrespuestaz)) {
            return false;
        }
        Dtrespuestaz other = (Dtrespuestaz) object;
        if ((this.dtrespuestazPK == null && other.dtrespuestazPK != null) || (this.dtrespuestazPK != null && !this.dtrespuestazPK.equals(other.dtrespuestazPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtrespuestaz[ dtrespuestazPK=" + dtrespuestazPK + " ]";
    }
    
}
