/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 */
public abstract class SpelElement {

    private ImageIcon afbeelding;
    
    public abstract ImageIcon getAfbeelding();
        
    

    public abstract boolean isToegankelijk(int pincode);

}
