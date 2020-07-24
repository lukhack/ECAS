/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Likas
 * clase de tipo POJO plain olg java object.
 */


@NamedQueries({
    @NamedQuery(name = "UiMaEstadoTarea.FindALL", query = "SELECT U FROM UiMaEstadoTarea U "),
})
@Entity
@Table(name = "uimaestadotarea", schema = "maestrosapp")
public class UiMaEstadoTarea implements  Serializable{
    
    private static final String FINDALL="UiMaEstadoTarea.FindALL";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    @Column(name = "descripcion")
    private String tipo;
    
    

    public UiMaEstadoTarea() {
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

}
