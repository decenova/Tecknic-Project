/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.UserDAO;

/**
 *
 * @author Trung
 */
@ParentPackage("json-default")
public class upgradeMember extends ActionSupport{
    
    //chưa có check role là admin
    private int userId;
    private int roleId;
    private boolean result;
    
    public upgradeMember() {
    }
    
    @Action(value = "/upgradeMember", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        
        UserDAO uDao = new UserDAO();
        result = uDao.updateRole(userId, roleId);
        
        return "success";
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isResult() {
        return result;
    }
    
    
    
    
    
    
}
