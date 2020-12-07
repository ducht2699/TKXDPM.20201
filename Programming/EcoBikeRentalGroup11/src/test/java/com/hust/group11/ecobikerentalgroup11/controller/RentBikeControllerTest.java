/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.controller;

import com.hust.group11.ecobikerentalgroup11.Entity.Bike;
import com.hust.group11.ecobikerentalgroup11.boundary.ScanCodeScreen;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JLabel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nguyen Thanh Long
 */
public class RentBikeControllerTest {
    private RentBikeController rbc;
            
    public RentBikeControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("------BEFORE ALL----");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("------AFTER ALL----");
    }
    
    @BeforeEach
    public void setUp() throws SQLException {
        System.out.println("------BEFORE EACH----");
        rbc = new RentBikeController();
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("------AFTER EACH----");
    }

    /**
     * Test of calculateDeposit method, of class RentBikeController.
     * @throws java.lang.Exception
     */
    @Test
    public void calculateDeposit() throws Exception {
        System.out.println(" Test calculateDeposit method");
        assertEquals(40, rbc.calculateDeposit(100));
        assertThrows(IOException.class,()-> rbc.calculateDeposit(-100));

    }
    /**
     * Test of payDeposit method, of class RentBikeController.
     */
    @Test
    public void testPayDeposit() throws IOException {
        System.out.println("showInfoDeposit");
        assertEquals(20, rbc.payDeposit(100, 80));
        assertThrows(IOException.class,()-> rbc.payDeposit(80, 100));
        assertThrows(IOException.class,()-> rbc.payDeposit(-20, 100));
        assertThrows(IOException.class,()-> rbc.payDeposit(80, -20));
        
    }
    
}
