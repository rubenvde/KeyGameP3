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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *
 * @author Ruben, Koray, Ruben
 */
public class Level extends JFrame{
    
    private final int VAK_BREEDTE = 64;
    private final int VAK_HOOGTE = 64;
    
    private Dimensie dimensie, spelerPos;
    private Speler speler;
    
    private JPanel paneelKnoppen, paneelLevel, testCells[][]; 
    
    private JButton resetKnop;
    
    private Veld[][] speelVeld;
    
    public Level(String padNaarLevel) {
        loadLevel(padNaarLevel);
 
        testCells = new JPanel[dimensie.getY()][dimensie.getX()];
        
        setTitle("LevelGrid");
        setSize(VAK_BREEDTE*dimensie.getX(), (VAK_HOOGTE*dimensie.getY()) + 52);
        setLayout(new BorderLayout());
        
        creëerVeld();
        creëerSpeler();
        paneelKnoppen();
        maakPaneel();
        
        this.setFocusable(true);
        this.addKeyListener(new verplaatsSpeler());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    private void creëerVeld(){
        paneelLevel = new JPanel();
        paneelLevel.setLayout(new GridLayout(dimensie.getY(), dimensie.getX(), 0, 0));
        paneelLevel.setBackground(Color.BLACK);
        paneelLevel.setOpaque(false);
        for (int i = 0; i < dimensie.getY(); i++) {
            for (int j = 0; j < dimensie.getX(); j++) {
                testCells[i][j] = new JPanel();
                if(speelVeld[i][j].getSpelElementIcon() != null) {
                    testCells[i][j].add(new JLabel(speelVeld[i][j].getSpelElementIcon()));
                    testCells[i][j].setLayout(new GridLayout(0,1));
                }
                paneelLevel.add(testCells[i][j]);
            }
        }
    }
    
    private void creëerSpeler(){
        spelerPos = speler.getPositie();
        speler = new Speler(spelerPos);
        testCells[spelerPos.getY()][spelerPos.getX()].add(speler.getSpelerLabel());
    }
    ///    
    /// Inner class
        class knopActie implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent event)
        {   
            if(event.getSource() == resetKnop){
                reset();
                System.out.println("TEST, gedrukt!");
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
    
    private void reset(){
        spelerPos.setDimensieReset();
        speler.setPositie(spelerPos);
        testCells[spelerPos.getY()][spelerPos.getX()].add(speler.getSpelerLabel());
        //DEZE METHODE IS NOG IN ONTWIKKELING
    }
    
    public void bereiktEindveld(){
        
    }
    //
    // Inner Class verplaatsSpeler
        class verplaatsSpeler implements KeyListener{
         
        @Override
        public void keyPressed(KeyEvent event) {   
         
            int code = event.getKeyCode();

            testCells[spelerPos.getY()][spelerPos.getX()].remove(speler.getSpelerLabel());
            testCells[spelerPos.getY()][spelerPos.getX()].repaint();
            
            SpelToetsCode c = SpelToetsCode.getEnumNaam(code);
            int nextX = spelerPos.getX();
            int nextY = spelerPos.getY();
            switch(c){
                case OMHOOG:
                    nextX = spelerPos.getX();
                    nextY = spelerPos.getY() -1;
                    
                    break;
                    
                case OMLAAG:
                    nextX = spelerPos.getX();
                    nextY = spelerPos.getY() +1;
                    
                    break;
                    
                case LINKS:
                    nextX = spelerPos.getX() -1;
                    nextY = spelerPos.getY();
                    
                    break;
                    
                case RECHTS:
                    nextX = spelerPos.getX() +1;
                    nextY = spelerPos.getY();
                    
                    break;
                    
                case SLEUTELOPPAKKEN:
                    spelerSleutelPakken();
                    break;
            }
            //Controleer of speler niet uit het veld gaat
            if(nextX >= 0 && nextX < dimensie.getX() && nextY >= 0 && nextY < dimensie.getY()){
                if(speelVeld[nextY][nextX].isBezetBaar(speler)) {
                spelerPos.setY(nextY);
                spelerPos.setX(nextX);
                }
                
                //Als speler zich op het eindveld gaat bevinden
                if(speelVeld[nextY][nextX].getSpelElement() instanceof Eindveld) {
                    System.out.println("GELUKT!");
                }
            }
            testCells[spelerPos.getY()][spelerPos.getX()].add(speler.getSpelerLabel());
            testCells[spelerPos.getY()][spelerPos.getX()].repaint();
        }
        
        @Override
        public void keyTyped(KeyEvent event) {}

        @Override
        public void keyReleased(KeyEvent event) {} 
        
        }// EINDE INNER CLASS verplaatsSpeler
    
    public void spelerSleutelPakken(){
        
        if(speelVeld[spelerPos.getY()][spelerPos.getX()].getSpelElement() instanceof Sleutel ){
            speler.setSleutel((Sleutel) speelVeld[spelerPos.getY()][spelerPos.getX()].getSpelElement());
            System.out.println("Speler sleutel: " + speler.getSleutel().getPincode());
            speelVeld[spelerPos.getY()][spelerPos.getX()].verwijderSpelElement(); // Element verdwijnt maar de afbeelding blijft hangen!!!
            testCells[spelerPos.getY()][spelerPos.getX()].removeAll();
            revalidate();
            repaint();
        } 
    }
    
    private void loadLevel(String pad) {
        // The name of the file to open.
        String file = new String();
        
        try {
            FileReader reader = new FileReader(pad);
            int character;
            while ((character = reader.read()) != -1) {
                file += (char) character;
            }
            reader.close();
 
        } catch (IOException e) {
            System.out.println("File niet gevonden!");
            return;
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
        //Zet dimensie
        dimensie = new Dimensie(x,y);
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
                speelVeld[tempY][tempX] = new Veld();
                //speler = new Speler(tempX, tempY);//<- even veranderd voor de test
                speler = new Speler(new Dimensie(tempX, tempY));
            }
            else if(veld[i].equals("E")) {
                //Doe iets
                speelVeld[tempY][tempX] = new Veld(new Eindveld());
                //System.out.println("Eindveld nog niet geïmplementeerd");
            }
            else if(veld[i].equals("M")) {
                speelVeld[tempY][tempX] = new Veld(new Muur());
            }
            else if(veld[i].startsWith("B")) {
                //krijg value in ()
                int pincode = 0;
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(veld[i]);
                while(m.find()) {
                    pincode = Integer.parseInt(m.group(1));   
                }
                speelVeld[tempY][tempX] = new Veld(new Barricade(pincode));
            }
            else if(veld[i].startsWith("S")) {
                //krijg value in ()
                int pincode = 0;
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(veld[i]);
                while(m.find()) {
                    pincode = Integer.parseInt(m.group(1));   
                }
                speelVeld[tempY][tempX] = new Veld(new Sleutel(pincode));
            }
            else if(veld[i].equals("X")) {
                //Speelveld is leeg
                speelVeld[tempY][tempX] = new Veld();
            }
            
        }
    }
    
}
