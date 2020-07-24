/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean;

import java.io.Serializable;
import java.util.PropertyResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@SessionScoped
public class UiNavegacionBean implements Serializable{
    
    private String urlPage;
    private String item;
    private String title;
    
    private Object obj;
    
    
    public UiNavegacionBean() {
    }
    
    
    
    public String sendPage(String page,String item,String title){
        this.urlPage=page;
        this.item=item;
        this.title=title;
        System.err.println("this.urlPage"+page);
        System.err.println("this.item;"+item);
        return page.concat("?facesRedirect=true");
    }
    
    public String sendPage(String page,String item,String title,Object obj){
        this.urlPage=page;
        this.item=item;
        this.title=title;
        this.obj=obj;
        return getUrlPage().concat("?facesRedirect=true");
    }

    public String getUrlPage() {
        String url;
        try{
            url=getBundle().getString("parameter_homeAdmon");
        }catch(Exception ex){
            ex.printStackTrace();
            url="dashboard.xhtml";
        }
        return urlPage==null?url:urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }

    public String getItem() {
        return item==null?"":item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    
    
    @Produces 
    public PropertyResourceBundle getBundle() {  
        FacesContext context = FacesContext.getCurrentInstance(); 
        return context.getApplication().evaluateExpressionGet(context, "#{config}", PropertyResourceBundle.class); 
    } 
    
}
