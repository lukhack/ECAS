/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.Bean.Controller.BitacoraController;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Interfaces.genericImp;
import co.com.lk.global.GlobalMaestros;
import co.com.lk.helper.Sha1;
import co.com.lk.helper.castFileBase64;
import co.com.lk.helper.facesMenssage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.component.selectbooleanbutton.SelectBooleanButton;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Likas
 */
@Named
@ViewScoped
public class UiAcount implements Serializable  {
    
    @Inject
    private UsuarioB usuarioB;
    
    
    @Inject
    private GlobalMaestros globalMaestros;
    
    private UploadedFile file;
    
    private String contrasena;
    
    private Boolean changePassword;
    private genericImp classGeneric;
    
    public UiAcount() {
        classGeneric = new genericDAO(); 
    } 
    
    
    public void saveUsuario(){
        try {
            verificarUsuario();
            if(!changePassword){
                String usuario=String.valueOf(usuarioB.getTbUiUsuario().getUsuario());
                String nombre=String.valueOf(usuarioB.getTbUiUsuario().getNombre());
                String correo=String.valueOf(usuarioB.getTbUiUsuario().getCorreo());
                String theme=String.valueOf(usuarioB.getTbUiUsuario().getTheme());
                String layout=String.valueOf(usuarioB.getTbUiUsuario().getLayout());
                boolean vertical=usuarioB.getTbUiUsuario().getVerticalMenu();
                
                int total=classGeneric.execSQLQUERYupdate(usuarioB.getTbUiUsuario().getClass().getName(),"UPDATEUSUARIO",nombre,usuario,correo,usuarioB.getTbUiUsuario().getAvatar(),theme,vertical,layout,usuarioB.getTbUiUsuario().getId());
                BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(), "Se actualiza los datos sin contraseña Usuario");
             
            }else{
                usuarioB.getTbUiUsuario().setPassword(Sha1.crypt(usuarioB.getTbUiUsuario().getPass1()));
                classGeneric.saveorUpdate(usuarioB.getTbUiUsuario(), 1L);
                BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(), "Se actualiza los datos sin contraseña Usuario");
             
            }
            globalMaestros.getUsuarios().replaceAll(s -> Objects.equals(s.getId(),usuarioB.getTbUiUsuario().getId())? usuarioB.getTbUiUsuario():s);
            facesMenssage.addMensaje(2, "Ok,Datos actulizados correctamente","");
        } catch (Exception ex) {
            BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(), "Error actualizando los datos de autenticación");
            facesMenssage.addMensaje(1, "Error,"+ex.getMessage(),"");
        }
    }
    
    
    private void verificarUsuario() throws Exception{
        
        
        if(usuarioB.getTbUiUsuario().getUsuario().equals(""))
            throw  new Exception("Debes Ingresar un valor en el nombre de usuario");
        
        
        if(changePassword){
            if(usuarioB.getTbUiUsuario().getPassword().equals(""))
                throw  new Exception("Debes Ingresar un valor en la clave");

            if(usuarioB.getTbUiUsuario().getPass1().equals(""))
                throw  new Exception("Debes confirmar la contraseña");


            if(!usuarioB.getTbUiUsuario().getPass2().equals(usuarioB.getTbUiUsuario().getPass1()))
                throw  new Exception("La confirmación de la clave deve ser igual al valor de la clave asignada");
        }
        
      }
    
    public void changePasswordListen(AjaxBehaviorEvent event){
        Boolean select = (Boolean)((SelectBooleanButton) event.getSource()).getValue();
        System.out.println("co.com.lk.Bean.Ui.UiAcount.changePasswordListen() "+select);
    }
     public void handleFileUpload(FileUploadEvent event) {
        try {
            String b64file=castFileBase64.base64file(event.getFile());
            usuarioB.getTbUiUsuario().setAvatar("data:image/png;base64,"+b64file);
            System.err.println("img:"+usuarioB.getTbUiUsuario().getAvatar());
        } catch (IOException ex) {
            Logger.getLogger(UiAcount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UsuarioB getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
        this.usuarioB = usuarioB;
    }

    public Boolean getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(Boolean changePassword) {
        this.changePassword = changePassword;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public GlobalMaestros getGlobalMaestros() {
        return globalMaestros;
    }

    public void setGlobalMaestros(GlobalMaestros globalMaestros) {
        this.globalMaestros = globalMaestros;
    }
    
    
 }
