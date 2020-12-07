/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group11.ecobikerentalgroup11.Entity;

/**
 *
 * @author DELL
 */
public class Station {
    private int stationId, stationArea, numBikeAvailable, numberDockingPoint;
    private String address, locationCode, stationName;

    public Station(int stationId, int stationArea, int numBikeAvailable, int numberDockingPoint, String address, String locationCode, String stationName) {
        this.stationId = stationId;
        this.stationArea = stationArea;
        this.numBikeAvailable = numBikeAvailable;
        this.numberDockingPoint = numberDockingPoint;
        this.address = address;
        this.locationCode = locationCode;
        this.stationName = stationName;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getStationArea() {
        return stationArea;
    }

    public void setStationArea(int stationArea) {
        this.stationArea = stationArea;
    }

    public int getNumBikeAvailable() {
        return numBikeAvailable;
    }

    public void setNumBikeAvailable(int numBikeAvailable) {
        this.numBikeAvailable = numBikeAvailable;
    }

    public int getNumberDockingPoint() {
        return numberDockingPoint;
    }

    public void setNumberDockingPoint(int numberDockingPoint) {
        this.numberDockingPoint = numberDockingPoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


}
