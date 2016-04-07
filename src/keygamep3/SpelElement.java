/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 * Abstracte class Spelelement die kan bestaan uit een Barricade, een Muur, een Omkeervak, een Eindveld en een Sleutel
 * Een Spelelement bevind zich op een Veld
 * @author Ruben
 */
public abstract class SpelElement {

    private ImageIcon afbeelding;
 
    /**
     * Elke subklasse moet deze methode hebben om de afbeelding te vragen
     * @return 
     */
    public abstract ImageIcon getAfbeelding();
    
    /**
     * Elke subklasse moet deze methode hebben om de toegankelijkheid te controleren
     * @param pincode
     * @return 
     */
    public abstract boolean isToegankelijk(int pincode);
    
    /**
     * Elke subklasse moet deze methode hebben om de pincode te vragen
     * @return 
     */
    public abstract int getPincode();

}
