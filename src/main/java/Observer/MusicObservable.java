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
    boolean registerMusicObserver(MusicObservable o);
    boolean removeMusicObserver(MusicObservable o);
    
    // This could have been left out of the interface 
    // (if we didn't want other code to be able to trigger it)
    void notifyMusicObservers();
}
