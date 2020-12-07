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
public class PaymentMethod {
    private String nameMethod, cardCode, nameOwner;
    private int cvvCode, dateExpired;

    public PaymentMethod(String nameMethod, String cardCode, String nameOwner, int cvvCode, int dateExpired) {
        this.nameMethod = nameMethod;
        this.cardCode = cardCode;
        this.nameOwner = nameOwner;
        this.cvvCode = cvvCode;
        this.dateExpired = dateExpired;
    }

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    public int getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(int dateExpired) {
        this.dateExpired = dateExpired;
    }
    
    
}
