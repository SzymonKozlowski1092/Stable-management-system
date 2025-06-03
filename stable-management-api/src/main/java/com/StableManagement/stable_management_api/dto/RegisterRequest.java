package com.StableManagement.stable_management_api.dto;

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private int code;
    private String password;

    public String getFirstName() {return firstName;}
    public String getLastName(){return lastName; }
    public String getUsername() {return username; }
    public String getPhoneNumber() {return phoneNumber; }
    public int getCode() { return code; }
    public String getPassword(){ return password; }
}