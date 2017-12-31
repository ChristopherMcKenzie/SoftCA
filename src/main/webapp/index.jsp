<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page import="Observer.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music Page</title>
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
        <%
                    Object Value2  = session.getAttribute("CurrentUser");
                    
                    ArrayList<Users> o = new ArrayList();
                    if (Value2!= null) {
                //        MusicObservable successUser = (Users) Value2;
                  //      o.add((Users)successUser);
                        Users successUser2 = (Users) Value2;
         %>
        <p>
            Hi <%=successUser2.getUserName() %> you have access now.<br>
      
        <form name="Log-out" action="FrontController">
            <input type="hidden" name="action" value="Logout">
            <input type="submit" value="Log-Out of Account"/> <br><br>
        </form>
    
            <%
                }
                Object Value3 = session.getAttribute("PlaySuccess");
                if(Value3!= null) {
                String Successmsg = (String) Value3;
            %>
        <p>
            <%=Successmsg%> 
        </p>
            <%
              }else{
            %>
            <a href="Reg.jsp">Registration</a><br>
            <a href="Login.jsp">Login</a>
            <%
                }
            %>
                
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
        <form name="PlaySong" action="FrontController" method="play" enctype="multipart/form-data">
        <input type="hidden" name="musicID" value="<%=allMusic.get(i).getMusicId()%>" />
        <input type="hidden" name="musicTitle" value="<%=allMusic.get(i).getTitle()%>" />
        <input type="hidden" name="action" value="Play" />
        <h3><%=(allMusic.get(i)).getTitle()%></h3>
        <%
            if (Value2!= null) {
                        Users successUser2 = (Users) Value2; 
                        %>
        <input type="hidden" name="userID" value="<%=successUser2.getUserID()%>"/>
        
        <%
            }
        %>      
        <input type="submit" value="Play"/> <br><br>
        </form>

    

     <%
         }
        %>
        
        <form name="StopSong" action="FrontController" method="play" enctype="multipart/form-data">
           <input type="hidden" name="action" value="Stop" />
           <input type="submit" value="Stop Music"/> <br><br>
        </form>
        </Playlist>
        <%
                    if (Value2!= null) {
                        Users successUser3 = (Users) Value2;
                        
         %>
    <Upload>
     <form name="UploadSong" action="FrontController" method="upload" enctype="multipart/form-data">
        <input type="hidden" name="userID" value="<%=successUser3.getUserID()%>"/>
         Title  :  <input name="Title" id="txtTitle" size=30 type="text"  placeholder="Title"  /><br>  
         Genre  : <input name="Genre" id="txtGenre" size=30 type="text" placeholder="Genre" /><br>
 
         Length: <input type="text" name="Length" size="30" placeholder="Length" /><br>
        <input type="hidden" name="action" value="Upload" />
        <input type="submit" value="Upload"/>
        </form>
    </Upload>
            
            <%
                }
                %>
 

            
    </body>
</html>

