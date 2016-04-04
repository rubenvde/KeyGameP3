/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author rubenvde
 */
public class Speler extends JButton{
    
    private Dimensie positie;
    private Sleutel sleutel;
    private int zak;
    private ImageIcon spelerAfbeelding;
    
    public Speler(Dimensie spelerPos) { // <-- eigenlijk Dimensie spelerPos
        //this.positie = positie;
        this.positie = spelerPos;
        this.spelerAfbeelding = new ImageIcon("Plaatjes/speler.jpg");
        this.setIcon(this.spelerAfbeelding);
        //this.setOpaque(false); //we hebben een gif speler nodig!!
        //this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
    }
    
    public Dimensie getPositie(){
        return this.positie;
    }
    
    public void setPositie(Dimensie positie){
        this.positie = positie;
    }
    
    public int getSleutel(){
        this.zak = this.sleutel.getPincode();
        return zak;
    }
    
    public void setSleutel(Sleutel sleutel){
        this.zak = sleutel.getPincode();
    }
    
}
