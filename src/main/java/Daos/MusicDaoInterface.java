package Daos;

import Dtos.Music;
import java.util.ArrayList;

public interface  MusicDaoInterface {
    
    public String PlayMusic(int musicID);
    
    public boolean PostMusic(int UploaderID, String Title, String Genre, String File, double MusicLength);
    
    public ArrayList<Music> GetAllMusic();
    
    
}
