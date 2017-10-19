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
import tung.utils.Utils;

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
        String doj = Utils.convertToDateV2(userProfile.getDoj());
        String dob = Utils.convertToDate(userProfile.getDob());
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("Profile", userProfile);
        //set riêng 2 thằng ngày
        request.setAttribute("JoiningDate", doj);
        request.setAttribute("BirthDate", dob);
        return SUCCESS;
    }

    public UserDTO getUserProfile() {
        return userProfile;
    }
    
    
}
