/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author julig
 */
public class Files {

    public Files() {
    }
    /*
    public  static void copiFile(Uireferenciadetallefile up,String path){
        
        String directorio=path+"/";
        System.out.println("contentipe"+directorio);
        
        File folder = new File(directorio);
        
        if(!folder.exists())
            folder.mkdirs();
        
        byte[] bytes=null;
 
            if (null!=up) {
            try {
                bytes = up.getFile().getContents();
                String nameFile=up.getFile().getFileName();
                System.err.println("name:"+nameFile);
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(folder.getAbsolutePath(),String.valueOf(up.getIduireferenciadetallefile())+"."+up.getExtencion())))) {
                    stream.write(bytes);
                }
                                
               
            } catch (IOException ex) {
                facesMenssage.addMensaje(1,  "Problemas para cargar el archivo", "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
    
    }
    
    
    public  static StreamedContent dowload(Uireferenciadetallefile file,String path) throws Exception{
        InputStream stream=null;
        String filename;
        try {
            //filename=file.getId()+".pdf";
            if(file.getFile()==null){
                String pathfile=path;
                //System.out.println("contentipe: "+pathfile+filename);
                File fl= new File(pathfile,String.valueOf(file.getIduireferenciadetallefile())+"."+file.getExtencion());
                stream = new FileInputStream(fl);
            }else{
                try {
                    stream = file.getFile().getInputstream();
                } catch (Exception ex) {
                    Logger.getLogger("Error copiando el archivo").log(Level.SEVERE, null, ex);
                }
            }
            String namefile=file.getNameFile();
            System.err.println("name file: "+namefile);
            return new DefaultStreamedContent(stream, "image/"+file.getExtencion(), namefile);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Error en la descarga del archivo");
        } 
    }
    
    
    
    public  static StreamedContent open(Uireferenciadetallefile file,String path) throws Exception{
        InputStream stream=null;
        String filename;
        try {
            //filename=file.getId()+".pdf";
            if(file.getFile()==null){
                String pathfile=path;
                //System.out.println("contentipe: "+pathfile+filename);
                File fl= new File(pathfile,String.valueOf(file.getIduireferenciadetallefile())+"."+file.getExtencion());
                stream = new FileInputStream(fl);
            }else{
                try {
                    stream = file.getFile().getInputstream();
                } catch (Exception ex) {
                    Logger.getLogger("Error copiando el archivo").log(Level.SEVERE, null, ex);
                }
            }
            String namefile=file.getNameFile();
            System.err.println("name file: "+namefile);
            return new DefaultStreamedContent(stream);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Error en la descarga del archivo");
        } 
    }*/
}
