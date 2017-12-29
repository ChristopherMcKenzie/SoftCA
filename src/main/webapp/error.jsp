
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
            <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
      
        <title>Error</title>
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
            #txtLength,#txtGenre,#txtTitle, #file
            {
                margin-top:10px;
                margin-left:10px
            }
            
        </style>
    </head>
    <body>
        <div id="wrapper">
         <header>    
        <h1>Something went wrong</h1>

         </header>
         <article>
        <%
            
            Object msg = session.getAttribute("errorMessage");
           
            String error = (String) msg;
            
%>

        <h3> <%=error%> </h3>
        <%
          
            session.removeAttribute("errorMessage");
            
%> 

<a href="javascript:history.back()" class="button">Back</a>
         </article>
        </div>
    </body>
</html>
