/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Dtos.User;
/**
 *
 * @author Gerard
 */
public interface UserDaoInterface {
    /**
     * 
     * @param uName
     * @param password
     * @param email
     * @param favGenre
     * @param admin
     * @return true or false based on if the user registerd successfully 
     */
    public boolean registerUser(String uName, String password, String email, String favGenre, int admin);
    /**
     * 
     * @param uName
     * @param password
     * @param admin
     * @return 
     */
    public User loggingUser(String uName, String password, int admin);
    /**
     * 
     * @param id
     * @return User info based on ID
     */
    public User getUser(int id);
    
    
    
}
