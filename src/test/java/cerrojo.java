
import java.io.FileNotFoundException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julig
 */
public class cerrojo {
    private Lock cerrojo = new ReentrantLock();
    private long cont = 0;

    public static void convertirLista(String texto){
        //System.err.println(texto.lines().collect(Collectors.toList()));
    
    }
    
   public static void main(String[] args) throws InterruptedException, FileNotFoundException {
      /*  var str="mitocode";
        if(str.isBlank())
            convertirLista("1,2,3,4");
                
                
            
        var repeated = str.repeat(5);
        System.out.println(repeated);
        
        
        var str2 = 1;
        
        System.out.println(str2);*/
    }
      
      
}
