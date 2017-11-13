/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.CommentDAO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class RemoveCommentById extends ActionSupport {
    int cmtId;
    
    public RemoveCommentById() {
    }
    
    @Action(value = "/removeCmt", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        CommentDAO dao = new CommentDAO();
        System.out.println(cmtId);
        dao.removeComment(cmtId);
        return SUCCESS;
    }

    public int getCmtId() {
        return cmtId;
    }

    public void setCmtId(int cmtId) {
        this.cmtId = cmtId;
    }
    
    
    
}
