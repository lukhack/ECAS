/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.Bean.component.ExecuteOrUpdate;
import co.com.lk.DAO.genericDAO;
import co.com.lk.Interfaces.beanImp;
import co.com.lk.Interfaces.genericImp;
import co.com.lk.helper.facesMenssage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Likas
 * @param <T>
 */

public class UiManager<T>  implements  Serializable,beanImp<T>{
    
    genericImp dao;
    
    private T obj;
    private List<T> list;
    private List<T> listFilter;
    
    public UiManager(T obj) {
        dao=new genericDAO(); 
        this.obj =obj;
        list=new ArrayList<>();
    }
    
    
    

    @Override
    public void save(T obj,List<String> updateObjecView)  {  
       try{
           dao.saveorUpdate(obj,1L);
           
           /*list.stream().filter(x->Objects.equals(x, obj)).findFirst().map(x->x=obj).orElseGet(()->{
               list.add(obj);
               return null;
           });*/
           
           ExecuteOrUpdate.excuteOrupdate(updateObjecView);
           newObejc(obj);
        }catch(Exception ex){ //To change body of generated methods, choose Tools | Templates.
           ex.printStackTrace();
           facesMenssage.addMensaje(1, "Error guardando "+ex.getMessage(), "");
        }
    }
    
    @Override
    public void save(T obj)  {  
       try{
           dao.saveorUpdate(obj,1L);
        }catch(Exception ex){ //To change body of generated methods, choose Tools | Templates.
           ex.printStackTrace();
           facesMenssage.addMensaje(1, "Error guardando "+ex.getMessage(), "");
        }
    }

    @Override
    public void newObejc(T obj) throws Exception {
       this.obj= (T) Class.forName(obj.getClass().getName()).newInstance(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(T obj) throws Exception {
      this.obj=obj; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T obj) throws Exception {
       dao.delete(obj,1L); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findObject(Integer id) throws Exception {
        //x.getClass().getField("id").get(obj).equals(id)
      return list.stream().filter(x->{
           try{
               System.err.println("id:"+x.getClass().getField("id").get(obj));
               return x.getClass().getField("id").get(obj).equals(id);
           }catch(Exception e){
               return false;
           }
       }).findFirst().orElse((T) Class.forName(obj.getClass().getName()).newInstance());
        
    }
     @Override
    public T findById(Integer id) throws Exception {
        return (T) dao.findById(id,obj.getClass().getName());
    }


    @Override
    public List<T> findList() {
       try{
        list= dao.findAll(obj.getClass().getName());
        return  list;
       }catch(Exception ex){ //To change body of generated methods, choose Tools | Templates.
        ex.printStackTrace();
        facesMenssage.addMensaje(1, "Error listando "+ex.getMessage(), "");
        return null;
       }finally{
       }
    }
    
    
    @Override
    public List<T> findListObject(List<T> list) {
       try{
        list= dao.findAll(obj.getClass().getName());
        return  list;
       }catch(Exception ex){ //To change body of generated methods, choose Tools | Templates.
        ex.printStackTrace();
        facesMenssage.addMensaje(1, "Error listando "+ex.getMessage(), "");
        return null;
       }finally{
       }
    }
    
    @Override
    public List<T> findLikeParameter(String nameClass, String staticVar, Object... parameters)  {
       try{
        list= dao.findLikeParameter(nameClass,staticVar,parameters);
        return  list;
       }catch(Exception ex){ //To change body of generated methods, choose Tools | Templates.
        ex.printStackTrace();
        facesMenssage.addMensaje(1, "Error listando "+ex.getMessage(), "");
        return null;
       }finally{
       }
    }
    
    @Override
    public void selectObjec(T obj) throws Exception {
        this.obj=obj; //To change body of generated methods, choose Tools | Templates.
    }
    
    

   

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public void saveList(List<T> obj) throws Exception { try{
           dao.saveorUpdate(obj,1L);
           
           
        }catch(Exception ex){ //To change body of generated methods, choose Tools | Templates.
           ex.printStackTrace();
           facesMenssage.addMensaje(1, "Error guardando "+ex.getMessage(), "");
        }
    }

    public List<T> getListFilter() {
        return listFilter;
    }

    public void setListFilter(List<T> listFilter) {
        this.listFilter = listFilter;
    }

    @Override
    public T findIdLikeParameter(String nameClass, String staticVar, Object... parameters) throws Exception {
        return (T) dao.findLikeid(nameClass,staticVar,parameters);
    }

   
     public String reinit() throws Exception{
         this.obj=(T) Class.forName(obj.getClass().getName()).newInstance();
         return null;
    }

    
    
   
 }
