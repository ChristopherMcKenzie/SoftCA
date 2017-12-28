/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Users;
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
public class UserDaoTest {
    public UserDao uDao;
    public UserDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        uDao = new UserDao("musicdatabase");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerUser method, of class UserDao.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String uName = "Chris";
        String password = "123";
        String email = "chris";
        String FavGenre = "dsa";
        UserDao instance = null;
        boolean expResult = true;
        boolean result = uDao.registerUser(uName, password, email, FavGenre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of loggingUser method, of class UserDao.
     */
    @Test
    public void testLoggingUser() {
        System.out.println("loggingUser");
        String uName = "BenRose";
        String password = "123";
       
        Users expResult = new Users(1,1, "BenRose", "ben.rose76@gmail.com", "123", "Ireland");
        Users result = uDao.loggingUser(uName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUser method, of class UserDao.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 1;
        
        Users expResult = new Users(1,1, "BenRose", "ben.rose76@gmail.com", "123", "Ireland");
        Users result = uDao.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
