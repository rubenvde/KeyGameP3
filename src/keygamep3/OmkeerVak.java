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
public class OmkeerVak extends SpelElement {
    
    private ImageIcon afbeelding;

    public OmkeerVak() {

    }

    @Override
    public ImageIcon getAfbeelding() {
            
        this.afbeelding = new ImageIcon("Plaatjes/omkeervak.png");
        return afbeelding;
    }

    @Override
    public int getPincode() {

        return 0;
    }

    @Override
    public boolean isToegankelijk(int pincode) { 
        return true;
    }
    
}
