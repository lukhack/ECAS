/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import co.com.lk.Entity.Master.TbUiUsuario;
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

@Entity
@Table(name = "pa_log")
//query natives

@NamedQueries({
    @NamedQuery(name = "TbLog.FindALL", query = "SELECT U FROM TbLog U ORDER BY U.fecha DESC"),
    @NamedQuery(name = "TbLog.FindById", query = "SELECT U FROM TbLog U WHERE U.id = ?1"),
    @NamedQuery(name = "TbLog.FindByLike", query = "SELECT U FROM TbLog U WHERE U.fecha like ?0 or U.mensaje like ?1 or U.trasaccion like ?2 or U.tbUsuario.Nombre like ?3")

})

//query native
public class TbLog implements  Serializable{  
    private static final String FINDALL="TbLog.FindALL";
    private static final String FINDID="TbLog.FindById";
    private static final String SEARCHREGISTER="TbLog.FindByLike";
    
    
        
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;  
    
    @Column(name = "IDUSER")    
    private Long idusuario;
    
    
    @Column(name = "transaccion")    
    private String trasaccion;
    
    
    @Column(name = "mensaje")    
    private String mensaje;
    
    @Column(name = "fecha")    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "IDUSER",insertable = false,updatable = false,nullable = true)
    private TbUiUsuario tbUsuario; 

    public TbLog() {
    }

    public TbLog(Long idusuario, String trasaccion, String mensaje, Date fecha) {
        this.idusuario = idusuario;
        this.trasaccion = trasaccion;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }
    
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getTrasaccion() {
       if(trasaccion.length()>50)
            return trasaccion.substring(1, 50);
        else
            return trasaccion;
    }

    public void setTrasaccion(String trasaccion) {
        this.trasaccion = trasaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        if(mensaje.length()>80)
            return mensaje.substring(0, 80);
        else
            return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TbUiUsuario getTbUsuario() {
        return tbUsuario;
    }

    public void setTbUsuario(TbUiUsuario tbUsuario) {
        this.tbUsuario = tbUsuario;
    }
    
    
    
    
    
     
    
    
    
}
