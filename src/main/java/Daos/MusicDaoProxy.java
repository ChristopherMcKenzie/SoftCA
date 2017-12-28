/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import java.util.*;
import Dtos.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class MusicDaoProxy implements MusicDaoInterface{

    private MusicDao musicDao;    
    private static volatile MusicDaoProxy singleProxyInstance;
    
    public static MusicDaoProxy getInstance()
    {
        if(singleProxyInstance == null)
        {
            synchronized(MusicDaoProxy.class)
            {
                if(singleProxyInstance == null)
                {
                    singleProxyInstance = new MusicDaoProxy();
                }
            }
        }
        return singleProxyInstance;
    }
    private MusicDaoProxy()
    {
        musicDao = new MusicDao("musicdatabase");
    }
    @Override
    public String PlayMusic(Users currentUser, int musicID) {
        if(currentUser.getUserID() == 0)
        {
            return musicDao.PlayMusic(currentUser, musicID);
        }
        else
        {
            return null;
        }
    }

    

    @Override
    public ArrayList<Music> GetAllMusic(Users currentUser){
        if(currentUser.getUserID() == 0)
        {
            return musicDao.GetAllMusic(currentUser);
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean PostMusic(Users currentUser, int UploaderID, String Title, String Genre, double Length, String File) {
        if(currentUser.getAdmin() == 0)
        {
            musicDao.PostMusic(currentUser, UploaderID, Title, Genre, Length, File);
            
        }
        else
        {
            return false;
        }
        return false;
    }
    
}