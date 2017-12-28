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
                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                        
         %>
        <p>
            Hi <%=successUser.getUserName()%> you have access now.<br>
            
            <%
                }
            %>
            <%
                Object Value3 = session.getAttribute("MuSuccess");
                if(Value3!= null) {
                String Successmsg = (String) Value3;
            %>
        <p>
            <%=Successmsg%> 
        </p>
            <%
                }
            %>

            <a href="Reg.jsp">Registration</a><br>
            <a href="Login.jsp">Login</a>
        </p>
        <h1>Player</h1>
         <%
            Users user = new Users();
            UserDao uDao = new UserDao("musicdatabase");
            MusicDaoProxy mDao = new MusicDaoProxy();
            
            
            ArrayList<Music> allMusic = new ArrayList();
            allMusic = mDao.GetAllMusic();
            for (int i = 0; i < allMusic.size(); i++) {
        %>

    <Playlist>
        <form name="SongUpload" action="FrontController" method="play" enctype="multipart/form-data">
        <input type="hidden" name="musicID" value="<%=allMusic.get(i).getMusicId()%>" />
        <input type="hidden" name="musicTitle" value="<%=allMusic.get(i).getTitle()%>" />
        <input type="hidden" name="action" value="Play" />
        <h3><%=(allMusic.get(i)).getTitle()%></h3>
        <input type="submit" value="Play"/> <br><br>
        </form>
    </Playlist>

     <%
         }
                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                        
         %>
    <Upload>
     <form name="UploadSong" action="FrontController" method="upload">
        <input type="hidden" name="userID" value="<%=successUser.getUserID()%>"/>
         Title  :  <input name="Title" id="txtTitle" size=30 type="text"  placeholder="Title"  /><br>  
         Genre  : <input name="Genre" id="txtGenre" size=30 type="text" placeholder="Genre" /><br>
         Song: <input type="file" name="file" size="50"/><br>
         Length: <input type="text" name="Length" size=30 type="text" placeholder="Length" /><br>
        <input type="hidden" name="action" value="Upload" />
        <input type="submit" value="Upload"/>
        </form>
    </Upload>
            
            <%
                }
                %>
 

            
    </body>
</html>
