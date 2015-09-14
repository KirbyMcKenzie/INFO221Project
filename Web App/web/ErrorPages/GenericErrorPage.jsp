<%-- 
    Document   : ErrorPage
    Created on : Sep 14, 2015, 2:45:00 PM
    Author     : kirbymckenzie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>TimeTravel Novelties | Error</title>
    </head>
    <center>
    <body>
        <h1>Sorry, something went wrong</h1>
        
        <br>
        
         <p><%=request.getAttribute("javax.servlet.error.message")%></p>
        <a href="javascript:history.back()">Back</a>
        
        <h2> Please try again later </h2>
        
        <br>
        
        <a href="/shop/index.jsp">
        <button>Return Home</button>
    </a>
    <center>
    </body>
</html>
