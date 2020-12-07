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

public class Bike {
    private int bikeId, stationId, lockId, value, status;
    private String licensePlate, model, type, battery, brand, image;

    public Bike(int bikeId, int stationId, int lockId, int value,
            String licensePlate, String model, String type,
            String battery, String brand, String image, int status) {
        this.bikeId = bikeId;
        this.stationId = stationId;
        this.lockId = lockId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.type = type;
        this.battery = battery;
        this.brand = brand;
        this.image = image;
        this.status = status;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getLockId() {
        return lockId;
    }

    public void setLockId(int lockId) {
        this.lockId = lockId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
    
}
