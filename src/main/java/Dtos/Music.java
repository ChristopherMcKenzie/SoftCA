/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author ben
 */
public class Music {
    private int MusicID;
    private int UploaderID;
    private String Title;
    private String Genre;
    private String File;
    private double MusicLength;
    
     public Music(int MusicId, int UploaderID, String Title, String Genre, String FilePath, double Length) {
        this.MusicID = MusicId;
        this.UploaderID = UploaderID;
        this.Title= Title;
        this.Genre = Genre;
        this.File = FilePath;
        this.MusicLength = Length;
    }

    public int getMusicId() {
        return MusicID;
    }

    public int getUploaderID() {
        return UploaderID;
    }
    
    public String getTitle() {
        return Title;
    }

    public String getGenre() {
        return Genre;
    }

    public double getLength() {
        return MusicLength;
    }

    public String getFilePath() {
        return File;
    }
    

    public void setMusicId(int MusicId) {
        this.MusicID = MusicId;
    }

    public void setUploaderID(int UploaderID) {
        this.UploaderID = UploaderID;
    }
    
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setLength(double Length) {
        this.MusicLength = Length;
    }

    public void setFilePath(String FilePath) {
        this.File = FilePath;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.MusicID;
        hash = 53 * hash + Objects.hashCode(this.Title);
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
        final Music other = (Music) obj;
        if (this.MusicID != other.MusicID) {
            return false;
        }
        if (!Objects.equals(this.Title, other.Title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Music{" + "MusicID=" + MusicID + ", UploaderID=" + UploaderID + ", Title=" + Title + ", Genre=" + Genre + ", File=" + File + ", Length=" + MusicLength + '}';
    }


}
