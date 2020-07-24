/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author julig
 */
@NamedQueries({
    @NamedQuery(name = "TbUiModulo.FindALL", query = "SELECT U FROM TbUiModulo U ORDER BY U.id"),
    @NamedQuery(name = "TbUiModulo.FindById", query = "SELECT U FROM TbUiModulo U WHERE U.id = ?1")
 
})
@Entity
@Table(name = "uimodulo", schema = "maestros")
public class TbUiModulo implements  Serializable{
    
    
    private static final String FINDALL="TbUiModulo.FindALL";
    private static final String FINDID="TbUiModulo.FindById";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nomModulo;
    
    private String icon;
    
    private String url;
    
    private String item;
    
    private boolean activo;
    
    private Long parent;
    
    
    private String parameters;
    
    private boolean children;
    private boolean actionListen;
        
    @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(name = "UiUsuarioModulo", schema = "maestros",
            joinColumns = {@JoinColumn(name="UiModulo_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="UiUsuario_id", referencedColumnName="id")})
   private List<TbUiUsuario> usuarios; 
    
    public TbUiModulo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getNomModulo() {
        return nomModulo;
    }

    public void setNomModulo(String nomModulo) {
        this.nomModulo = nomModulo;
    }

    public List<TbUiUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TbUiUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public boolean getActionListen() {
        return actionListen;
    }

    public void setActionListen(boolean actionListen) {
        this.actionListen = actionListen;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
    
    

    
    public Map<String,String> getMapParameters(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.err.println("paramter:"+getParameters());
            
            return Objects.nonNull(getParameters())?mapper.readValue(getParameters(), new TypeReference<Map<String,String>>(){}):null;
        } catch (Exception ex) {
            return null;
        }
    }   
    

    
    
    
}
