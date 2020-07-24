
package co.com.lk.Bean;

import co.com.lk.Bean.Controller.BitacoraController;
import co.com.lk.Bean.dt.DtECASucursalController;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.DAO.UsuariosDAO;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.TbLog;
import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Interfaces.genericImp;
import co.com.lk.helper.Sha1;
import co.com.lk.helper.facesMenssage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import net.arnx.wmf2svg.util.Base64;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;
//import org.primefaces.PrimeFaces;

/**
 *
 * @author Likas
 */
@Named
@ViewScoped
public class LoginB implements Serializable{
    
    @Inject
    private UsuarioB usuarioB;
    
    @Inject
    private DtECASucursalController sucursal;
    
    @Produces   
    private ResourceBundle config;
    
    private String usuario;
    private String pass;
    private genericImp classGeneric;
    private TbLog log;
    protected FacesContext visionContext = null; 
    public LoginB() {
        classGeneric = new genericDAO();
        log=new TbLog();                                                                                                                              
        
    }
    
    
    
    @PostConstruct
    private void init(){
         try {
            //addMessage("Welcome to Primefaces!!");
            //urlSelectMaestros=select;
            if(verificarLogin()){
               FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            }   
            
        } catch (IOException ex) {
            Logger.getLogger(LogB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   private boolean verificarLogin(){
        try{
            TbUiUsuario s=(TbUiUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
                
            if(s.getLogin()!=null){
                return true;
            }
             
            return false;
        }catch(NullPointerException e){
            return false;
        }
   } 
   public String consultar(){
       try{
            //FacesContext.getCurrentInstance().getExternalContext().redirect("Inicio.xhtml");
           
           // boolean error = Boolean.FALSE;
           
           UsuariosDAO usuariosDAO= new UsuariosDAO();
           
           
            TbUiUsuario usuarioSystem= (TbUiUsuario) usuariosDAO.findByIdLogin(usuarioB.getTbUiUsuario());    
            if(usuarioSystem!=null){
                if(usuarioSystem.getUsuario().equals(usuarioB.getTbUiUsuario().getUsuario())  && usuarioSystem.getPassword().equals(Sha1.crypt(usuarioB.getTbUiUsuario().getPassword()))){
                    
                    
                    Calendar date = Calendar.getInstance();

                    String fecha=String.valueOf(date.get(Calendar.DATE));
                    usuarioSystem.setLogin(Base64.encode((usuario+fecha+pass).getBytes()));

                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", usuarioSystem);
                    usuarioB.setTbUiUsuario(usuarioSystem);
                    
                    BitacoraController.saveBitacora(usuarioSystem, "Ingreso al sistema");
                    showMensaje(2,"Ok","Inicio de sessión 3, OK");
                    //LogB.saveLog(usuarioSystem.getId(),"Autenticación Correcta" , "Ingreso al sistema", new Date());
                    return "Inicio?faces-redirect=true";
                }else {
                    BitacoraController.saveBitacora(null, "Ingreso fallido al sistema "+usuario);
                  // LogB.saveLog(1L,"Autenticación Error" , "Error en los datos de autenticación user:"+usuarioB.getTbUiUsuario().getUsuario()+" pass:"+usuarioB.getTbUiUsuario().getPassword(), new Date());
                   facesMenssage.addMensaje(1,"Usuario o contraseña no validos","");
                   return "login";
                }
            }else{
                BitacoraController.saveBitacora(null, "Ingreso fallido al sistema "+usuario);
                facesMenssage.addMensaje(1,"El usuario no existe en la base de datos","");
                //LogB.saveLog(1L,"Error Autenticación" , "El usuario no existe: "+usuarioB.getTbUiUsuario().getUsuario()+" pass: "+usuarioB.getTbUiUsuario().getPassword(), new Date());
                return "login";
            }
        }catch(Exception ex){
           ex.printStackTrace();
             facesMenssage.addMensaje(1,ex.getMessage(),"");
         return "login";
       }
        
   }
  
   
   /*
   *Muestra los mensajes en el grow
   */
   private void showMensaje(int type, String title,String mensaje){
       FacesMessage.Severity typeMensaje=FacesMessage.SEVERITY_INFO;
       
       /*
       1:Failed
       2:Successful
       */
       switch(type){
           case 1:
               typeMensaje=FacesMessage.SEVERITY_ERROR;
               break;
           case 2:
               typeMensaje=FacesMessage.SEVERITY_INFO;
               break;
       }
       
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage(typeMensaje, title,mensaje));
   }

   

   

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    
    public String urladmon(){   
     
        // addMessage("hola mundo");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("admon.xhtml");
        //PrimeFaces.current().ajax().update("formapp");
        RequestContext.getCurrentInstance().update("formapp");
        //RequestContext context = RequestContext.getCurrentInstance();
        //PrimeFaces.current().ajax().addCallbackParam("view", "Inicio.xhtml");
        RequestContext.getCurrentInstance().addCallbackParam("view", "Inicio.xhtml"); 
        //context.addCallbackParam("view", "admon.xhtml");
        return "Inicio.xhtml";
       
    }
    
     public String urllogin(){   
        BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(), "Usuario cerro session");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "Login";
    }
    
    
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);    
    }
     
     public void logout(){
        BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(), "Usuario cerro session");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
     }

    public UsuarioB getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
        this.usuarioB = usuarioB;
    }

    public ResourceBundle getConfig() {
        return config;
    }

    public void setConfig(ResourceBundle config) {
        this.config = config;
    }
     
     
}
