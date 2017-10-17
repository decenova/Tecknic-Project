/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.UserDAO;
import tung.dto.UserDTO;

/**
 *
 * @author hoanh
 */
public class LoadProfileAction extends ActionSupport {
    private UserDTO userProfile;
    
    public LoadProfileAction() {
    }
    @Action(value = "/loadProfile", results = {
        @Result(name = "success", location = "/profilemanager.jsp")
    })
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String username = (String) session.get("USERNAME");
        UserDAO dao = new UserDAO();
        userProfile = dao.loadUser(username);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("Profile", userProfile);
        return SUCCESS;
    }

    public UserDTO getUserProfile() {
        return userProfile;
    }
    
    
}
