/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.ConfiguracionBean;
import co.com.lk.Bean.MensajeriaBean;
import co.com.lk.Bean.application.GlopalConf;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.Master.IUConfigForm;
import co.com.lk.Entity.Master.TbUiMensajes;
import co.com.lk.Entity.Master.TbUiUsuario;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class mensajeriaController implements Serializable{
    
    @Inject
    private ConfiguracionBean configuracionBean;   
    
    
    @Inject
    private GlopalConf glopalConf;
    
    
    @Inject
    private MensajeriaBean bean;
    
    @Inject
    private UsuarioB usuarioB;
    
    int totalMensajes;
    boolean save;
    String mensaje;
    int total;
    public mensajeriaController() {
    }
    
    public Map<TbUiUsuario,Integer> mensajesPendientes(TbUiUsuario usuario){
        try {
            totalMensajes=0;
            Map<TbUiUsuario,Integer> map = new HashMap<>();
            List<TbUiMensajes> data=bean.getDao().findLikeParameter(bean.getMensajes().getClass().getName(), "FINDIDMENSAJE", usuario.getId());
            data.stream().forEach((TbUiMensajes x)->{
                int value= Objects.isNull(map.get(x.getUisuario_emi()))?1:map.get(x.getUisuario_emi())+1;
                map.put(x.getUisuario_emi(),value++);
                totalMensajes++;
            });
            return map;
        }catch (Exception ex){
            Logger.getLogger(mensajeriaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int contador(){
        return total=total+1;
    }
    
    public void save(){
         try {
            TbUiMensajes msn=new TbUiMensajes();
            msn.setFecha(new Date());
            msn.setLeido(false);
            msn.setMensaje(mensaje);
            msn.setUisuario_emi(usuarioB.getTbUiUsuario());
            msn.setUisuario_rec(bean.getUsuario());
            bean.getDao().save(msn , 1L);
            mensaje="";
        }catch (Exception ex){
            Logger.getLogger(mensajeriaController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    
    public Collection<TbUiMensajes> mensajesPorUsuario(TbUiUsuario usuarioemi){
        try {
           
            List<TbUiMensajes> data= bean.getDao().findLikeParameter(bean.getMensajes().getClass().getName(), "FINDIDMENSAJES", usuarioemi.getId(), usuarioB.getTbUiUsuario().getId(),usuarioB.getTbUiUsuario().getId(),usuarioemi.getId());
            
            return data;
        }catch (Exception ex){
            //Logger.getLogger(mensajeriaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String mapConfig(String tipo, String valor){
        Map<String,IUConfigForm> config= glopalConf.getConfigMap().get(tipo);
        return config.get(valor).getValor();
    }
    
    public ConfiguracionBean getConfiguracionBean() {
        return configuracionBean;
    }

    public void setConfiguracionBean(ConfiguracionBean configuracionBean) {
        this.configuracionBean = configuracionBean;
    }

    public GlopalConf getGlopalConf() {
        return glopalConf;
    }

    public void setGlopalConf(GlopalConf glopalConf) {
        this.glopalConf = glopalConf;
    }

    public UsuarioB getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
        this.usuarioB = usuarioB;
    }

    public MensajeriaBean getBean() {
        return bean;
    }

    public void setBean(MensajeriaBean bean) {
        this.bean = bean;
    }

    public int getTotalMensajes() {
        return totalMensajes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
}
