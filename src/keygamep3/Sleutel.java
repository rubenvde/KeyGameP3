/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygamep3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 */
public class Sleutel extends SpelElement {

    private int pincode;

    public Sleutel(int pincode) {

        this.pincode = pincode;
        this.afbeelding = new ImageIcon(getClass().getResource("/Plaatjes/sleutel.png"));


    }

    public int getPincode() {

        return pincode;
    }

    @Override
    public boolean isToegankelijk(int pincode) {

        return true;
    }

}
