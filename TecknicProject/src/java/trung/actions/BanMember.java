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
public class BanMember extends ActionSupport{
    
    private int userId;
    private int modId;
    private String reason;
    private boolean result;
    
    public BanMember() {
    }
    
    @Action(value = "/banMember", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        
        UserDAO uDao = new UserDAO();
        result = uDao.banUser(userId, modId, reason);
        
        return "success";
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setModId(int modId) {
        this.modId = modId;
    }
    
    

    public boolean isResult() {
        return result;
    }
    
    
    
}
