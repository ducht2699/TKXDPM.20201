/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.boundary;

import com.hust.group11.ecobikerentalgroup11.Constants;
import com.hust.group11.ecobikerentalgroup11.DataBase;
import com.hust.group11.ecobikerentalgroup11.Entity.Bike;
import com.hust.group11.ecobikerentalgroup11.Entity.DockingPoint;
import com.hust.group11.ecobikerentalgroup11.Entity.Station;
import com.hust.group11.ecobikerentalgroup11.Entity.User;
import com.hust.group11.ecobikerentalgroup11.MainEntry;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nguyen Hai Long
 */
public class ViewListBikeScreen extends javax.swing.JFrame {

    /**
     * Creates new form ViewListBikeScreen
     */
    private JFrame backScreen;
    private Station station;
    private ArrayList<Bike> arrBike;
    private DataBase db;
    private Bike passBike;
    private DockingPoint dp;
    private User user;

    public ViewListBikeScreen(JFrame backScreen, User user, Station station) throws SQLException {
        initComponents();
        this.station = station;
        stationName.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        stationName.setText(station.getStationName());
        this.backScreen = backScreen;
        this.db = new DataBase();
        this.user = user;
        showListBike();
        sortTable();
    }

    private void showListBike() {
        arrBike = new ArrayList<>();
        try {
            String sqlString = "select * from bike where station_id = '" + station.getStationId() + "'";
            ResultSet rs = db.query(sqlString);
            while (rs.next()) {
                Bike bike = new Bike(0, 0, 0, 0, "", "", "", "", "", "", 1);
                bike.setBikeId(rs.getInt("bike_id"));
                bike.setStationId(rs.getInt("station_id"));
                bike.setLockId(rs.getInt("lock_id"));
                bike.setValue(rs.getInt("value_of_bike"));
                bike.setLicensePlate(rs.getString("plate_license"));
                bike.setModel(rs.getString("model"));
                bike.setType(rs.getString("type"));
                bike.setBattery(rs.getString("battery"));
                bike.setBrand(rs.getString("brand"));
                bike.setImage(rs.getString("image"));
                bike.setStatus(rs.getInt("status"));
                arrBike.add(bike);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        DefaultTableModel model = (DefaultTableModel) listBikeTable.getModel();
        System.out.println("set Model here");
        for (int i = 0; i < arrBike.size(); i++) {
            Bike b = arrBike.get(i);
            String status = b.getStatus() == 0 ? "Available" : "Busy";
            model.addRow(new Object[]{i, b.getLicensePlate(), b.getModel(), b.getType(),
                b.getLockId(), b.getBattery() + " %", status, b.getValue() + Constants.MONEY_UNIT});
        }
        model.fireTableDataChanged();
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
        filterComboBox = new javax.swing.JComboBox<>();
        rentBikeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBikeTable = new javax.swing.JTable();
        stationName = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View List Bike");
        setResizable(false);

        jLabel1.setText("Choice bike type:");

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Single Bike", "Double Bike", "Electric Bike" }));

        rentBikeBtn.setText("Rent bike");
        rentBikeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentBikeBtnActionPerformed(evt);
            }
        });

        listBikeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Plate License", "Model", "Type", "Docking Point", "Battery", "Status", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listBikeTable.setToolTipText("");
        listBikeTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        listBikeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(listBikeTable);
        if (listBikeTable.getColumnModel().getColumnCount() > 0) {
            listBikeTable.getColumnModel().getColumn(0).setResizable(false);
            listBikeTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            listBikeTable.getColumnModel().getColumn(1).setResizable(false);
            listBikeTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            listBikeTable.getColumnModel().getColumn(2).setResizable(false);
            listBikeTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            listBikeTable.getColumnModel().getColumn(3).setResizable(false);
            listBikeTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            listBikeTable.getColumnModel().getColumn(4).setResizable(false);
            listBikeTable.getColumnModel().getColumn(4).setPreferredWidth(60);
            listBikeTable.getColumnModel().getColumn(5).setResizable(false);
            listBikeTable.getColumnModel().getColumn(5).setPreferredWidth(40);
            listBikeTable.getColumnModel().getColumn(6).setResizable(false);
            listBikeTable.getColumnModel().getColumn(6).setPreferredWidth(50);
            listBikeTable.getColumnModel().getColumn(7).setResizable(false);
            listBikeTable.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        stationName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stationName.setText("Station name");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(backButton)
                            .addGap(18, 18, 18)
                            .addComponent(rentBikeBtn)
                            .addGap(255, 255, 255))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(stationName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stationName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentBikeBtn)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void sortTable() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listBikeTable.getModel());
        listBikeTable.setRowSorter(sorter);
        filterComboBox.addActionListener((ActionEvent e) -> {
            String text = filterComboBox.getSelectedItem().toString();
            if (text.trim().length() == 0) {
                sorter.setRowFilter(null);
            } else {
                if (text.trim().equals("All")) {
                    System.out.println("set null key");
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Bike"));
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
    }


    private void rentBikeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentBikeBtnActionPerformed
//        
        int column = 1;
        int row = listBikeTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "You have not choose station");
        } else {
            String value = listBikeTable.getModel().getValueAt(row, column).toString();

            arrBike.forEach((Bike b) -> {
                if (b.getLicensePlate().equals(value)) {
                    passBike = b;
                }
            });
            String sqlGetDockingPoint = "select * from docking_lock where lock_id='"+passBike.getLockId()+"'";
            ResultSet rs;
            try {
                rs = db.query(sqlGetDockingPoint);
                dp = new DockingPoint(0, 0, 0, "");
                while(rs.next()) {
                    System.out.println("barcode passing : " + rs.getString("bar_code"));
                    dp.setBarCode(rs.getString("bar_code"));
                    dp.setLockId(rs.getInt("lock_id"));
                    dp.setStationId(rs.getInt("station_id"));
                    dp.setStatus(rs.getInt("status"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewListBikeScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            MainEntry.move(this, new RentBikeScreen(user, dp, backScreen));
            System.out.println("value: " + value);;
        }
    }//GEN-LAST:event_rentBikeBtnActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainEntry.move(this, backScreen);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listBikeTable;
    private javax.swing.JButton rentBikeBtn;
    private javax.swing.JLabel stationName;
    // End of variables declaration//GEN-END:variables
}
