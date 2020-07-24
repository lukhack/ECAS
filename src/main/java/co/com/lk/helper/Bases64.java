/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

/**
 *
 * @author julig
 */
public class Bases64 {
     /** Read the object from Base64 string. */
   public static String fromString(String s) throws IOException , ClassNotFoundException {
        byte [] data = org.apache.commons.codec.binary.Base64.decodeBase64(s);
        String decode = new String(data, "UTF-8");
        return decode;
   }

    /** Write the object to a Base64 string. */
    public static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray()); 
    }
}
