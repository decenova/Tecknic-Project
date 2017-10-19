/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import thang.dao.UserDAO;
import thang.dto.UserDTO;

/**
 *
 * @author Decen
 */
public class LoginAction extends ActionSupport {

    private String txtUsername;
    private String txtPassword;
    private UserDTO dto;
    private boolean isFalse = false;

    public LoginAction() {
    }

    @Action(value = "/login", results = {
        @Result(name = "input", location = "/error.jsp"),
        @Result(name = "success", location = "/index.jsp"),
        @Result(name = "false", location = "/login.jsp")
    })
    public String execute() throws Exception {
        UserDAO uDao = new UserDAO();
        dto = uDao.checkLogin(txtUsername, txtPassword);
        if (dto.getRole().equals("false")) {
            isFalse = true;
            return "false";
        }
        else {
            isFalse = false;
            Map session = ActionContext.getContext().getSession();
            session.put("ID", dto.getId());
            session.put("USERNAME", dto.getUsername());
            session.put("NAME", dto.getName());
            session.put("AVATAR", dto.getAvatar());
            session.put("ROLE", dto.getRole());
//            session.put("ID", dto.getId()); // tung thêm
        }
        return "success";
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public UserDTO getDto() {
        return dto;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }


    public boolean isIsFalse() {
        return isFalse;
    }

    public void setIsFalse(boolean isFalse) {
        this.isFalse = isFalse;
    }

}
