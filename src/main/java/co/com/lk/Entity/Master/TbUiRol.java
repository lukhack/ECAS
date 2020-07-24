/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "uirol" , schema = "maestros")
@NamedQueries({
    @NamedQuery(name = "TbUiRol.FindALL", query = "SELECT U FROM TbUiRol U "),
    @NamedQuery(name = "TbUiRol.FindById", query = "SELECT U FROM TbUiRol U WHERE U.id = ?1"),
})  
public class TbUiRol implements Serializable {    

    private static final String FINDALL="TbUiRol.FindALL";
    private static final String FINDID="TbUiRol.FindById";
    
    @Size(max = 45)
    @Column(name = "Rol")
    private String rol;

    
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "uiRol")
    private List<TbUiUsuario>  uiUsuarios;
    
    public TbUiRol() {
    }
    
    
    
    
    
    public Long getId() { 
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TbUiUsuario> getUiUsuarios() {
        return uiUsuarios;
    }

    public void setUiUsuarios(List<TbUiUsuario> uiUsuarios) {
        this.uiUsuarios = uiUsuarios;
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
        System.err.println("pase por equeal");
        if (!(object instanceof TbUiRol)) {
            System.err.println("pase por equeal 1");
            return false;
        }
        TbUiRol other = (TbUiRol) object;
        boolean lreturn=!((this.id == null && other.id != null) || (this.id != null && !(Objects.equals(this.id, other.getId()))));
        return lreturn;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    
    
}
