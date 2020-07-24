/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.helper;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author julig
 */
public abstract class castFileBase64 {
    public static String base64file(UploadedFile file) throws IOException{
        String fileb64=""; 
        InputStream is=file.getInputstream() ;
        byte[] bytes = IOUtils.toByteArray(is);
        fileb64 = Base64.encodeBase64String(bytes);
        return fileb64;
    }
}
