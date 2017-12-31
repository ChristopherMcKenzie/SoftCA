
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>

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
            #txtLength,#txtGenre,#txtTitle, #file
            {
                margin-top:10px;
                margin-left:10px
            }
            
        </style>
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
                //MusicObserver successmusic = (Music) Value3;
                MusicDaoProxy mDao = new MusicDaoProxy();
                Users currentUser = new Users();
                UserDao uDao = new UserDao("musicdatabase");
                

           %>
           <p>
               Current song is: <%=successmusic.toString()%>
           </p>
           <%
               //<p>successmusic.PlayNewSong()</p>
               }

           %>
              
           
    </body>
</html>
