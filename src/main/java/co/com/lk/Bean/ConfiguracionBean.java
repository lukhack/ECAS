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


import co.com.lk.Bean.application.GlopalConf;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Interfaces.genericImp;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ConfiguracionBean implements Serializable { // "implements Serializable" to fix WELD-000072
    @Inject
    private GlopalConf glopalConf;
    
    private genericImp dao;

    public ConfiguracionBean() {
       dao=new genericDAO();
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    

    public genericImp getDao() {
        return dao;
    }

    public void setDao(genericImp dao) {
        this.dao = dao;
    }

    public GlopalConf getGlopalConf() {
        return glopalConf;
    }

    public void setGlopalConf(GlopalConf glopalConf) {
        this.glopalConf = glopalConf;
    }

    
    
     
}
