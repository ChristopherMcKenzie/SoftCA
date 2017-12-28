/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.MusicDao;
import Daos.MusicDaoProxy;
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
        String uid = request.getParameter("userID");
        
        if(id != null &&  title != null)
        {
            int mID = Integer.parseInt(id);
            int userID = Integer.parseInt(uid);
            try{
                
                UserDao uDao = new UserDao("muiscdatabase");
                uDao.getUser(userID);
                user.setAdmin(uDao.getUser(userID).getAdmin());
                user.setEmail(uDao.getUser(userID).getEmail());
                user.setFavGenre(uDao.getUser(userID).getFavGenre());
                user.setPassword(uDao.getUser(userID).getPassword());
                user.setUserID(userID);
                user.setUserName(uDao.getUser(userID).getUserName());
                MusicDaoProxy mDao = new MusicDaoProxy();
                String song = mDao.PlayMusic(user, mID);
                if (song != null)
                {
                    session.setAttribute("MusicToPlay", mID);
                    session.setAttribute("MusicTitle", title);
                    forwardToJsp = "Music.jsp";
                }
                
             
                
            }catch(Exception e)
            {
                forwardToJsp = "index.jsp";
                session.setAttribute(title, e);
                
            }
        }else
           {
                    
             forwardToJsp = "error.jsp";   
             session.setAttribute("errorMessage", "A parameter value required for jamming to tunes was missing");
           }
        return forwardToJsp;
    }
    
}
