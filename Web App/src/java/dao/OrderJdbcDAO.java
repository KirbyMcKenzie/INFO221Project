/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Order;
import domain.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author kirbymckenzie
 */
public class OrderJdbcDAO implements OrderDAO {

    private String url = "jdbc:h2:tcp://localhost/~/project;IFEXISTS=TRUE";

    public OrderJdbcDAO() {

    }

    public OrderJdbcDAO(String url) {
        this.url = url;
    }

    

    // get connection to database
    Connection dbCon = JdbcConnection.getConnection(url);

    @Override
    public void saveOrder(Order aOrder) {
        String sql = "insert into SALES (order_date, customer) values (?,?)";

        try (
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            Timestamp timestamp = new Timestamp(aOrder.getDate().getTime());

            // copy the data from the order domain object into the SQL parameters
            stmt.setTimestamp(1, timestamp);
            stmt.setString(2, aOrder.getCustomer().getUsername());

            stmt.executeUpdate(); // execute the statement

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                // extract the ID from the result
                Integer generatedId = rs.getInt(1);
                // do stuff with ID (omitted)
                aOrder.setOrderID(generatedId);
                ArrayList<OrderItem> items = aOrder.getItems();

                for (OrderItem item : items) {
                    item.setOrder(aOrder);
                    addOrderItem(item, dbCon);
                    updateStockItem(item, dbCon);
                }

                dbCon.commit();

            }
        } catch (SQLException ex) { // we are forced to catch SQLException

            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }

    } // end saveOrder method

    @Override
    public void addOrderItem(OrderItem item, Connection dbCon) throws SQLException {

        String sql2 = "insert into OrderItems (product_ID, order_id, quantity_Purchased, price) values (?,?,?,?)";

        try (
                PreparedStatement stmt = dbCon.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);) {
            
            stmt.setInt(1, item.getProduct().getProductID());
            stmt.setInt(2, item.getOrder().getOrderID());
            stmt.setDouble(3, item.getQuantityPurchased());
            stmt.setDouble(4, item.getPurchasePrice());
            
            
            

            stmt.executeUpdate();
        }

    } // end addOrderItem method

    public void updateStockItem(OrderItem item, Connection dbCon) throws SQLException {

        String sql3 = "update products set Quantity=(? - ?) where ID = ?";

        try (
                PreparedStatement stmt = dbCon.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);) {

            stmt.setInt(1, item.getProduct().getQuantity());
            stmt.setInt(2, item.getQuantityPurchased());
            stmt.setInt(3, item.getProduct().getProductID());

            stmt.executeUpdate();
        }

    } // end UpdateStockItem method

} // end OrderJdbcDAO class
