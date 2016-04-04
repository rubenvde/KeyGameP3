/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;

/**
 *
 * @author rubenvde
 */
public class Speler {
    
    private Dimensie positie;
    private Sleutel zak;
    private ImageIcon afbeelding, spelerAfbeelding;
    private Image spelerImageConver, newspelerImage;
    private JLabel spelerLabel;

    
    public Speler(Dimensie spelerPos) { // <-- eigenlijk Dimensie spelerPos
        this.positie = spelerPos;
        spelerLabel = new JLabel();
        
        spelerAfbeelding = new ImageIcon("Plaatjes/speler.gif");
        spelerLabel.setIcon(this.spelerAfbeelding);
        spelerLabel.setOpaque(false); //we hebben een gif speler nodig!!
    }
    
    public Dimensie getPositie(){
        return this.positie;
    }
    
    public void setPositie(Dimensie positie){
        this.positie = positie;
    }
    
    public Sleutel getSleutel(){
        return this.zak;
    }
    
    public void setSleutel(Sleutel sleutel){
        this.zak = sleutel;
    }
    
    public JLabel getSpelerLabel(){
        return this.spelerLabel;
    }
    
}
