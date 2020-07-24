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
@Table(name = "dtrespuestazdetalle", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtrespuestadetalle.findAll", query = "SELECT d FROM Dtrespuestadetalle d")})
public class Dtrespuestadetalle implements Serializable {

    @Size(max = 1000)
    @Column(name = "Respuesta")
    private String respuesta;
    
    @Column(name = "Fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    
    @JoinColumn(name = "Form", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dtrespuestaform dtrespuestaform;

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DtrespuestadetallePK dtrepuestadetallePK;
    
    @Column(name = "Orden")
    private Integer orden;

    public Dtrespuestadetalle() {
    }

    public Dtrespuestadetalle(DtrespuestadetallePK dtrepuestadetallePK) {
        this.dtrepuestadetallePK = dtrepuestadetallePK;
    }

    public Dtrespuestadetalle(int form, int hogar, int persona, String codPreg, String padrePreg) {
        this.dtrepuestadetallePK = new DtrespuestadetallePK(form, hogar, persona, codPreg, padrePreg);
    }

    public DtrespuestadetallePK getDtrepuestadetallePK() {
        return dtrepuestadetallePK;
    }

    public void setDtrepuestadetallePK(DtrespuestadetallePK dtrepuestadetallePK) {
        this.dtrepuestadetallePK = dtrepuestadetallePK;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtrepuestadetallePK != null ? dtrepuestadetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtrespuestadetalle)) {
            return false;
        }
        Dtrespuestadetalle other = (Dtrespuestadetalle) object;
        if ((this.dtrepuestadetallePK == null && other.dtrepuestadetallePK != null) || (this.dtrepuestadetallePK != null && !this.dtrepuestadetallePK.equals(other.dtrepuestadetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtrepuestadetalle[ dtrepuestadetallePK=" + dtrepuestadetallePK + " ]";
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
    
}
