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
public class Barricade extends SpelElement {

    private int pincode;
    private Speler speler; // Nodig???
    private ImageIcon afbeelding;

    public Barricade(int pincode) {
        
        this.pincode = pincode;
    }
    
    @Override
    public ImageIcon getAfbeelding() {
        
        this.afbeelding = new ImageIcon("Plaatjes/doors.png");
        this.afbeelding.setDescription("barricade");
        return afbeelding;
    }

    /**
     *
     * @param pincode
     * @return
     */
    @Override
    public boolean isToegankelijk(int pincode) { //<- waarom hebben we hier een pincode? 
                                            // hieronder hebben we toch al een getPincode van Speler....
        return this.pincode == pincode; //speler.getSleutel().getPincode(); <- is dit wel nodig?
        
    }
}
