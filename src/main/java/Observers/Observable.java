/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observers;

/**
 *
 * @author Gerard
 */
public interface Observable {
    boolean registerObserver(Observer o);
    boolean unregisterObserver(Observer o);
    
    void update();
}