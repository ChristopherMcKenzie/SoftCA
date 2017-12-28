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
public class MusicDaoProxyTest {
    public MusicDao mDao;
    public MusicDaoProxyTest() {
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
     * Test of getInstance method, of class MusicDaoProxy.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MusicDaoProxy expResult = null;
        MusicDaoProxy result = MusicDaoProxy.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("");
    }

    /**
     * Test of PlayMusic method, of class MusicDaoProxy.
     */
    @Test
    public void testPlayMusic() {
        System.out.println("PlayMusic");
        Users currentUser = null;
        int musicID = 0;
        MusicDaoProxy instance = new MusicDaoProxy();
        String expResult = "";
        String result = instance.PlayMusic(currentUser, musicID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllMusic method, of class MusicDaoProxy.
     */
    @Test
    public void testGetAllMusic() {
        System.out.println("GetAllMusic");
        Users currentUser = null;
        MusicDaoProxy instance = new MusicDaoProxy();
        ArrayList<Music> expResult = null;
        ArrayList<Music> result = instance.GetAllMusic(currentUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PostMusic method, of class MusicDaoProxy.
     */
    @Test
    public void testPostMusic() {
        System.out.println("PostMusic");
        Users currentUser = null;
        int UploaderID = 0;
        String Title = "";
        String Genre = "";
        double Length = 0.0;
        String File = "";
        MusicDaoProxy instance = new MusicDaoProxy();
        boolean expResult = false;
        boolean result = instance.PostMusic(currentUser, UploaderID, Title, Genre, Length, File);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
