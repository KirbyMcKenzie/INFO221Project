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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
 <%
    
  ProductDAO dao = new ProductJdbcDAO(); 
  
  Collection<Product> product = dao.getAll();
 
  //Product products = new Product(2365,"Productt","description bruh","categories bruh",2.00,1) ;
                      
%>

<table> 
    
         <% 
  
            for (Product products : product) { 
         
         %>
            
            <tr>
                
              <td><%= products.getProductID()%></td>
              <td><%= products.getName()%></td>
              <td><%= products.getDescription()%></td>
              
              
</tr> 

<% } %>

</table>

    </body>
</html>
