
package Dtos;
//Author Ben

public class User implements Comparable<User> {
    private int UserID;
    private String UserName;
    private String Email;
    private String Password;
    private String FavGenre;
    
    public User() {
    }
    
    public User(int UserID, String UserName, String Email, String Password, String FavGenre){
        this.UserID = UserID;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.FavGenre = FavGenre;
    }
    
    public User(int UserID, String UserName, String Email, String Password){
        this.UserID = UserID;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
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
        final User other = (User) obj;
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
    public int compareTo(User o) {
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
    
    
    
}
