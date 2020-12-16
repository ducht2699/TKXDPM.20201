/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.boundary;

/**
 *
 * @author Nguyen Hai Long
 */
import com.hust.group11.ecobikerentalgroup11.DataBase;
import com.hust.group11.ecobikerentalgroup11.Entity.Station;
import com.hust.group11.ecobikerentalgroup11.Entity.User;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.hust.group11.ecobikerentalgroup11.MainEntry;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminManageStation extends javax.swing.JFrame {

    /**
     * Creates new form FindStationScreen
     */
    private JFrame backScreen;
    private ArrayList<Station> arrStation;
    private DataBase db;
    private User user;
    private Station passStation;

    public AdminManageStation(User user, JFrame backScreen) throws SQLException {
        initComponents();
        this.backScreen = backScreen;
        this.db = new DataBase();
        this.user = user;
        showInfoTable();
        sortTable();
    }

    public void deleteStation() throws SQLException {
        int column = 1;
        int row = stationListTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Choose a station first!");
        } else {
            String value = stationListTable.getModel().getValueAt(row, column).toString();

            arrStation.forEach((Station s) -> {
                if (s.getStationName().equals(value)) {
                    passStation = s;
                }
            });

            //delete station in DB
            String sqlDelete = "DELETE FROM station WHERE station_id = ?";
            db.delete(sqlDelete, passStation.getStationId());

            JOptionPane.showMessageDialog(this, "Deleted!");

        }
    }

    public void showInfoTable() throws SQLException {
        arrStation = new ArrayList<>();
        try {
            String sqlString = "select * from station";
            ResultSet rs = db.query(sqlString);
            while (rs.next()) {
                System.out.println("set station" + rs.getString("station_name"));
                Station s = new Station(0, 0, 0, 0, "", "", "");
                s.setStationArea(rs.getInt("area"));
                s.setStationName(rs.getString("station_name"));
                s.setStationId(rs.getInt("station_id"));
                s.setLocationCode(rs.getString("location_code"));
                s.setAddress(rs.getString("address"));
                arrStation.add(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        DefaultTableModel model = (DefaultTableModel) stationListTable.getModel();
        model.setRowCount(0);
        System.out.println("set Model here" + arrStation.size());
        model.fireTableDataChanged();
        for (int i = 0; i < arrStation.size(); i++) {
            Station s = arrStation.get(i);

            String sqlGetDockingPoint = "select * from docking_lock where station_id='" + s.getStationId() + "'";
            int numDockingPoint = db.getRow(sqlGetDockingPoint);
            System.out.println("num docking : " + numDockingPoint);
            s.setNumberDockingPoint(numDockingPoint);

            String sqlGetBikeAvailable = "select * from bike where station_id='" + s.getStationId() + "' and status='0'";
            int numbikeAvailable = db.getRow(sqlGetBikeAvailable);
            System.out.println("num bike avail: " + numbikeAvailable);
            s.setNumBikeAvailable(numbikeAvailable);

            model.addRow(new Object[]{i + 1, s.getStationName(), 100, s.getAddress(), s.getNumBikeAvailable()});
            System.out.println("add row" + s.getStationName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stationListTable = new javax.swing.JTable();
        textFieldSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEditStation = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        btnAddStation = new javax.swing.JButton();
        btnDeleteStation = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find Station");
        setResizable(false);

        stationListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Station Name", "Distance(m)", "Address", "Bike Avail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stationListTable.setToolTipText("");
        stationListTable.setRowHeight(18);
        stationListTable.setRowMargin(2);
        stationListTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(stationListTable);
        if (stationListTable.getColumnModel().getColumnCount() > 0) {
            stationListTable.getColumnModel().getColumn(0).setResizable(false);
            stationListTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            stationListTable.getColumnModel().getColumn(1).setResizable(false);
            stationListTable.getColumnModel().getColumn(1).setPreferredWidth(160);
            stationListTable.getColumnModel().getColumn(2).setResizable(false);
            stationListTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            stationListTable.getColumnModel().getColumn(3).setPreferredWidth(250);
            stationListTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Search Station");

        btnEditStation.setText("Edit");
        btnEditStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStationActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        btnAddStation.setText("Add");
        btnAddStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStationActionPerformed(evt);
            }
        });

        btnDeleteStation.setText("Delete");
        btnDeleteStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddStation, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditStation)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteStation, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldSearch)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditStation)
                    .addComponent(btnAddStation)
                    .addComponent(btnDeleteStation)
                    .addComponent(backButton))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void btnEditStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStationActionPerformed
        int column = 1;
        int row = stationListTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "You have not choose station");
        } else {
            String value = stationListTable.getModel().getValueAt(row, column).toString();

            arrStation.forEach((Station s) -> {
                if (s.getStationName().equals(value)) {
                    passStation = s;
                }
            });
            try {
                MainEntry.move(this, new AdminEditStationScreen(this, user, passStation));
                //showInfoTable();
            } catch (SQLException ex) {
                System.out.println("ERROR! btnEdit");
                Logger.getLogger(AdminManageStation.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            System.out.println("value: " + value);
        }
    }//GEN-LAST:event_btnEditStationActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainEntry.move(this, backScreen);
    }//GEN-LAST:event_backButtonActionPerformed

    private void btnDeleteStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStationActionPerformed
        try {
            // TODO add your handling code here:
            deleteStation();
            showInfoTable();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminManageStation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteStationActionPerformed

    private void btnAddStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStationActionPerformed
        try {
            //create new form add station
            MainEntry.move(this, new AdminAddStation(user, this, stationListTable));
        } catch (SQLException ex) {
            Logger.getLogger(AdminManageStation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddStationActionPerformed

    private void sortTable() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(stationListTable.getModel());
        stationListTable.setRowSorter(sorter);
        textFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textFieldSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textFieldSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnAddStation;
    private javax.swing.JButton btnDeleteStation;
    private javax.swing.JButton btnEditStation;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stationListTable;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
