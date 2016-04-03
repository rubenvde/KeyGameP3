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
    
    OMHOOG(KeyEvent.VK_UP),
    OMLAAG(KeyEvent.VK_DOWN),
    RECHTS(KeyEvent.VK_RIGHT),
    LINKS(KeyEvent.VK_LEFT),
    
    SLEUTELOPPAKKEN(KeyEvent.VK_SPACE);
    
    int keyCode;
    
    
    SpelToetsCode(int keyCode) {
        
        this.keyCode = keyCode;
    }
    
    public int getKeyCode() {
        return keyCode;
    }
    
    public static SpelToetsCode getEnumNaam(int toetsCode) {
        for (SpelToetsCode c : values()) {
            if (c.getKeyCode() == toetsCode) {
                return c;
            }
        }
        return null;
    }
}
    

