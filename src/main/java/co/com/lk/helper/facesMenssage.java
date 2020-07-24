/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Likas
 */
public final class facesMenssage {
    private facesMenssage(){
    }
    
    public static void addMensaje(int type, String title,String mensaje){
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
            case 3:
               typeMensaje=FacesMessage.SEVERITY_FATAL;
               break;
       }
       
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage(typeMensaje, title,mensaje));
   }
}
