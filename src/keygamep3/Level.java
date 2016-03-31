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
 * @author Ruben, Koray, Ruben
 */
public class Level extends JFrame{
    
    private Dimensie dimensie;
    private Speler speler;
    private final int VAK_BREEDTE = 64;
    private final int VAK_HOOGTE = 64;
    
    private JPanel paneelKnoppen, paneelLevel;
    private JButton startKnop, resetKnop;
    
    //private Veld[][] speelVeld;
    
    private JLabel [][] testCells;

    public Level() {
        dimensie = new Dimensie(2,5);
        testCells = new JLabel[10][10];
        
        setTitle("TestGrid");
        setSize(VAK_BREEDTE*dimensie.getX(), VAK_HOOGTE*dimensie.getY());
        setLayout(new GridLayout(dimensie.getY(), dimensie.getX()));
        
        //speelVeld = new Veld[][];
        creëerVeld();
        //paneelKnoppen();
        //maakPaneel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    private void creëerVeld(){
        for (int i = 0; i < dimensie.getY(); i++) {
            for (int j = 0; j < dimensie.getX(); j++) {
                testCells[i][j] = new JLabel();
                testCells[i][j].setIcon(new ImageIcon(getClass().getResource("grass.png")));
                testCells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                add(testCells[i][j]);
            }
        }
    }
        
        // Inner class
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
    
    private void paneelKnoppen()
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
        //paneelKnoppen.add(startKnop);
        paneelKnoppen.add(resetKnop);
        
        paneelLevel = new JPanel();
        paneelLevel.setLayout(new GridLayout(dimensie.getY(),dimensie.getX()));
        
        add(paneelLevel, BorderLayout.CENTER);
        add(paneelKnoppen, BorderLayout.SOUTH);
    }
    
    public void reset(){
        
    }
    
    public void bereiktEindveld(){
        
    }
    
    public void verplaatsSpeler(){
        
    }
    
    public void spelerSleutelPakken(){
        
    }
    
    public static void main(String[] args) { // <-- Geen zorgen jongens dit is alleen voor mij :D
        
        Level level = new Level();
    }
    
}
