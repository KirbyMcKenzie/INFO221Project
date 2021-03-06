/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author kirbymckenzie
 */
public class OrderItem {

    private Integer quantityPurchased;
    private double purchasePrice;
    private Product product;
    private Order order;

    
    
    public OrderItem() {
    }

    public OrderItem(int quantityPurchased, double purchasePrice, Product product) {
        this.quantityPurchased = quantityPurchased;
        this.purchasePrice = purchasePrice;
        this.product = product;
    }

    

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    

    @Override
    public String toString() {
        return "OrderItem{" + "quantityPurchased=" + quantityPurchased + ", purchasePrice=" + purchasePrice + '}';
    }
    
    public double getItemTotal(){
        double total = this.getQuantityPurchased() * this.getPurchasePrice();
        return total;
    }

} // end class
