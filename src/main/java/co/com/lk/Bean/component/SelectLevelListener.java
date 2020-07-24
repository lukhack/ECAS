/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.extensions.component.masterdetail.SelectLevelEvent;

/**
 *
 * @author julig
 */
@ManagedBean  
@RequestScoped  
public class SelectLevelListener {  
  
    private boolean errorOccured = false;  
  
    public int handleNavigation(SelectLevelEvent selectLevelEvent) {  
        if (errorOccured) {  
            return 2;  
        } else {  
            return selectLevelEvent.getNewLevel();  
        }  
    }  
  
    public void setErrorOccured(boolean errorOccured) {  
        this.errorOccured = errorOccured;  
    }  
}  
