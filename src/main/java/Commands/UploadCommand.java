/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.MusicDao;
import Dtos.Users;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ben
 */
public class UploadCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            String forwardToJsp = "";
            Users user = new Users();
                String ID = request.getParameter("userID");
                String Title = request.getParameter("Title");
                String Genre = request.getParameter("Genre");
                String Length = request.getParameter("Length");
                // gets absolute path of the web application
                String appPath = "E:\\SoftProject\\SoftCA\\src\\main\\webapp\\Music\\" + Title + ".mp3";

                if (Title != null && Genre != null && Length !=null && !Title.equals("") && !Genre.equals("") && !Length.equals(""))
                {
                    int UploaderID = Integer.parseInt(ID);
                    double MusicLength = Double.parseDouble(Length);
                    HttpSession session = request.getSession();
                    MusicDao musicDao = new MusicDao("musicdatabase");
                    boolean Action = musicDao.PostMusic(user, UploaderID, Title, Genre, MusicLength, appPath);
                    if(Action == true){
                        String msg = "Music Uploaded";
                        session.setAttribute("PlaySuccess", msg);
                        
                        forwardToJsp = "index.jsp";
                        
                    }
                    else if(Action == false)
                    {
                        String msg = " Music Failed ";
                        session.setAttribute("PlaySuccess", msg);
                        
                        
                        forwardToJsp = "index.jsp";
                    } 
                }else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    HttpSession session = request.getSession();

                    
                    session.setAttribute("errorMessage", "A parameter value required for Music Upload was missing");
                }
                
                
                return forwardToJsp;
    }                    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}

