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
    private int creditCardDetails;
    private String password;

    public Customer() {
    }

    public Customer(String username, String name, int creditCardDetails, String password) {
        this.username = username;
        this.name = name;
        this.creditCardDetails = creditCardDetails;
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
        return creditCardDetails;
    }

    public void setCreditCardDetails(int creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "username=" + username + ", name=" + name + ", creditCardDetails=" + creditCardDetails + ", password=" + password + '}';
    }

}// end class
