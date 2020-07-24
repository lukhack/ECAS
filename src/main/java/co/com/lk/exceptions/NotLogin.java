/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.exceptions;

/**
 *
 * @author julig
 */
public class NotLogin extends  Exception{
    
    public NotLogin(String message, Throwable cause) {
        super(message, cause);
    }
    public NotLogin(String message) {
        super(message);
    }

}
