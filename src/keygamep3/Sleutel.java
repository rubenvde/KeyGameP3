/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

/**
 *
 * @author Ruben
 */
public class Sleutel extends SpelElement {
    
    private boolean toegankelijk;
    
    public Sleutel() {
        
    }
    
    public boolean isToegankelijk(int pincode) {
        
        toegankelijk = true;
        return toegankelijk;
    }
}
