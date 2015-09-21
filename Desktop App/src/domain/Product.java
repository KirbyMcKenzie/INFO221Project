/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Blob;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author kirbymckenzie
 */
public class Product implements Comparable<Product> {
    
    private int productID;
    
    @NotNull(message = "Name must be provided.")
    @NotBlank(message="Name must be provided.")
    @Length(min=2, message="Name must contain at least two characters.")
    private String name;
    
    private String description;
    private String category;
    
   @NotNull(message = "Price must be provided.")
   @NotNegative(message = "Price must be a positive number.")
    private Double price;
   
    private int quantity;
    
    private Blob image;

    public Product() {
       
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + productID + "\t Name: " + name + "\t Category: " + category + 
                "\t Price " + price + "\t Quantity " + quantity + "\t Description: " + description;
    }

    public Product(int productID, String name, String description, String category, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    

     @Override
    public int compareTo(Product anotherProduct) {
      Integer myId = this.getProductID();
      Integer theirId = anotherProduct.getProductID();
      return myId.compareTo(theirId);
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.productID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.productID != other.productID) {
            return false;
        }
        return true;
    }


} // end class
