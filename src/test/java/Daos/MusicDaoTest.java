/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Music;
import Dtos.Users;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gerard
 */
public class MusicDaoTest {
    public MusicDao mDao;
    public MusicDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                mDao = new MusicDao("musicdatabase");

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of PlayMusic method, of class MusicDao.
     */
    @Test
    public void testPlayMusic() {
        System.out.println("PlayMusic");
        Users currentUser = new Users(1,1, "BenRose", "ben.rose76@gmail.com","123",  "Ireland");
        int musicID = 1;
        Music expResult = new Music(1,1, "Deju Vu.mp3","Pop", "Music/Deju.Vu.mp3", 4.2);
        Music result = mDao.PlayMusic(currentUser, musicID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of PostMusic method, of class MusicDao.
     */
    @Test
    public void testPostMusic() {
        System.out.println("PostMusic");
        Users currentUser = new Users(1,1, "BenRose", "ben.rose76@gmail.com","123",  "Ireland");
        int UploaderID = 1;
        String Title = "newsong";
        String Genre = "song";
        double Length = 2.0;
        String File = "2";
        MusicDao instance = new MusicDao("musicdatabase");
        boolean expResult = true;
        boolean result = instance.PostMusic(currentUser, UploaderID, Title, Genre, Length, File);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of GetAllMusic method, of class MusicDao.
     */
    @Test
    public void testGetAllMusic() {
        System.out.println("GetAllMusic");

        MusicDao instance = new MusicDao("musicdatabase");
        ArrayList<Music> expResult = null;
        ArrayList<Music> result = instance.GetAllMusic();
        int finalRes = result.size();
        assertEquals(3, finalRes);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
