/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.Entity;

/**
 *
 * @author Nguyen Thanh Long
 */
public class Transaction {
    private String startTime, endTime;
    private int bikeId, userId, transactionId, status, deposit;

    public Transaction(String startTime, String endTime, int bikeId, int userId, int transactionId, int status, int deposit) {
        this.startTime = startTime;
        this.bikeId = bikeId;
        this.userId = userId;
        this.transactionId = transactionId;
        this.status = status;
        this.deposit = deposit;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
    
    
    
}
