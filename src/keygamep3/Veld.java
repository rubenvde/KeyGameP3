/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

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
}
