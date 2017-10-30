/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
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
public class GetOwnArticleList extends ActionSupport{
    
    private ArrayList<ArticleDTO> result;
    
    public GetOwnArticleList() {
    }
    
    @Action(value = "/getOwnArticleList", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        ArticleDAO aDao = new ArticleDAO();
        int userId;
        
        Map session = ActionContext.getContext().getSession();
        userId = (int)session.get("ID");
        
        System.out.println("ID: " + userId);
        
        result = aDao.findArticleByUserID(userId);
        
        
        return "success";
    }

    public ArrayList<ArticleDTO> getResult() {
        return result;
    }
    
    
    
    
}
