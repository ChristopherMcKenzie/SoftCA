package Daos;

import Dtos.Music;
import Dtos.Users;
import java.util.ArrayList;

public interface MusicDaoInterface {
    
    /**
     *
     * @param currentUser
     * @param musicID
     * @return Redirects to a page where the music is playing
     */
    public Music PlayMusic(Users currentUser, int musicID);
      
    
    /**
     *
     * @param currentUser
     * @param UploaderID
     * @param Title
     * @param Genre
     * @param Length
     * @param File
     * @return true if the music was posted false if it wasn't
     */
    public boolean PostMusic(Users currentUser, int UploaderID, String Title, String Genre, double Length, String File);
    
    /**
     *
     * @return List of the music available
     */
    public ArrayList<Music> GetAllMusic();
       
}
