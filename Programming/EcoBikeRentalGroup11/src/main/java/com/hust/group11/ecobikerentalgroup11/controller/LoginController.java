package com.hust.group11.ecobikerentalgroup11.controller;

import com.hust.group11.ecobikerentalgroup11.boundary.LoginScreen;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.hust.group11.ecobikerentalgroup11.DataBase;
import com.hust.group11.ecobikerentalgroup11.Entity.User;
import com.hust.group11.ecobikerentalgroup11.MainEntry;
import com.hust.group11.ecobikerentalgroup11.boundary.HomeScreen;
import com.hust.group11.ecobikerentalgroup11.boundary.ScanCodeScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thanh Long
 */
public class LoginController {
    public DataBase db;
    public LoginController(){
        try {
            this.db = new DataBase();
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void handleLogin(ActionEvent e, String username, String password, JFrame backScreen){
        System.out.println("Login here");
       
        try {
            String sqlString = "Select * from user where username='" + username + "' and password='" + password + "'";
            ResultSet rs = db.query(sqlString);
            if (rs.next()) {
                 User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getInt("status"));
//                ScanCodeScreen sc = new ScanCodeScreen(backScreen);
                HomeScreen hc = new HomeScreen(user, backScreen);
                MainEntry.move(backScreen, hc);
                JOptionPane.showMessageDialog(hc, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(backScreen, "Wrong Username & Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
