<%-- 
    Document   : LogIn
    Created on : Sep 7, 2015, 3:31:34 PM
    Author     : kirbymckenzie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TimeTravel Novelties | Login </title>
    </head>

    <body>

        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
    <center>
        <h1> Customer Login </h1>

        <br>

        <form action="LoginServlet" method="post">



            <legend>Enter your account details to login</legend>

            <br>

            <label for="txtUsername">Username:</label> <br> 
            <input id="txtUsername" name="username" type="text"> <br> 

            <label for="txtPassword">Password:</label> <br> 
            <input id="txtPassword" name="password" type="password"> <br> 

            <br>

            <button type="submit">Login</button>



        </form>
        
        <br>
        
        don't have an account? <a href= "/shop/CreateAccount.jsp">create one here</a>

    </center>
</body>
</html>
