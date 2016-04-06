/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class Barricade extends SpelElement {

    private int pincode;
    
    private ImageIcon afbeelding;

    public Barricade(int pincode) {
        
        this.pincode = pincode;
    }
    
    @Override
    public ImageIcon getAfbeelding() {
        
        this.afbeelding = new ImageIcon("Plaatjes/doors.png");
        return afbeelding;
    }
    
    @Override
    public int getPincode() {

        return this.pincode;
    }

    /**
     *
     * @param pincode
     * @return
     */
    @Override
    public boolean isToegankelijk(int pincode) { 
                                       
        if(this.pincode != pincode){
            JOptionPane.showMessageDialog(null, "Deze sleutel past niet!", "", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
}
