/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.UserDAO;
import tung.dto.UserDTO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class LoadAllMember extends ActionSupport {
    
    private ArrayList<UserDTO> memberList;
    
    public LoadAllMember() {
    }
    @Action(value = "/loadAll", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        int id = (int) session.get("ID");
        memberList = dao.getAllUser(id);
//        HttpServletRequest request = ServletActionContext.getRequest();
//        request.setAttribute("MemberList", memberList);
        return SUCCESS;
    }

    public ArrayList<UserDTO> getMemberList() {
        return memberList;
    }

    
}
