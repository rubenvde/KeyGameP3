/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ruben
 */
public class LevelTest {

    public LevelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of speler op het veld met een Sleutel kan komen
     */
    @Test
    public void testIsToegankelijkSleutel() {
        System.out.println("sleutelIsToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelVeld();

        assertEquals("Sleutel is toegankelijk", true, speelVeld[2][3].isBezetBaar(speler));
    }
    /**
     * Test of speler op het veld met een muur kan komen
     */
    @Test
    public void testIsToegankelijkMuur() {
        System.out.println("muurIsToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelVeld();

        assertEquals("Muur is NIET toegankelijk", false, speelVeld[0][1].isBezetBaar(speler));
    }
    /**
     * Test of Speler op het veld met een barricade kan komen als hij geen sleutel heeft
     */
    @Test
    public void testIsNietToegankelijkBarricade() {
        System.out.println("barricadeIsNietToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelVeld();

        assertEquals("Barricade is gesloten", false, speelVeld[1][1].isBezetBaar(speler));
    }
    /**
     * Test of Speler op het met veld met barricade kan komen als hij de juiste sleutel heeft
     */
    @Test
    public void testIsToegankelijkBarricade() {
        System.out.println("barricadeIsToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelVeld();

        speler.setSleutel(new Sleutel(100));

        assertEquals("Barricade is geopend", true, speelVeld[1][1].isBezetBaar(speler));
    }
    /**
     * Test of Speler zich buiten het level kan bevinden
     */
    @Test
    public void testIsSpelerBuitenVeldLinks() {
        System.out.println("spelerIsBuitenVeldLinks");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();

        assertEquals("Speler is buiten het speelveld aan de linkerkant", false, instance.isInVeld(new Dimensie(-1, 2)));
    }
    /**
     * Test of Speler zich buiten het level kan bevinden
     */
    @Test
    public void testIsSpelerBuitenVeldRechts() {
        System.out.println("spelerIsBuitenVeldRechts");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();

        assertEquals("Speler is buiten het speelveld aan de rechterkant", false, instance.isInVeld(new Dimensie(20, 2)));
    }
    /**
     * Test of Speler zich in het veld kan bevinden
     */
    @Test
    public void testIsSpelerInVeld() {
        System.out.println("spelerIsInVeld");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();

        assertEquals("Speler is in het speelveld", true, instance.isInVeld(new Dimensie(1, 2)));
    }

}
