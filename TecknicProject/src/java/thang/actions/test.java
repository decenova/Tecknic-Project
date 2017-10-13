/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Decen
 */
public class test extends ActionSupport {
    
    public test() {
    }
    @Action(value = "/test", results = {
        @Result(name = "a", location = "/index.jsp")
    })
    public String execute() throws Exception {
        return "a";
    }
    
}
