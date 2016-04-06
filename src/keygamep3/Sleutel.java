/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;

/**
 *
 * @author Ruben
 */
public class Sleutel extends SpelElement {

    private int pincode;
    
    private ImageIcon afbeelding;

    public Sleutel(int pincode) {

        this.pincode = pincode;
    }

    @Override
    public ImageIcon getAfbeelding() {
            
        this.afbeelding = new ImageIcon("Plaatjes/sleutel.png");
        return afbeelding;
    }

    @Override
    public int getPincode() {

        return this.pincode;
    }

    @Override
    public boolean isToegankelijk(int pincode) { // is deze methode voor sleutel nodig?

        return true;
    }
    
    public static void main(String[] args) {
         Sleutel sleutels = new Sleutel(0);
        JLabel sleutel = new JLabel();
        sleutel.setIcon(sleutels.getAfbeelding());
        
        JFrame frame = new JFrame();
        
        frame.setTitle("LevelGrid");
       
       
        frame.setSize(300, 200);
         
        frame.add(sleutel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
