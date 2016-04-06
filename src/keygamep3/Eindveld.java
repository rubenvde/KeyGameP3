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
public class Eindveld extends SpelElement {
    
    private ImageIcon afbeelding;
    private boolean isEindveld;
    
    public Eindveld() {
        
    }
    
    public boolean isEindveld() {
        return true;
        
    }
    
    public ImageIcon getAfbeelding() {
        this.afbeelding = new ImageIcon("Plaatjes/Eindveld.png");
        return afbeelding;
    }
    
    public boolean isToegankelijk(int pincode) {
        return true;
    }
    
    public int getPincode() {
        return 0;
    }
}
