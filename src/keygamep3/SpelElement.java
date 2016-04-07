/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 * SpelElement is een abstracte superklasse
 * @author Ruben, Koray, Ruben
 */
public abstract class SpelElement {

    private ImageIcon afbeelding;
    
    /**
     * 
     * @return 
     */
    public abstract ImageIcon getAfbeelding();
    
    /**
     * 
     * @param pincode
     * @return 
     */
    public abstract boolean isToegankelijk(int pincode);
    
    /**
     * 
     * @return 
     */
    public abstract int getPincode();

}
