/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Barricade is een subclass van Spelelement
 * @author Ruben
 */
public class Barricade extends SpelElement {

    private int pincode;
    
    private ImageIcon afbeelding;
    /**
     * De constructor van Barricade
     * @param pincode 
     */
    public Barricade(int pincode) {
        this.afbeelding = new ImageIcon("Plaatjes/barricade.png");
        this.pincode = pincode;
    }
    /**
     * Vraag een afbeelding op
     * @return 
     */
    @Override
    public ImageIcon getAfbeelding() {
        return afbeelding;
    }
    /**
     * Vraag pincode op
     * @return 
     */
    @Override
    public int getPincode() {
        return this.pincode;
    }

    /**
     * Vraag op of Barricade toegankelijk is
     * @param pincode
     * @return
     */
    @Override
    public boolean isToegankelijk(int pincode) { 
        //vergelijk de pincode van barricade met die van speler                               
        if(this.pincode != pincode){
            //Als de pincode niet klopt word er een scherm getoond 
            JOptionPane.showMessageDialog(null, "U heeft de juiste sleutel nodig om de barricade te openen!", "", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
}
