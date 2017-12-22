/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gerard
 */
public class UserDao extends Dao implements UserDaoInterface{

    public UserDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public boolean registerUser(String uName, String password, String email, String favGenre, int admin) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();
            
            String query = "Insert into user(username, email, password, favGenre) Values (?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, favGenre);
            
            rowsAffected = ps.executeUpdate();
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the RegistorUser() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the RegistorUser() method");
                e.getMessage();
                
            }
        }
        if(rowsAffected > 0)
        {
        return true;
        }
        else{
            return false;
        }
        
    }

    @Override
    public User loggingUser(String uName, String password, int admin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        
        try{
            con = getConnection();

            String query = "SELECT * from users Where username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            
            while(rs.next())
            {
            u = new User(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getString("FavGenre"), rs.getInt("admin"));
            }
 
        }catch (SQLException e) {
            System.out.println("Exception occured in the LogingInUser() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the RemoveUser() method");
                e.getMessage();
                
            }
        }
        return u;
        
    }

    @Override
    public User getUser(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try
        {
            con = getConnection();
            String query = "Select * from users where ID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("favGenre"), rs.getInt("admin"));
            }
            
        }catch(SQLException e){
        
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the GetAuthorByID() method: " + e.getMessage());
            }
        }
        
        return u;
    }
    
}
