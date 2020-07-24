/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UIImagesView  implements Serializable{
    
     private List<String> images;
     
    public UIImagesView() {
        images=new ArrayList<>();
        images.add("banner-04.jpg");
        images.add("banner-05.jpg");
    }
    
    
    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
    
    
    
}
