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

    private int pincode;
    
    private ImageIcon afbeelding;

    public Sleutel(int pincode) {

        this.pincode = pincode;
    }

    @Override
    public ImageIcon getAfbeelding() {
            
        this.afbeelding = new ImageIcon("Plaatjes/sleutel.png");
        return afbeelding;
    }

    public int getPincode() {

        return this.pincode;
    }

    @Override
    public boolean isToegankelijk(int pincode) { // is deze methode voor sleutel nodig?

        return true;
    }

}
