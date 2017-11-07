/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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
    private String txtPhoneNum;
    private String flAvatar;

    
    public UpdateProfileAction() {
    }

    @Action(value = "/updateProfile", results = {
//        @Result(name = "input", location = "/error.jsp"),
        @Result(name = "success", type = "redirectAction", params = {
            "actionName", "loadProfile"
        }),
        @Result(name = "fail", location = "/profilemanager.jsp"),
    
    })
    public String execute() throws Exception {
        String url = "fail";
        UserDAO dao = new UserDAO();
        char gender = cbxGender.charAt(0);
        Timestamp dob = (txtDob.isEmpty()) ? null : Utils.parseToDate(txtDob);
        UserDTO user = new UserDTO();
        Map session = ActionContext.getContext().getSession();
        if (!flAvatar.isEmpty())
            user.setAvatar("img/" + flAvatar);
        user.setUsername((String)session.get("USERNAME"));
        user.setName(txtName);
        user.setGender(gender);
        user.setDob(dob);
        user.setEmail(txtEmail);
        user.setAddress(txtAddress);
        user.setPhoneNum(txtPhoneNum);
        if (dao.updateUser(user)) {
            session.put("AVATAR", user.getAvatar());
            url = SUCCESS;
        }
            
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

    public String getTxtPhoneNum() {
        return txtPhoneNum;
    }

    public void setTxtPhoneNum(String txtPhoneNum) {
        this.txtPhoneNum = txtPhoneNum;
    }

    public String getFlAvatar() {
        return flAvatar;
    }

    public void setFlAvatar(String flAvatar) {
        this.flAvatar = flAvatar;
    }





    
}
