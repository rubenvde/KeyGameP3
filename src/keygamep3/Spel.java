/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.*;

import javax.swing.*;

/**
 *
 * @author Ruben
 */

public class Spel {
    private Level[] levels;
    
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGTH = 600;

    public Spel() {
        levels = new Level[5];
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setSize(FRAME_WIDTH, FRAME_HEIGTH);
        
        JPanel paneelKnoppen = new JPanel();
        JPanel levelPaneel = new JPanel();
        
        levelPaneel.setLayout(new GridLayout(10,10));
        levelPaneel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        levelPaneel.setBackground(Color.RED);
        
        paneelKnoppen.setBackground(Color.yellow);
       
        JButton startKnop = new JButton("Start");
        JButton resetKnop = new JButton("Reset");
        paneelKnoppen.add(startKnop);
        paneelKnoppen.add(resetKnop);
        
        
        f.add(paneelKnoppen, BorderLayout.SOUTH);
        f.add(levelPaneel, BorderLayout.CENTER);
    }
    public void startLevel() {
        
    }
    
    
}
