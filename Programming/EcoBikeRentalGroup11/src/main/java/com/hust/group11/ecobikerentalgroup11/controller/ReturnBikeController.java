/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.controller;

import com.google.zxing.FormatException;
import com.hust.group11.ecobikerentalgroup11.DataBase;
import com.hust.group11.ecobikerentalgroup11.Constants;
import com.hust.group11.ecobikerentalgroup11.Entity.Bike;
import com.hust.group11.ecobikerentalgroup11.Entity.DockingPoint;
import com.hust.group11.ecobikerentalgroup11.Entity.Transaction;
import com.hust.group11.ecobikerentalgroup11.Entity.User;
import com.hust.group11.ecobikerentalgroup11.GenerateQRCode;
import com.hust.group11.ecobikerentalgroup11.MainEntry;
import com.hust.group11.ecobikerentalgroup11.boundary.RentBikeScreen;
import com.hust.group11.ecobikerentalgroup11.boundary.ReturnBikeScreen;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Thanh Long
 */
public class ReturnBikeController {

    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;
    private DataBase db;

    public ReturnBikeController() throws SQLException {
        super();
        db = new DataBase();
    }

    public void handleCheckBarCode(ActionEvent e, File f, JFrame backScreen, User user, Bike bike, Transaction transaction) throws SQLException, FormatException {
        System.out.println("Add file here");
        String sqlString = "select * from docking_lock";
        ResultSet rs = db.query(sqlString);
        String barCodeScan = GenerateQRCode.readQRCode(f.getName());
        System.out.println("image code name: " + f.getName());
        Boolean isSuccess = false;
        String idLock = "";
        DockingPoint dp = new DockingPoint(0, 0, 0, "");
        while (rs.next()) {
            String barCode = rs.getString("bar_code");
            System.out.println("barcode: " + barCode);
            System.out.println("barcode scan: " + barCodeScan);
            if (barCodeScan == null ? barCode == null : barCodeScan.equals(barCode)) {
                dp.setLockId(rs.getInt("lock_id"));
                dp.setStationId(rs.getInt("station_id"));
                dp.setBarCode(rs.getString("bar_code"));
                dp.setStatus(rs.getInt("status"));
                int dockingStatus = rs.getInt("status");
                System.out.println("lockid---------->: " + dp.getLockId());
                isSuccess = true;
                System.out.println("status docking: " + dockingStatus);
                if (user.getStatus() == Constants.USER_RENTING) {
                    if (dockingStatus == Constants.DOCKING_AVAIL) {
                        System.out.println("Route to return");
                        ReturnBikeScreen returnBikeScreen = new ReturnBikeScreen(transaction, bike, user, dp, backScreen);
                        MainEntry.move(backScreen, returnBikeScreen);
                    } else {
                        JOptionPane.showMessageDialog(backScreen, "The doking point is not available to return!!");
                    }
                } else {
                    if (dockingStatus == Constants.DOCKING_AVAIL) {
                        JOptionPane.showMessageDialog(backScreen, "The doking point have no bike to rent!");
                    } else {
                        int confirm = JOptionPane.showConfirmDialog(backScreen, "You are not renting!!!");
                        if (confirm == JOptionPane.OK_OPTION) {
                            System.out.println("Route to rent");
                            idLock = rs.getString("lock_id");
                            System.out.println("id Lock : " + idLock);
                            RentBikeScreen rentBikeScreen = new RentBikeScreen(user, dp, backScreen);
                            MainEntry.move(backScreen, rentBikeScreen);
                        } else {
                            JOptionPane.showMessageDialog(backScreen, "Good bye you should find another docking");
                        }

                    }

                }

            }
        }
        if (!isSuccess) {
            JOptionPane.showMessageDialog(backScreen, "Scan code fail, Try again!!");
        }
    }

    public void showInfoDeposit(Bike bike, JLabel valueBikeModel, JLabel valueBike, JLabel valueDeposit) throws Exception {
        int valueOfBike = bike.getValue();
        String modelOfBike = bike.getModel();

        valueBikeModel.setText(modelOfBike);
        valueBike.setText(Integer.toString(valueOfBike) + Constants.MONEY_UNIT);
        valueDeposit.setText(Integer.toString(calculateDeposit(valueOfBike)) + Constants.MONEY_UNIT);
    }

    public int calculateDeposit(int valueOfBike) throws Exception {
        if (valueOfBike < 0) {
            throw new IOException("Value of bike can not be negative");
        }
        return (int) Constants.DEPOSIT_PERCENT * valueOfBike / 100;
    }

    public int payDeposit(int balance, int deposit) throws IOException {
        if (balance < deposit) {
            throw new IOException("Balance can not smaller than deposit");
        };
        if (balance <= 0 || deposit <= 0) {
            throw new IOException("Balance or Deposit can not negative");
        }
        return balance - deposit;
    }

    public void route(JPanel route, JPanel screenBefore) {
        try {
            route.setVisible(true);
            screenBefore.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(RentBikeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
