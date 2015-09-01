/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "insert into customers (username, name, email, address, password) "
                + "values (?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // copy the data from the product domain object into the SQL parameters
            stmt.setString(1, aCustomer.getUsername());
            stmt.setString(2, aCustomer.getName());
            stmt.setString(3, aCustomer.getEmail());
            stmt.setString(4, aCustomer.getAddress());
            stmt.setString(5, aCustomer.getPassword());

            stmt.executeUpdate(); // execute the statement
        } catch (SQLException ex) { // we are forced to catch SQLException

            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
