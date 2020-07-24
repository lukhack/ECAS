/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.global;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.UiMaEstadoTarea;
import co.com.lk.Entity.Master.TbUiUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class GlobalMaestros  implements Serializable{
    
    private List<UiMaEstadoTarea> estadosTarea;
    private List<TbUiUsuario> usuarios;

    public GlobalMaestros() {
        estadosTarea=new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        try {
            estadosTarea= new genericDAO().findAll(new UiMaEstadoTarea().getClass().getName());
            usuarios=new genericDAO().findAll(new TbUiUsuario().getClass().getName());
        } catch (Exception ex) {
            Logger.getLogger(GlobalMaestros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TbUiUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TbUiUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<UiMaEstadoTarea> getEstadosTarea() {
        return estadosTarea;
    }

    public void setEstadosTarea(List<UiMaEstadoTarea> estadosTarea) {
        this.estadosTarea = estadosTarea;
    }

    public List<TbUiUsuario> getUsuarios(TbUiUsuario usuario) {
        return usuarios.stream().filter(x->!Objects.equals(x.getId(),usuario.getId())).collect(Collectors.toList());
    }
    
}
