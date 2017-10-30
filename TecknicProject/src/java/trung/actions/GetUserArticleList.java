/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
@ParentPackage("json-default")
public class GetUserArticleList extends ActionSupport{
    
    private int userId;
    private ArrayList<ArticleDTO> result;
    
    public GetUserArticleList() {
    }
    
    @Action(value = "/getUserArticleList", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        ArticleDAO aDao = new ArticleDAO();
        
        result = aDao.findOtherArticleByUserID(userId);
        
        return "success";
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<ArticleDTO> getResult() {
        return result;
    }
    
}
