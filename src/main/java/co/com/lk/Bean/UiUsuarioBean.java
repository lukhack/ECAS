/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.Bean.Controller.Master.MaPropertiesBungleManager;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.TbUiModulo;
import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Interfaces.genericImp;
import co.com.lk.global.GlobalMenu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.TreeNode;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class UiUsuarioBean implements  Serializable{
    TbUiUsuario uiUsuario;
   
    genericImp dao;
    List<TbUiUsuario> filterUiUsuario;
    List<TbUiUsuario> uiUsuarios;    
    private List<TbUiModulo> modulos;
    private TbUiModulo modulo;
    
    int nivel=0;
    
    int process;
    
    boolean changePasswordListen;
    
    @Inject
    private MaDatosMaestroBean maDatosMaestroBean;   
    
    
    @Inject
    private GlobalMenu globalMenu;   
    
    @Inject
    MaPropertiesBungleManager bungleManager;
    
    
    private TreeNode root;
    private TreeNode[] selectedNodes;
     
    
    public UiUsuarioBean() {
        dao = new genericDAO(); 
        uiUsuario = new TbUiUsuario();
        modulos = new ArrayList<>();
        modulo=new TbUiModulo();
    }
    
    
    
    
    @PostConstruct
    private void init(){
        try {
            uiUsuarios = dao.findAll(uiUsuario.getClass().getName());
            
        } catch (Exception ex) {
            
        }
    }

    public TbUiUsuario getUiUsuario() {
        return uiUsuario;
    }

    public void setUiUsuario(TbUiUsuario uiUsuario) {
        this.uiUsuario = uiUsuario;
    }

    public genericImp getDao() {
        return dao;
    }

    public void setDao(genericImp dao) {
        this.dao = dao;
    }

    public List<TbUiUsuario> getFilterUiUsuario() {
        return filterUiUsuario;
    }

    public void setFilterUiUsuario(List<TbUiUsuario> filterUiUsuario) {
        this.filterUiUsuario = filterUiUsuario;
    }

    public List<TbUiUsuario> getUiUsuarios() {
        return uiUsuarios;
    }

    public void setUiUsuarios(List<TbUiUsuario> uiUsuarios) {
        this.uiUsuarios = uiUsuarios;
    }

    public MaDatosMaestroBean getMaDatosMaestroBean() {
        return maDatosMaestroBean;
    }

    public void setMaDatosMaestroBean(MaDatosMaestroBean maDatosMaestroBean) {
        this.maDatosMaestroBean = maDatosMaestroBean;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public MaPropertiesBungleManager getBungleManager() {
        return bungleManager;
    }

    public void setBungleManager(MaPropertiesBungleManager bungleManager) {
        this.bungleManager = bungleManager;
    }

    

    public boolean getChangePasswordListen() {
        return changePasswordListen;
    }

    public void setChangePasswordListen(boolean changePasswordListen) {
        this.changePasswordListen = changePasswordListen;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public List<TbUiModulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<TbUiModulo> modulos) {
        this.modulos = modulos;
    }

    public TbUiModulo getModulo() {
        return modulo;
    }

    public void setModulo(TbUiModulo modulo) {
        this.modulo = modulo;
    }

   

    
    
    

    public GlobalMenu getGlobalMenu() {
        return globalMenu;
    }

    public void setGlobalMenu(GlobalMenu globalMenu) {
        this.globalMenu = globalMenu;
    }

    

   
    
    
    
    
    
    
}
