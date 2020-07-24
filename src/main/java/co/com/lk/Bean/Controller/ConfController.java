/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.ConfiguracionBean;
import co.com.lk.Bean.component.componentPross;
import co.com.lk.Bean.application.GlopalConf;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.Master.IUConfigForm;
import co.com.lk.Entity.Master.IUConfig;
import co.com.lk.helper.facesMenssage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class ConfController implements Serializable{
    @Inject
    private ConfiguracionBean configuracionBean;   
    
    
    
    @Inject
    private GlopalConf glopalConf;
    
    @Inject
    private UsuarioB usuarioB;
    
    boolean save;
    public ConfController() {
    }
    
    public void save(IUConfig conf){
        save=true;
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
       configuracionBean.getGlopalConf().getConfigs().stream().filter(x->x==conf).forEach(x->{
           x.getIUConfigForm().stream().forEach(y->{
                String txtProperty = request.getParameter(conf.getNameform()+":"+y.getNameId());
                String Value= componentPross.convertData(txtProperty,y.getTipoCampo().getTipoCampo());
                y.setValor(Value);
                try {
                    configuracionBean.getDao().saveorUpdate(y, 1L);
                }catch (Exception ex) {
                    save=false;
                }
                System.err.println("data: "+Value);
           });
           
           BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(), "Archivos de configuración actulizado("+x.getTipo()+")");
       });
       if(save)
           facesMenssage.addMensaje(2, "Datos almacenados correctaemente", "");
       else{
           BitacoraController.saveBitacora(usuarioB.getTbUiUsuario(),"Error aculizando el archivo de configuración");
           facesMenssage.addMensaje(1, "Se encontraron problemas con los datos", "");
       }
    }
    
    public String mapConfig(String tipo, String valor){
        Map<String,IUConfigForm> config= glopalConf.getConfigMap().get(tipo);
        IUConfigForm configForm = config.get(valor);
       
        return Optional.ofNullable(configForm).orElseThrow(() -> new IllegalArgumentException("La configuracion esta nula")).getValor();
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
    
    
    
}
