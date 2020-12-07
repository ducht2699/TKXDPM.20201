/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11;
import com.hust.group11.ecobikerentalgroup11.boundary.LoginScreen;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nguyen Thanh Long
 */


public class MainEntry {
    public static void move(JFrame currScreen, JFrame nextScreen) {
        nextScreen.setLocation(currScreen.getLocation());
        nextScreen.setVisible(true);
        currScreen.setVisible(false);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void createAndShowGUI() throws Exception {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }
}
