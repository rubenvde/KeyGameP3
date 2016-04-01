/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 *
 * @author rubenvde
 */
public class Speler {
    
    private Dimensie positie;
    private Sleutel zak;
    private ImageIcon spelerAfbeelding;
    
    public Speler(Dimensie positie) {
        this.positie = positie;
        this.spelerAfbeelding = new ImageIcon("Plaatjes/speler.jpg");
    }
    
    public Dimensie getPositie(){
        return this.positie;
    }
    
    public void setPositie(Dimensie positie){
        this.positie = positie;
    }
    
    public Sleutel getSleutel(){
        return zak;
    }
    
    public void setSleutel(Sleutel sleutel){
        this.zak = sleutel;
    }
    
}
