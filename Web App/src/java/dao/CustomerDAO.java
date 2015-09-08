package dao;

import domain.Customer;

/**
 *
 * @author kirbymckenzie
 */


public interface CustomerDAO {
   
   void saveCustomer(Customer aCustomer);
   
   Customer login(String username, String password);
   
}