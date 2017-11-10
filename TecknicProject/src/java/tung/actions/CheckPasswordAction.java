/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.UserDAO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class CheckPasswordAction extends ActionSupport {

    String oldPassword;
    boolean checkRight;

    public CheckPasswordAction() {
    }

    @Action(value = "/checkPwd", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        checkRight = false;
        UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        if (oldPassword.equals(dao.getPasswordByUsername((String) session.get("USERNAME")))) {
            checkRight = true;
        }
        System.out.println(checkRight);
        return SUCCESS;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public boolean isCheckRight() {
        return checkRight;
    }

    public void setCheckRight(boolean checkRight) {
        this.checkRight = checkRight;
    }

}
