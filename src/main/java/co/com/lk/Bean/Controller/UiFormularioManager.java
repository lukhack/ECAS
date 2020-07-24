/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.Dtformulario;
import co.com.lk.Entity.Dtgrupo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class UiFormularioManager extends UiManager<Dtgrupo>{
    
    
    @Inject
    private UsuarioB usuario;
    
    Map<String,List<Map<String,String>>> formDetalle;
    
    
    List<Dtformulario> formulario;
    
    public UiFormularioManager() {
        super(new Dtgrupo());
        findList();
        formulario=new ArrayList<>();
        
    }
    
    @PostConstruct
    public  void init(){
        getList().stream().forEach(x->{
            x.getDtsubgrupoCollection().stream().forEach(y->{
                formulario.addAll(y.getDtformularioCollection().stream().collect(Collectors.toList()));
            });
        
        });
    }
    

    @Override
    public List<Dtgrupo> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Dtformulario> getFormulario() {
        return formulario;
    }

    public void setFormulario(List<Dtformulario> formulario) {
        this.formulario = formulario;
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }
    
    
    
}
