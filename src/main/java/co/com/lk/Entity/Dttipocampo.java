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
@Table(name = "dttipocampo", schema = "censo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dttipocampo.findAll", query = "SELECT d FROM Dttipocampo d"),
    @NamedQuery(name = "Dttipocampo.findById", query = "SELECT d FROM Dttipocampo d WHERE d.id = :id"),
    @NamedQuery(name = "Dttipocampo.findByTipoCampo", query = "SELECT d FROM Dttipocampo d WHERE d.tipoCampo = :tipoCampo"),
    @NamedQuery(name = "Dttipocampo.findByTable", query = "SELECT d FROM Dttipocampo d WHERE d.table = :table")})
public class Dttipocampo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "tipoCampo")
    private String tipoCampo;
    @Size(max = 45)
    @Column(name = "tabla")
    private String table;

    public Dttipocampo() {
    }

    public Dttipocampo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
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
        if (!(object instanceof Dttipocampo)) {
            return false;
        }
        Dttipocampo other = (Dttipocampo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.Dttipocampo[ id=" + id + " ]";
    }
    
}
