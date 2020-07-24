/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;

import java.awt.Point;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dttercerorutacoordenada", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dttercerorutacoordenada.findAll", query = "SELECT d FROM Dttercerorutacoordenada d"),
    @NamedQuery(name = "Dttercerorutacoordenada.findById", query = "SELECT d FROM Dttercerorutacoordenada d WHERE d.id = :id"),
    @NamedQuery(name = "Dttercerorutacoordenada.findByDireccion", query = "SELECT d FROM Dttercerorutacoordenada d WHERE d.direccion = :direccion")})
public class Dttercerorutacoordenada implements Serializable {
    
    private static final String FINDALL="Dttercerorutacoordenada.findAll";
    private static final String FINDID="Dttercerorutacoordenada.findById";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "point",columnDefinition="Point", nullable = true)
    private Point point;
    
    
    @JoinColumn(name = "idterceroruta", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtterceroruta dtterceroruta;

    public Dttercerorutacoordenada() {
    }

    public Dttercerorutacoordenada(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    public Dtterceroruta getDtterceroruta() {
        return dtterceroruta;
    }

    public void setDtterceroruta(Dtterceroruta dtterceroruta) {
        this.dtterceroruta = dtterceroruta;
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
        final Dttercerorutacoordenada other = (Dttercerorutacoordenada) obj;
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.point, other.point);
    }

    

    @Override
    public String toString() {
        return "co.com.lk.Entity.ma.Dttercerorutacoordenada[ id=" + id + " ]";
    }
    
}
