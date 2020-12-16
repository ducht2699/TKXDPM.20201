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
import com.hust.group11.ecobikerentalgroup11.boundary.admin.HomeScreenAdmin;
import com.hust.group11.ecobikerentalgroup11.boundary.ScanCodeScreen;
import com.hust.group11.ecobikerentalgroup11.boundary.SignUpScreen;
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
 * @author Hoang Duc
 */
public class UsersController {

    public DataBase db;

    public UsersController() {
        try {
            this.db = new DataBase();
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleLogin(String username, String password, JFrame backScreen) {
        System.out.println("Login here");

        try {
            String sqlString = "Select * from user where username='" + username + "' and password='" + password + "'";
            ResultSet rs = db.query(sqlString);
            if (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getInt("status"), rs.getInt("isAdmin"));
                if (user.isAdmin() == 0) {
                    HomeScreen hc = new HomeScreen(user, backScreen);
                    MainEntry.move(backScreen, hc);
                    JOptionPane.showMessageDialog(hc, "You have successfully logged in!");
                } else if (user.isAdmin() == 1) {
                    HomeScreenAdmin hc = new HomeScreenAdmin(user, backScreen);
                    MainEntry.move(backScreen, hc);
                    JOptionPane.showMessageDialog(hc, "You have successfully logged in!");
                }

            } else {
                JOptionPane.showMessageDialog(backScreen, "Wrong Username & Password!");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void handleRegister(JFrame backScreen, String userName, String name, String pass, String confirmPass) throws SQLException {
        if (pass.equals(confirmPass)) {
            String sql = "INSERT INTO user (`user_id`, `name`, `username`, `password`, `status`, `isAdmin`) VALUES (null, '" + name + "', '" + userName + "', '" + pass + "', '0', '0');";
            db.insert(sql);
            LoginScreen hc = new LoginScreen();
            MainEntry.move(backScreen, hc);
            JOptionPane.showMessageDialog(backScreen, "You have successfully registered!");
        } else {
            JOptionPane.showMessageDialog(backScreen, "Passwords don't match!");
        }

    }
}
