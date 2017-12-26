/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.MusicDao;
import Daos.UserDao;
import Dtos.Users;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
/**
 *
 * @author ben
 */
public class PlayMusicCommand implements Command{
    
    Users user = new Users();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String id = request.getParameter("musicID");
        String title = request.getParameter("musicTitle");
        String userID = request.getParameter("userID");
        
        if(id != null &&  title != null)
        {
            int mID = Integer.parseInt(id);
            
            try{
                UserDao uDao = new UserDao("muiscdatabase");
                MusicDao mDao = new MusicDao("musicdatabase");
                String FilePath = mDao.PlayMusic(user, mID);
                if (FilePath != null)
                {
                    session.setAttribute("MusicToPlay", mID);
                    session.setAttribute("MusicTitle", title);
                    forwardToJsp = "CurrentSong.jsp";
                }
                
             
                
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }else
           {
                    
             forwardToJsp = "error.jsp";   
             session.setAttribute("errorMessage", "A parameter value required for jamming to tunes was missing");
           }
        return forwardToJsp;
    }
    
}
