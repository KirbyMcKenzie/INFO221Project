package dao;

import domain.Order;
import domain.OrderItem;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kirbymckenzie
 */


public interface OrderDAO {
   
   void saveOrder(Order aOrder);
   
   void addOrderItem(OrderItem item, Connection dbCon) throws SQLException;
   
   void updateStockItem(OrderItem item, Connection dbCon) throws SQLException;
   
   
   
 
   
}