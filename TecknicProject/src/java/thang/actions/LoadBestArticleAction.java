/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import thang.dao.ArticleDAO;

/**
 *
 * @author Decen
 */
@ParentPackage("json-default")
public class LoadBestArticleAction extends ActionSupport {

    private ArrayList json;

    public LoadBestArticleAction() {
    }

    @Action(value = "/loadBestArticle", results = {
        @Result(name = SUCCESS, type = "json")
        ,
        @Result(name = INPUT, type = "json")
    })
    public String execute() throws Exception {
        ArticleDAO dao = new ArticleDAO();
        Calendar cal = Calendar.getInstance();
        Timestamp endTime = new Timestamp(cal.getTime().getTime());
        cal.add(Calendar.DATE, -7);
        Timestamp startTime = new Timestamp(cal.getTime().getTime());
        json = dao.loadBestArticle(startTime, endTime);
        return SUCCESS;
    }

    public ArrayList getJson() {
        return json;
    }

}
