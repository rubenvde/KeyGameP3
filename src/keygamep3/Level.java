/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.round;
import javax.swing.*;

/**
 *
 * @author Ruben, Koray, Ruben
 */
public class Level extends JFrame{
    
    private final int VAK_BREEDTE = 64;
    private final int VAK_HOOGTE = 64;
    
    private Dimensie dimensie;
    private Speler speler;
    
    private JPanel paneelKnoppen, paneelLevel;
    private JButton startKnop, resetKnop;
    
    private Veld[][] speelVeld;
    
    private JLabel [][] testCells;

    public Level() {
        loadLevel();
        
        dimensie = new Dimensie(8,5);
        testCells = new JLabel[dimensie.getY()][dimensie.getX()];
        
        setTitle("LevelGrid");
        setSize(VAK_BREEDTE*dimensie.getX(), (VAK_HOOGTE*dimensie.getY()) + 52);
        setLayout(new BorderLayout());
        
        //speelVeld = new Veld[][];
        
        creëerVeld();
        paneelKnoppen();
        maakPaneel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    private void creëerVeld(){
        paneelLevel = new JPanel();
        paneelLevel.setLayout(new GridLayout(dimensie.getY(), dimensie.getX(), 0, 0));
        paneelLevel.setBackground(Color.BLACK);
        
        for (int i = 0; i < dimensie.getY(); i++) {
            for (int j = 0; j < dimensie.getX(); j++) {
                testCells[i][j] = new JLabel();
                testCells[i][j].setIcon(new ImageIcon("/Users/koray/Desktop/GAME/KeyGameP3/Plaatjes/grass.png"));//<-- Test afbeelding
                paneelLevel.add(testCells[i][j]);
            }
        }
    }
    
    ///    
    /// Inner class
        class knopActie implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent event)
        {   
            if(event.getSource() == resetKnop){// resetKnop
                //zodra een level is gemaakt kan het getest worden.
            }
            revalidate();
            repaint();
        }
    }
    
    private void paneelKnoppen()
    {
        resetKnop = new JButton("Reset");
        resetKnop.addActionListener(new knopActie());
    }
    
    private void maakPaneel()
    {   
        paneelKnoppen = new JPanel();
        paneelKnoppen.setBackground(Color.DARK_GRAY);
        paneelKnoppen.add(resetKnop);
        
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
    
    public static void main(String[] args) { // <-- Geen zorgen, dit is alleen voor mij :D
        
        Level level = new Level();
    }
    
    private void loadLevel() {
        // The name of the file to open.
        String file = new String();
        
        try {
            FileReader reader = new FileReader("temp.txt");
            int character;
            while ((character = reader.read()) != -1) {
                file += (char) character;
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //File is opgehaald nu filteren
        
        // Veld dimentie scheiden van veld
        String[] dOfV = file.split(",veld:");
        
        // Dimenties scheiden
        String[] dimenties = dOfV[0].split(",");
        
        int x = 0;
        int y = 0;
        //Haal de x en y op
        for(int i = 0; i < dimenties.length; i++) {
            if(dimenties[i].startsWith("x:")) {
                String[] xSplit = dimenties[i].split(":");
                if(xSplit.length > 1) {
                    x = Integer.parseInt(xSplit[1]);
                }
                else
                {
                    System.out.println("Whoops error! Er klopt iets niet met de indeling");
                    return;
                }
            }
            else if(dimenties[i].startsWith("y:")) {
                String[] ySplit = dimenties[i].split(":");
                if(ySplit.length > 1) {
                    y = Integer.parseInt(ySplit[1]);
                }
                else
                {
                    System.out.println("Whoops error! Er klopt iets niet met de indeling");
                    return;
                }
            }
            else {
                
                System.out.println("Huh? Iets extra's? Error! " + dimenties[i]);
            }
        }
        
        //x en y zijn nu opgenomen nu het veld
        String[] veld = dOfV[1].split(",");
        
        speelVeld = new Veld[y][x];
        
        for(int i = 0; i < veld.length; i++) {
            int tempY = round(i / y);
            int tempX = i % x;
            speelVeld[tempY][tempX] = new Veld();
            
            //Als er een P staat
            if(veld[i].equals("P")) {
                //Doe iets
                //speelVeld[tempY][tempX] = new Veld();
            }
            else if(veld[i].equals("M")) {
                //speelVeld[tempY][tempX] = new Veld(new Muur());
            }
            
            
        }
    }
    
}
