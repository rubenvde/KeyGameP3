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
    
    private Dimensie dimensie, spelerPos, spelerBewegen;
    private Speler speler;
    
    private JPanel paneelKnoppen, paneelLevel;
    private JPanel testCells[][];
    private JButton resetKnop;
    
    private Veld[][] speelVeld;

    public Level() {    //<- Deze methode is straks niet meer beschikbaar
        loadLevel();
 
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
    
    public Level(String padNaarLevel) {
        loadLevel(padNaarLevel);
 
        testCells = new JPanel[dimensie.getY()][dimensie.getX()];
        
        setTitle("LevelGrid");
        setSize(VAK_BREEDTE*dimensie.getX(), (VAK_HOOGTE*dimensie.getY()) + 52);
        setLayout(new BorderLayout());
        
        creëerVeld();
        //creëerSpeler();
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
        paneelLevel.setOpaque(false);
        for (int i = 0; i < dimensie.getY(); i++) {
            for (int j = 0; j < dimensie.getX(); j++) {
                testCells[i][j] = new JPanel();
                if(speelVeld[i][j].getSpelElementIcon() != null) {
                    //testCells[i][j].setIcon(speelVeld[i][j].getSpelElementIcon());
                    testCells[i][j].add(new JLabel(speelVeld[i][j].getSpelElementIcon()));
                    testCells[i][j].setLayout(new GridLayout(0,1));
                    testCells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    testCells[i][j].setBackground(Color.red); //<< om te zien of er gaten zijn in Label
                }
                paneelLevel.add(testCells[i][j]);
            }
        }
    }
    
    private void creëerSpeler(){
        spelerPos = speler.getPositie();
        speler = new Speler(spelerPos);
        testCells[spelerPos.getY()][spelerPos.getX()].add(speler.getSpelerLabel());
        //speler.getSpelerLabel().addKeyListener(new verplaatsSpeler());
        //addKeyListener(new verplaatsSpeler());
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
            System.out.println("hoi");
            int code = event.getKeyCode();
            
            spelerBewegen = speler.getPositie();
            
            testCells[spelerBewegen.getY()][spelerBewegen.getX()].remove(speler.getSpelerLabel());
            testCells[spelerBewegen.getY()][spelerBewegen.getX()].repaint();
            
            SpelToetsCode c = SpelToetsCode.getEnumNaam(code);
            switch(c){
                case OMHOOG:
                    spelerBewegen.setY(spelerBewegen.getY()-1);
                    break;
                
                case OMLAAG:
                    spelerBewegen.setY(spelerBewegen.getY()+1);
                    break;
                    
                case LINKS:
                    spelerBewegen.setX(spelerBewegen.getX()-1);
                    break;
                    
                case RECHTS:
                    spelerBewegen.setX(spelerBewegen.getX()+1);
                    break;
            }
            if(spelerBewegen.getX()<0){spelerBewegen.setX(spelerBewegen.getX()+1);}
            if(spelerBewegen.getX() == dimensie.getX()){spelerBewegen.setX(spelerBewegen.getX()-1);}
            
            if(spelerBewegen.getY()<0){spelerBewegen.setY(spelerBewegen.getY()+1);}
            if(spelerBewegen.getY() == dimensie.getY()){spelerBewegen.setY(spelerBewegen.getY()-1);}
            
            testCells[spelerBewegen.getY()][spelerBewegen.getX()].add(speler.getSpelerLabel());
            testCells[spelerBewegen.getY()][spelerBewegen.getX()].revalidate();
            speler.getSpelerLabel().requestFocus(true);
            //speler.getSpelerLabel().requestFocus();
        }
        
        @Override
        public void keyTyped(KeyEvent event) {}

        @Override
        public void keyReleased(KeyEvent event) {} 
        
        }// EINDE INNER CLASS verplaatsSpeler
    
    public void verplaatsSpeler(){
       // deze methode is waarschijnlijk niet meer nodig....? 
    }
    
    public void spelerSleutelPakken(){
        
    }
    
    public static void main(String[] args) { // <-- Geen zorgen, dit is alleen voor mij :D
        
        Level level = new Level();
    }
    
    private void loadLevel() {  //<- Is straks niet meer aan te roepen
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
                speelVeld[tempY][tempX] = new Veld();
                System.out.println("Eindveld nog niet geïmplementeerd");
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
                speelVeld[tempY][tempX] = new Veld();
                System.out.println("Eindveld nog niet geïmplementeerd");
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
