/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ruben
 */
public class Barricade extends SpelElement {

    private int pincode;

    public Barricade(int pincode) {
        
        this.pincode = pincode;
        afbeelding = null;
        try {
            afbeelding = ImageIO.read(new File("doors.png"));
        } catch (IOException e) {
            System.out.println("Error");
        }


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
