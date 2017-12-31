
package Dtos;
//Author Ben

import Observer.MusicObservable;
import Observer.MusicObserver;
import java.util.ArrayList;


public class Users implements Comparable<Users>, MusicObservable {
    private int UserID;
    private String UserName;
    private String Email;
    private String Password;
    private String FavGenre;
    private int admin;
    private ArrayList<MusicObserver> observers = new ArrayList();
    
    public Users() {
    }
    
    public Users(int UserID,int admin, String UserName, String Email, String Password, String FavGenre){
        this.UserID = UserID;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.FavGenre = FavGenre;
        this.admin = admin;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

   
   
    public String getFavGenre() {
        return FavGenre;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

  
    
    public void setFavGenre(String FavGenre) {
        this.FavGenre = FavGenre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.UserID;
        hash = 47 * hash + (this.UserName != null ? this.UserName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.UserID != other.UserID) {
            return false;
        }
        if ((this.UserName == null) ? (other.UserName != null) : !this.UserName.equals(other.UserName)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Users o) {
        if(this.UserID > o.UserID)
        {
            return +1;
        }
        if(this.UserID < o.UserID)
        {
            return -1;
        }
        else 
            return 0;
    }

    @Override
    public String toString() {
        return "Users{" + "UserID=" + UserID + ", UserName=" + UserName + ", Email=" + Email + ", Password=" + Password + ", FavGenre=" + FavGenre + '}';
    }


    @Override
    public void notifyMusicObservers() {
       for(MusicObserver o : observers){
            o.PlayNewSong();
        }
    }

    @Override
    public boolean registerMusicObserver(MusicObserver o) {
        if(o != null && !observers.contains(o)){
            // Add the new observer
            observers.add(o);
            System.out.println("Adding observer " + o.toString() + " to list of observers for " + UserName + ".");
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMusicObserver(MusicObserver o) {
       if(o!= null && observers.remove(o))
        {
            System.out.println("Removed observer " + o.toString() + " from list of observers for " + UserName + ".");
            return true;
        }
       return false;
    }
    
}
