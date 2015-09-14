/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author kirbymckenzie
 */
public class Customer {

    private String username;

    public Customer(String username, String password, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }
    
    @NotNull(message = "Please provide your first name")
    @NotBlank(message="Please provide your first name")
    @Length(min=2, message="your first name must contain at least two characters.")
    private String firstName;
    
    @NotNull(message = "Last name must be provided.")
    @NotBlank(message="Last name must be provided.")
    @Length(min=2, message="your last name must contain at least two characters.")
    private String lastName;
    
    @NotNull(message = "Email must be provided.")
    @NotBlank(message="Email must be provided.")
    private String email;
    
    @NotNull(message = "Address must be provided.")
    @NotBlank(message="Address must be provided.")
    private String streetAddress;
    
    @NotNull(message = "Suburb must be provided.")
    @NotBlank(message="Suburb must be provided.")
    private String suburb;
    
    @NotNull(message = "Password must be provided.")
    @NotBlank(message="Password must be provided.")
    private String password;

    public Customer() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer(String username, String firstName, String lastName, String email, 
            String streetAddress, String suburb, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.password = password;
    }

    
    

    

}// end class
