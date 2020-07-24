/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import co.com.lk.Entity.Master.UiMaEstadoTarea;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Likas
 * clase de tipo POJO plain olg java object.
 */



@NamedQueries({
    @NamedQuery(name = "TbUiMensajes.FindALL", query = "SELECT U FROM TbUiMensajes U "),
    @NamedQuery(name = "TbUiMensajes.FindById", query = "SELECT U FROM TbUiMensajes U WHERE U.id = ?1"),
    @NamedQuery(name = "TbUiMensajes.FindByMensUsuario", query = "SELECT U FROM TbUiMensajes U WHERE U.uisuario_rec.Id = ?1 and U.leido=false"),
    @NamedQuery(name = "TbUiMensajes.FindByMensUsuarioEmi", query = "SELECT U FROM TbUiMensajes U WHERE ((U.uisuario_rec.Id = ?0 and U.uisuario_emi.Id=?1) or (U.uisuario_rec.Id = ?2 and U.uisuario_emi.Id=?3))")
})
@Entity
@Table(name = "iumensajes", schema = "maestros")
public class TbUiMensajes implements  Serializable{
        
    private static final String FINDALL="TbUiMensajes.FindALL";
    private static final String FINDID="TbUiMensajes.FindById";
    private static final String FINDIDMENSAJE="TbUiMensajes.FindByMensUsuario";
    private static final String FINDIDMENSAJES="TbUiMensajes.FindByMensUsuarioEmi";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    @Column(name = "mensaje")
    private String mensaje;
    
    
    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "fechaLeido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLeido;
    
    @Column(name = "leido")
    private boolean leido;      
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UiUsuario_emisor",referencedColumnName = "Id")
    private TbUiUsuario uisuario_emi;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UiUsuario_recep",referencedColumnName = "Id")
    private TbUiUsuario uisuario_rec;
    
    
    
    public TbUiMensajes() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TbUiUsuario getUisuario_emi() {
        return uisuario_emi;
    }

    public void setUisuario_emi(TbUiUsuario uisuario_emi) {
        this.uisuario_emi = uisuario_emi;
    }

    public TbUiUsuario getUisuario_rec() {
        return uisuario_rec;
    }

    public void setUisuario_rec(TbUiUsuario uisuario_rec) {
        this.uisuario_rec = uisuario_rec;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Date getFechaLeido() {
        return fechaLeido;
    }

    public void setFechaLeido(Date fechaLeido) {
        this.fechaLeido = fechaLeido;
    }
    
    
    
    
    
}
