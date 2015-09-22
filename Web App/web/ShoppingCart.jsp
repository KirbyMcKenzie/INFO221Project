<%-- 
    Document   : ShoppingCart
    Created on : Sep 22, 2015, 1:46:58 PM
    Author     : kirbymckenzie
--%>

<%@page import="domain.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <link rel="stylesheet" type="text/css" href="css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TimeTravel Novelties | Cart</title>
    </head>
    <body>
    <center>
        <h1>Shopping Cart</h1>
        
        <%
        
        Order order = (Order) session.getAttribute("order");
                
                
                %>
        
        
        
    </center>
    </body>
</html>
