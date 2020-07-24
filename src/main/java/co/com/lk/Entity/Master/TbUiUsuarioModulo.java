/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author julig
 */
@Entity
@Table(name = "uiusuariomodulo", schema = "maestros")
@NamedQueries({
    @NamedQuery(name = "TbUiUsuarioModulo.FindALL", query = "SELECT U FROM TbUiUsuarioModulo U "),
    @NamedQuery(name = "TbUiUsuarioModulo.FindById", query = "SELECT U FROM TbUiUsuarioModulo U WHERE U.id = ?1")
})
public class TbUiUsuarioModulo implements  Serializable{
    
    private static final String FINDALL="TbUiUsuarioModulo.FindALL"; 
    private static final String FINDID="TbUiUsuarioModulo.FindById";
    
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UiUsuario_id")
    private TbUiUsuario uiUsuario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UiModulo_id")
    private TbUiModulo uiModulo;
    
    private boolean Enable;
    
      
    public TbUiUsuarioModulo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TbUiUsuario getUiUsuario() {
        return uiUsuario;
    }

    public void setUiUsuario(TbUiUsuario uiUsuario) {
        this.uiUsuario = uiUsuario;
    }

    public TbUiModulo getUiModulo() {
        return uiModulo;
    }

    public void setUiModulo(TbUiModulo uiModulo) {
        this.uiModulo = uiModulo;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean Enable) {
        this.Enable = Enable;
    }

    

    
    
    

    
    
    
     
    
}
