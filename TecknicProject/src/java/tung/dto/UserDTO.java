/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.dto;

import java.sql.Timestamp;

/**
 *
 * @author hoanh
 */
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private char gender;
    private Timestamp dob;
    private String email;
    private String phoneNum;
    private String address;
    private String role;

    public UserDTO() {
        avatar = "img/defaultavatar.jpg";
    }

    public UserDTO(String username, String name, char gender, Timestamp dob, String email, String phoneNum, String address, String role) {
        avatar = "img/defaultavatar.jpg";
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.role = role;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", avatar=" + avatar + ", gender=" + gender + ", datetime=" + dob + ", email=" + email + ", phoneNum=" + phoneNum + ", address=" + address + ", role=" + role + '}';
    }
}
