/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.EmailBean;
import co.com.lk.helper.SendMail;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.util.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Likas
 */
@Named
@ViewScoped
public class EmailController  implements  Serializable{
    
    @Inject
    private EmailBean emailBean;
    
    
    
    private  ResourceBundle poperties;
             
     StringBuilder st;
    public EmailController() {
       st=new StringBuilder();
       
    } 
    
    
    public void sendMail(){
        try {
            SendMail mail=new SendMail();
            
            String imagen = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("img");
            
           emailBean.setImagen(imagen);
            
            send();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(EmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void send() throws Exception {
        String host = poperties.getString("SMTP.HOST");
        String usuario=poperties.getString("SMTP.EMAILUSUARIO");
        String pass=poperties.getString("SMTP.EMAILPASSWORD");
        String from= poperties.getString("SMTP.FROM");
        String port=poperties.getString("SMTP.PORT");
        String copyto = poperties.getString("EMAIL.COPYTO");
        String linkLogo = poperties.getString("LOGO");
        String logo="<img width='200' src='"+linkLogo+"' alt='Proveedores Vid'/>";
        StringBuilder html= new StringBuilder();
        html.append(logo);
        html.append("<h2>Mapa Confecamaras</h2>");
        html.append("<hr style='background-color:#A90083;border: #A90083 1px solid;'/>");
        html.append("<br/>");
        html.append(emailBean.getMensaje());
        
         
        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setSmtpPort(Integer.valueOf(port));
        email.setStartTLSEnabled(true);
        email.setAuthenticator(new DefaultAuthenticator(usuario, pass));
        
        String[] correos= emailBean.getDestinatarios().split(",");
        Arrays.stream(correos).forEach(x-> {try {
            email.addTo(x);
            } catch (EmailException ex) {
                Logger.getLogger(EmailController.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        
        
        email.addCc(copyto);
        email.setFrom(from);
         byte[] qrImageBytes = java.util.Base64.getDecoder().decode(emailBean.getImagen().replace("data:image/png;base64,", "")); // get your image byte array
        ByteArrayDataSource qrImageDataSource = new ByteArrayDataSource(qrImageBytes, "image/png");
        String contentid=  email.embed(qrImageDataSource,"Mapa.png");
        email.setSubject(emailBean.getAsunto());
        String img= "<img src='cid: "+contentid+"'>";
        email.setHtmlMsg(html.toString()+img);
        email.send();
        /**/
        System.out.println("Email Sent successfully 2....");
    
    }

   
    
    
    
    
    public EmailBean getEmailBean() {
        return emailBean;
    }

    public void setEmailBean(EmailBean emailBean) {
        this.emailBean = emailBean;
    }

    public ResourceBundle getPoperties() {
        return poperties;
    }

    public void setPoperties(ResourceBundle poperties) {
        this.poperties = poperties;
    }

   
    
    
   
    
   
    
    
    
 }
