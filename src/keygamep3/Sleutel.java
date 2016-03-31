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
public class Sleutel extends SpelElement {
    
    private ImageIcon afbeelding;
    private int pincode;
    
    public Sleutel(int pincode) {
        
        this.pincode = pincode;
        afbeelding = new ImageIcon(GetClass().GetResource("sleutel.png"));
        
    }
    
    @Override
    public boolean isToegankelijk(int pincode) {
        
        return true;
    }

}
