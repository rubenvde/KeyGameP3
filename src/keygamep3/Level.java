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
 * @author Ruben
 */
public class Level extends JFrame{
    private Dimensie dimensie;
    private Speler speler;
    //private Veld[][] speelVeld;
    
    private JTable [][] testCells;

    public Level() {
        
        dimensie = new Dimensie(3,5);
        testCells = new JTable[10][10];
        setTitle("TestGrid");
        setSize(640, 640);
        setLayout(new GridLayout(dimensie.getX(),dimensie.getY()));
        
        //speelVeld = new Veld[][];
        //Dit mag dus niet hardcoded
        //speler = new Speler(new Positie(0,0));
        
        creëerVeld();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    private void creëerVeld(){
        
        for (int i = 0; i < dimensie.getX(); i++) {
            for (int j = 0; j < dimensie.getY(); j++) {
                testCells[i][j] = new JTable();
                testCells[i][j].setBackground(Color.YELLOW);
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
