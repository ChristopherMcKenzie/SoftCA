package Daos;

import Dtos.Music;
import java.util.ArrayList;

public interface  MusicDaoInterface {
    
    public String PlayMusic(int musicID);
    
    public boolean PostMusic(int UploaderID, String Title, String Genre, double Length, String File);
    
    public ArrayList<Music> GetAllMusic();
    
    
}
