
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
            
                Object Value3 = session.getAttribute("MuSuccess");
                if(Value3!= null) {
                String Successmsg = (String) Value3;
                }
                MusicDao mDao = new MusicDao("musicdatabase");
                Users currentUser = new Users();
                UserDao uDao = new UserDao("musicdatabase");
         
         
            ArrayList<Music> allMusic = new ArrayList();
            allMusic = mDao.GetAllMusic(currentUser);
            for (int i = 0; i < allMusic.size(); i++) {
                
                %>
            <Playlist>
        <form name="SongList" action="FrontController" method="play" enctype="multipart/form-data">
        <input type="hidden" name="musicID" value="<%=allMusic.get(i).getMusicId()%>" />
        <input type="hidden" name="musicTitle" value="<%=allMusic.get(i).getTitle()%>" />
        <input type="hidden" name="action" value="Play" />
        <h3><%=(allMusic.get(i)).getTitle()%></h3>
        <input type="submit" value="Play"/> <br><br>
        </form>
    </Playlist>
        <%
            }

        %>
    </body>
</html>
