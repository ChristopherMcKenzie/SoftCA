<%-- 
    Document   : Reg
    Created on : Dec 23, 2017, 7:57:11 PM
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
         <form name="reg" action="FrontController" method="post" onsubmit="return validateForm();">
                <h3>SIGN-UP NOW</h3>
                
                Username  :  <input name="userName" id="txtUsername" size=30 type="text" maxlength="20" placeholder="Username"  /><span id="namelocation" style="color:red"></span><br>  
                
                
                Password  : <input name="password" id="txtPassword" size=30 type="password" placeholder="Password" /><span id="passwordlocation" style="color:red"></span><br>
                
               
                
               <!--[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$-->
                Email  : <span><input name="email" size=30 type="email" maxlength="30" placeholder="Email" /><span id="emaillocation" style="color:red"></span><br>
                Country : <input name="country" id="txtCountry" size=30 type="text" placeholder="country" /><span id="passwordlocation" style="color:red"></span><br>
                FavGenre : <input name="genre" id="txtFavGenre" size=30 type="text" placeholder="genre" /><span id="passwordlocation" style="color:red"></span><br>
                
                
                <input type="submit" id="btnSubmit" value="Register" />
                
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
                
            </form>
    </body>
</html>
