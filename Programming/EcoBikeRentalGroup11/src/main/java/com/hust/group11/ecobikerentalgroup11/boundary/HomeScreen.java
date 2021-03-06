/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.boundary;

import com.hust.group11.ecobikerentalgroup11.Constants;
import com.hust.group11.ecobikerentalgroup11.DataBase;
import com.hust.group11.ecobikerentalgroup11.Entity.Bike;
import com.hust.group11.ecobikerentalgroup11.Entity.Transaction;
import com.hust.group11.ecobikerentalgroup11.Entity.User;
import com.hust.group11.ecobikerentalgroup11.MainEntry;
import java.awt.Color;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Thanh Long
 */
public class HomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form HomeScreen
     */
    private DataBase db;
    public static User user;
    private JFrame backScreen;
    private Transaction transaction;
    private Bike bike;

    public HomeScreen(User user, JFrame backScreen) throws SQLException {
        initComponents();
        this.user = user;
        this.backScreen = backScreen;
        this.db = new DataBase();
        imageCodePanel.showImage(new File("home_station.jpg"));
        usernameLabel.setText(user.getUsername());
        if (user.getStatus() == Constants.USER_RENTING) {
            System.out.println("Home user is renting");
            getTransaction();
            statusLabel.setForeground(Color.green);
            statusLabel.setText("renting...");

        } else {
            statusLabel.setForeground(Color.red);
            statusLabel.setText("not rent");
        }
    }

    private void getTransaction() throws SQLException {
        int bikeId;
        String sqlGetTransaction = "SELECT * FROM transaction WHERE user_id = '" + user.getUserId() + "'";
        ResultSet rs = db.query(sqlGetTransaction);
        while (rs.next()) {
            transaction = new Transaction(rs.getString("start_time"), rs.getString("end_time"), rs.getInt("bike_id"), rs.getInt("user_id"), rs.getInt("transaction_id"), rs.getInt("status"), rs.getInt("deposit"));
            String sqlGetBike = "SELECT * FROM bike WHERE bike_id = '" + transaction.getBikeId() + "'";
            System.out.println("bike_id_transaction===>" + transaction.getBikeId());
            ResultSet rs2 = db.query(sqlGetBike);
            bike = new Bike(0, 0, 0, 0, "", "", "", "", "", "", 1);
            while (rs2.next()) {
                bike.setBikeId(rs2.getInt("bike_id"));
                bike.setStationId(rs2.getInt("station_id"));
                bike.setLockId(rs2.getInt("lock_id"));
                bike.setValue(rs2.getInt("value_of_bike"));
                bike.setLicensePlate(rs2.getString("plate_license"));
                bike.setModel(rs2.getString("model"));
                bike.setType(rs2.getString("type"));
                bike.setBattery(rs2.getString("battery"));
                bike.setBrand(rs2.getString("brand"));
                bike.setImage(rs2.getString("image"));
                bike.setStatus(rs2.getInt("status"));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        imageCodePanel = new com.hust.group11.ecobikerentalgroup11.boundary.ImageCodePanel();
        findStationButton = new javax.swing.JButton();
        rentingButton = new javax.swing.JButton();
        rentBikeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ECO BIKE RENTAL");

        jLabel2.setText("GROUP 7");

        logoutButton.setText("Log out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        usernameLabel.setText("Username");

        statusLabel.setText("Status");

        javax.swing.GroupLayout imageCodePanelLayout = new javax.swing.GroupLayout(imageCodePanel);
        imageCodePanel.setLayout(imageCodePanelLayout);
        imageCodePanelLayout.setHorizontalGroup(
            imageCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageCodePanelLayout.setVerticalGroup(
            imageCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        findStationButton.setText("Find Station");
        findStationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findStationButtonActionPerformed(evt);
            }
        });

        rentingButton.setText("Renting");
        rentingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentingButtonActionPerformed(evt);
            }
        });

        rentBikeButton.setText("Rent bike");
        rentBikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentBikeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addGap(37, 37, 37)
                        .addComponent(logoutButton))
                    .addComponent(statusLabel))
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageCodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(findStationButton)
                        .addGap(47, 47, 47)
                        .addComponent(rentingButton)
                        .addGap(40, 40, 40)
                        .addComponent(rentBikeButton)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logoutButton)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statusLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findStationButton)
                    .addComponent(rentingButton)
                    .addComponent(rentBikeButton))
                .addGap(27, 27, 27)
                .addComponent(imageCodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rentingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentingButtonActionPerformed
        if (user.getStatus() == Constants.USER_RENTING) {
            RentingScreen rentingScreen = new RentingScreen(transaction, user, bike, this);
            MainEntry.move(this, rentingScreen);
        } else {
            JOptionPane.showMessageDialog(this, "You are not renting");
        }
    }//GEN-LAST:event_rentingButtonActionPerformed

    private void rentBikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentBikeButtonActionPerformed
        try {
            if (user.getStatus() == Constants.USER_AVAIL) {
                ScanCodeScreen scs = new ScanCodeScreen(user, this);
                MainEntry.move(this, scs);
            } else {
                ScanCodeScreen scs = new ScanCodeScreen(transaction, bike, user, this);
                MainEntry.move(this, scs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rentBikeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure");
        System.out.println("confirm: " + confirm);
        if (confirm == JOptionPane.YES_OPTION) {
            MainEntry.move(this, new LoginScreen());
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void findStationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findStationButtonActionPerformed
        try {
            MainEntry.move(this, new FindStationScreen(user, this));
        } catch (SQLException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_findStationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findStationButton;
    private com.hust.group11.ecobikerentalgroup11.boundary.ImageCodePanel imageCodePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton rentBikeButton;
    private javax.swing.JButton rentingButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
