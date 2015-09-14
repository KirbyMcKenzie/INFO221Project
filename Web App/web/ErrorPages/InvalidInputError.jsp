<%-- 
    Document   : InvalidInputError
    Created on : Sep 14, 2015, 3:43:18 PM
    Author     : kirbymckenzie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>Error</title>
    </head>

    <center>
        <body>
            <h1>Sorry, something went wrong</h1>

            <br>

            <p><%=request.getAttribute("javax.servlet.error.message")%></p>

            <a href="javascript:history.back()">
                <button>Back</button>
            </a>


            <br>
    </center>
</body>
</html>
