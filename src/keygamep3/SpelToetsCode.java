/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.event.KeyEvent;

/**
 *
 * @author Ruben
 */
public enum SpelToetsCode {
    
    //Omhoog, Omlaag, Rechts, links;
    
    Omhoog(KeyEvent.VK_UP),
    Omlaag(KeyEvent.VK_DOWN),
    Rechts(KeyEvent.VK_RIGHT),
    Links(KeyEvent.VK_LEFT),
    
    SleutelOppakken(KeyEvent.VK_SPACE);
    
    private int keyCode;
    
    private SpelToetsCode(int keyCode) {
        
        this.keyCode = keyCode;
    }
    
    public int getKeyCode() {
        return keyCode;
    }}
    

