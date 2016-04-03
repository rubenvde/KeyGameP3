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
public class Speler {
    
    private Dimensie positie;
    private Sleutel zak;
    private ImageIcon spelerAfbeelding;
    private JButton player;
    
    public Speler(Dimensie spelerPos) { // <-- eigenlijk Dimensie positie
        //this.positie = positie;
        this.positie = spelerPos;
        this.spelerAfbeelding = new ImageIcon("Plaatjes/speler.jpg");
        player = new JButton();
        player.setIcon(this.spelerAfbeelding);
        //player.setOpaque(false); we hebben een gif speler nodig!!
        //player.setContentAreaFilled(false);
        //player.setBorderPainted(false);
    }
    
    public Dimensie getPositie(){
        return this.positie;
    }
    
    public void setPositie(Dimensie positie){
        this.positie = positie;
    }
    
    public int getSleutel(){
        int zak = this.zak.getPincode();
        return zak;
    }
    
    public void setSleutel(Sleutel sleutel){
        this.zak = sleutel;
    }
    
    public JButton getPlayerAfbeelding(){
        return this.player;
    }
    
}
