/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Trung
 */

public class updateArticle extends ActionSupport{
    
    public updateArticle() {
    }
    
    @Action(value = "/updateArticle", results = {
        @Result(name = "success", location = "/index.jsp")
    })
    public String execute() throws Exception {
        return "success";
    }
    
}
