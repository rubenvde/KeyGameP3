/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;

/**
 * Een level bestaat uit verschillende velden waar zich Spelelementen en/of een speler kan bevinden
 * @author rubenvde
 */
public class Veld {

    private SpelElement spelElement;

    /**
     * De constructor van Veld zonder Spelelement
     */
    public Veld() {
        this.spelElement = null;

    }

    /**
     * De constructor van Veld met Spelelement
     * @param spelElement
     */
    public Veld(SpelElement spelElement) {
        this.spelElement = spelElement;
    }

    /**
     * Hier verwijder je het Spelelement van het Veld
     */
    public void verwijderSpelElement() {
        this.spelElement = null;
    }
    /**
     * Vraag Spelelement op
     * @return 
     */
    public SpelElement getSpelElement() {
        return spelElement;
    }
    
    /**
     * Check of een Veld bezetbaar is
     * @param speler
     * @return 
     */
    public boolean isBezetBaar(Speler speler) {
        if (this.spelElement != null) {
            if (speler.getSleutel() != null) {
                //Als speler een sleutel heeft dan kan stuur die mee
                return spelElement.isToegankelijk(speler.getSleutel().getPincode());
            } else {
                //Als speler geen sleutel heeft dan stuur dan 0 mee
                return spelElement.isToegankelijk(0);
            }
        } else {
            //Als spelElement een gang is waar door gelopen kan worden
            return true;
        }
    }
    
    /**
     * Schrijf Spelement
     * @return 
     */
    public ImageIcon getSpelElementIcon() {
        if (this.spelElement != null) {
            return this.spelElement.getAfbeelding();
        } else {
            return null;
        }
    }
}
