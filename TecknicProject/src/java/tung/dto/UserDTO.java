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
    private Timestamp doj;
    private String txtDateOfJoin;
    private long totalOfView;

    public Timestamp getDoj() {
        return doj;
    }

    public void setDoj(Timestamp doj) {
        this.doj = doj;
    }
    private String address;
    private String role;

    public UserDTO() {
        avatar = "img/defaultavatar.jpg";
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

    public String getTxtDateOfJoin() {
        return txtDateOfJoin;
    }

    public void setTxtDateOfJoin(String txtDateOfJoin) {
        this.txtDateOfJoin = txtDateOfJoin;
    }

    public long getTotalOfView() {
        return totalOfView;
    }

    public void setTotalOfView(long totalOfView) {
        this.totalOfView = totalOfView;
    }
    
    

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", avatar=" + avatar + ", gender=" + gender + ", datetime=" + dob + ", email=" + email + ", phoneNum=" + phoneNum + ", address=" + address + ", role=" + role + '}';
    }
}
