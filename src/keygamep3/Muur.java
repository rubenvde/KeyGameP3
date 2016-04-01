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
public class Muur extends SpelElement {
    
    
    public Muur() {
        
        afbeelding = null;
        try {
            afbeelding = ImageIO.read(new File("muur.png"));
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
    
    @Override
    public boolean isToegankelijk(int pincode) {
        
        return false;
    }
    
}
