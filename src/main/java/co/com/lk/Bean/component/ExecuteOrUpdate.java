/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.component;

import java.util.List;
import java.util.Objects;
import org.primefaces.context.RequestContext;
//import org.primefaces.PrimeFaces;

/**
 *
 * @author julig
 */
public class ExecuteOrUpdate {
    
    public static void excuteOrupdate(List<String> parameter){
        parameter.stream().forEach(x->{
            System.err.println("data:"+x);
               String[] data= x.split(";");
               try{
                   if(data.length>0){
                       if(Objects.equals(data[0].toLowerCase(),"update"))
                            updateComonent(data[1]);
                       else if(Objects.equals(data[0].toLowerCase(), "execute"))
                            exceute(data[1]);
                   }else{
                       throw  new Exception("No cumple con los parametros para ejecutar al acción");
                   }
               }catch(Exception ex){
                   System.err.println("No se podido executar el compando ExcuteOrUPDATE, "+ex.getMessage());
                   ex.printStackTrace();
               }
               
        });
           
    }
    
    public static void updateComonent(String component) throws Exception{
         try{
            RequestContext.getCurrentInstance().update(component);
            //PrimeFaces.current().ajax().update(component);
        }catch(Exception ex){
            throw  new Exception("Error ejecutando updateComponent");
        }
    }
    
    public static void exceute(String command) throws Exception{
        try{
            RequestContext.getCurrentInstance().execute(command);
            //PrimeFaces.current().executeScript(command);
        }catch(Exception ex){
            throw  new Exception("Error ejecutando updateComponent");
        }
    }
}
