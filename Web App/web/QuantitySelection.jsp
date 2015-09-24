<%-- 
    Document   : BuyProduct
    Created on : Sep 21, 2015, 2:43:58 PM
    Author     : kirbymckenzie
--%>

<%@page import="java.util.Collection"%>
<%@page import="domain.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page import="dao.ProductJdbcDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <title>Disguised.com | for all your fraudulent needs | Select Quantity</title>
    </head>
    <body>
    <center>

        <%
            Product product = (Product) session.getAttribute("product");


        %>

        <br>
        <h1><%= product.getName()%></h1>



        <p><%= product.getName()%></p>
        <p>Price $<%= product.getPrice()%>NZD</p>
        <p> Description:<%= product.getDescription()%></p>

        <br>
        <br>

        <form action="AddToCartServlet" method="post">




            <legend> <h2>Select your desired quantity</h2> </legend>

            <p> Stock Left: <%= product.getQuantity()%></p>

            <label for="txtQuantity"><p> Quantity: </p> </label> 
            <input id="txtQuantity" name="quantity" type="text"> 

            <br>
            <br>

            <button type="submit"> Add to Cart </button>



        </form>


    </center>
</body>
</html>
