/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author kirbymckenzie
 */
public class ProductJdbcDAO implements ProductDAO {

    private String url = "jdbc:h2:tcp://localhost/~/project;IFEXISTS=TRUE";

    public ProductJdbcDAO() {
    }

    public ProductJdbcDAO(String url) {
        this.url = url;

    }
   

    @Override
    public void saveProduct(Product aProduct) {
        String sql = "merge into products (id, productname, description, category, price, quantity) "
                + "values (?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // copy the data from the product domain object into the SQL parameters
            stmt.setInt(1, aProduct.getProductID());
            stmt.setString(2, aProduct.getName());
            stmt.setString(3, aProduct.getDescription());
            stmt.setString(4, aProduct.getCategory());
            stmt.setDouble(5, aProduct.getPrice());
            stmt.setInt(6, aProduct.getQuantity());
           

            stmt.executeUpdate(); // execute the statement
        } catch (SQLException ex) { // we are forced to catch SQLException

            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(),ex);
        }
    }

    @Override
    public void deleteProduct(Product aProduct) {
        String sql = "delete from products where id = ?";
        try (
                // get connection to database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
             // copy the data from the product domain object into the SQL parameters
            stmt.setInt(1, aProduct.getProductID());

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
        // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(),ex);
        }
    }

    @Override
    public Collection<Product> getAll() {
        String sql = "select * from products order by id";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // execute the query
            ResultSet rs = stmt.executeQuery();
            // Create a collection for holding the products we get from the query. 
            // We are using a List in order to preserve the order in which
            // the data was returned from the query.

            List<Product> products = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {
                // get the data out of the query
                Integer id = rs.getInt("id");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");

                // use the data to create a product object
                Product p = new Product(id, productName, description, category,
                        price, quantity); // and put it in the collection

                products.add(p);
            }

            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(),ex);
        }
    }

    @Override
    public Collection<Product> getByCategory(String aCategory) {
        String sql = "select * from products where category = ?";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, aCategory);
            // execute the query
            ResultSet rs = stmt.executeQuery();
            // Create a collection for holding the product we get from the query.
            // We are using a List in order to preserve the order in which
            // the data was returned from the query.
            Collection<Product> products = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {
            // get the data out of the query
                Integer id = rs.getInt("id");
                String name = rs.getString("ProductName");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                
            // use the data to create a product object
                Product p = new Product(id, name, description, category, price, quantity);
            // and put it in the collection
                products.add(p);
            }

            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(),ex);

        }

    }

    @Override
    public Collection<String> getCategories() {

        String sql = "select distinct category from products order by category";

        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // execute the query
            ResultSet rs = stmt.executeQuery();
            // Create a collection for holding the product we get from the query.
            // We are using a List in order to preserve the order in which
            // the data was returned from the query.
            Collection<String> categories = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {
                // get the data out of the query

                String category = rs.getString("category");

                // and put it in the collection
                categories.add(category);
            }
            return categories;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(),ex);
        }
    }

    @Override
    public Product getById(Integer id
    ) {
        String sql = "select * from products where id = ?";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection(url);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            // Create a collection for holding the product we get from the query.
            // We are using a List in order to preserve the order in which
            // the data was returned from the query.

            // iterate through the query results
            if (rs.next()) {
            // get the data out of the query

                Integer productId = rs.getInt("id");
                String name = rs.getString("productName");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
            // use the data to create a product object
                Product p = new Product(productId, name, description, category,
                        price, quantity);
            // and put it in the collection
                return p;
            }
            return null;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(),ex);
        }
    }

}
