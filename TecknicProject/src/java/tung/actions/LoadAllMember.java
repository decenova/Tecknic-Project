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
    int pos;
    int size;
    private ArrayList<UserDTO> memberList;
    
    public LoadAllMember() {
    }
    @Action(value = "/loadAll", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        memberList = dao.getAllUser(pos, size);
        return SUCCESS;
    }

    public ArrayList<UserDTO> getMemberList() {
        return memberList;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    

    
}
