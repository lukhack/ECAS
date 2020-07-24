/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.session;

import co.com.lk.Entity.Master.TbUiModulo;
import co.com.lk.global.GlobalMenu;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author julig
 */
@Named
@SessionScoped
public class MenuSession implements  Serializable{
    private MenuModel menu;
    
    @Inject
    private UsuarioB usuarioB;   
    
    
    @Inject
    private GlobalMenu globalMenu;    
    
    
    public MenuSession() {
         menu=new DefaultMenuModel();
    }
    
    @PostConstruct
    private void init(){
        try {
            crearMenu();
        } catch (Exception ex) {
            
        }
    }
    
    
    private void crearMenu() {
        try{
        
        List<TbUiModulo> modulos=Objects.equals(usuarioB.getTbUiUsuario().getUiRol().getId(),Long.valueOf(1))?globalMenu.getModulos():usuarioB.getTbUiUsuario().getMaModulos();
        modulos.stream().forEach(x->{
            if(x.getActivo()){
                if(Objects.equals(x.getParent(),0L) && x.getActivo()  && globalMenu.getModulos().stream().filter(r->Objects.equals(x.getId(), r.getParent())).count()==0){
                     menu.addElement(menuItemCreate(x));
                }else if(Objects.equals(x.getParent(),0L)  && globalMenu.getModulos().stream().filter(r->Objects.equals(x.getId(), r.getParent())).count()>0){
                    menu.addElement(Stream(x,new DefaultSubMenu(x.getNomModulo(),x.getIcon()),modulos));
                }
            }
        });
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private DefaultSubMenu Stream(TbUiModulo mod, DefaultSubMenu subMenu,List<TbUiModulo> modulos){
        if(mod.getActivo()){
        if(modulos.stream().filter(r->Objects.equals(mod.getId(), r.getParent())).count()>0){ 
             modulos.stream().filter(x->Objects.equals(mod.getId(), x.getParent())).forEach(x->{
                 if(x.getActivo() ){
                     if(modulos.stream().filter(r->Objects.equals(x.getId(), r.getParent())).count()>0)
                        subMenu.addElement(Stream(x,new DefaultSubMenu(x.getNomModulo(),x.getIcon()),modulos));
                     else
                         subMenu.addElement(menuItemCreate(x));
                }
             });
         }else{

                 subMenu.addElement(menuItemCreate(mod));
         }
       }
       return subMenu;
   }

    private DefaultMenuItem menuItemCreate(TbUiModulo mod){
        DefaultMenuItem item = new DefaultMenuItem(mod.getNomModulo());
            if(mod.getActionListen()){
                 item.setCommand("#{uiNavegacionBean.sendPage(\""+mod.getUrl()+"\",\""+mod.getItem()+"\",\""+mod.getNomModulo()+"\")}");
            }else{
                 item.setOutcome(mod.getUrl());
            }
            
            item.setGlobal(false);
            item.setAjax(false);
            item.setProcess("@this");
            item.setPartialSubmit(true);
            item.setIcon(mod.getIcon());
            item.setIgnoreAutoUpdate(true);
            item.setIncludeViewParams(true);
            item.setImmediate(true);
            
            if(Objects.nonNull(mod.getMapParameters()))
            mod.getMapParameters().entrySet().stream().forEach(k->{
                item.setParam(k.getKey(), k.getValue());
            });
        return item;
    }
    
    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    public GlobalMenu getGlobalMenu() {
        return globalMenu;
    }

    public void setGlobalMenu(GlobalMenu globalMenu) {
        this.globalMenu = globalMenu;
    }

    public UsuarioB getUsuarioB() {
       return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
       this.usuarioB = usuarioB;
    }
    
    
   
}
