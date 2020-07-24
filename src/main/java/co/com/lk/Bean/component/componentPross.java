/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.component;

/**
 *
 * @author julig
 */
public  class componentPross {
     
    public static String convertData(String data,String component){
         if(component.equals("Boolean")){
                if(data==null)
                    data="false";
                else
                    data="true";
         }
         return data;
     }
}
