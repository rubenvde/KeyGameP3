/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Klas Spel, implementeert ActionListener
 * @author Ruben, Koray, Ruben
 */

public class Spel implements ActionListener{
    
    private final int FRAME_BREEDTE = 300;
    private final int FRAME_HOOGTE = 100;
    
    private JFrame frame;

    private JButton openLevel;
    
    /**
     * Constructor Spel
     */
    public Spel(){
        frame = new JFrame();
        frame.setTitle("KeyGame");
        frame.setSize(FRAME_BREEDTE, FRAME_HOOGTE);
        
        openLevel = new JButton("Open level");
        openLevel.addActionListener(this);
        
        frame.add(openLevel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    /**
     * Implementatie van de abstracte methode van ActionListener
     * @param event 
     */
    @Override
        public void actionPerformed(ActionEvent event) {   
            if(event.getSource() == openLevel){// StartKnop
                FileDialog fd = new FileDialog(frame, "Test", FileDialog.LOAD);
                fd.setDirectory("levels/");
                fd.setVisible(true);
                startLevel(fd.getDirectory() + fd.getFile());
            }
            frame.revalidate();
            frame.repaint();
        }
    
    /**
     * Deze methode start de gevraagde level
     * @param pad 
     */    
    public void startLevel(String pad) {
        Level l = new Level(pad);
    }
}