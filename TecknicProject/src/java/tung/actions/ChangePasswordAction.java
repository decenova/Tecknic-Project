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
import org.apache.struts2.convention.annotation.Result;
import tung.dao.UserDAO;

/**
 *
 * @author hoanh
 */
public class ChangePasswordAction extends ActionSupport {

    String newPassword;

    public ChangePasswordAction() {
    }

    @Action(value = "/changePwd", results = {
        @Result(name = "success", location = "/login.jsp")
    })
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        if (dao.changePassword(newPassword, (String) session.get("USERNAME"))) {
            session.put("USERNAME", null);
            session.put("NAME", null);
            session.put("AVATAR", null);
            session.put("ROLE", null);
        }
        return SUCCESS;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
