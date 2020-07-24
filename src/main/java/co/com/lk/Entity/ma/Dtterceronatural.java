/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.ma;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtterceronatural", schema = "maestrosapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtterceronatural.findAll", query = "SELECT d FROM Dtterceronatural d"),
    @NamedQuery(name = "Dtterceronatural.findByDtterceroId", query = "SELECT d FROM Dtterceronatural d WHERE d.id = :id"),
    @NamedQuery(name = "Dtterceronatural.findByNombres", query = "SELECT d FROM Dtterceronatural d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "Dtterceronatural.findByApellidos", query = "SELECT d FROM Dtterceronatural d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "Dtterceronatural.findByFechaNacimiento", query = "SELECT d FROM Dtterceronatural d WHERE d.fechaNacimiento = :fechaNacimiento")})
public class Dtterceronatural implements Serializable {

    
    private static final String FINDALL="Dtterceronatural.findAll";
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "Nombres")
    private String nombres;
    @Size(max = 100)
    @Column(name = "Apellidos")
    private String apellidos;
    
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @JoinColumn(name = "dtmacondicionsocial_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmacondicionsocial dtmacondicionsocialId;
    
    @JoinColumn(name = "dtmaestadocivil_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmaestadocivil dtmaestadocivilId;
    
    @JoinColumn(name = "dtmaestrato_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmaestrato dtmaestratoId;
    
    @JoinColumn(name = "uiacondicionreciclador_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmacondiciontercero dtmacondicionrecicladorId;
    
    @JoinColumn(name = "dttipotercero", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY) 
    private Dttercerotipo dttercerotipo;
    
    @JoinColumn(name = "dttercero_id", nullable = false,unique = true)
    @OneToOne(optional = false)
    private Dttercero dttercero;

    public Dtterceronatural() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Dtmacondicionsocial getDtmacondicionsocialId() {
        return dtmacondicionsocialId;
    }

    public void setDtmacondicionsocialId(Dtmacondicionsocial dtmacondicionsocialId) {
        this.dtmacondicionsocialId = dtmacondicionsocialId;
    }

    public Dtmaestadocivil getDtmaestadocivilId() {
        return dtmaestadocivilId;
    }

    public void setDtmaestadocivilId(Dtmaestadocivil dtmaestadocivilId) {
        this.dtmaestadocivilId = dtmaestadocivilId;
    }

    public Dtmaestrato getDtmaestratoId() {
        return dtmaestratoId;
    }

    public void setDtmaestratoId(Dtmaestrato dtmaestratoId) {
        this.dtmaestratoId = dtmaestratoId;
    }

    public Dttercero getDttercero() {
        return dttercero;
    }

    public void setDttercero(Dttercero dttercero) {
        this.dttercero = dttercero;
    }

    public Dtmacondiciontercero getDtmacondicionrecicladorId() {
        return dtmacondicionrecicladorId;
    }

    public void setDtmacondicionrecicladorId(Dtmacondiciontercero dtmacondicionrecicladorId) {
        this.dtmacondicionrecicladorId = dtmacondicionrecicladorId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dtterceronatural other = (Dtterceronatural) obj;
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

   

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtterceronatural[ dtterceroId=" + id + " ]";
    }

   

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Dttercerotipo getDttercerotipo() {
        return dttercerotipo;
    }

    public void setDttercerotipo(Dttercerotipo dttercerotipo) {
        this.dttercerotipo = dttercerotipo;
    }

    
    
}
