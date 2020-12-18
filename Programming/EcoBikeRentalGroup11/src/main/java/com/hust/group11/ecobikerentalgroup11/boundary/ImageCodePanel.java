/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.boundary;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Thanh Long
 */
public class ImageCodePanel extends JPanel {

    private BufferedImage image;
    private boolean isSet;
    private File file;

    public ImageCodePanel() {
        this.file = new File("choose-img.png");
        isSet = false;
        if (!isSet) {
            try {
                image = ImageIO.read(this.file);
                isSet = true;
            } catch (IOException ex) {
                Logger.getLogger(ImageCodePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void showImage(File file) {
        try {
            image = ImageIO.read(file);
            this.file = file;
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public String getImageName() {
        return file.getName();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this); // see javadoc for more info on the parameters            
    }

}
