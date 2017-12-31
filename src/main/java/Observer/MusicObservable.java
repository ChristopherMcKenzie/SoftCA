/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author ben
 */
public interface MusicObservable {
    boolean registerMusicObserver(MusicObserver o);
    boolean removeMusicObserver(MusicObserver o);
    
  
    void notifyMusicObservers();
}
