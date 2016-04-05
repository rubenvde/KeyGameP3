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
public class Veld {
    private boolean isEindveld; // <- nog overna denken
    private SpelElement spelElement;
    
    
    public Veld() {
        this.spelElement = null;

    }
    
    public Veld(SpelElement spelElement) {
        this.spelElement = spelElement;
    }
    
    public void verwijderSpelElement() {
        
        this.spelElement = null;
    }
    
    public SpelElement getSpelElement() {
        return spelElement;
    }
    
    public boolean isBezetBaar(Speler speler){
        if(this.spelElement != null) {
            if(speler.getSleutel() != null) {
                return spelElement.isToegankelijk(speler.getSleutel().getPincode());
            }
            else
            {
                return spelElement.isToegankelijk(0);
            }
        }
        else
        {
            return true;
        }
    }
    
    //Schrijf Spelelement
    public ImageIcon getSpelElementIcon() {
        if(this.spelElement != null) {
            return this.spelElement.getAfbeelding();
        }
        else
        {
            return null;
        }
    }
}
