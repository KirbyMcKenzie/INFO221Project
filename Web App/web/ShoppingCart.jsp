<%-- 
    Document   : ShoppingCart
    Created on : Sep 22, 2015, 1:46:58 PM
    Author     : kirbymckenzie
--%>

<%@page import="domain.OrderItem"%>
<%@page import="java.util.ArrayList"%>
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
        <h1> Shopping Cart </h1>

        <%
            Order cart = (Order) session.getAttribute("order");

            ArrayList<OrderItem> orderlist = cart.getItems();


        %>

        <table border="3">



            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>



                </tr>
            </thead>
            <tbody>
                <% for (OrderItem orders : orderlist) {%>
                <tr>

                    <td><%= orders.getProduct().getName()%></td>
                    <td><%= orders.getPurchasePrice()%></td>
                    <td><%= orders.getQuantityPurchased()%></td>
                    <td><%= orders.getItemTotal()%></td>

                    <% }%>

                    </td>
            </tbody>
        </table>
    </form>
    
    <a href="/shop/CheckoutServlet">
        <button>Checkout Order</button>
    </a>
    
</center>
</body>
</html>
