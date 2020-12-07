/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nguyen Thanh Long
 */
public class DataBase {

    private final int PORT = 3306;
    private final String DB_NAME = "tkxdpm_nhom11";
    private final String URL = "jdbc:mysql://localhost:" + PORT + "/" + DB_NAME;
    private final String USER = "root";
    private final String PASS = "";
    public Connection connection;

    public DataBase() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASS);
    }

    public ResultSet query(String sqlString) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlString);
        return rs;
    }

    public int update(String sqlString) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlString);
        int update = statement.executeUpdate();
        return update;
    }

    public int getRow(String sqlString) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlString);
        int rowcount = 0;
        while (rs.next()) {
            rowcount++;
        }
        return rowcount;
    }

    public ResultSet insert(String sqlString) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        return rs;
    }
}
