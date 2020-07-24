/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Likas
 * clase de tipo POJO plain olg java object.
 */


@NamedQueries({
    @NamedQuery(name = "IUBitacora.FindALL", query = "SELECT U FROM IUBitacora U "),
})
@Entity
@Table(name = "iubitacora", schema = "maestros")
public class IUBitacora implements  Serializable{
    
    private static final String FINDALL="IUBitacora.FindALL";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    
    
    @Column(name = "Accion")
    private String resulLog;
    
    
    @Column(name = "FechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "IUUsuarioId",nullable = true)
    private TbUiUsuario usuario;
     
    
    public IUBitacora() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    

    public String getResulLog() {
        return resulLog;
    }

    public void setResulLog(String resulLog) {
        this.resulLog = resulLog;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TbUiUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUiUsuario usuario) {
        this.usuario = usuario;
    }
    
    
}
