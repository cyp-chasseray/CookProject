package com.example.demo.model;

public class User {
    private int id;
    private String lastname;
    private String firstname;
    private String pictureUrl;
    private String password;
    private String email;

    public User(int id, String lastname, String firstname, String pictureUrl, String password, String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.pictureUrl = pictureUrl;
        this.password = password;
        this.email = email;
    }
    public User(String lastname, String firstname, String pictureUrl, String password, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.pictureUrl = pictureUrl;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

