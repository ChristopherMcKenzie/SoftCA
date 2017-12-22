/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Dtos.Music;
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
    public String PlayMusic(String title) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String song = null;
        try{
           con = getConnection();
            String query = "Select FilePath from music Where Title = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery(); 
        while(rs.next())
            {
                song = rs.getString("FilePath");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getUserbyName() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getUserbyName() method: " + e.getMessage());
            }
        }
        
        return song;
    }

    @Override
    public boolean PostMusic(int MusicId, String Title, String Genre, double Length, String FilePath) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into music (MusicId, Title, Genre, game, Length, FilePath) values(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, Genre);
            ps.setDouble(3, Length);
            ps.setString(4, FilePath);
            
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
    
    
}
