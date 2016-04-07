/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 * Muur is een subclass van Spelelement
 * @author Ruben
 */
public class Muur extends SpelElement {
    
    private ImageIcon afbeelding;
    /**
     * Constructor van Muur
     */
    public Muur() {
        this.afbeelding = new ImageIcon("Plaatjes/muur.png");
    }
    /**
     * Vraag de afbeelding op
     * @return 
     */
    @Override
    public ImageIcon getAfbeelding() {
        return afbeelding;
    }
    /**
     * Gaaf aan dat Muur niet toegankelijk is
     * @param pincode
     * @return 
     */
    @Override
    public boolean isToegankelijk(int pincode) {
        return false;
    }
    /**
     * return 0
     * @return 
     */
    @Override
    public int getPincode(){
        return 0;
    }
    
}
