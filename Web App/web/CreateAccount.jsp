<%-- 
    Document   : CreateAccount
    Created on : Aug 31, 2015, 2:38:07 PM
    Author     : kirbymckenzie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disguised.com | for all your fraudulent needs | Create Account </title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
    <center>
        <h1>Create Account</h1>
     
        <form action="CreateAccountServlet" method="post">

            <legend> <p>Enter your details to register </p> </legend>

            <label for="txtFirstName"> <p> First Name: </p> </label> 
            <input id="txtFirstName" name="firstName" type="text">

            <label for="txtLastName"> <p>Last Name: </p></label>
            <input id="txtLastName" name="lastName" type="text">

            <label for="txtEmal"> <p>Email: </p></label>
            <input id="txtEmail" name="email" type="text"> <br> 

            <label for="txtStreetAddress"> <p>Street Address: </p> </label>
            <input id="txtStreetAddress" name="streetAddress" type="text"> <br> 

            <label for="txtSuburb"> <p>Suburb: </p></label>
            <input id="txtSuburb" name="suburb" type="text"> <br>


            <label for="txtUsername"> <p>Username: </p></label>
            <input id="txtUsername" name="username" type="text"> <br>

            <label for="txtPassword"> <p>Password: </p></label>
            <input id="txtPassword" name="password" type="password"> <br>

            <br>

            <button type="submit">Submit</button>
            
            <br>
            <br>

        </form>
    </center>
</body>
</html>
