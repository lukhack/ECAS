/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.ma.DtmamaterialMarca;
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
public class DtMaMaterialesMarcaController extends UiManager<DtmamaterialMarca>{
    @Inject
    UsuarioB usuario;
    
    
    @Inject
    DtMaMaterialesCategoriaController material;
    
    public DtMaMaterialesMarcaController() {
        super(new DtmamaterialMarca());
        findList();
    }

    @Override
    public List<DtmamaterialMarca> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(DtmamaterialMarca obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<DtmamaterialMarca> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }

    @Override
    public DtmamaterialMarca getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }
   
    public String  reinit() throws Exception {
        getObj().setMaterial(material.getObj());
        setObj(new DtmamaterialMarca()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }

   
    public DtmamaterialMarca addObjs(DtmamaterialMarca obj) {
        obj.setMaterial(material.getObj());
        super.setObj(obj); //To change body of generated methods, choose Tools | Templates.
        return super.getObj();
    }
    
    
    
   
    
}
