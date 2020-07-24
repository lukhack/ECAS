/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtterceroruta", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtterceroruta.findAll", query = "SELECT d FROM Dtterceroruta d"),
    @NamedQuery(name = "Dtterceroruta.findById", query = "SELECT d FROM Dtterceroruta d WHERE d.id = :id"),
    @NamedQuery(name = "Dtterceroruta.findByRuta", query = "SELECT d FROM Dtterceroruta d WHERE d.ruta = :ruta")})
public class Dtterceroruta implements Serializable {
    
    private static final String FINDALL="Dtterceroruta.findAll";
    private static final String FINDID="Dtterceroruta.findById";
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "ruta")
    private String ruta;
    
    @JoinColumn(name = "idtercero", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dttercero idtercero;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtterceroruta", fetch = FetchType.LAZY)
    private List<Dttercerorutacoordenada> dttercerorutacoordenada;

    public Dtterceroruta() {
        dttercerorutacoordenada=new ArrayList<>();
    }

    public Dtterceroruta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Dttercero getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(Dttercero idtercero) {
        this.idtercero = idtercero;
    }

    public List<Dttercerorutacoordenada> getDttercerorutacoordenada() {
        return dttercerorutacoordenada;
    }

    public void setDttercerorutacoordenada(List<Dttercerorutacoordenada> dttercerorutacoordenada) {
        this.dttercerorutacoordenada = dttercerorutacoordenada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        final Dtterceroruta other = (Dtterceroruta) obj;
        if (!Objects.equals(this.ruta, other.ruta)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dtterceroruta[ id=" + id + " ]";
    }
    
}
