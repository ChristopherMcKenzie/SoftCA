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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean PostMusic(int MusicId, String Title, String Genre, double Length, String FilePath) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into music (MusicId, Title, Genre, Length, FilePath) values(?,?,?,?)";
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

    @Override
    public Music getMusic(int musicId) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = null;
        ResultSet rs = null;
        Music m = null;
        try{
            con = getConnection();

            query = "Select * from music where MusicId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, musicId);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                m = new Music(rs.getInt("MusicId"), rs.getString("Title"), rs.getString("Genre"), rs.getDouble("Length"), rs.getString("Filepath"));
            }
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the getMusic(id) method: " + e.getMessage());
            
        } finally {
            try {
                if(rs != null)
                {
                    rs.close();
                }
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
        return m;
       
    }

    @Override
    public boolean deleteMusic(int musicId) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "DELETE from music where MusicId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, musicId);
            
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
        else
        {
            return false;
        }
    }

    @Override
    public ArrayList<Music> getAllMusic(ArrayList<Music> music) {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Music> musics = new ArrayList();
        ResultSet rs = null;
        
        try{
            con = getConnection();

            String query = "SELECT * FROM music into music";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            
            while(rs.next())
            {
                Music m = new Music(rs.getInt("MusicId"), rs.getString("Title"), rs.getString("Genre"), rs.getDouble("Length"), rs.getString("Filepath"));
                musics.add(m);    
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the PostMusic() method: " + e.getMessage());
            
        } finally {
            try {
                if(rs != null)
                {
                    rs.close();
                }
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
       return musics;
    }
    
    
}
