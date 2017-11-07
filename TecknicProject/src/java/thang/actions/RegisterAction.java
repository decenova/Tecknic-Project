/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import thang.dao.UserDAO;
import thang.dto.UserDTO;
import tung.utils.Utils;

/**
 *
 * @author Decen
 */
public class RegisterAction extends ActionSupport {
    private String username;
    private String password;
    private String name;
    private String avatar;
    private char gender;
    private String dob;
    private Timestamp doj;
    private String email;
    private String phoneNum;
    private String address;
    public RegisterAction() {
    }
    
    @Action(value = "/register", results = {
        @Result(name = "input", location = "/error.jsp"),
        @Result(name = "success", location = "/login.jsp"),
        @Result(name = "false", location = "/error.jsp")
    })
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        doj = new Timestamp(new Date().getTime());
        Timestamp dobtime = (dob.equals(""))?null:Utils.parseToDate(dob);
        boolean check = dao.createUser(new UserDTO(username, password, name, gender, dobtime, doj, email, phoneNum, address));
        if (check)
            return "success";
        else
            return "false";
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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
    
}
