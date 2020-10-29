package com.example.footballnews.model;

import java.io.Serializable;

public class Users implements Serializable {
    private String name;
    private String email;
    private String pass;
    private String gender;
    private String location;

    public Users() {
    }

    public Users(String name, String email, String pass, String gender, String location) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.gender = gender;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
