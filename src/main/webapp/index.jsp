<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Music"%>
<%@page import="Daos.MusicDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music Page</title>
    </head>
    <body>
        <h1>Player</h1>
         <%
            MusicDao mDao = new MusicDao("musicdatabase");
            ArrayList<Music> allMusic = new ArrayList(mDao.GetAllMusic());
            for (int i = 0; i < allMusic.size(); i++) {
        %>
    <Playlist>
        <h3><%=(allMusic.get(i)).getTitle()%></h3>
    </Playlist>
        <%
            }
            %>
    </body>
</html>
