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
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>TimeTravel Novelties | Login </title>
    </head>

    <body>

        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
    <center>
        <h1> Customer Login </h1>


        <form action="LoginServlet" method="post">



            <legend> <p>Enter your account details to login</p> </legend>



            <label for="txtUsername"><p> Username: </p> </label> 
            <input id="txtUsername" name="username" type="text"> 

            <label for="txtPassword"> <p>Password: </p> </label> 
            <input id="txtPassword" name="password" type="password"> <br>
            

            <br>

            <button type="submit"> Login </button>



        </form>
        
        <br>
        
        <p> don't have an account? <a href= "/shop/CreateAccount.jsp">create one here  </a> </p>

    </center>
</body>
</html>
