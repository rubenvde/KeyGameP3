/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 * Sleutel is een subklasse van SpelElement
 * @author Ruben, Koray, Ruben
 */
public class Sleutel extends SpelElement {

    private int pincode;
    
    private ImageIcon afbeelding;

    /**
     * Constructor Sleutel heeft een pincode
     * @param pincode 
     */
    public Sleutel(int pincode) {
        this.afbeelding = new ImageIcon("Plaatjes/sleutel.png");
        this.pincode = pincode;
    }
    
    /**
     * Vraagt afbeelding
     * @return 
     */
    @Override
    public ImageIcon getAfbeelding() {           
        return afbeelding;
    }
    
    /**
     * Vraagt pincode
     * @return 
     */
    @Override
    public int getPincode() {
        return this.pincode;
    }

    /**
     * Geeft aan dat sleutel altijd toegankelijk is 
     * @param pincode
     * @return 
     */
    @Override
    public boolean isToegankelijk(int pincode) {
        return true;
    }
}
