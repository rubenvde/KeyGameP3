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

public class Spel extends JFrame{ // dit maakt het makkelijk aangezien we met 1 JFrame werken, we kunnen het altijd aanpassen
    
    private final int FRAME_WIDTH = 640; // Hier moeten we nog over nadenken
    private final int FRAME_HEIGTH = 640;// Hier moeten we nog over nadenken
    
    private Level [] levels; // Misschien handig als we 3 constructors aanmaken met ieder zijn eigen level
     private Level currentLevel;
    
    private JPanel paneelKnoppen;
    private JButton startKnop, resetKnop;

    public Spel(){
        
        setTitle("KeyGame");
        setSize(FRAME_WIDTH, FRAME_HEIGTH);
        setLayout(new BorderLayout());
        /*
        levels = new Level[5];

        //Start met het eerste level
        currentLevel = levels[0];
        */

        
        paneelKnopjes();
        maakPaneel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    // Inner Class knopActie voor de knoppen Start en Reset
    class knopActie implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent event)
        {   
            if(event.getSource() == startKnop){// StartKnop
                //add(levels[0].getLevel(), BorderLayout.CENTER);//hier komt een level van de classe Level
            }else if(event.getSource() == resetKnop){// resetKnop
                //zodra een level is gemaakt kan het getest worden.
            }
            revalidate();
            repaint();
        }
    }
    
    private void paneelKnopjes()
    {
        startKnop = new JButton("Start");
        startKnop.addActionListener(new knopActie());
   
        resetKnop = new JButton("Reset");
        resetKnop.addActionListener(new knopActie());
    }
    
    private void maakPaneel()
    {   
        paneelKnoppen = new JPanel();
        paneelKnoppen.setBackground(Color.DARK_GRAY);
        paneelKnoppen.add(startKnop);
        paneelKnoppen.add(resetKnop);

        add(paneelKnoppen, BorderLayout.SOUTH);
    }
    
    public void startLevel() {
        
    }
    
    /*
    public static void main(String[] args) { // Gebruik ik om te zien of het goed werkt. Voor Koray
        
        Spel spel = new Spel();
        
    }
    */
    
}
