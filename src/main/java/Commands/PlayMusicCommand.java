/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.MusicDao;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ben
 */
public class PlayMusicCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        
        if(title != null && title.equals(""))
        {
            try{
                
                MusicDao mDao = new MusicDao("musicdatabase");
                String FilePath = mDao.PlayMusic(title);
                if (FilePath.equals("") || FilePath != null)
                {
                    session.setAttribute("MusicToPlay", title);
                    forwardToJsp = "index.jsp";
                }
                
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
