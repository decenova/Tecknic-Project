/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.ArticleDAO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class GetAmountOfUncheckedArticle extends ActionSupport {

    int numberOfUnchecked;

    public GetAmountOfUncheckedArticle() {
    }

    @Action(value = "/getAmountOfUnchecked", results = {
        @Result(name = "success", type = "json")

    })
    public String execute() throws Exception {
        ArticleDAO dao = new ArticleDAO();
        numberOfUnchecked = dao.getAmountOfUncheckArticle();
        return SUCCESS;
    }

    public int getNumberOfUnchecked() {
        return numberOfUnchecked;
    }

    public void setNumberOfUnchecked(int numberOfUnchecked) {
        this.numberOfUnchecked = numberOfUnchecked;
    }

}
