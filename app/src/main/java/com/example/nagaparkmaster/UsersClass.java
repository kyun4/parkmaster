package com.example.nagaparkmaster;

public class UsersClass {
    String username;
    String email;
    String address;
    String firebase_uid;
    String firstname;
    String lastname;
    String phone;
    String current_location_latitude;
    String current_location_longitude;
    String date_time_registered;


    public UsersClass() {
    }

    public UsersClass(String username, String email, String address, String firebase_uid, String firstname, String lastname, String phone, String current_location_latitude, String current_location_longitude, String date_time_registered) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.firebase_uid = firebase_uid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.current_location_latitude = current_location_latitude;
        this.current_location_longitude = current_location_longitude;
        this.date_time_registered = date_time_registered;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirebase_uid() {
        return firebase_uid;
    }

    public void setFirebase_uid(String firebase_uid) {
        this.firebase_uid = firebase_uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrent_location_latitude() {
        return current_location_latitude;
    }

    public void setCurrent_location_latitude(String current_location_latitude) {
        this.current_location_latitude = current_location_latitude;
    }

    public String getCurrent_location_longitude() {
        return current_location_longitude;
    }

    public void setCurrent_location_longitude(String current_location_longitude) {
        this.current_location_longitude = current_location_longitude;
    }

    public String getDate_time_registered() {
        return date_time_registered;
    }

    public void setDate_time_registered(String date_time_registered) {
        this.date_time_registered = date_time_registered;
    }
}
