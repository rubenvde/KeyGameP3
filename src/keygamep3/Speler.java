/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author rubenvde
 */
public class Speler extends JFrame{
    
    private Dimensie positie;
    private Sleutel zak;
    private ImageIcon spelerAfbeelding;
    private JButton button;
    
    public Speler() {//    public Speler(Dimensie positie) {

        
        setSize(300, 400);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.positie = positie;
        //getImage = new ImageIcon("KeyGameP3/build/classes/keygamep3/Plaatjes/speler.jpg").getImage();
        this.spelerAfbeelding = new ImageIcon(getClass().getResource("/Plaatjes/speler.jpg"));
        //this.spelerAfbeelding = getImage;
        button = new JButton(spelerAfbeelding);
        add(button);
        setVisible(true);
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
    
    public static void main(String[] args) {
        
        Speler sp = new Speler();
    }
    
}
