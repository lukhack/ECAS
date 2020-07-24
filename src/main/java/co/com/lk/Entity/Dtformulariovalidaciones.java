/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtformulariovalidaciones", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtformulariovalidaciones.findAll", query = "SELECT d FROM Dtformulariovalidaciones d"),
    @NamedQuery(name = "Dtformulariovalidaciones.findById", query = "SELECT d FROM Dtformulariovalidaciones d WHERE d.id = :id")})
public class Dtformulariovalidaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "Tipo")
    private String tipo;
    @Size(max = 10)
    @Column(name = "ValorRest")
    private String valorRest;
    @Size(max = 10000)
    @Column(name = "PregCargar")
    private String pregCargar;
    @Size(max = 100)
    @Column(name = "Codigos")
    private String codigos;
    @Column(name = "idRegla")
    private Integer idRegla;
    @Size(max = 1)
    @Column(name = "Visible")
    private Boolean visible;
    @Size(max = 1)
    @Column(name = "Enabled")
    private Boolean enabled;
    @Column(name = "OnOff")
    private Integer onOff;
    @Size(max = 5)
    @Column(name = "Seccion")
    private String seccion;
    @Size(max = 100)
    @Column(name = "Parametro")
    private String parametro;
    @Size(max = 100)
    @Column(name = "NoParametro")
    private String noParametro;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "PregRest", referencedColumnName = "CodPreg")
    @ManyToOne
    private Dtformulario pregRest;

    public Dtformulariovalidaciones() {
    }

    public Dtformulariovalidaciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValorRest() {
        return valorRest;
    }

    public void setValorRest(String valorRest) {
        this.valorRest = valorRest;
    }

    public String getPregCargar() {
        return pregCargar;
    }

    public void setPregCargar(String pregCargar) {
        this.pregCargar = pregCargar;
    }

    public String getCodigos() {
        return codigos;
    }

    public void setCodigos(String codigos) {
        this.codigos = codigos;
    }

    public Integer getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getOnOff() {
        return onOff;
    }

    public void setOnOff(Integer onOff) {
        this.onOff = onOff;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getNoParametro() {
        return noParametro;
    }

    public void setNoParametro(String noParametro) {
        this.noParametro = noParametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dtformulario getPregRest() {
        return pregRest;
    }

    public void setPregRest(Dtformulario pregRest) {
        this.pregRest = pregRest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtformulariovalidaciones)) {
            return false;
        }
        Dtformulariovalidaciones other = (Dtformulariovalidaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtformulariovalidaciones[ id=" + id + " ]";
    }
    
}
