/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.TbLog;
import co.com.lk.Interfaces.genericImp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LogB implements Serializable{
    genericImp classGeneric;
    TbLog log;
    private List<TbLog> logs;
    private String textSearch;
     
    public LogB() {
        classGeneric = new genericDAO();
        logs = new ArrayList<>();
        log=new TbLog();
    }
    
    @PostConstruct
    private void init(){
        listar();
    }
    
    private void listar(){
        try {
            logs = classGeneric.findAll(log.getClass().getName());
        } catch (Exception ex) {
            Logger.getLogger(LogB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void searchlist(String e){
        
              List<TbLog> list = new ArrayList<>();
              
             if(e.toString().trim().equals("")){
                 listar();
                           
             }else{
             
              String[] campo =  e.toString().split(" ");
              
              try {
                  for(String c:campo){
                        list.addAll(classGeneric.findLikeParameter(log.getClass().getName(), "SEARCHREGISTER",
                                c+"%",
                               "%"+c+"%", 
                               "%"+c+"%",
                                c+"%",
                                c+"%"));
                  }
                  
                  logs = list;
              } catch (Exception ex) {
                  ex.printStackTrace();
                  listar();
              }
             }
    }
    
     public List<TbLog> uniqueSinOrdenar(List<TbLog> lista) {

        HashSet<TbLog> hs = new HashSet<>();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        return lista;
    }
    
    public static void saveLog(Long id,String title,String mensaje, Date fecha){
        try {
            genericImp classGeneric = new genericDAO();
            classGeneric.save(new TbLog(id,title,mensaje, fecha), 1L);
        } catch (Exception ex) {
            Logger.getLogger(LogB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TbLog> getLogs() {
        return logs;
    }

    public void setLogs(List<TbLog> logs) {
        this.logs = logs;
    }

    public String getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }
    
    
}
