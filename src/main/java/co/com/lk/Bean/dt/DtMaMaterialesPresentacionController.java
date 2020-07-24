/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.dt;

import co.com.lk.Bean.UiManager;
import co.com.lk.Bean.session.UsuarioB;
import co.com.lk.Entity.ma.DtmamaterialMarcaPresentacion;
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
public class DtMaMaterialesPresentacionController extends UiManager<DtmamaterialMarcaPresentacion>{
    @Inject
    UsuarioB usuario;
    
    @Inject
    DtMaMaterialesMarcaController materialMarca;
    
    
    public DtMaMaterialesPresentacionController() {
        super(new DtmamaterialMarcaPresentacion());
        findList();
        
        
    }

    @Override
    public List<DtmamaterialMarcaPresentacion> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(DtmamaterialMarcaPresentacion obj, List<String> updateObjecView) {
        super.save(obj, updateObjecView); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveList(List<DtmamaterialMarcaPresentacion> obj) throws Exception {
        try{
            obj.stream().forEach(x->super.save(x));
            facesMenssage.addMensaje(2, "Datos procesados correctamente", "");
        }catch(Exception ex){
            facesMenssage.addMensaje(2, "Error procesando los datos", "");
        }
    }

    @Override
    public DtmamaterialMarcaPresentacion getObj() {
        return super.getObj(); //To change body of generated methods, choose Tools | Templates.
    }

        

   
    public String  reinit() throws Exception {
        getObj().setIdmaterialmarca(materialMarca.getObj());
        setObj(new DtmamaterialMarcaPresentacion()); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public UsuarioB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioB usuario) {
        this.usuario = usuario;
    }

   
    public DtmamaterialMarcaPresentacion addObjs(DtmamaterialMarcaPresentacion obj) {
        obj.setIdmaterialmarca(materialMarca.getObj());
        super.setObj(obj); //To change body of generated methods, choose Tools | Templates.
        return super.getObj();
    }
    
    
    
   
    
}
