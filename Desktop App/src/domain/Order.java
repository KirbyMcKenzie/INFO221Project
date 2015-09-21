/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kirbymckenzie
 */
public class Order {
    
    

    private String orderID;
    private Date date;
    private Customer customer;
    
    private ArrayList <OrderItem> itemList = new ArrayList();

    OrderItem order = new OrderItem();

    public Order() {
    }

    public Order(String orderID, Date date) {
        this.orderID = orderID;
        this.date = date;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", date=" + date + '}';
    }

    public double getTotal() {
        return order.getItemTotal();
    }
    
    public void addItem(OrderItem orderItem){
        itemList.add(orderItem);
        
    }
    

} // end class
