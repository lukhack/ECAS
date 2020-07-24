/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.TbUiRol;
import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Interfaces.genericImp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Likas
 */
@Named
@SessionScoped
public class MaDatosMaestroBean  implements  Serializable{
    
    @Inject
    private UsuarioB usuarioB;
    
    
    private int selectDepencia;
    
    private TbUiRol uiRol;
    private List<TbUiRol> uiRols;
   
    private genericImp dao;
    
    private boolean rederMap=true;
    
    @Inject
    private GbMaestrosBean gbMaestros;
    
    public MaDatosMaestroBean() {
        dao = new genericDAO(); 
        uiRol=new TbUiRol();
        uiRols=new ArrayList<>();
    } 
    
    @PostConstruct
    public void init(){
        try{
           uiRols = dao.findAll(uiRol.getClass().getName());
           TbUiUsuario usb= usuarioB.getTbUiUsuario();  
           long rol=2;
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
   
    
    
    public UsuarioB getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
        this.usuarioB = usuarioB;
    }

    public int getSelectDepencia() {
        return selectDepencia;
    }

    public void setSelectDepencia(int selectDepencia) {
        this.selectDepencia = selectDepencia;
    }

    public TbUiRol getUiRol() {
        return uiRol;
    }

    public void setUiRol(TbUiRol uiRol) {
        this.uiRol = uiRol;
    }

    public List<TbUiRol> getUiRols() {
        return uiRols;
    }

    public void setUiRols(List<TbUiRol> uiRols) {
        this.uiRols = uiRols;
    }

    


    public GbMaestrosBean getGbMaestros() {
        return gbMaestros;
    }

    public void setGbMaestros(GbMaestrosBean gbMaestros) {
        this.gbMaestros = gbMaestros;
    }

    public boolean isRederMap() {
        return rederMap;
    }

    public void setRederMap(boolean rederMap) {
        this.rederMap = rederMap;
    }

    

    
    
    
    
 }
