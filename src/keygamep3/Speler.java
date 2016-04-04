/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author rubenvde
 */
public class Speler {
    
    private Dimensie positie;
    private Sleutel zak;
    private ImageIcon spelerAfbeelding;
    private JLabel spelerLabel;

    
    public Speler(Dimensie spelerPos) { // <-- eigenlijk Dimensie spelerPos
        this.positie = spelerPos;
        
        this.zak = new Sleutel(0); // zonder dit kan hij over Barricade lopen, wat niet de bedoeling is
        
        spelerAfbeelding = new ImageIcon("Plaatjes/speler.gif");
        
        spelerLabel = new JLabel();
        spelerLabel.setIcon(this.spelerAfbeelding);
        spelerLabel.setOpaque(false);
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
