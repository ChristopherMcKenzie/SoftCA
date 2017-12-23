/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.MusicDao;
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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String id = request.getParameter("musicID");
        String title = request.getParameter("musicTitle");
        
        
        if(id != null &&  title != null)
        {
            int mID = Integer.parseInt(id);
            try{
                
                MusicDao mDao = new MusicDao("musicdatabase");
                String FilePath = mDao.PlayMusic(mID);
                if (FilePath != null)
                {
                    session.setAttribute("MusicToPlay", mID);
                    session.setAttribute("MusicTitle", title);
                    forwardToJsp = "index.jsp";
                }
                
                String Full = FilePath;
                File file = new File(Full);
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                
               try{
                Player player = new Player(bis);
                player.play();
                }catch (JavaLayerException ex){}
                
            }catch (InputMismatchException e) {
               forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Text was supplied for parameters is not the right type."); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PlayMusicCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
           {
                    
             forwardToJsp = "error.jsp";   
             session.setAttribute("errorMessage", "A parameter value required for jamming to tunes was missing");
           }
        return forwardToJsp;
    }
    
}
