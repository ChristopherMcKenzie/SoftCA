<%-- 
    Document   : Login
    Created on : Dec 23, 2017, 7:57:18 PM
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css" href="stylesheet">
            body
            {
                background-color:black;
                color:green;
            }
            a
            {
                text-decoration: none;
                color: white;
                font-size: 15px;
            }
            input
            {
                display:block;
                margin-top:10px;
                margin-left:10px
            }
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
       <form action="FrontController" method="post" onsubmit="return validateForm();">
                <h3>WELCOME BACK TO THE PARTY</h3>
                
                Username  :<input name="userName" size=30 type="text" maxlength="30" placeholder="Username"/> 
                
                
                Password  : <input name="password" size=20 type="password" placeholder="Password"/> 
                
                
                <input type="submit"  value="Login" />
                
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="login" />
                <br />
                <a href='Reg.jsp' >Don't Have a Account? Sign-Up</a>
                
            </form>
    </body>
</html>
