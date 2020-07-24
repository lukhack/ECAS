/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.helper;


import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Likas
 */
@ManagedBean
@RequestScoped
public class SendMail {
  
    @ManagedProperty("#{config}")
    private  ResourceBundle poperties;
    
    private String asunto;
    private String mensaje;
    private String destinatarios;
    
    
    private String usuario;
    private String password;
    private String host;
    private String from;
    private String copyTo;
    private String port;
    
    public SendMail() {
       
    }
        
  
    
  
    public void send() throws Exception {
        try{ 
        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setSmtpPort(Integer.valueOf(port));
        email.setStartTLSEnabled(true);
        email.setAuthenticator(new DefaultAuthenticator(usuario, password));
        
        
            String des[] =destinatarios.split(";");
            for(String ds:des){
                try {
                    email.addTo(ds.replace(" ",""));
                } catch (EmailException ex) {
                    ex.printStackTrace();
                }
            }    
       
        if(copyTo!=null){
        String copy[] =copyTo.split(";");
        for(String ds:copy){
                try {
                    email.addCc(ds.replace(" ",""));
                } catch (EmailException ex) {
                    ex.printStackTrace();
                }
            }    
        }
       
       
        email.setFrom(from);
        email.setCharset("utf-8");
        email.setSubject(asunto);
        email.setHtmlMsg(mensaje);
         System.out.println("Email Sent successfully 1....");
        email.send();
 
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    
    }

   /* public  void sendFormulario() throws Exception{
        String linkLogo;
       
        linkLogo = poperties.getString("LOGO");
        
        String logo="<img src='"+linkLogo+"' alt='Proveedores Vid'/>";
        
        StringBuilder html= new StringBuilder();
        
        html.append("<br/>");
        html.append("<h2>Mapas</h2>");
        html.append("<hr style='background-color:#A90083;border: #A90083 1px solid;'/>");
        html.append(logo);
        
       
         this.send();
   }*/

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }
    
    
   

    public ResourceBundle getPoperties() {
        return poperties;
    }

    public void setPoperties(ResourceBundle poperties) {
        this.poperties = poperties;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCopyTo() {
        return copyTo;
    }

    public void setCopyTo(String copyTo) {
        this.copyTo = copyTo;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

   
   
    
}