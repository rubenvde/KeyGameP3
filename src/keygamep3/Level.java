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
    private Dimensie dimensie;
    private Speler speler;
    //private Veld[][] speelVeld;

    public Level() {
        
        dimensie = new Dimensie(5,5);
        //speelVeld = new Veld[][];
        //Dit mag dus niet hardcoded
        //speler = new Speler(new Positie(0,0));
        
    }
    
    private void creëerVeld(){
        for (int i = 0; i < dimensie.getX(); i++) {
            for (int j = 0; j < dimensie.getY(); j++) {
                //speelVeld[i][j] = new Veld();
                
            }
        }
    }
    
    public void reset(){
        
    }
    
    public void bereiktEindveld(){
        
    }
    
    public void verplaatsSpeler(){
        
    }
    
    public void spelerSleutelPakken(){
        
    }
}
