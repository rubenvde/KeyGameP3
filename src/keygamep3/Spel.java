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
    private JPanel paneelKnoppen;
    //private JButton startKnop, resetKnop;
    JButton openLevel;
    
    public Spel(){
        frame = new JFrame();
        frame.setTitle("KeyGame");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGTH);

        
        //paneelKnopjes();
        //maakPaneel();
        
        openLevel = new JButton("Open Level");
        openLevel.addActionListener(new knopActie());
        
        frame.add(openLevel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
    
    // Inner Class knopActie voor de knoppen Start en Reset
    class knopActie implements ActionListener{
          
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
                /*
            }else if(event.getSource() == resetKnop){// resetKnop
                //zodra een level is gemaakt kan het getest worden.
            }*/
            frame.revalidate();
            frame.repaint();
        }
    }
    
    /*
    private void paneelKnopjes()
    {
        startKnop = new JButton("Start");
        startKnop.addActionListener(new knopActie());
   
        resetKnop = new JButton("Reset");
        resetKnop.addActionListener(new knopActie());
    }
    */
    
    /*
    private void maakPaneel()
    {   
        paneelKnoppen = new JPanel();
        paneelKnoppen.setBackground(Color.DARK_GRAY);
        paneelKnoppen.add(startKnop);
        paneelKnoppen.add(resetKnop);

        add(paneelKnoppen, BorderLayout.SOUTH);
    }
    */
    public void startLevel(String pad) {
        Level l = new Level(pad);
    }
    /*
    public static void main(String[] args) { // Gebruik ik om te zien of het goed werkt. Voor Koray
        
        Spel spel = new Spel();
        
    }
    */
}
