/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 *Eindveld is een subklasse van SpelElement
 * @author Ruben, Koray, Ruben
 */
public class Eindveld extends SpelElement {
    
    private ImageIcon afbeelding;
    
    /**
     * Constructor Eindveld
     */
    public Eindveld() {
       this.afbeelding = new ImageIcon("Plaatjes/Eindveld.png"); 
    }
    
    /**
     * vraagt afbeelding van Eindveld
     * @return 
     */
    public ImageIcon getAfbeelding() {
        return afbeelding;
    }
    
    /**
     * 
     * @param pincode
     * @return 
     */
    public boolean isToegankelijk(int pincode) {
        return true;
    }
    
    public int getPincode() {
        return 0;
    }
}
