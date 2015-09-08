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
        <title>Customer Login</title>
    </head>
    <body>

        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <form action="LogInServlet" method="post">
            <fieldset>
                <br>

                <legend>Enter your details to log in bruh</legend>


                <label for="txtUsername">Username:</label> <br> 
                <input id="txtUsername" name="username" type="text"> <br> 

                <label for="txtPassword">Password:</label> <br> 
                <input id="txtPassword" name="password" type="password"> <br> 


                <button type="submit">Submit</button>

            </fieldset>

        </form>

    </body>
</html>
