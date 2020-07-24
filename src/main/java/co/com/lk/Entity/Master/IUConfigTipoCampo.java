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
    @NamedQuery(name = "IUConfigTipoCampo.FindALL", query = "SELECT U FROM IUConfigTipoCampo U "),
})
@Entity
@Table(name = "uiconfigtipocampo", schema = "maestros")
public class IUConfigTipoCampo implements  Serializable{
    
    private static final String FINDALL="IUConfigTipoCampo.FindALL";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    @Column(name = "tipoCampo")
    private String tipoCampo;
    
   @OneToMany(mappedBy = "tipoCampo")
   private List<IUConfigForm> config;

    public IUConfigTipoCampo() {
    }
   
   
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    

    public List<IUConfigForm> getConfig() {
        return config;
    }

    public void setConfig(List<IUConfigForm> config) {
        this.config = config;
    }

    
   
   
  
}
