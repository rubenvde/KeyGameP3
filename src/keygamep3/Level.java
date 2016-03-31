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
    
    
    
    public Level(Spel spel, Veld[][] sV) {
        this.spel = spel;
        
        //Speelveld moet aangemaakt worden door level
        this.speelVeld = sV;
        
    }
    
    //Moet misschien ook in construtor? Geen speler, geen spel met level?
    public void creerSpeler(Positie p) {
        this.speler = new Speler(p);
    }
    
}
