/*
A JSF2 Leaflet wrapper component for OpenStreetMap
Copyright (C) 2015 Leonardo Ciocari

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.*/

package co.com.lk.Bean;


import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped 
public class EmailBean implements Serializable { // "implements Serializable" to fix WELD-000072
    private String destinatarios;
    private String asunto;
    private String imagen;
    private String mensaje;
            
    public EmailBean() {
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
     
}
