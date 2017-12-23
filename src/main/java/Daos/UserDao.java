/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Users;
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
    public boolean registerUser(String uName, String password, String email, String country, String favGenre) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();
            
            String query = "Insert into user(username, email, password, country, favGenre) Values (?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, country);
            ps.setString(5, favGenre);
            
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
    public Users loggingUser(String uName, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;
        
        try{
            con = getConnection();

            String query = "SELECT * from user Where username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            
            while(rs.next())
            {
            u = new Users(rs.getInt("userID"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("country"), rs.getString("FavGenre"));
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
                System.out.println("Exception occured in the finally section of the LogingInUser() method");
                e.getMessage();
                
            }
        }
        return u;
        
    }

    @Override
    public Users getUser(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;
        try
        {
            con = getConnection();
            String query = "Select * from users where username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                u = new Users(rs.getInt("userID"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("country"), rs.getString("favGenre"));
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
                System.out.println("Exception occured in the finally section of the getUser() method: " + e.getMessage());
            }
        }
        
        return u;
    }
    
}
