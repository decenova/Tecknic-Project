/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import thang.dao.UserDAO;

/**
 *
 * @author Decen
 */
@ParentPackage("json-default")
public class CheckUsernameAction extends ActionSupport {
    private boolean check;
    private String username;
    public CheckUsernameAction() {
    }
    @Action(value = "/checkusername", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        check = dao.isUsernameExsisted(username);
        return "success";
    }

    public boolean isCheck() {
        return check;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
