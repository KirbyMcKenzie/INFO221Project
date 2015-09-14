/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kirbymckenzie 
 */
public class CustomerJdbcDAO implements CustomerDAO {

    private String url = "jdbc:h2:tcp://localhost/~/project;IFEXISTS=TRUE";

    public CustomerJdbcDAO() {
    }

    public CustomerJdbcDAO(String url) {
        this.url = url;

    }

    @Override
    public void saveCustomer(Customer aCustomer) {
        String sql = "insert into CUSTOMERS (username, firstName, lastName, email, streetAddress,"
                + "suburb, password) "
                + "values (?,?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // copy the data from the product domain object into the SQL parameters
            stmt.setString(1, aCustomer.getUsername());
            stmt.setString(2, aCustomer.getFirstName());
            stmt.setString(3, aCustomer.getLastName());
            stmt.setString(4, aCustomer.getEmail());
            stmt.setString(5, aCustomer.getStreetAddress());
            stmt.setString(6, aCustomer.getSuburb());
            stmt.setString(7, aCustomer.getPassword());

            stmt.executeUpdate(); // execute the statement
        } catch (SQLException ex) { // we are forced to catch SQLException

            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    

    @Override
    public Customer login(String username, String password) {
       String sql = "SELECT * FROM CUSTOMERS WHERE Username  = ?"
               + "AND Password = ?";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            // execute the query
            
            ResultSet rs = stmt.executeQuery();
        
            
            // iterate through the query results
            while (rs.next()) {
            // get the data out of the query
                String custUsername = rs.getString("username");
                String custPassword = rs.getString("password");
               String custFirstName = rs.getString("firstName");
              
                
            // use the data to create a customer object
                Customer cust = new Customer(custUsername, custPassword,custFirstName);
            // and put it in the collection
                return cust;
            }

            return null;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(),ex);

        }

    }

    
    
    
    
    
    
}
