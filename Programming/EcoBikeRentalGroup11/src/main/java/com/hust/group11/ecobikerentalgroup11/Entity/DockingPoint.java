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
public class DockingPoint {
    private int lockId, status, stationId;
    private String barCode;

    public DockingPoint(int lockId, int status, int stationId, String barCode) {
        this.lockId = lockId;
        this.status = status;
        this.stationId = stationId;
        this.barCode = barCode;
    }

    public int getLockId() {
        return lockId;
    }

    public void setLockId(int lockId) {
        this.lockId = lockId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    
}
