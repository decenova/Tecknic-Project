/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import thang.dao.ArticleDAO;
import trung.dao.UserDAO;
import trung.dto.ArticleDTO;
import trung.dto.UserDTO;
import tung.dao.CommentDAO;

/**
 *
 * @author Trung
 */
@ParentPackage("json-default")
public class CheckArticle extends ActionSupport{
    
    private int articleId;
    private int statusId;
    private boolean result = false;
    
    public CheckArticle() {
    }
    
    @Action(value = "/checkArticle", results = {
        @Result(name = "success", location = "/article.jsp")
    })
    public String execute() throws Exception {
        
        System.out.println("articleID: " + articleId);
        System.out.println("statusId: " + statusId);
        
        ArticleDTO article = new ArticleDTO();
        trung.dao.ArticleDAO tADAO = new trung.dao.ArticleDAO();
        
        article = tADAO.viewArticleForUpdate(articleId);
        
        if (article.getStatus().compareToIgnoreCase("submited") == 0) {
            ArticleDAO aDAO = new ArticleDAO();
            result = aDAO.changeStatus(articleId, statusId);
            result = true;
        }
        
        return "success";
    }
    
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public boolean isResult() {
        return result;
    }
    
    
    
}
