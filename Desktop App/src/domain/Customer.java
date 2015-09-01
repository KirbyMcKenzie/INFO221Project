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
public class Customer {

    private String username;
    private String name;
    private String email;
    private String address; 
    private int creditCard;
    private String password;

    public Customer() {
    }

    public Customer(String username, String name, int creditCardDetails, String password) {
        this.username = username;
        this.name = name;
        this.creditCard = creditCardDetails;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditCardDetails() {
        return creditCard;
    }

    public void setCreditCardDetails(int creditCardDetails) {
        this.creditCard = creditCardDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(String username, String name, String email, String address, int creditCardDetails, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.address = address;
        this.creditCard = creditCardDetails;
        this.password = password;
    }
    
    

}// end class
