/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author julig
 */
@Named
@ViewScoped
public class IndexController implements Serializable{

    public IndexController() {}
    
    
    public List<Integer> range(Integer rg){
        List<Integer> dt=new ArrayList<>();
        
        IntStream.rangeClosed(1,rg).forEach(x->{
            dt.add(x);
        });
        
        return dt;
    }
    
    
}
