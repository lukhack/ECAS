/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.Bean.UiManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import co.com.lk.Entity.Dtrespuestaform;
import co.com.lk.Entity.Dtrespuestaz;
import co.com.lk.Entity.Master.TbUiUsuario;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.tabview.TabView;
/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class UiRespuestasFormManager extends UiManager<Dtrespuestaform>{
    
    @Inject
    private UiFormularioManager uiFormulario;
     
    @Inject
    private UiListaManager uiList;
    
    
    
    Map<String,List<Map<String,String>>> formDetalle;
    
    Integer activeIndex=0;
    
    TabView tabview;
    List<Dtrespuestaform> filterListData;
    
    
    
    public UiRespuestasFormManager() {
        super(new Dtrespuestaform());
        findList();
        
    }
    
    public String valRepuesta(String codPreg){
        try{
        return getObj().getDtrespuestazCollection().stream().filter(x->Objects.equals(x.getDtrespuestazPK().getCodPreg(), codPreg)).map(x->x.getRespuesta().replace("-88", "")).findFirst().orElse("");
        }catch(Exception ex){
            return "";
        }
    }

    @Override
    public void selectObjec(Dtrespuestaform obj) throws Exception {
        super.selectObjec(obj); //To change body of generated methods, choose Tools | Templates.
        
        formDetalle = new HashMap<>();
        HashMap<String,String> dtvalue1= new LinkedHashMap<>();
        
        HashMap<String,HashMap<Integer,HashMap<String,String>>> dtvalue2= new LinkedHashMap<>();
        

        
        
        
        obj.getDtrespuestadetalleCollection().stream().forEach(x->{
            if(Objects.isNull(dtvalue2.get(x.getDtrepuestadetallePK().getPadrePreg())))
                dtvalue2.put(x.getDtrepuestadetallePK().getPadrePreg(), new LinkedHashMap<>());
            
            if(Objects.isNull(dtvalue2.get(x.getDtrepuestadetallePK().getPadrePreg()).get(x.getDtrepuestadetallePK().getHogar())))
                dtvalue2.get(x.getDtrepuestadetallePK().getPadrePreg()).put(x.getDtrepuestadetallePK().getHogar(), new LinkedHashMap<>());
            
            dtvalue2.get(x.getDtrepuestadetallePK().getPadrePreg()).get(x.getDtrepuestadetallePK().getHogar()).put(x.getDtrepuestadetallePK().getCodPreg(), x.getRespuesta());
       });
        
       
        
        dtvalue2.entrySet().stream().forEach(x1->{
            
           if(Objects.isNull(formDetalle.get(x1.getKey())))
                formDetalle.put(x1.getKey(), new ArrayList());
                
                x1.getValue().entrySet().stream().forEach(x2->{
                    HashMap<String,String> dtvalue= new LinkedHashMap<>();
                    
                    dtvalue.put("id", String.valueOf(formDetalle.get(x1.getKey()).size()+1));
                    x2.getValue().entrySet().stream().forEach(x3->{
                        dtvalue.put(x3.getKey(), x3.getValue());
                    });
                    formDetalle.get(x1.getKey()).add(dtvalue);
                });
                
                
                
        });
        
    }
    
    
    public List<Map<String,String>> getListMapFormulario(String codPreg) {
       return formDetalle.get(codPreg);
    }
    
    
    @PostConstruct
    public void init(){
         formDetalle = new HashMap<>();
    }
    
    public List<Dtrespuestaform> findListUser(TbUiUsuario usuario){
        if(usuario.getUiRol().getId().equals(1))
            return super.getList();
        else
            return super.findLikeParameter(getObj().getClass().getName(), "FINDUSUARIO", usuario.getId());
    }
    
    public Dtrespuestaz findDataFormZ(Dtrespuestaform rForm,String codPreg){
        return rForm.getDtrespuestazCollection().stream().filter(x->Objects.equals(x.getDtrespuestazPK().getCodPreg(), codPreg)).findFirst().orElse(new Dtrespuestaz());
    }
    
    @Override
    public List<Dtrespuestaform> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    public UiListaManager getUiList() {
        return uiList;
    }

    public void setUiList(UiListaManager uiList) {
        this.uiList = uiList;
    }

    


    public Map<String, List<Map<String, String>>> getFormDetalle() {
        return formDetalle;
    }

    public void setFormDetalle(Map<String, List<Map<String, String>>> formDetalle) {
        this.formDetalle = formDetalle;
    }

    public Integer getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(Integer activeIndex) {
        this.activeIndex = activeIndex;
    }

    public List<Dtrespuestaform> getFilterListData() {
        return filterListData;
    }

    public void setFilterListData(List<Dtrespuestaform> filterListData) {
        this.filterListData = filterListData;
    }

    public UiFormularioManager getUiFormulario() {
        return uiFormulario;
    }

    public void setUiFormulario(UiFormularioManager uiFormulario) {
        this.uiFormulario = uiFormulario;
    }
    
    
    
}
