/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.Controller;

import co.com.lk.DAO.genericDAO;
import co.com.lk.Entity.Master.IUBitacora;
import co.com.lk.Entity.Master.TbUiUsuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitacoraController {
    
    
    public BitacoraController() {
    }
    
    public static void saveBitacora(TbUiUsuario usuario,String Accion){
         try {
            IUBitacora bitacora=new IUBitacora();
            bitacora.setFecha(new Date());
            bitacora.setResulLog(Accion);
            bitacora.setUsuario(usuario);
            new genericDAO().saveorUpdate(bitacora, 1L);
        } catch (Exception ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
