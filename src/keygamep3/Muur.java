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
    
    private ImageIcon afbeelding;
    
    public Muur() {
        
    }
    
    @Override
    public ImageIcon getAfbeelding() {
        
        this.afbeelding = new ImageIcon("Plaatjes/muur.png");
        return afbeelding;
    }
    
    @Override
    public boolean isToegankelijk(int pincode) {
        
        return false;
    }
    
}
