/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Bean.application;


import co.com.lk.Bean.UiManager;
import co.com.lk.Entity.dt.Dtfactura;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtmaparameter;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author julig
 */

@ApplicationScoped
public  class ConsecutivoEcas extends UiManager<Dtecassucursal>{
     
    private boolean enposicion = false;

    public ConsecutivoEcas() {
        super(new Dtecassucursal());
    }

    
    
    public ConsecutivoEcas(Dtecassucursal obj) {
        super(obj);
    }
    
    
    public synchronized void  start(){
        enposicion = true;    
        int x=0;
        System.err.println("data 8");

        while (enposicion) {
            try {    
                x++;
                System.err.println("x: "+x);
                Thread.sleep(1000);
                wait();
                System.err.println("Y: "+x);
            }catch (InterruptedException ex) {
                Logger.getLogger(ConsecutivoEcas.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        System.err.println("data 9");
    }
    
     
    public  void  Increment() throws Exception{
          System.err.println("data 6");
          enposicion = true;    
          Thread r=new Thread(() -> {
              int x=0;
              synchronized(ConsecutivoEcas.this){
                 while (enposicion) {
                    try {    
                        x++;
                        System.err.println("x: "+x);
                        wait();
                        System.err.println("Y: "+x);
                    }catch (InterruptedException ex) {
                        Logger.getLogger(ConsecutivoEcas.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                }
              }
        });
        r.start();
    }
    
    /**
     *
     * @param scl
     * @throws Exception
     */
    public  synchronized void  procesarFactura(Session session, Dtfactura factura, Dtecassucursal scl,Integer tipo) throws  Exception{
        try {
            
            
            try{
                Transaction tr = session.getTransaction();
                tr.begin();
                
                Dtecassucursal sucursal = super.findById(scl.getId());
                Dtmaparameter parameter;

                if(Objects.isNull(factura.getId())){
                    if(sucursal.getParameterGlobal())
                        parameter = sucursal.getDtEcaid().getDtmaparameterList().stream().filter(x->x.getVigente() && Objects.equals(x.getDtTipoFacturaid().getId(), tipo)).findAny().orElse(null);
                    else
                        parameter= sucursal.getDtmaparameterList().stream().filter(x->x.getVigente() && Objects.equals(x.getDtTipoFacturaid().getId(), tipo)).findAny().orElse(null);

                    parameter.setConsActual(parameter.getConsActual()+1);
                    session.saveOrUpdate(parameter);
                    factura.setConsecutivo(parameter.getPrefijo()+parameter.getSimbSeparacion()+parameter.getConsActual());
                }
                session.saveOrUpdate(factura);
                tr.commit();
            
            }catch(Exception ex){
                ex.printStackTrace();
                session.getTransaction().rollback();
                throw new Exception("Error guardando los datos");
            }finally{
                if(session != null){
                    session.close();
                }
            }
                
            
        } catch (InterruptedException ex) {
            throw new Exception("Se encontraron problemas para generar el consecutivo de la factura, vuelva a intentarlo y si el problema persiste contacte a su administrador "+ex.getMessage());
        } catch (Exception ex) {
            throw new Exception("Se encontraron problemas para generar el consecutivo de la factura, vuelva a intentarlo y si el problema persiste contacte a su administrador "+ex.getMessage());
        }
    
    }
    
    
    public synchronized void stopError(String key) {
        enposicion=false;
        notify();
    }
    
    public void stop() {
        System.err.println("stop");
        enposicion=false;
        
        notify();
        System.err.println("stop 2");
    }
    
}
