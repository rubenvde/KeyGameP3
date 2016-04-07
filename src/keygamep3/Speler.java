/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Een speler bevind op een Veld in een Level
 * @author rubenvde
 */
public class Speler {
    
    private Dimensie positie;
    private Sleutel zak;
    private ImageIcon spelerAfbeelding;
    private JLabel spelerLabel;

    /**
     * De constructor van Speler
     * @param spelerPos 
     */
    public Speler(Dimensie spelerPos) {
        //De positie van Speler
        this.positie = spelerPos;
        //De inventory van Speler die één Sleutel kan bevatten
        this.zak = new Sleutel(0); // zonder dit kan hij over Barricade lopen, wat niet de bedoeling is
        
        spelerAfbeelding = new ImageIcon("Plaatjes/speler.gif");
        //Maak van Speler een label zodat er een afbeelding bij Speler toegevoegd kan worden
        spelerLabel = new JLabel(this.spelerAfbeelding);
        spelerLabel.setOpaque(false);
    }
    /**
     * Vraag de postie op
     * @return 
     */
    public Dimensie getPositie(){
        return this.positie;
    }
    /**
     * Aangemaakt voor JUNIT testing
     * @param positie 
     */
    public void setPositie(Dimensie positie){
        this.positie = positie;
    }
    /**
     * Vraag de inventory(zak) van Speler op
     * @return 
     */
    public Sleutel getSleutel(){
        return this.zak;
    }
    /**
     * Sleutel word in zak gestopt
     * @param sleutel 
     */
    public void setSleutel(Sleutel sleutel){
        this.zak = sleutel;
    }
    /**
     * Vraag de label waar Speler op gemaakt is op
     * @return 
     */
    public JLabel getSpelerLabel(){
        return this.spelerLabel;
    }
    
}
