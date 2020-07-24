/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import co.com.lk.Entity.Dtrespuestaform;
import co.com.lk.Entity.ma.Dteca;
import co.com.lk.Entity.ma.Dtecassucursal;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Likas
 * clase de tipo POJO plain olg java object.
 */


@NamedQueries({
    @NamedQuery(name = "TbUiUsuario.FindALL", query = "SELECT U FROM TbUiUsuario U "),
    @NamedQuery(name = "TbUiUsuario.FindById", query = "SELECT U FROM TbUiUsuario U WHERE U.id = ?1"),
    @NamedQuery(name = "TbUiUsuario.Login", query =   "SELECT U FROM TbUiUsuario U where U.Usuario = ?0 and U.Password = ?1"),
    @NamedQuery(name = "TbUiUsuario.CONSULTARUSUARIO", query =   "SELECT U FROM TbUiUsuario U where U.Usuario = ?1 "),
    @NamedQuery(name = "TbUiUsuario.TbUiUsuario", query = "UPDATE TbUiUsuario U set U.Nombre = ?0, U.Usuario = ?1, U.correo = ?2, U.avatar=?3, U.theme=?4, U.verticalMenu=?5,U.layout=?6 WHERE U.Id = ?7"),  
    
})
@NamedNativeQueries({
    @NamedNativeQuery(name="TbUiUsuario.DELETEUSUARIOMODULO", query="Delete from maestros.UiUsuarioModulo WHERE UiUsuario_id = ?1"),
    @NamedNativeQuery(name="TbUiUsuario.INSERTUSUARIOMODULO", query="INSERT INTO maestros.UiUsuarioModulo VALUES(?1,?2)")
})
@Entity
@Table(name = "uiusuario", schema = "maestros")
public class TbUiUsuario implements  Serializable{
    
    public static final String LOGIN_USER="TbUiUsuario.Login";    
    private static final String FINDALL="TbUiUsuario.FindALL";
    private static final String FINDID="TbUiUsuario.FindById";
    private static final String CONSULTARUSUARIO="TbUiUsuario.CONSULTARUSUARIO";
    private static final String UPDATEUSUARIO="TbUiUsuario.TbUiUsuario";
    private static final String DELETEUSUARIOMODULO="TbUiUsuario.DELETEUSUARIOMODULO";
    private static final String INSERTUSUARIOMODULO="TbUiUsuario.INSERTUSUARIOMODULO";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    @Column(name = "nombre") 
    private String Nombre;
    
    @Column(name = "usuario") 
    private String Usuario;
    
    
    @Column(name = "pass") 
    private String Password;     
    
    
    @Column(name = "estado")
    private Boolean Estado=true;
    
    
    @Column(name = "avatar",nullable = true)
    private String avatar;
    
    
    @Column(name = "theme",nullable = true)
    private String theme;
    
    
    @Column(name = "layout",nullable = true)
    private String layout;
    
    
    @Column(name = "verticalMenu")
    private Boolean verticalMenu;
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UiRol_id")
    private TbUiRol uiRol;
    
    
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    
    
    
    
    @OneToMany(mappedBy = "usuario")
    private Collection<Dtrespuestaform> dtrespuestaformCollection;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UiUsuarioModulo", schema = "maestros",
            joinColumns = {@JoinColumn(name="UiUsuario_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="UiModulo_id", referencedColumnName="id")})
    private List<TbUiModulo> maModulos;
    
   
    @JoinTable(name = "uiusuarioecasucursal", schema = "maestros",
        joinColumns = {@JoinColumn(name = "usuario_id", referencedColumnName = "id")}, 
        inverseJoinColumns = {@JoinColumn(name = "ecasucursal_id", referencedColumnName = "id")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Dtecassucursal dtecassucursal;
    
    
    
    @JoinTable(name = "uiusuarioecas", schema = "maestros",
        joinColumns = {@JoinColumn(name = "usuario_id", referencedColumnName = "id")}, 
        inverseJoinColumns = {@JoinColumn(name = "ecas_id", referencedColumnName = "id")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Dteca dtEcaPadre;
    
    
    @Transient
    private String pass1;
    
    @Transient
    private String pass2;
     
    @Transient
    private String login;

    
    public TbUiUsuario() {
    }

    public TbUiUsuario(Long Id) {
        this.Id = Id;
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }


    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    public TbUiRol getUiRol() {
        return uiRol;
    }

    public void setUiRol(TbUiRol uiRol) {
        this.uiRol = uiRol;
    }

    

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

   

    public List<TbUiModulo> getMaModulos() {
        return maModulos;
    }

    public void setMaModulos(List<TbUiModulo> maModulos) {
        this.maModulos = maModulos;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        System.err.println("pase por equeal");
        if (!(object instanceof TbUiUsuario)) {
            System.err.println("pase por equeal 1");
            return false;
        }
        TbUiUsuario other = (TbUiUsuario) object;
        boolean lreturn=!((this.Id == null && other.getId() != null) || (this.Id != null && !(Objects.equals(this.Id, other.getId()))));
        return lreturn;
    }


    public Boolean getVerticalMenu() {
        return verticalMenu;
    }

    public void setVerticalMenu(Boolean verticalMenu) {
        this.verticalMenu = verticalMenu;
    }
/*
    @XmlTransient
    
    public Collection<Uitercero> getUiterceroCollection() {
        return uiterceroCollection;
    }

    public void setUiterceroCollection(Collection<Uitercero> uiterceroCollection) {
        this.uiterceroCollection = uiterceroCollection;
    }

   */

    @XmlTransient
    public Collection<Dtrespuestaform> getDtrespuestaformCollection() {
        return dtrespuestaformCollection;
    }

    public void setDtrespuestaformCollection(Collection<Dtrespuestaform> dtrespuestaformCollection) {
        this.dtrespuestaformCollection = dtrespuestaformCollection;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Dtecassucursal getDtecassucursal() {
        return dtecassucursal;
    }

    public void setDtecassucursal(Dtecassucursal dtecassucursal) {
        this.dtecassucursal = dtecassucursal;
    }


    public Dteca getDtEcaPadre() {
        return dtEcaPadre;
    }

    public void setDtEcaPadre(Dteca dtEcaPadre) {
        this.dtEcaPadre = dtEcaPadre;
    }

    
    
    
}
