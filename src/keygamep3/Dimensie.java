/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

/**
 *
 * @author rubenvde, Koray, Ruben
 */
public class Dimensie {
    private int x;
    private int y;
    
    /**
     * Contructor van Dimensie
     * @param x
     * @param y 
     */
    public Dimensie(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Vraag X op
     * @return 
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Vraag Y op
     * @return 
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Wijzig X
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Wijzig Y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
}
