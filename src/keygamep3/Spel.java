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
 *
 * @author Ruben
 */

public class Spel{
    
    private final int FRAME_WIDTH = 300; // Hier moeten we nog over nadenken
    private final int FRAME_HEIGTH = 100;// Hier moeten we nog over nadenken
    
    private JFrame frame;

    JButton openLevel;
    
    public Spel(){
        frame = new JFrame();
        frame.setTitle("KeyGame");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGTH);
        
        openLevel = new JButton("Open Level");
        openLevel.addActionListener(new KnopActie());
        
        frame.add(openLevel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
    
    // Inner Class knopActie voor de knoppen Start en Reset
    class KnopActie implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent event)
        {   
            if(event.getSource() == openLevel){// StartKnop
                FileDialog fd = new FileDialog(frame, "Test", FileDialog.LOAD);
                fd.setDirectory("levels/");
                fd.setVisible(true);
                startLevel(fd.getDirectory() + fd.getFile());
                //add(levels[0].getLevel(), BorderLayout.CENTER);//hier komt een level van de classe Level
            }
            frame.revalidate();
            frame.repaint();
        }
    }

    public void startLevel(String pad) {
        Level l = new Level(pad);
    }
}
