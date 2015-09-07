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
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Create Account</h1>
    </body>


    <form action="CreateAccountServlet" method="post">
        <fieldset>

            <legend>Enter your details to register</legend>


            <label for="txtUsername">Username:</label> <br> 
            <input id="txtUsername" name="username" type="text"> <br> 

            <label for="txtName">Name:</label> <br> 
            <input id="txtName" name="name" type="text"> <br> 

            <label for="txtEmal">Email:</label> <br> 
            <input id="txtEmail" name="email" type="text"> <br> 

            <label for="txtAddress">Address:</label> <br> 
            <input id="txtAddress" name="address" type="text"> <br> 

            
            <label for="txtPassword">Password:</label> <br> 
            <input id="txtPassword" name="password" type="password"> <br> 


            <button type="submit">Submit</button>

        </fieldset>

    </form>

</html>
