/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.global;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author julig
 */
@ManagedBean
@SessionScoped
public class GlobalSession {
    private String title="CardioVid";

    public String getTitle() {
        if(title.equals(""))
            return "CardioVid";
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
