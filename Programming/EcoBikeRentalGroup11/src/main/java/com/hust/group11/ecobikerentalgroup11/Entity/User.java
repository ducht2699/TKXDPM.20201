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
public class User {
    private String username, password;
    private int userId, status;

    public User(int userId, String username, int status) {
        this.userId = userId;
        this.username = username;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
