/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author kirbymckenzie
 */
public class DAOException extends RuntimeException {
    
    public DAOException(String reason){

// reason describes the reason that the exception was thrown
        
super(reason);
}
    
   public DAOException(String reason, Throwable cause){
       // reason describes the reason that the exception was thrown
       super(reason,cause);
   } 
    
}
