
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                    Object Value2  = session.getAttribute("CurrentUser");
                    if (Value2!= null) {
                        Users successUser = (Users) Value2;
                    }
            
                Object Value3 = session.getAttribute("PlaySuccess");
                if(Value3!= null) {
                String successmusic = (String) Value3;
                
                MusicDaoProxy mDao = new MusicDaoProxy();
                Users currentUser = new Users();
                UserDao uDao = new UserDao("musicdatabase");
                
           %>
           <p>
               Current song is: <%=successmusic.toString()%>
           </p>
           <%
               }

           %>
              
           
    </body>
</html>
