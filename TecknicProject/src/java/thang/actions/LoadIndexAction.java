/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Decen
 */
public class LoadIndexAction extends ActionSupport {
    
    private int tagId;
    
    public LoadIndexAction() {
    }
    @Action(value = "/loadIndex", results = {
        @Result(name = SUCCESS, location = "/index.jsp"),
        @Result(name = INPUT, location = "/error.jsp"),
    })
    public String execute() throws Exception {
        return SUCCESS;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
    
}
