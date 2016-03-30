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
public class Level {
    private int veldGrootte;
    private Speler speler;
    private Spel spel;
    private Veld[][] speelVeld;
    
    
    
    public Level(Spel spel) {
        this.spel = spel;
        
        //Dit mag dus niet hardcoded
        //speler = new Speler(new Positie(0,0));
        
    }
}
