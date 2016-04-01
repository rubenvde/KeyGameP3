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
public class Muur extends SpelElement {
    
    
    public Muur() {
        
        this.afbeelding = new ImageIcon(getClass().getResource("/Plaatjes/muur.png"));
    }
    
    @Override
    public boolean isToegankelijk(int pincode) {
        
        return false;
    }
    
}
