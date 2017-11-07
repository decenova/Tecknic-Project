/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dto;

import java.sql.Timestamp;

/**
 *
 * @author Decen
 */
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private char gender;
    private Timestamp dob;
    private Timestamp doj;
    private String email;
    private String phoneNum;
    private String address;
    private String role;
    private int roleId;

    public UserDTO() {
        avatar = "img/defaultavatar.jpg";
    }

    public UserDTO(int id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = (avatar == null || avatar.length() <= 0)?"img/defaultavatar.jpg":avatar;
    }
    
    public UserDTO(String username, String password, String name, char gender, Timestamp dob, Timestamp doj, String email, String phoneNum, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.avatar = "img/defaultavatar.jpg";
        this.gender = gender;
        this.dob = dob;
        this.doj = doj;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.role = "Member";
        this.roleId = 1;
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

    public Timestamp getDoj() {
        return doj;
    }

    public void setDoj(Timestamp doj) {
        this.doj = doj;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", avatar=" + avatar + ", gender=" + gender + ", datetime=" + dob + ", email=" + email + ", phoneNum=" + phoneNum + ", address=" + address + ", role=" + role + '}';
    }

}
