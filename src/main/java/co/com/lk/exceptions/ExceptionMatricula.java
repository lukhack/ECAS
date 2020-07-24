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
public class ExceptionMatricula extends  Exception{
    
    public ExceptionMatricula(String message, Throwable cause) {
        super(message, cause);
    }
    public ExceptionMatricula(String message) {
        super(message);
    }

}
