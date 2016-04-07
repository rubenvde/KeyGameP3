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
 * Eem spel bestaat uit meerdere levels
 * @author Ruben, Koray, Ruben
 */
public class Level extends JFrame implements KeyListener, ActionListener {
 
    private final int VAK_BREEDTE = 64;
    private final int VAK_HOOGTE = 64;

    private Dimensie dimensie, spelerPos;
    private Speler speler;

    private JPanel paneelKnoppen, paneelLevel, levelCells[][];

    private JButton resetKnop;

    private String padNaarLevel;

    private Veld[][] speelVeld;

    private int aantalStappenOmgekeerd = 0;

    /**
     * Constructor van Level
     * @param padNaarLevel
     */
    public Level(String padNaarLevel) {
        this.padNaarLevel = padNaarLevel;
        laadLevel(padNaarLevel);

        levelCells = new JPanel[dimensie.getY()][dimensie.getX()];

        setTitle("LevelGrid");
        setSize(VAK_BREEDTE * dimensie.getX(), (VAK_HOOGTE * dimensie.getY()) + 52);
        setLayout(new BorderLayout());

        creëerVeld();
        creëerSpeler();
        paneelKnoppen();
        maakPaneel();

        this.setFocusable(true);
        this.addKeyListener(this);
        //Sluit alleen het frame als er op kruisje wordt gedrukt
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setResizable(false);
        setVisible(true);
    }

    /**
     * Maakt een visuele weergave van speelVeld
     */
    private void creëerVeld() {
        paneelLevel = new JPanel();
        paneelLevel.setLayout(new GridLayout(dimensie.getY(), dimensie.getX(), 0, 0));
        paneelLevel.setBackground(Color.BLACK);
        paneelLevel.setOpaque(false);
        //Loop door een 2d array om velden te creeeren
        for (int i = 0; i < dimensie.getY(); i++) {
            for (int j = 0; j < dimensie.getX(); j++) {
                levelCells[i][j] = new JPanel();
                if (speelVeld[i][j].getSpelElementIcon() != null) {
                    levelCells[i][j].setLayout(new OverlayLayout(levelCells[i][j]));
                    //Wanneer het spelelement een sleutel of barricade is moet er een pincode worden weergegeven
                    if (speelVeld[i][j].getSpelElement() instanceof Sleutel || speelVeld[i][j].getSpelElement() instanceof Barricade) {
                        JLabel label = new JLabel("" + speelVeld[i][j].getSpelElement().getPincode());
                        label.setOpaque(false);
                        levelCells[i][j].add(label);
                    }
                    //Zet het spelelement icoontje in de velden
                    JLabel vak = new JLabel(speelVeld[i][j].getSpelElementIcon());
                    levelCells[i][j].add(vak);
                }
                paneelLevel.add(levelCells[i][j]);
            }
        }
    }

    /**
     * Zet een speler op het veld
     */
    private void creëerSpeler() {
        spelerPos = speler.getPositie();
        speler = new Speler(spelerPos);
        levelCells[spelerPos.getY()][spelerPos.getX()].add(speler.getSpelerLabel());
    }

    /**
     * Reageert op buttons die geklikt worden
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        //Als de knop een resetknop is, herstart het level
        if (event.getSource() == resetKnop) {
            resetLevel();
        }
        revalidate();
        repaint();
    }

    /**
     * Voegt de resetknop aan het paneel toe
     */
    private void paneelKnoppen() {
        resetKnop = new JButton("Reset");
        resetKnop.addActionListener(this);
    }

    /**
     * Creeer het paneel waar het level en de reset knop worden toegevoegd
     */
    private void maakPaneel() {
        paneelKnoppen = new JPanel();
        paneelKnoppen.setBackground(Color.DARK_GRAY);
        paneelKnoppen.add(resetKnop);
        //Voegt de panelen toe aan de BorderLayout van de JFrame van Level
        add(paneelLevel, BorderLayout.CENTER);
        add(paneelKnoppen, BorderLayout.SOUTH);
    }

    /**
     * Reset het level
     */
    private void resetLevel() {
        dispose();
        Level l = new Level(padNaarLevel);
    }

    /**
     * Wordt uigevoerd wanneer het eindveld is bereikt
     */
    private void bereiktEindveld() {
        JOptionPane.showMessageDialog(null, "Klik op deze knop om het volgende level te kiezen", "Gefeliciteerd!", JOptionPane.PLAIN_MESSAGE);
        setVisible(false);
    }

    /**
     * Afhandeling van de toetsen die ingedrukt worden
     * @param event
     */
    @Override
    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();

        levelCells[spelerPos.getY()][spelerPos.getX()].remove(speler.getSpelerLabel());
        levelCells[spelerPos.getY()][spelerPos.getX()].repaint();
        SpelToetsCode c = SpelToetsCode.getEnumNaam(code);
        int nextX = spelerPos.getX();
        int nextY = spelerPos.getY();

        //Als speler op omkeervak staat
        if ((speelVeld[spelerPos.getY()][spelerPos.getX()].getSpelElement() instanceof OmkeerVak)) {
            aantalStappenOmgekeerd = 5;
        }
        //Controlleer of de keypress wel echt omhoog,omlaag,links,rechts of spatiebalk is
        if (c != null) {
            switch (c) {

                case OMHOOG:
                    nextX = spelerPos.getX();
                    if (aantalStappenOmgekeerd > 0) {
                        nextY = spelerPos.getY() + 1;
                    } else {
                        nextY = spelerPos.getY() - 1;
                    }

                    break;

                case OMLAAG:
                    nextX = spelerPos.getX();
                    if (aantalStappenOmgekeerd > 0) {
                        nextY = spelerPos.getY() - 1;
                    } else {
                        nextY = spelerPos.getY() + 1;
                    }

                    break;

                case LINKS:
                    if (aantalStappenOmgekeerd > 0) {
                        nextX = spelerPos.getX() + 1;
                    } else {
                        nextX = spelerPos.getX() - 1;
                    }
                    nextY = spelerPos.getY();

                    break;

                case RECHTS:
                    if (aantalStappenOmgekeerd > 0) {
                        nextX = spelerPos.getX() - 1;
                    } else {
                        nextX = spelerPos.getX() + 1;
                    }
                    nextY = spelerPos.getY();

                    break;

                case SLEUTELOPPAKKEN:
                    spelerSleutelPakken();

                    break;
            }
        }
        //Controleer of speler niet uit het veld gaat
        if (isInVeld(new Dimensie(nextX, nextY))) {
            if (speelVeld[nextY][nextX].isBezetBaar(speler)) {
                //Als er een barricade komt
                if (speelVeld[nextY][nextX].getSpelElement() instanceof Barricade) {
                    speelVeld[nextY][nextX].verwijderSpelElement();
                    levelCells[nextY][nextX].removeAll();
                }
                //Zet spelerpositie naar nextX, nextY
                spelerPos.setY(nextY);
                spelerPos.setX(nextX);
                //Als er omgekeerde stappen gemaakt zijn, doe -1
                if (aantalStappenOmgekeerd > 0) {
                    aantalStappenOmgekeerd--;
                }
            }
            //Als speler zich op het eindveld gaat bevinden
            if (speelVeld[nextY][nextX].getSpelElement() instanceof Eindveld) {
                bereiktEindveld();
            }
        }
        levelCells[spelerPos.getY()][spelerPos.getX()].add(speler.getSpelerLabel());
        levelCells[spelerPos.getY()][spelerPos.getX()].repaint();
    }//Einde keyPressed

    /**
     * Moet in interface KeyListener maar doen wij niks mee
     * @param event
     */
    @Override
    public void keyTyped(KeyEvent event) {
    }

    /**
     * Moet in interface KeyListener maar doen wij niks mee
     * @param event
     */
    @Override
    public void keyReleased(KeyEvent event) {
    }

    /**
     * Aangemaakt voor JUNIT testing
     *
     * @return
     */
    public Speler getSpeler() {
        return this.speler;
    }

    /**
     * Aangemaakt voor JUNIT testing
     *
     * @return
     */
    public Veld[][] getSpeelVeld() {
        return this.speelVeld;
    }

    /**
     * Controlleer of dimensie in veld zit
     * @param pos
     * @return
     */
    public boolean isInVeld(Dimensie pos) {
        if (pos.getX() >= 0 && pos.getX() < dimensie.getX() && pos.getY() >= 0 && pos.getY() < dimensie.getY()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Zorgt ervoor dat sleutel wordt opgepakt en aan speler wordt gegeven
     */
    private void spelerSleutelPakken() {
        //Controlleer of speler op een sleutel staat
        if (speelVeld[spelerPos.getY()][spelerPos.getX()].getSpelElement() instanceof Sleutel) {
            //Verplaats sleutel naar zak van speler
            speler.setSleutel((Sleutel) speelVeld[spelerPos.getY()][spelerPos.getX()].getSpelElement());
            //Verwijder de sleutel van het veld
            speelVeld[spelerPos.getY()][spelerPos.getX()].verwijderSpelElement();
            levelCells[spelerPos.getY()][spelerPos.getX()].removeAll();
            revalidate();
            repaint();
        }
    }

    /**
     *
     * @param pad
     */
    private void laadLevel(String pad) {
        // Hier wordt het txt file als een string opgeslagen.
        String file = new String();
        //Probeer het txt file te vinden en te lezen
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
        for (int i = 0; i < dimenties.length; i++) {
            if (dimenties[i].startsWith("x:")) {
                String[] xSplit = dimenties[i].split(":");
                if (xSplit.length > 1) {
                    x = Integer.parseInt(xSplit[1]);
                } else {
                    System.out.println("Whoops error! Er klopt iets niet met de indeling");
                    return;
                }
            } else if (dimenties[i].startsWith("y:")) {
                String[] ySplit = dimenties[i].split(":");
                if (ySplit.length > 1) {
                    y = Integer.parseInt(ySplit[1]);
                } else {
                    System.out.println("Whoops error! Er klopt iets niet met de indeling");
                    return;
                }
            } else {

                System.out.println("Huh? Iets extra's? Error! " + dimenties[i]);
            }
        }
        //Zet dimensie
        dimensie = new Dimensie(x, y);
        //x en y zijn nu opgenomen nu het veld
        String[] veld = dOfV[1].split(",");

        speelVeld = new Veld[y][x];

        for (int i = 0; i < veld.length; i++) {
            int tempY = round(i / x);
            int tempX = i % x;
            speelVeld[tempY][tempX] = new Veld();

            if (veld[i].startsWith("B")) {
                //krijg value in ()
                int pincode = 0;
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(veld[i]);
                while (m.find()) {
                    pincode = Integer.parseInt(m.group(1));
                }
                speelVeld[tempY][tempX] = new Veld(new Barricade(pincode));
            } else if (veld[i].startsWith("S")) {
                //krijg value in ()
                int pincode = 0;
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(veld[i]);
                while (m.find()) {
                    pincode = Integer.parseInt(m.group(1));
                }
                speelVeld[tempY][tempX] = new Veld(new Sleutel(pincode));
            } else {
                switch (veld[i]) {
                    case "P":
                        //Voeg nieuw veld toe met speler daarop
                        speelVeld[tempY][tempX] = new Veld();
                        speler = new Speler(new Dimensie(tempX, tempY));
                        break;
                    case "E":
                        //Creeer veld met eindveld als spelelement
                        speelVeld[tempY][tempX] = new Veld(new Eindveld());
                        break;
                    case "O":
                        //Creeer veld met omkeervak als spelelement
                        speelVeld[tempY][tempX] = new Veld(new OmkeerVak());
                        break;
                    case "M":
                        //Creeer veld met muur als spelelement
                        speelVeld[tempY][tempX] = new Veld(new Muur());
                        break;
                    case "X":
                        //Creeer een nieuw veld
                        speelVeld[tempY][tempX] = new Veld();
                        break;
                    default:
                        System.out.println("Error. Het level file klopt niet is namelijk:" + veld[i]);
                        break;
                }
            }
        }
    }//Einde loadLevel
}//Einde Level
