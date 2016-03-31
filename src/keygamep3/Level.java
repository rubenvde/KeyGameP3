/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.Color;
import java.awt.GridLayout;
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
    //private Veld[][] speelVeld;
    
    private JLabel [][] testCells;

    public Level() {
        
        dimensie = new Dimensie(6,5);
        testCells = new JLabel[10][10];
        setTitle("TestGrid");
        setSize(VAK_BREEDTE*dimensie.getX(), VAK_HOOGTE*dimensie.getY());
        setLayout(new GridLayout(dimensie.getY(),dimensie.getX()));
        
        //speelVeld = new Veld[][];
        
        creëerVeld();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
    
    private void creëerVeld(){
        for (int i = 0; i < dimensie.getX(); i++) {
            for (int j = 0; j < dimensie.getY(); j++) {
                testCells[i][j] = new JLabel();
                //testCells[i][j].setIcon(new ImageIcon(getClass().getResource("grass.png")));
                testCells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(testCells[i][j]);
            }
        }
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
