/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 */
public class Barricade extends SpelElement {

    private int pincode;

    public Barricade(int pincode) {
        
        this.pincode = pincode;
        this.afbeelding = new ImageIcon(getClass().getResource("Plaatjes/doors.png"));


    }
    
    public int getPincode() {
        return pincode;
    }

    /**
     *
     * @param pincode
     * @return
     */
    @Override
    public boolean isToegankelijk(int pincode) {
        
        if (pincode == speler.pincode) {        //weet ff niet wat ik hier moet zetten omdat speler class nog niet gemaakt is
            return true;
        } else {
            return false;
        }
    }
}
