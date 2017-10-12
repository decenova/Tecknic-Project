/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


/**
 *
 * @author Decen
 */
public class LoginAction extends ActionSupport{
    private String txtUsername;
    private String txtPassword;
    public LoginAction() {
    }
    @Action(value = "/loginControl", results = {
        @Result(name = "input", location = "error.jsp")
    })
    public String execute() throws Exception {
        
        return "";
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
    
}
