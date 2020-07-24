/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.MaDatosMaestroBean;
import co.com.lk.Bean.UiNavegacionBean;
import co.com.lk.Bean.UiUsuarioBean;
import co.com.lk.Entity.Master.TbUiModulo;
import co.com.lk.Entity.Master.TbUiRol;
import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.helper.Sha1;
import co.com.lk.helper.facesMenssage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.primefaces.PrimeFaces;
//import org.primefaces.PrimeFaces;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Likas
 */
@Named
@ViewScoped
public class UiUsuarioController  implements  Serializable{
    
    @Inject
    private UiUsuarioBean usuarioBean;
    
    @Inject
    private MaDatosMaestroBean maDatosMaestroBean;   
    
    
    public UiUsuarioController() {  
    } 
    
    
    @Inject
    private UiNavegacionBean nav;
    
    public String editUser(TbUiUsuario usuario){
        usuarioBean.setUiUsuario(usuario);
        System.err.println("print ln:"+usuarioBean.getUiUsuario().getNombre());
       return nav.sendPage("Admon", "navegacion/Usuarios/usuario.xhtml", "Perfil de Usuario");
    }
    
    
    public void nuevo(Object object){
        try {
           if(object instanceof TbUiUsuario){ 
           usuarioBean.setUiUsuario(new TbUiUsuario());
           usuarioBean.getUiUsuario().setUiRol(new TbUiRol());
                   
           
            findmodulos();
            usuarioBean.setSelectedNodes(null); 
            usuarioBean.setRoot(null); 
            createTreeNode();    
            usuarioBean.setModulos(new ArrayList<>());
            int process=Integer.valueOf(usuarioBean.getBungleManager().getBundle("#{config}").getString("NEW"));
            usuarioBean.setProcess(process);
            usuarioBean.setNivel(1);
            
            //PrimeFaces.current().ajax().update("formapp");
            RequestContext.getCurrentInstance().update("formapp");
            
        }
        } catch (Exception ex) {
            facesMenssage.addMensaje(1, ex.getMessage(), "");
            Logger.getLogger(UiUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editData(Object object){
        if(object instanceof TbUiUsuario){ 
           usuarioBean.setUiUsuario((TbUiUsuario) object);
          
           if(usuarioBean.getUiUsuario().getUiRol()==null)
               usuarioBean.getUiUsuario().setUiRol(new TbUiRol());
                   
           
            findmodulos();
            usuarioBean.setSelectedNodes(null); 
            usuarioBean.setRoot(null); 
            createTreeNode();    
            usuarioBean.setModulos(new ArrayList<>());
            int process=Integer.valueOf(usuarioBean.getBungleManager().getBundle("#{config}").getString("EDIT"));
            usuarioBean.setProcess(process);
            usuarioBean.setNivel(0);
            //PrimeFaces.current().ajax().update("formapp");
            RequestContext.getCurrentInstance().update("formapp");
            
        }
    }
    
    
    public void findmodulos(){
        try {
            usuarioBean.setModulos(usuarioBean.getDao().findAll(usuarioBean.getModulo().getClass().getName()));
            
            
        } catch (Exception ex) {
            Logger.getLogger(TbUiModulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createTreeNode() {
         
        CheckboxTreeNode root2 = new CheckboxTreeNode("Root", null);
        
        usuarioBean.getModulos().stream().filter(x->x.getParent()==0L).forEach(x->{
                CheckboxTreeNode ch1=  new  CheckboxTreeNode(x, root2);
                TreeNode n1 = ch1;                
                n1.setExpanded(true);
                
                
                usuarioBean.getModulos().stream().filter(z->Objects.equals(z.getParent(), x.getId())).forEach(y->{
                    TreeNode n2 = new CheckboxTreeNode(y, n1);
                    
                    usuarioBean.getModulos().stream().filter(b->Objects.equals(b.getParent(), y.getId())).forEach(z->{
                        CheckboxTreeNode ch2 = new CheckboxTreeNode(z, n2);
                        ch2.setSelected(getVerificarModulo(z));
                        TreeNode n3 =ch2;
                        
                    });
                    
                    boolean act1=getVerificarModulo(y);
                    if(n2.getChildCount()>0)ch1.setPartialSelected(act1);else ch1.setSelected(act1);
                });
                
                boolean act1=getVerificarModulo(x);
                if(n1.getChildCount()>0)ch1.setPartialSelected(act1);else ch1.setSelected(act1);
         });
         
        
        usuarioBean.setRoot(root2);
    
    }
    
    
    public boolean getVerificarModulo(TbUiModulo doc){
        try {
            TbUiModulo mod= usuarioBean.getUiUsuario().getMaModulos().stream().filter(x->Long.valueOf(x.getId()).equals(doc.getId())).findAny().orElse(null);
           return mod!=null;
        } catch (Exception ex) {
           return false;
        }
    
    }
    
    public void save(){
        try {
            verificar();
            usuarioBean.getUiUsuario().setVerticalMenu(false);
            
            usuarioBean.getDao().saveorUpdate(usuarioBean.getUiUsuario(), 1L);
               
            Map<Long,TbUiModulo> map= new HashMap<>();
             if(usuarioBean.getSelectedNodes() != null && usuarioBean.getSelectedNodes().length > 0) {
                
                Arrays.stream(usuarioBean.getSelectedNodes()).forEach(x->{
                    try {
                        TbUiModulo mod= (TbUiModulo) x.getData();
                        
                        if(!mod.getUsuarios().stream().filter(r->r.getId().equals(usuarioBean.getUiUsuario().getId())).findAny().isPresent())
                            mod.getUsuarios().add(usuarioBean.getUiUsuario());
                            map.put(mod.getId(),mod);
                            System.out.println("id"+mod.getId());
                        
                            TreeNode nd = x.getParent();

                            while(!(nd.getData() instanceof String)){
                                TbUiModulo mod2= (TbUiModulo) nd.getData();
                                if(!mod2.getUsuarios().stream().filter(r->r.getId().equals(usuarioBean.getUiUsuario().getId())).findAny().isPresent())
                                    mod2.getUsuarios().add(usuarioBean.getUiUsuario());

                                map.put(mod2.getId(),mod2);

                                System.out.println("id"+mod2.getId());
                                nd=nd.getParent();
                            }
                    } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                });
                
                usuarioBean.getDao().execNativeSQLQuery(usuarioBean.getUiUsuario().getClass().getName(),"DELETEUSUARIOMODULO",usuarioBean.getUiUsuario().getId());
               
                map.entrySet().stream().forEach(x->{
                    try {
                        System.out.println("id fin: "+x.getValue().getId());
                        usuarioBean.getDao().execNativeSQLQuery(usuarioBean.getUiUsuario().getClass().getName(),"INSERTUSUARIOMODULO",usuarioBean.getUiUsuario().getId(),x.getValue().getId());
               
                    } catch (Exception ex) {
                        Logger.getLogger(UiUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
             
            facesMenssage.addMensaje(2,"Datos almacenados correctamente","");
           //return "Admon.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            facesMenssage.addMensaje(1,"Error procesando los datos.","");
        }
    }
    
   private void verificar() throws Exception{
        if(usuarioBean.getUiUsuario().getUsuario().equals(""))
            throw  new Exception("Debes Ingresar un valor en el nombre de usuario");
        
        if(usuarioBean.getUiUsuario().getCorreo().equals(""))
            throw  new Exception("Debes Ingresar un valor en correo");
        
        if(usuarioBean. getChangePasswordListen() || (usuarioBean.getProcess()== Integer.valueOf(usuarioBean.getBungleManager().getBundle("#{config}").getString("NEW")))){
            if(!usuarioBean.getUiUsuario().getPass2().equals(usuarioBean.getUiUsuario().getPass1()))
                throw  new Exception("La confirmación de la clave deve ser igual al valor de la clave asignada");

             if(usuarioBean.getUiUsuario().getPass1().equals(""))
                throw  new Exception("Debes Ingresar un valor en la clave");

            if(usuarioBean.getUiUsuario().getPass2().equals(""))
                throw  new Exception("Debes Ingresar un valor en confirmar clave");

            usuarioBean.getUiUsuario().setPassword(Sha1.crypt(usuarioBean.getUiUsuario().getPass1()));
        }
    }
   
   
   
    public void onSelecRoles(AjaxBehaviorEvent event){
        Long select = (Long)((SelectOneMenu) event.getSource()).getValue();
       usuarioBean.getUiUsuario().setUiRol((TbUiRol) maDatosMaestroBean.getUiRols().stream()
               .filter((e)->Objects.equals( e.getId(),select.longValue())).findAny().orElse(new TbUiRol()));      
    }
   
   
    public MaDatosMaestroBean getMaDatosMaestroBean() {
        return maDatosMaestroBean;
    }

    public void setMaDatosMaestroBean(MaDatosMaestroBean maDatosMaestroBean) {
        this.maDatosMaestroBean = maDatosMaestroBean;
    }

    public UiUsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UiUsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public UiNavegacionBean getNav() {
        return nav;
    }

    public void setNav(UiNavegacionBean nav) {
        this.nav = nav;
    }
}
