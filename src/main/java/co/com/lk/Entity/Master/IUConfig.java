/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Likas
 * clase de tipo POJO plain olg java object.
 */


@NamedQueries({
    @NamedQuery(name = "IUConfig.FindALL", query = "SELECT U FROM IUConfig U "),
})
@Entity
@Table(name = "uiconfig", schema = "maestros")
public class IUConfig implements  Serializable{
    
    private static final String FINDALL="IUConfig.FindALL";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    @Column(name = "tipo")
    private String tipo;
    
    
    @Column(name = "nameform")
    private String nameform;
    
    
    @Column(name = "nametitle")
    private String nametitle;
    
    
    @Column(name = "numcolum")
    private int numColum;
    
    
    @Column(name = "icon")
    private String icon;
    
    
    
    @Column(name = "activo")
    private boolean activo;
    
   @OneToMany(mappedBy = "tipo")
   private List<IUConfigForm> IUConfigForm;

    public IUConfig() {
    }
   
   
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<IUConfigForm> getIUConfigForm() {
        return IUConfigForm;
    }

    public void setIUConfigForm(List<IUConfigForm> IUConfigForm) {
        this.IUConfigForm = IUConfigForm;
    }

    
    

    public String getNameform() {
        return nameform;
    }

    public void setNameform(String nameform) {
        this.nameform = nameform;
    }

    public String getNametitle() {
        return nametitle;
    }

    public void setNametitle(String nametitle) {
        this.nametitle = nametitle;
    }

    public int getNumColum() {
        return numColum;
    }

    public void setNumColum(int numColum) {
        this.numColum = numColum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
   
   
   
  
}
