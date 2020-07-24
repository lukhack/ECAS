/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.helper.facesMenssage;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class DtTerceroController extends UiManager<Dttercero>{
    
    @Inject
    UsuarioB usuario;
   
    Dttercero data;
    
    public DtTerceroController() {
        super(new Dttercero());
        //findList();
    }

    @Override
    public List<Dttercero> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Dttercero obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<Dttercero> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        
        }
        
    }
    
   
   
    public String  reinit() throws Exception {
        setObj(new Dttercero()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public Dttercero getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }

    public Dttercero getData() {
        return data;
    }

    public void setData(Dttercero data) {
        System.err.println("data: "+data.getDocumento());
        this.data = data;
    }

    
    
    
    
    
    
}
