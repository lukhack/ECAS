/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.application;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.IUConfigForm;
import co.com.lk.Entity.Master.IUConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ApplicationScoped
public class GlopalConf  implements Serializable{
    List<IUConfig> configs;
    Map<String,Map<String,IUConfigForm>> configMap=new HashMap<>();
    IUConfig data;
    
    public GlopalConf() {
        try {
            configs=new genericDAO().findAll(new IUConfig().getClass().getName());
            configs.stream().forEach(x->{
                Map<String,IUConfigForm> map=new HashMap<>();
                x.getIUConfigForm().stream().forEach(y->{
                    map.put(y.getParameterValue(), y);
                
                });
                configMap.put(x.getTipo(), map);
            });
            
            System.out.println("Cantidad de configuraciones "+configMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }
    
    
    public String mapConfig(String tipo, String valor){
        Map<String,IUConfigForm> config = getConfigMap().get(tipo);
        return config.get(valor).getValor();
    }
    
    public String getContextPath(){
        return FacesContext.getCurrentInstance().getExternalContext().getContextName();
    }

    public List<IUConfig> getConfigs() {
        return configs.stream().filter(x->x.getActivo()).collect(Collectors.toList());
    }

    public void setConfigs(List<IUConfig> configsTipos) {
        this.configs = configsTipos;
    }

    public Map<String, Map<String, IUConfigForm>> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, Map<String, IUConfigForm>> configMap) {
        this.configMap = configMap;
    }

    public IUConfig getData() {
        return data;
    }

    public void setData(IUConfig data) {
        this.data = data;
    }
    
    
}
