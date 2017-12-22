package Daos;

import Dtos.Music;
import java.util.ArrayList;

public interface  MusicDaoInterface {
    
    public String PlayMusic(String title);
    
    public boolean PostMusic(int MusicId, String Title, String Genre, double Length, String FilePath);
    
    public Music getMusic(int musicId);
    
    public boolean deleteMusic(int musicId);
    
    public ArrayList<Music> getAllMusic(ArrayList<Music> music);
    
    
}
