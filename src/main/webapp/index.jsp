<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music Page</title>
    </head>
    <body>
        <%
                    Object Value2  = session.getAttribute("CurrentUser");
                    UserDao navaccount = new UserDao("musicdatabase");
                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                        
         %>
        <p>
            Hi <%=successUser.getUserName()%>
            
            <%
                }
                %>
                <br> 
            <a href="Reg.jsp">Registration</a><br>
            <a href="Login.jsp">Login</a>
        </p>
        <h1>Player</h1>
         <%
            MusicDao mDao = new MusicDao("musicdatabase");
            ArrayList<Music> allMusic = new ArrayList(mDao.GetAllMusic());
            for (int i = 0; i < allMusic.size(); i++) {
        %>

    <Playlist>
        <form name="SongPlay" action="FrontController" method="play">
        <input type="hidden" name="musicID" value="<%=allMusic.get(i).getMusicId()%>" />
        <input type="hidden" name="musicTitle" value="<%=allMusic.get(i).getTitle()%>" />
        <input type="hidden" name="action" value="Play" />
        <h3><%=(allMusic.get(i)).getTitle()%></h3>
        <input type="submit" value="Play"/>
        </form>
    </Playlist>
        <%
            }
            %>
            
    </body>
</html>
