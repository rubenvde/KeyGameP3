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
     * Test of IsToegankelijk method, of class Level
     * Controlleer of speler de sleutel op kan pakken.
     */
    @Test
    public void testIsToegankelijkSleutel() {
        System.out.println("isToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelveld();
        
        assertEquals("Sleutel is toegankelijk" , true,speelVeld[2][3].isBezetBaar(speler));

        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testIsToegankelijkMuur() {
        System.out.println("isToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelveld();
        
        assertEquals("Muur is NIET toegankelijk" , false,speelVeld[0][1].isBezetBaar(speler)); 
    }
    @Test
    public void testIsToegankelijkBarricade() {
        System.out.println("isToegankelijk");
        Level instance = new Level("temp.txt");
        Speler speler = instance.getSpeler();
        Veld[][] speelVeld = instance.getSpeelveld();
        
        assertEquals("Barricade is gesloten" , false,speelVeld[1][1].isBezetBaar(speler));
        
        speler.setSleutel(new Sleutel(100));
        
        assertEquals("Barricade is geopend" , true,speelVeld[1][1].isBezetBaar(speler));
}}
