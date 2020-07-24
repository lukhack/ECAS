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


import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.TbUiMensajes;
import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Interfaces.genericImp;
import co.com.lk.global.GlobalMaestros;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped 
public class MensajeriaBean implements Serializable { // "implements Serializable" to fix WELD-000072
    @Inject
    private GlobalMaestros glopalConf;
    
    private genericImp dao;
    private TbUiUsuario usuario;
    private TbUiMensajes mensajes;
    private boolean renderTheadMensaje;
    public MensajeriaBean() {
       dao=new genericDAO();
       mensajes = new TbUiMensajes();
    }
    
    @PostConstruct
    public void init(){
        
    }

    public GlobalMaestros getGlopalConf() {
        return glopalConf;
    }

    public void setGlopalConf(GlobalMaestros glopalConf) {
        this.glopalConf = glopalConf;
    }

    public genericImp getDao() {
        return dao;
    }

    public void setDao(genericImp dao) {
        this.dao = dao;
    }

    public TbUiUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUiUsuario usuario) {
        this.usuario = usuario;
    }

    public TbUiMensajes getMensajes() {
        return mensajes;
    }

    public void setMensajes(TbUiMensajes mensajes) {
        this.mensajes = mensajes;
    }

    public boolean isRenderTheadMensaje() {
        return renderTheadMensaje;
    }

    public void setRenderTheadMensaje(boolean renderTheadMensaje) {
        this.renderTheadMensaje = renderTheadMensaje;
    }
    
    

    
    
     
}
