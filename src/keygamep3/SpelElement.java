/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 */
public abstract class SpelElement {
    
    private ImageIcon afbeelding;
    private int pincode;
    private boolean toegankelijk;
    
    public SpelElement() {
        
        
    }
    
    public boolean isToegankelijk(int pincode) {
        
        this.pincode = pincode;
        if (pincode == Speler.pincode) {
            toegankelijk = true;
        }
        else {
            toegankelijk = false;
        }
        return toegankelijk;
        
    }
    
}
