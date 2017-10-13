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

/**
 *
 * @author Decen
 */
public class Logout extends ActionSupport {
    
    public Logout() {
    }
    @Action(value = "/logout", results = {
        @Result(name = "success", location = "/index.jsp"),
        @Result(name = "false", location = "/error.jsp")
    })
    public String execute() throws Exception {
        try {
            Map session = ActionContext.getContext().getSession();
            session.put("USERNAME", null);
            session.put("NAME", null);
            session.put("AVATAR", null);
            session.put("ROLE", null);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "success";
    }
    
}
