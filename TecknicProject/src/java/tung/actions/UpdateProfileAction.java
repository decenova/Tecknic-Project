/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.UserDAO;
import tung.dto.UserDTO;
import tung.utils.Utils;

/**
 *
 * @author hoanh
 */
public class UpdateProfileAction extends ActionSupport {

    private String txtName;
    private String cbxGender;
    private String txtDob;
    private String txtEmail;
    private String txtAddress;

    
    public UpdateProfileAction() {
    }

    @Action(value = "/updateProfile", results = {
//        @Result(name = "input", location = "/error.jsp"),
        @Result(name = "success", location = "/profilemanager.jsp"),
        @Result(name = "fail", location = "/profilemanager.jsp"),
    
    })
    public String execute() throws Exception {
        String url = "fail";
        UserDAO dao = new UserDAO();
        char gender = cbxGender.charAt(0);
        Timestamp dob = Utils.parseToDate(txtDob);
        UserDTO user = new UserDTO();
        user.setName(txtName);
        user.setGender(gender);
        user.setDob(dob);
        user.setEmail(txtEmail);
        user.setAddress(txtAddress);
        if (dao.updateUser(user))
            url = SUCCESS;
        return url;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getCbxGender() {
        return cbxGender;
    }

    public void setCbxGender(String cbxGender) {
        this.cbxGender = cbxGender;
    }

    public String getTxtDob() {
        return txtDob;
    }

    public void setTxtDob(String txtDob) {
        this.txtDob = txtDob;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }

}
