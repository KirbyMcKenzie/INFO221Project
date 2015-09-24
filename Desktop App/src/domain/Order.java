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
    
    

    private Integer orderID;
    private Date date;
    private Customer customer;
    private ArrayList <OrderItem> itemList = new ArrayList();
    
    

    OrderItem orderItem = new OrderItem();

    public Order() {
    }
    
    

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order(Integer orderID, Date date, Customer customer) {
        this.orderID = orderID;
        this.date = date;
        this.customer = customer;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
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
    

    public double getTotal() {
        return orderItem.getItemTotal();
    }
    
    public void addItem(OrderItem orderItem){
        itemList.add(orderItem);
        
    }
    
    public ArrayList<OrderItem> getItems(){
        return itemList;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", date=" + date + ", customer=" + customer + '}';
    }
    
    
    
    

} // end class
