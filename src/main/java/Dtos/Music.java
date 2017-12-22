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
    private int MusicId;
    private String Title;
    private String Genre;
    private double Length;
    private String FilePath;
    
     public Music(int MusicId, String Title, String Genre, double Length, String FilePath) {
        this.MusicId = MusicId;
        this.Title= Title;
        this.Genre = Genre;
        this.Length = Length;
        this.FilePath = FilePath;
    }

    public int getMusicId() {
        return MusicId;
    }

    public String getTitle() {
        return Title;
    }

    public String getGenre() {
        return Genre;
    }

    public double getLength() {
        return Length;
    }

    public String getFilePath() {
        return FilePath;
    }
    

    public void setMusicId(int MusicId) {
        this.MusicId = MusicId;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setLength(double Length) {
        this.Length = Length;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.MusicId;
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
        if (this.MusicId != other.MusicId) {
            return false;
        }
        if (!Objects.equals(this.Title, other.Title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Music{" + "MusicId=" + MusicId + ", Title=" + Title + ", Genre=" + Genre + ", Length=" + Length + ", FilePath=" + FilePath + '}';
    } 
}
