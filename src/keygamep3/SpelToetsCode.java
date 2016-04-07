/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.event.KeyEvent;

/**
 * Enumaration class Speltoetscode
 * @author Ruben
 */
public enum SpelToetsCode {
    
    //Omhoog, Omlaag, Rechts, links die met de pijltjestoetsen worden uitgevoerd;
    
    OMHOOG(KeyEvent.VK_UP),
    OMLAAG(KeyEvent.VK_DOWN),
    RECHTS(KeyEvent.VK_RIGHT),
    LINKS(KeyEvent.VK_LEFT),
    //Sleuteloppakken word met de spatieknop uitgevoerd
    SLEUTELOPPAKKEN(KeyEvent.VK_SPACE);
    
    int toetsCode;
    
    /**
     * Constuctor van Speltoetscode
     * @param keyCode 
     */
    SpelToetsCode(int toetsCode) {
        this.toetsCode = toetsCode;
    }
    /**
     * Vraag keycode op
     * @return 
     */
    public int getToetsCode() {
        return toetsCode;
    }
    /**
     * Zoek de juiste Toetscode
     * @param toetsCode
     * @return 
     */
    public static SpelToetsCode getEnumNaam(int toetsCode) {
        for (SpelToetsCode c : values()) {
            if (c.getToetsCode() == toetsCode) {
                //Als de juiste Toetscode is gevonden return die dan
                return c;
            }
        }
        return null;
    }
}
    

