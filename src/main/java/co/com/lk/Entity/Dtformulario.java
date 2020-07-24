/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtformulario", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtformulario.findAll", query = "SELECT d FROM Dtformulario d")})
public class Dtformulario implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Orden")
    private int orden;
    @Size(max = 300)
    @Column(name = "Pregunta")
    private String pregunta;
    @Size(max = 100)
    @Column(name = "OpcResp")
    private String opcResp;
    @Size(max = 12)
    @Column(name = "TipoIngreso")
    private String tipoIngreso;
    @Size(max = 12)
    @Column(name = "TipoCampo")
    private String tipoCampo;
    @Size(max = 20)
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "Obligatorio")
    private Boolean obligatorio;
    
    @Size(max = 1000)
    @Column(name = "Help")
    private String help;
    @Column(name = "Precargado")
    private Boolean precargado;
    @Size(max = 1)
    @Column(name = "savedata")
    private String savedata;
    @Size(max = 10)
    @Column(name = "NCodPreg")
    private String nCodPreg;
    @Size(max = 10)
    @Column(name = "padre")
    private String padre;
    @Size(max = 200)
    @Column(name = "parameter")
    private String parameter;
    
    @Column(name = "remove")
    private Boolean remove;
    
    
    @Column(name = "visible")
    private Boolean visible;
    
    @OneToMany(mappedBy = "pregRest")
    private Collection<Dtformulariovalidaciones> dtformulariovalidacionesCollection;
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CodPreg")
    private String codPreg;
    @Column(name = "LongitudMin")
    private Integer longitudMin;
    @Column(name = "LongitudMax")
    private Integer longitudMax;
    @Column(name = "VlrMinimo")
    private Integer vlrMinimo;
    @Column(name = "VlrMaximo")
    private Integer vlrMaximo;
    @Column(name = "TieneValidacion")
    private Boolean tieneValidacion;
    @Column(name = "columna")
    private Integer columna;
    @Column(name = "peso")
    private Integer peso;
    
    @JoinColumn(name = "subGrupo", referencedColumnName = "id")
    @ManyToOne
    private Dtsubgrupo subGrupo;
    

    public Dtformulario() {
    }

    public Dtformulario(String codPreg) {
        this.codPreg = codPreg;
    }

    public Dtformulario(String codPreg, int orden) {
        this.codPreg = codPreg;
        this.orden = orden;
    }


    public String getCodPreg() {
        return codPreg;
    }

    public void setCodPreg(String codPreg) {
        this.codPreg = codPreg;
    }


    public Integer getLongitudMin() {
        return longitudMin;
    }

    public void setLongitudMin(Integer longitudMin) {
        this.longitudMin = longitudMin;
    }

    public Integer getLongitudMax() {
        return longitudMax;
    }

    public void setLongitudMax(Integer longitudMax) {
        this.longitudMax = longitudMax;
    }

    public Integer getVlrMinimo() {
        return vlrMinimo;
    }

    public void setVlrMinimo(Integer vlrMinimo) {
        this.vlrMinimo = vlrMinimo;
    }

    public Integer getVlrMaximo() {
        return vlrMaximo;
    }

    public void setVlrMaximo(Integer vlrMaximo) {
        this.vlrMaximo = vlrMaximo;
    }

    public Boolean getTieneValidacion() {
        return tieneValidacion;
    }

    public void setTieneValidacion(Boolean tieneValidacion) {
        this.tieneValidacion = tieneValidacion;
    }


    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }


    public Dtsubgrupo getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(Dtsubgrupo subGrupo) {
        this.subGrupo = subGrupo;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPreg != null ? codPreg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtformulario)) {
            return false;
        }
        Dtformulario other = (Dtformulario) object;
        if ((this.codPreg == null && other.codPreg != null) || (this.codPreg != null && !this.codPreg.equals(other.codPreg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dtformulario[ codPreg=" + codPreg + " ]";
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcResp() {
        return opcResp;
    }

    public void setOpcResp(String opcResp) {
        this.opcResp = opcResp;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Boolean getPrecargado() {
        return precargado;
    }

    public void setPrecargado(Boolean precargado) {
        this.precargado = precargado;
    }

    public String getSavedata() {
        return savedata;
    }

    public void setSavedata(String savedata) {
        this.savedata = savedata;
    }

    public String getNCodPreg() {
        return nCodPreg;
    }

    public void setNCodPreg(String nCodPreg) {
        this.nCodPreg = nCodPreg;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    

    @XmlTransient
    public Collection<Dtformulariovalidaciones> getDtformulariovalidacionesCollection() {
        return dtformulariovalidacionesCollection;
    }

    public void setDtformulariovalidacionesCollection(Collection<Dtformulariovalidaciones> dtformulariovalidacionesCollection) {
        this.dtformulariovalidacionesCollection = dtformulariovalidacionesCollection;
    }
    
}
