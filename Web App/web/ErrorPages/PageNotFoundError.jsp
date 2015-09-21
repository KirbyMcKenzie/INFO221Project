<%-- 
    Document   : PageNotFoundError
    Created on : Sep 14, 2015, 3:51:36 PM
    Author     : kirbymckenzie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>Page not found</title>
    </head>
    <center>
    <body>
        <h1>ERROR 404: PAGE NOT FOUND</h1>
        
        <br>
        
        <h2><%=request.getAttribute("javax.servlet.error.message")%> was not found</h2>
        
        <br>
        
         <img src="https://cammy-marketing.s3.amazonaws.com/2014/12/1424879935/home-alone-boy.jpg" 
             alt="NOT FOUND" width="420" height="400">
        
        
         <br>
         
        <h2> Please check the URL you have entered is valid </h2>

        <br>
        
            <a href="/shop/index.jsp">
        <button> Return Home</button>
    </a>
    </body>
    </center>
</html>
