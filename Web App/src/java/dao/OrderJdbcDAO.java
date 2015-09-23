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

    Order order = new Order();

    Timestamp timestamp = new Timestamp(order.getDate().getTime());
    Connection dbCon = JdbcConnection.getConnection(url);

    @Override
    public void saveOrder(Order aOrder) {
        String sql = "insert into SALES (date, customer) values (?,?)";

        try (
                // get connection to database

                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);) {

            // copy the data from the product domain object into the SQL parameters
            stmt.setTimestamp(1, timestamp);
            stmt.setString(2, aOrder.getCustomer().getUsername());

            stmt.executeUpdate(); // execute the statement

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                // extract the ID from the result
                Integer generatedId = rs.getInt(1);
                // do stuff with ID (omitted)
                aOrder.setOrderID(generatedId);
                ArrayList<OrderItem> items = order.getItems();

                for (OrderItem item : items) {
                    item.setOrder(order);
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

    public void addOrderItem(OrderItem item, Connection dbCon) throws SQLException {

        String sql2 = "insert into OrderItem (orderid, quantityPurchased, purchasePrice) values (?,?,?)";

        try (
                PreparedStatement stmt = dbCon.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);) {

            stmt.setDouble(1, item.getQuantityPurchased());
            stmt.setDouble(2, item.getPurchasePrice());
            stmt.setInt(3, item.getOrder().getOrderID());

            stmt.executeUpdate();
        }

    } // end addOrderItem method

    public void updateStockItem(OrderItem item, Connection dbCon) throws SQLException {

        String sql3 = "update product set Quantity=(? - ?} where productID = ?";

        try (
                PreparedStatement stmt = dbCon.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);) {
            
            stmt.setInt(1, item.getProduct().getQuantity());
            stmt.setInt(2, item.getQuantityPurchased());
            stmt.setInt(3, item.getProduct().getProductID());
            
            stmt.executeUpdate();
        }
            
        } // end UpdateStockItem method

    } // end OrderJdbcDAO class
