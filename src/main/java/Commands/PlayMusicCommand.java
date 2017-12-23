/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.MusicDao;
import java.io.File;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
                Media hit = new Media(new File(Full).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(hit);
                mediaPlayer.play();
                
            }catch (InputMismatchException e) {
               forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Text was supplied for parameters is not the right type."); 
            }
        }else
           {
                    
             forwardToJsp = "error.jsp";   
             session.setAttribute("errorMessage", "A parameter value required for jamming to tunes was missing");
           }
        return forwardToJsp;
    }
    
}
