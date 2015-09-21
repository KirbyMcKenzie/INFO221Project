<%-- 
    Document   : ViewProducts
    Created on : Sep 2, 2015, 7:39:44 PM
    Author     : kirbymckenzie
--%>

<%@page import="java.util.Collection"%>
<%@page import="dao.ProductJdbcDAO"%>
<%@page import="dao.ProductDAO"%>
<%@page import="dao.ProductDAO"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>TimeTravel Novelties | Products</title>
    </head>
    <body>
    <center>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Product Catalog</h1>


        <%
            ProductDAO dao = new ProductJdbcDAO();
            Collection<Product> product;

            String categorySelected = request.getParameter("category");

            if (categorySelected == null || categorySelected.equals("All")) {
                product = new ProductJdbcDAO().getAll();
            } else {
                product = new ProductJdbcDAO().getByCategory(categorySelected);

            }

            Collection<String> categories = new ProductJdbcDAO().getCategories();

        %>

        <form action="ViewProducts.jsp" method="GET">
            <select name="category">
                <option value="All" selected>All</option>
                <% for (String category : categories) {%>
                <option value="<%=category%>"><%=category%></option>
                <%}%>
            </select>
            <button type="submit"> Refine Category</button>
        </form>


    </form>

    <br>

    <form action ="/shop/BuyServlet" >
    <table border="3">

        <thead>
            <tr>
                <th>Category</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Availability</th>
                <th>Purchase </th>
                
            </tr>
        </thead>
        <tbody>
            <% for (Product products : product) {%>
            <tr>

                <td><%= products.getCategory()%></td>
                <td><%= products.getName()%></td>
                <td><%= products.getDescription()%></td>
                <td> $<%= products.getPrice()%></td>
                <td> <%= products.getQuantity()%></td>
                <td> <button type= "submit" name ="productID" value=
                             "<%= products.getProductID() %>" >View Product </button>
                
            
             
            <% }%>
            
            </td>
        </tbody>
    </table>
    </form>
</center>
 
</body>
</html>
