/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
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
public class SearchUserLikeNameAction extends ActionSupport {
    private String searchName;
    private ArrayList<UserDTO> searchUserList;
    public SearchUserLikeNameAction() {
    }
    
    @Action(value = "/searchLikeName", results = {
        @Result(name = "success", type = "json")
    })
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        searchUserList = dao.findByLikeName(searchName);
        return SUCCESS;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public ArrayList<UserDTO> getSearchUserList() {
        return searchUserList;
    }

    
    
    
}
