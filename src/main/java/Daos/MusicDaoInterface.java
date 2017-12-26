package Daos;

import Dtos.Music;
import Dtos.Users;
import java.util.ArrayList;

public interface MusicDaoInterface {
    
    public String PlayMusic(Users currentUser, int musicID);
    
    public boolean PostMusic(Users currentUser, int UploaderID, String Title, String Genre, double Length, String File);
    
    public ArrayList<Music> GetAllMusic(Users currentUser);
    
 
    
}
