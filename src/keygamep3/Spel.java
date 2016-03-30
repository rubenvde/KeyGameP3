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
    
    private JPanel paneelKnoppen;
    private JButton startKnop, resetKnop;

    public Spel(){
        
        setTitle("KeyGame");
        setSize(FRAME_WIDTH, FRAME_HEIGTH);
        setLayout(new BorderLayout());
        
        levels = new Level[3];
        levels[0] = new Level();//level 1
        levels[1] = new Level();//level 2
        levels[2] = new Level();//level 3
        
        /*
        paneelLevel = new JPanel(); // NIET NODIG OMDAT DE LEVEL AL EEN PANEEL HEEFT
        //paneelLevel.setLayout(new GridLayout(10, 10, 0, 0));
        paneelLevel.setSize(300, 300);
        paneelLevel.setBackground(Color.YELLOW);
        paneelLevel.add(new JButton());
        
        paneelKnoppen = new JPanel();
        paneelKnoppen.setBackground(Color.DARK_GRAY);
        
        BOVENSTAANDE NIET NODIG, OMDAT DIE ZIJN GEIMPLEMENTEERD IN PANEELKNOPJES() EN MAAKPANEEL() METHODE
        */
        
        paneelKnopjes();
        maakPaneel();

        //frame.add(paneelLevel, BorderLayout.CENTER);  <---- NIET NODIG, WANT HIJ ZIT IN createPaneel()
        //frame.add(paneelKnoppen, BorderLayout.SOUTH); <---- NIET NODIG, WANT HIJ ZIT IN createPaneel()
        
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
    
    public static void main(String[] args) { // Gebruik ik om te zien of het goed werkt.
        
        Spel spel = new Spel();
        
    }
    
    
}
