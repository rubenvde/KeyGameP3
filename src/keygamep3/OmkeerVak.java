/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 * Omkeervak is een subclass van Spelelement
 * @author Ruben
 */
public class OmkeerVak extends SpelElement {
    
    private ImageIcon afbeelding;
    /**
     * De constuctor van Omkeervak
     */
    public OmkeerVak() {
        this.afbeelding = new ImageIcon("Plaatjes/omkeervak.png");
    }
    /**
     * Vraag een afbeelding op
     * @return 
     */
    @Override
    public ImageIcon getAfbeelding() {
        return afbeelding;
    }
    /**
     * Return 0;
     * @return 
     */
    @Override
    public int getPincode() {
        return 0;
    }
    /**
     * Geef aan dat Omkeervak toegankelijk is
     * @param pincode
     * @return 
     */
    @Override
    public boolean isToegankelijk(int pincode) { 
        return true;
    }
    
}
