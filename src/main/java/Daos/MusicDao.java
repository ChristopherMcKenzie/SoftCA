/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Dtos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ben
 */
public class MusicDao extends Dao implements MusicDaoInterface{

    public MusicDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public String PlayMusic(Users currentUser, int musicID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String song = null;
        try{
           con = getConnection();
            String query = "Select title from music Where MusicID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, musicID);
            rs = ps.executeQuery(); 
        while(rs.next())
            {
                song = rs.getString("title");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the PlayMusic() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occured in the finally section of the PlayMusic() method: " + e.getMessage());
            }
        }
        
        return song;
    }

    @Override
    public boolean PostMusic(Users currentUser,int UploaderID, String Title, String Genre, double Length, String File) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into music (UploaderID, Title, Genre, File, MusicLength) values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, UploaderID);
            ps.setString(2, Title);
            ps.setString(3, Genre);
            ps.setString(4, File);
            ps.setDouble(5, Length);
            
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the PostMusic() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the final part of PostMusic()");
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
    public ArrayList<Music> GetAllMusic(Users currentUser) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Music> music = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from music";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Music m = new Music(rs.getInt("MusicID"), rs.getInt("UploaderID"), rs.getString("Title"), rs.getString("Genre"), rs.getString("File"), rs.getDouble("MusicLength"));
                music.add(m);
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the GetAllMusic() method: " + e.getMessage());
        } finally {
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
                System.out.println("Exception occurred in the final part of GetAllMusic(): " + e.getMessage());
            }
        }
        return music;
    }

   
    
    
    
}
